import java.time.LocalDateTime;

public class Servico {
    private Veiculo veiculo;
    private String descricao;
    private Mecanico mecanico;
    private LocalDateTime dataEntrada;
    private LocalDateTime dataSaida;
    private boolean concluido;
    private List<ServicoManutencao> servicosRealizados;

    public Servico(Veiculo veiculo, String descricao, Mecanico mecanico) {
        this.veiculo = veiculo;
        this.descricao = descricao;
        this.mecanico = mecanico;
        this.dataEntrada = LocalDateTime.now();
        this.concluido = false;
        this.servicosRealizados = new ArrayList<>();
    }

    // Getters e Setters
    public Veiculo getVeiculo() { return veiculo; }
    public boolean isConcluido() { return concluido; }
    public void setConcluido(boolean concluido) { this.concluido = concluido; }
    public void setDataSaida(LocalDateTime dataSaida) { this.dataSaida = dataSaida; }
    public List<ServicoManutencao> getServicosRealizados() { return servicosRealizados; }
    // ... outros getters e setters
}