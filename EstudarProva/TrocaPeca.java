public abstract class TrocaPeca extends ServicoManutencao {
    private String nomePeca;

    public TrocaPeca(String nomePeca, String tipoServico) {
        super(tipoServico);
        this.nomePeca = nomePeca;
    }

    public String getNomePeca() { return nomePeca; }
}