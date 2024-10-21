package fag;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
	
    List<Quarto> quartos = new ArrayList<>();
    List<Reserva> reservas = new ArrayList<>();

    public void adicionarQuarto(int numero, String tipo, double preco) {
    	
    Quarto quarto = new Quarto(numero, tipo, preco);
    quartos.add(quarto);
    }

    public void adicionarReserva(Hospede hospede, String checkin, String checkout, int numeroQuartos, String tipoQuarto) {
    	
    Reserva reserva = new Reserva(hospede, checkin, checkout, numeroQuartos, tipoQuarto);
    reservas.add(reserva);
    atualizarDisponibilidade(tipoQuarto, -numeroQuartos);
    }

    public void registrarCheckin(String nome) {
    	
    for (Reserva reserva : reservas) {
    if (reserva.getNomeHospede().equals(nome)) {
    atualizarDisponibilidade(reserva.getTipoQuarto(), -reserva.getNumeroQuartos());
    }
    }
    }

    public void registrarCheckout(String nome) {
    	
    for (Reserva reserva : reservas) {
    if (reserva.getNomeHospede().equals(nome)) {
    atualizarDisponibilidade(reserva.getTipoQuarto(), reserva.getNumeroQuartos());
    }
    }
    }

    private void atualizarDisponibilidade(String tipoQuarto, int numeroQuartos) {
    	
    for (Quarto quarto : quartos) {
    if (quarto.tipo.equals(tipoQuarto) && quarto.disponivel && numeroQuartos != 0) {
    quarto.disponivel = numeroQuartos > 0;
    numeroQuartos += numeroQuartos > 0 ? -1 : 1;
    }
    }
    }

    public void gerarRelatorioOcupacao() {
    	
    int ocupados = 0;
    for (Quarto quarto : quartos) {
    if (!quarto.disponivel) {
    ocupados++;
    System.out.println("Quarto " + quarto.numero + " (" + quarto.tipo + "), " + quarto.preco + " por dia");
    }
    }
    System.out.println("Número de quartos ocupados: " + ocupados);
    }

    public void gerarHistoricoReservas() {
    	
    for (Reserva reserva : reservas) {
     System.out.println("Hóspede: " + reserva.getNomeHospede() + ", Check-in: " + reserva.getCheckin() + ", Check-out: " + reserva.getCheckout() + ", Tipo de quarto: " + reserva.getTipoQuarto() + ", Quartos reservados: " + reserva.getNumeroQuartos());
    }
    }
}

