public abstract class ServicoManutencao {
    private String tipo;
    private boolean concluido;

    public ServicoManutencao(String tipo) {
        this.tipo = tipo;
        this.concluido = false;
    }

    public abstract String realizar();

    // Getters e Setters
    public boolean isConcluido() { return concluido; }
    public void setConcluido(boolean concluido) { this.concluido = concluido; }
    public String getTipo() { return tipo; }
}