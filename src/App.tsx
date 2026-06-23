import Contact from './components/Contact';
import Footer from './components/Footer';

const solutions = [
  'Sites institucionais com identidade visual forte e páginas responsivas.',
  'Landing pages para campanhas, captação de leads e apresentação de serviços.',
  'Automações e integrações para deixar o atendimento mais rápido e organizado.',
];

const clients = [
  { name: 'Eduardo', role: 'Empreendedor digital' },
  { name: 'Gustavo', role: 'Gestor comercial' },
  { name: 'Adriel', role: 'Criador de conteúdo' },
  { name: 'Outros clientes', role: 'Projetos sob medida' },
];

const plans = [
  {
    name: 'Básico',
    description: 'Comece com uma presença digital objetiva e profissional.',
    price: 'Grátis',
    button: 'Baixar agora',
    features: ['Página inicial simples', 'Até 10 ajustes por mês', 'Suporte por e-mail'],
  },
  {
    name: 'Premium',
    description: 'Para quem quer lançar uma página completa com mais impacto.',
    price: 'R$ 19,90',
    detail: '/mês',
    button: 'Experimente de graça',
    featured: true,
    features: ['Sem interrupção de anúncios', 'Atualize quantas vezes quiser', 'Todos os recursos disponíveis'],
  },
  {
    name: 'Empresarial',
    description: 'Soluções para empresas que precisam de fluxo e performance.',
    price: 'R$ 12,90',
    detail: '/mês por dev',
    button: 'Baixar agora',
    features: ['Com anúncios', 'Até 10 produtos por dia', 'Use sem limitação'],
  },
];

function Header() {
  return (
    <header className="absolute left-0 right-0 top-0 z-20 px-6 py-6 md:px-16">
      <nav className="mx-auto flex max-w-6xl items-center justify-between rounded-full bg-white/80 px-5 py-3 shadow-sm backdrop-blur md:bg-transparent md:shadow-none">
        <a href="#inicio" className="text-2xl font-black tracking-tight text-slate-900">
          GBsolution
        </a>
        <div className="hidden items-center gap-8 text-sm font-semibold text-slate-600 md:flex">
          <a href="#inicio" className="hover:text-sky-500">Home</a>
          <a href="#solucoes" className="hover:text-sky-500">Soluções</a>
          <a href="#clientes" className="hover:text-sky-500">Clientes</a>
          <a href="#planos" className="hover:text-sky-500">Preços</a>
          <a href="#contato" className="hover:text-sky-500">Contato</a>
        </div>
        <div className="hidden items-center gap-6 md:flex">
          <a href="#contato" className="font-bold text-sky-500">Login</a>
          <a href="#contato" className="rounded-md bg-sky-500 px-6 py-3 font-bold text-white shadow-sm transition hover:bg-sky-600">
            Cadastre-se →
          </a>
        </div>
      </nav>
    </header>
  );
}

function Hero() {
  return (
    <section id="inicio" className="relative isolate flex min-h-screen items-center overflow-hidden bg-white px-6 py-32 text-center">
      <div className="absolute -left-24 -top-24 h-64 w-64 rounded-br-[5rem] bg-sky-200" />
      <div className="absolute right-0 top-0 -z-10 h-[88%] w-[42%] rounded-bl-[5rem] bg-sky-200 max-md:hidden" />
      <div className="mx-auto max-w-3xl">
        <span className="mb-8 block text-sm font-bold text-sky-500">Olá</span>
        <h1 className="text-5xl font-black leading-tight tracking-tight text-slate-900 md:text-7xl">
          Uma solução que irá te entregar X
        </h1>
        <p className="mx-auto mt-10 max-w-xl text-base leading-8 text-slate-500">
          Você sabe que, para alcançar o sucesso, é fundamental ter parceiros que te impulsionem a ir mais longe.
        </p>
        <div className="mt-10 flex flex-wrap justify-center gap-4">
          <a href="#contato" className="rounded-md bg-sky-500 px-9 py-4 text-sm font-bold text-white transition hover:bg-sky-600">
            Cadastre-se
          </a>
          <a href="#solucoes" className="rounded-md border border-sky-500 px-9 py-4 text-sm font-bold text-sky-500 transition hover:bg-sky-50">
            Veja mais
          </a>
        </div>
      </div>
    </section>
  );
}

function Solutions() {
  return (
    <section id="solucoes" className="min-h-screen bg-white px-6 py-28 text-center">
      <span className="text-sm font-bold text-sky-500">Soluções</span>
      <h2 className="mt-3 text-4xl font-black text-slate-900 md:text-5xl">Sob medida para você</h2>
      <p className="mx-auto mt-6 max-w-xl text-slate-500">
        Inovação é com a gente! A GBsolution já conquistou diversos clientes; veja você mais um deles.
      </p>
      <div className="mx-auto mt-20 grid max-w-5xl gap-8 md:grid-cols-3">
        {solutions.map((text) => (
          <article key={text} className="rounded-md border-b-4 border-sky-200 bg-white px-10 py-16 shadow-xl shadow-slate-200/70">
            <div className="mx-auto mb-10 h-12 w-12 rounded-full border-2 border-sky-500 after:mx-auto after:block after:h-5 after:w-4 after:translate-y-10 after:border-x-2 after:border-b-2 after:border-sky-500" />
            <h3 className="text-2xl font-black text-slate-900">Produto Vencedor</h3>
            <p className="mt-8 text-slate-500">{text}</p>
          </article>
        ))}
      </div>
    </section>
  );
}

function Clients() {
  return (
    <section id="clientes" className="min-h-screen bg-sky-200 px-6 py-28 text-center">
      <span className="text-sm font-bold text-sky-500">Conselho de quem conhece</span>
      <h2 className="mt-3 text-4xl font-black text-slate-900 md:text-5xl">Cada cliente importa!</h2>
      <p className="mx-auto mt-6 max-w-xl text-slate-500">Depoimentos de clientes que confiam na GBsolution para transformar ideias em presença digital.</p>
      <div className="clients-viewport relative mx-auto mt-20 max-w-6xl overflow-hidden" aria-label="Depoimentos de clientes em carrossel horizontal">
        <div className="pointer-events-none absolute inset-y-0 left-0 z-10 w-20 bg-gradient-to-r from-sky-200 to-transparent" />
        <div className="pointer-events-none absolute inset-y-0 right-0 z-10 w-20 bg-gradient-to-l from-sky-200 to-transparent" />
        <div className="clients-track flex w-max gap-6">
          {[0, 1].map((group) => (
            <div key={group} className="flex gap-6" aria-hidden={group === 1}>
              {clients.map((client) => (
                <article key={`${client.name}-${group}`} className="w-72 shrink-0 rounded-md bg-white px-8 py-16 shadow-sm md:w-80">
                  <p className="mx-auto max-w-44 text-slate-500">A GBsolution ajudou a organizar minha presença online com uma página clara, moderna e pronta para captar contatos.</p>
                  <div className="mt-8 text-sky-300">★★★★★</div>
                  <h3 className="mt-5 font-black text-slate-900">{client.name}</h3>
                  <p className="mt-2 text-xs font-bold text-slate-500">{client.role}</p>
                </article>
              ))}
            </div>
          ))}
        </div>
      </div>
    </section>
  );
}

function Plans() {
  return (
    <section id="planos" className="min-h-screen bg-white px-6 py-28 text-center">
      <span className="text-sm font-bold text-sky-500">Planos e preços</span>
      <h2 className="mt-3 text-4xl font-black text-slate-900 md:text-5xl">Nossos planos</h2>
      <div className="mx-auto mt-20 grid max-w-5xl items-center gap-8 md:grid-cols-3">
        {plans.map((plan) => (
          <article key={plan.name} className={`relative rounded-3xl bg-white p-9 text-left shadow-xl shadow-slate-200/80 ${plan.featured ? 'border-2 border-sky-500 md:-translate-y-8' : ''}`}>
            {plan.featured && <div className="absolute left-1/2 top-0 -translate-x-1/2 rounded-b-xl bg-sky-500 px-10 py-3 text-xs font-black text-white">1º MÊS GRÁTIS</div>}
            <h3 className="mt-8 text-xl font-black text-slate-900">{plan.name}</h3>
            <p className="mt-3 min-h-14 text-slate-500">{plan.description}</p>
            <p className="mt-8 text-4xl font-black text-slate-900">{plan.price}<span className="text-sm font-medium text-slate-500">{plan.detail}</span></p>
            <a href="#contato" className={`mt-8 block rounded-md border border-sky-500 px-6 py-4 text-center text-sm font-bold ${plan.featured ? 'bg-sky-500 text-white' : 'text-sky-500'}`}>{plan.button}</a>
            <div className="my-8 h-px bg-sky-200" />
            <ul className="space-y-4 text-slate-600">
              {plan.features.map((feature) => <li key={feature}>✓ {feature}</li>)}
            </ul>
          </article>
        ))}
      </div>
    </section>
  );
}

function App() {
  return (
    <div className="min-h-screen bg-white font-sans">
      <Header />
      <main>
        <Hero />
        <Solutions />
        <Clients />
        <Plans />
        <Contact />
      </main>
      <Footer />
    </div>
  );
}

export default App;
