export default function Footer() {
  return (
    <footer className="bg-white pt-16 flex flex-col font-sans border-t border-gray-100">
      <div className="max-w-6xl mx-auto px-6 w-full mb-16">
        <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-4 gap-10">
          
          <div className="flex flex-col gap-4">
            <h3 className="text-xl font-bold text-[#1e293b]">LogoMarca</h3>
            <div className="flex gap-4 text-[#3aa3fb]">
              <a href="#" className="hover:text-blue-700 transition">
                <svg className="w-5 h-5" fill="none" stroke="currentColor" viewBox="0 0 24 24" strokeWidth="2"><rect x="2" y="2" width="20" height="20" rx="5" ry="5"></rect><path d="M16 11.37A4 4 0 1112.63 8 4 4 0 0116 11.37z"></path><line x1="17.5" y1="6.5" x2="17.51" y2="6.5"></line></svg>
              </a>
              <a href="#" className="hover:text-blue-700 transition">
                <svg className="w-5 h-5" fill="none" stroke="currentColor" viewBox="0 0 24 24" strokeWidth="2"><path d="M18 2h-3a5 5 0 00-5 5v3H7v4h3v8h4v-8h3l1-4h-4V7a1 1 0 011-1h3z"></path></svg>
              </a>
              <a href="#" className="hover:text-blue-700 transition">
                <svg className="w-5 h-5" fill="none" stroke="currentColor" viewBox="0 0 24 24" strokeWidth="2"><path d="M22.54 6.42a2.78 2.78 0 00-1.94-2C18.88 4 12 4 12 4s-6.88 0-8.6.46a2.78 2.78 0 00-1.94 2A29 29 0 001 11.75a29 29 0 00.46 5.33 2.78 2.78 0 001.94 2C5.12 19.5 12 19.5 12 19.5s6.88 0 8.6-.46a2.78 2.78 0 001.94-2 29 29 0 00.46-5.33 29 29 0 00-.46-5.33z"></path><polygon points="9.75 15.02 15.5 11.75 9.75 8.48 9.75 15.02"></polygon></svg>
              </a>
            </div>
          </div>

          <div className="flex flex-col gap-3">
            <h4 className="font-bold text-[#1e293b] mb-2">Empresa</h4>
            <a href="#" className="text-gray-500 hover:text-[#3aa3fb] text-sm font-medium transition-colors">Sobre nós</a>
            <a href="#" className="text-gray-500 hover:text-[#3aa3fb] text-sm font-medium transition-colors">Faça parte do time</a>
            <a href="#" className="text-gray-500 hover:text-[#3aa3fb] text-sm font-medium transition-colors">Blog</a>
          </div>

          <div className="flex flex-col gap-3">
            <h4 className="font-bold text-[#1e293b] mb-2">Funcionalidades</h4>
            <a href="#" className="text-gray-500 hover:text-[#3aa3fb] text-sm font-medium transition-colors">Marketing</a>
            <a href="#" className="text-gray-500 hover:text-[#3aa3fb] text-sm font-medium transition-colors">Análise de dados</a>
            <a href="#" className="text-gray-500 hover:text-[#3aa3fb] text-sm font-medium transition-colors">Boot discord</a>
          </div>

          <div className="flex flex-col gap-3">
            <h4 className="font-bold text-[#1e293b] mb-2">Recursos</h4>
            <a href="#" className="text-gray-500 hover:text-[#3aa3fb] text-sm font-medium transition-colors">IOS & Android</a>
            <a href="#" className="text-gray-500 hover:text-[#3aa3fb] text-sm font-medium transition-colors">Teste a Demo</a>
            <a href="#" className="text-gray-500 hover:text-[#3aa3fb] text-sm font-medium transition-colors">Clientes</a>
            <a href="#" className="text-gray-500 hover:text-[#3aa3fb] text-sm font-medium transition-colors">API</a>
          </div>

        </div>
      </div>

      <div className="bg-[#fafafa] py-6 text-center border-t border-gray-100">
        <p className="text-xs md:text-sm text-gray-500 font-semibold">
          Aula de Programação Web ©2024 - Todos os direitos reservados.
        </p>
      </div>
    </footer>
  );
}
