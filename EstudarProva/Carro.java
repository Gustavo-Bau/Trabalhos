public class Carro extends Veiculo {
    private int numPortas;

    public Carro(String placa, String modelo, String marca, int ano, Cliente proprietario, int numPortas) {
        super(placa, modelo, marca, ano, proprietario);
        this.numPortas = numPortas;
    }

    // Getter e Setter específico
    public int getNumPortas() { return numPortas; }
}