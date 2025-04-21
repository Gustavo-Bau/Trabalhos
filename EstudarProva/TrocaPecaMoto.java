public class TrocaPecaMoto extends TrocaPeca {
    public TrocaPecaMoto(String nomePeca) {
        super(nomePeca, "Troca de Peça - Moto");
    }

    @Override
    public String realizar() {
        setConcluido(true);
        return "Peça " + getNomePeca() + " trocada na moto";
    }
}