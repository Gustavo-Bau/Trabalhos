import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Criando clientes
        Cliente cliente1 = new Cliente("João Silva", "123.456.789-00", "(11) 9999-8888", "Rua A, 123");
        
        // Cadastrando veículos
        Carro carro1 = new Carro("ABC-1234", "Fiesta", "Ford", 2018, cliente1, 4);
        Moto moto1 = new Moto("XYZ-9876", "CG 160", "Honda", 2020, cliente1, 160);
        
        cliente1.adicionarVeiculo(carro1);
        cliente1.adicionarVeiculo(moto1);
        
        // Buscando veículos
        Veiculo veiculoEncontrado = BuscadorVeiculos.buscarPorModelo("Fiesta", cliente1.getVeiculos());
        System.out.println("Veículo encontrado: " + veiculoEncontrado.getModelo());
        
        // Configurando oficina
        Oficina oficina = new Oficina();
        Mecanico mecanico1 = new Mecanico("Carlos");
        oficina.adicionarMecanico(mecanico1);
        
        // Registrando entrada para serviço
        System.out.println(oficina.registrarEntrada(carro1, "Problema no motor", mecanico1));
        
        // Realizando serviços
        Servico servico = oficina.getServicosAtivos().get(0);
        
        // Troca de óleo
        TrocaOleo trocaOleo = new TrocaOleo("Sintético 5W30", 4.5, true);
        servico.getServicosRealizados().add(trocaOleo);
        System.out.println(trocaOleo.realizar());
        
        // Troca de peça específica
        ServicoManutencao trocaPeca;
        if (servico.getVeiculo() instanceof Carro) {
            trocaPeca = new TrocaPecaCarro("Correia dentada");
        } else {
            trocaPeca = new TrocaPecaMoto("Corrente de transmissão");
        }
        servico.getServicosRealizados().add(trocaPeca);
        System.out.println(trocaPeca.realizar());
        
        // Verificando mecânicos disponíveis
        List<Mecanico> disponiveis = oficina.mecanicosDisponiveis();
        System.out.println("Mecânicos disponíveis: " + disponiveis.size());
        
        // Registrando saída
        System.out.println(oficina.registrarSaida(carro1));
    }
}