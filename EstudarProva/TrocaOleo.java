public class TrocaOleo extends ServicoManutencao {
    private String tipoOleo;
    private double quantidade;
    private boolean filtroTrocado;

    public TrocaOleo(String tipoOleo, double quantidade, boolean filtroTrocado) {
        super("Troca de Óleo");
        this.tipoOleo = tipoOleo;
        this.quantidade = quantidade;
        this.filtroTrocado = filtroTrocado;
    }

    @Override
    public String realizar() {
        setConcluido(true);
        return "Troca de óleo realizada: " + quantidade + "L de " + tipoOleo + 
               (filtroTrocado ? " com troca de filtro" : "");
    }
}