package fag;

public class Reserva {
    Hospede hospede;
    String checkin;
    String checkout;
    int numeroQuartos;
    String tipoQuarto;
    boolean checkinFeito;

    public Reserva(Hospede hospede, String checkin, String checkout, int numeroQuartos, String tipoQuarto) {
        this.hospede = hospede;
        this.checkin = checkin;
        this.checkout = checkout;
        this.numeroQuartos = numeroQuartos;
        this.tipoQuarto = tipoQuarto;
        this.checkinFeito = false;
    }

    public String getNomeHospede() {
        return hospede.nome;
    }

    public String getCheckin() {
        return checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public int getNumeroQuartos() {
        return numeroQuartos;
    }

    public String getTipoQuarto() {
        return tipoQuarto;
    }

    public boolean isCheckinFeito() {
        return checkinFeito;
    }

    public void setCheckinFeito(boolean checkinFeito) {
        this.checkinFeito = checkinFeito;
    }
}

