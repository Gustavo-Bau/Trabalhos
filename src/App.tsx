import Contact from './components/Contact';
import Footer from './components/Footer';

function App() {
  return (
    <div className="min-h-screen bg-[#f8fafc] flex flex-col font-sans">
      {/* Se você tiver feito o Header e o Hero, eles entrariam aqui! */}
      
      <main className="flex-grow flex items-center justify-center">
        <div className="w-full">
          <Contact />
        </div>
      </main>

      <Footer />
    </div>
  );
}

export default App;