const nodemailer = require('nodemailer');

exports.handler = async (event) => {
  if (event.httpMethod !== 'POST') {
    return { statusCode: 405, body: 'Método não permitido' };
  }

  try {
    const { email, motivo, captchaToken } = JSON.parse(event.body);

    if (!captchaToken) {
      return {
        statusCode: 400,
        body: JSON.stringify({ error: 'Token do reCAPTCHA em falta.' })
      };
    }

    // Validação do reCAPTCHA
    const RECAPTCHA_SECRET_KEY = process.env.RECAPTCHA_SECRET_KEY;
    if (!RECAPTCHA_SECRET_KEY) {
      console.error('RECAPTCHA_SECRET_KEY não está definido nas variáveis de ambiente.');
      return {
        statusCode: 500,
        body: JSON.stringify({ error: 'Erro de configuração do servidor: Chave secreta do reCAPTCHA não encontrada.' })
      };
    }

    const verificationUrl = `https://www.google.com/recaptcha/api/siteverify?secret=${RECAPTCHA_SECRET_KEY}&response=${captchaToken}`;
    
    const captchaResponse = await fetch(verificationUrl, { method: 'POST' });
    const captchaValidation = await captchaResponse.json();

    if (!captchaValidation.success) {
      console.warn('Validação reCAPTCHA falhou:', captchaValidation['error-codes']);
      return {
        statusCode: 400,
        body: JSON.stringify({ error: 'Validação de segurança falhou. Por favor, tente novamente.' })
      };
    }

    // Configuração do Nodemailer
    const EMAIL_USER = process.env.EMAIL_USER;
    const EMAIL_PASS = process.env.EMAIL_PASS;
    const EMAIL_TO = process.env.EMAIL_TO;

    if (!EMAIL_USER || !EMAIL_PASS || !EMAIL_TO) {
      console.error('Variáveis de ambiente de e-mail (EMAIL_USER, EMAIL_PASS, EMAIL_TO) não estão definidas.');
      return {
        statusCode: 500,
        body: JSON.stringify({ error: 'Erro de configuração do servidor: Credenciais de e-mail não encontradas.' })
      };
    }

    const transporter = nodemailer.createTransport({
      host: 'smtp.gmail.com',
      port: 465,
      secure: true,
      auth: {
        user: EMAIL_USER, 
        pass: EMAIL_PASS  
      }
    });

    await transporter.sendMail({
      from: `"Formulário Landing Page" <${EMAIL_USER}>`,
      replyTo: email,
      to: EMAIL_TO, 
      subject: `Novo Contato - Dúvida / Orçamento (Validado com Sucesso)`,
      text: `Email do cliente: ${email}\nMotivo do contato: ${motivo}`,
      html: `
        <h3>Você recebeu uma nova mensagem pelo site!</h3>
        <p><strong>Email do cliente:</strong> ${email}</p>
        <p><strong>Motivo do contato:</strong><br/>${motivo}</p>
      `
    });

    return {
      statusCode: 200,
      body: JSON.stringify({ message: 'E-mail enviado com sucesso!' })
    };
  } catch (error) {
    console.error('Erro no processamento interno:', error);
    return {
      statusCode: 500,
      body: JSON.stringify({ error: 'Erro ao processar requisição interna.' })
    };
  }
};
