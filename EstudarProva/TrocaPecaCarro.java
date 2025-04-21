public class TrocaPecaCarro extends TrocaPeca {
    public TrocaPecaCarro(String nomePeca) {
        super(nomePeca, "Troca de Peça - Carro");
    }

    @Override
    public String realizar() {
        setConcluido(true);
        return "Peça " + getNomePeca() + " trocada no carro";
    }
}