public class Moto extends Veiculo {
    private int cilindradas;

    public Moto(String placa, String modelo, String marca, int ano, Cliente proprietario, int cilindradas) {
        super(placa, modelo, marca, ano, proprietario);
        this.cilindradas = cilindradas;
    }

    // Getter e Setter específico
    public int getCilindradas() { return cilindradas; }
}