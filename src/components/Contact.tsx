import { useState, useRef } from 'react';
import ReCAPTCHA from 'react-google-recaptcha';

export default function Contact() {
  const [email, setEmail] = useState('');
  const [motivo, setMotivo] = useState('');
  const [status, setStatus] = useState('');
  const [captchaToken, setCaptchaToken] = useState<string | null>(null);
  const recaptchaRef = useRef<ReCAPTCHA>(null);

  const handleCaptchaChange = (token: string | null) => {
    setCaptchaToken(token);
  };

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();

    if (!captchaToken) {
      setStatus('Por favor, confirme que não é um robô.');
      return;
    }

    setStatus('A enviar...');
    
    try {
      const response = await fetch('/.netlify/functions/send-email', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ email, motivo, captchaToken }),
      });

      if (response.ok) {
        setStatus('Mensagem enviada com sucesso!');
        setEmail('');
        setMotivo('');
        setCaptchaToken(null);
        recaptchaRef.current?.reset();
      } else {
        const errorData = await response.json();
        setStatus(errorData.error || 'Erro ao enviar a mensagem.');
      }
    } catch {
      setStatus('Erro de conexão ao tentar enviar.');
    }
  };

  return (
    <section className="bg-white py-20 px-4 font-sans">
      <div className="max-w-3xl mx-auto text-center flex flex-col items-center">
        <span className="text-[#3b82f6] font-bold text-sm tracking-wide mb-2 block">
          Envie sua dúvida
        </span>
        <h2 className="text-4xl font-extrabold text-[#1e293b] mb-6">
          Entre em contato
        </h2>
        
        <p className="text-gray-500 text-sm md:text-base mb-10 max-w-xl mx-auto leading-relaxed">
          Entre em contato, estamos dispostos a tirar qualquer dúvida,
          seja um orçamento, uma dúvida técnica de algum de nossos produtos.
          Estamos à disposição para responder.😎
        </p>

        <form onSubmit={handleSubmit} className="flex flex-col gap-4 w-full max-w-lg">
          <input
            type="email"
            placeholder="Seu melhor Email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
            className="w-full bg-[#f8fafc] border border-gray-200 text-gray-700 rounded-md px-4 py-3 focus:outline-none focus:border-blue-500 focus:ring-1 focus:ring-blue-500 transition-colors"
          />
          <textarea
            placeholder="Motivo do contato. Ex: Gostei muito do produto X, poderia me enviar um orçamento?"
            value={motivo}
            onChange={(e) => setMotivo(e.target.value)}
            required
            rows={3}
            className="w-full bg-[#f8fafc] border border-gray-200 text-gray-700 rounded-md px-4 py-3 focus:outline-none focus:border-blue-500 focus:ring-1 focus:ring-blue-500 transition-colors resize-none"
          />
          
          <div className="mx-auto my-2">
            <ReCAPTCHA
            ref={recaptchaRef}
            sitekey="6LeGeCwtAAAAAHrQb6Q5NIL4hr7oKOWFKj6LnBCi" 
            onChange={handleCaptchaChange}
            />
          </div>

          <button
            type="submit"
            className="bg-[#3aa3fb] text-white font-bold py-3 px-12 rounded-md mx-auto mt-2 hover:bg-blue-500 transition-colors"
            disabled={!captchaToken}
          >
            Enviar
          </button>
          
          {status && <p className="mt-4 text-blue-500 font-semibold">{status}</p>}
        </form>
      </div>
    </section>
  );
}
