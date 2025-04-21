import java.util.ArrayList;
import java.util.List;

public class Oficina {
    private List<Servico> servicosAtivos;
    private List<Mecanico> mecanicos;

    public Oficina() {
        this.servicosAtivos = new ArrayList<>();
        this.mecanicos = new ArrayList<>();
    }

    // Registrar entrada de veículo para serviço
    public String registrarEntrada(Veiculo veiculo, String descricaoProblema, Mecanico mecanico) {
        if (veiculo.isEmServico()) {
            return "Veículo já está em serviço";
        }
        
        veiculo.setEmServico(true);
        Servico novoServico = new Servico(veiculo, descricaoProblema, mecanico);
        servicosAtivos.add(novoServico);
        mecanico.setDisponivel(false);
        return "Entrada registrada com sucesso";
    }

    // Registrar saída de veículo
    public String registrarSaida(Veiculo veiculo) {
        for (Servico servico : servicosAtivos) {
            if (servico.getVeiculo().equals(veiculo)) {
                servico.getVeiculo().setEmServico(false);
                servico.setConcluido(true);
                servico.setDataSaida(LocalDateTime.now());
                servico.getMecanico().setDisponivel(true);
                servicosAtivos.remove(servico);
                return "Saída registrada com sucesso";
            }
        }
        return "Veículo não encontrado em serviços ativos";
    }

    // Verificar mecânicos disponíveis
    public List<Mecanico> mecanicosDisponiveis() {
        List<Mecanico> disponiveis = new ArrayList<>();
        for (Mecanico mecanico : mecanicos) {
            if (mecanico.isDisponivel()) {
                disponiveis.add(mecanico);
            }
        }
        return disponiveis;
    }

    // Adicionar mecânico à oficina
    public void adicionarMecanico(Mecanico mecanico) {
        this.mecanicos.add(mecanico);
    }
}