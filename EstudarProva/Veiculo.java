public abstract class Veiculo {
    private String placa;
    private String modelo;
    private String marca;
    private int ano;
    private Cliente proprietario;
    private boolean emServico;

    public Veiculo(String placa, String modelo, String marca, int ano, Cliente proprietario) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.proprietario = proprietario;
        this.emServico = false;
    }

    // Getters e Setters
    public String getModelo() { return modelo; }
    public String getMarca() { return marca; }
    public boolean isEmServico() { return emServico; }
    public void setEmServico(boolean emServico) { this.emServico = emServico; }
    // ... outros getters e setters
}