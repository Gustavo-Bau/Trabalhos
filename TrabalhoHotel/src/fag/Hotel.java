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

    public void adicionarReserva(Hospede hospede, String checkin, String checkout, int numeroQuarto) {
        Quarto quarto = encontrarQuartoPorNumero(numeroQuarto);
        if (quarto != null && quarto.isDisponivel()) {
            if (verificarDisponibilidade(quarto.tipo, 1)) {
                quarto.setDisponivel(false);
                Reserva reserva = new Reserva(hospede, checkin, checkout, 1, quarto.tipo);
                reservas.add(reserva);
                System.out.println("Reserva adicionada com sucesso.");
            } else {
                System.out.println("Quarto não disponível para reserva.");
            }
        } else {
            System.out.println("Quarto não encontrado.");
        }
    }

    public void registrarCheckin(String nome) {
        for (Reserva reserva : reservas) {
            if (reserva.getNomeHospede().equals(nome) && !reserva.isCheckinFeito()) {
                Quarto quarto = encontrarQuartoPorTipo(reserva.getTipoQuarto());
                if (quarto != null && !quarto.isDisponivel()) {
                    reserva.setCheckinFeito(true);
                    System.out.println("Check-in realizado para " + nome);
                    return;
                }
            }
        }
        System.out.println("Reserva não encontrada ou check-in já realizado para " + nome);
    }

    public void registrarCheckout(String nome) {
        for (Reserva reserva : reservas) {
            if (reserva.getNomeHospede().equals(nome) && reserva.isCheckinFeito()) {
                Quarto quarto = encontrarQuartoPorTipo(reserva.getTipoQuarto());
                if (quarto != null && !quarto.isDisponivel()) {
                    quarto.setDisponivel(true);
                    reserva.setCheckinFeito(false);
                    System.out.println("Check-out realizado para " + nome);
                    return;
                }
            }
        }
        System.out.println("Reserva não encontrada ou check-in não realizado para " + nome);
    }

    private boolean verificarDisponibilidade(String tipoQuarto, int numeroQuartos) {
        int disponiveis = 0;
        for (Quarto quarto : quartos) {
            if (quarto.tipo.equals(tipoQuarto) && quarto.isDisponivel()) {
                disponiveis++;
            }
        }
        return disponiveis >= numeroQuartos;
    }

    private boolean verificarDisponibilidadePorNumero(int numero) {
        Quarto quarto = encontrarQuartoPorNumero(numero);
        return quarto != null && quarto.isDisponivel();
    }

    private Quarto encontrarQuartoPorNumero(int numero) {
        for (Quarto quarto : quartos) {
            if (quarto.numero == numero) {
                return quarto;
            }
        }
        return null;
    }

    private Quarto encontrarQuartoPorTipo(String tipo) {
        for (Quarto quarto : quartos) {
            if (quarto.tipo.equals(tipo) && !quarto.isDisponivel()) {
                return quarto;
            }
        }
        return null;
    }

    public boolean verificarQuartoExiste(int numero) {
        return encontrarQuartoPorNumero(numero) != null;
    }

    public void listarQuartos() {
        for (Quarto quarto : quartos) {
            System.out.println("Quarto " + quarto.numero + " - Tipo: " + quarto.tipo + " - Preço: " + quarto.preco + " - Disponível: " + (quarto.isDisponivel() ? "Sim" : "Não"));
        }
    }

    public void listarReservas() {
        for (Reserva reserva : reservas) {
            System.out.println("Hóspede: " + reserva.getNomeHospede() + 
                               ", Check-in: " + reserva.getCheckin() + 
                               ", Check-out: " + reserva.getCheckout() + 
                               ", Tipo de quarto: " + reserva.getTipoQuarto() + 
                               ", Quartos reservados: " + reserva.getNumeroQuartos() +
                               ", Check-in feito: " + (reserva.isCheckinFeito() ? "Sim" : "Não"));
        }
    }

    public void listarReservasDisponiveisParaCheckin() {
        for (Reserva reserva : reservas) {
            if (!reserva.isCheckinFeito()) {
                System.out.println("Hóspede: " + reserva.getNomeHospede() + 
                                   ", Check-in: " + reserva.getCheckin() + 
                                   ", Check-out: " + reserva.getCheckout() + 
                                   ", Tipo de quarto: " + reserva.getTipoQuarto() + 
                                   ", Quartos reservados: " + reserva.getNumeroQuartos());
            }
        }
    }

    public void listarReservasCheckinFeito() {
        for (Reserva reserva : reservas) {
            if (reserva.isCheckinFeito()) {
                System.out.println("Hóspede: " + reserva.getNomeHospede() + 
                                   ", Check-in: " + reserva.getCheckin() + 
                                   ", Check-out: " + reserva.getCheckout() + 
                                   ", Tipo de quarto: " + reserva.getTipoQuarto() + 
                                   ", Quartos reservados: " + reserva.getNumeroQuartos());
            }
        }
    }

    public void gerarRelatorioOcupacao() {
        int ocupados = 0;
        for (Quarto quarto : quartos) {
            if (!quarto.isDisponivel()) {
                ocupados++;
                System.out.println("Quarto " + quarto.numero + " (" + quarto.tipo + "), " + quarto.preco + " por dia");
            }
        }
        System.out.println("Número de quartos ocupados: " + ocupados);
    }

    public void gerarHistoricoReservas() {
        for (Reserva reserva : reservas) {
            System.out.println("Hóspede: " + reserva.getNomeHospede() + 
                               ", Check-in: " + reserva.getCheckin() + 
                               ", Check-out: " + reserva.getCheckout() + 
                               ", Tipo de quarto: " + reserva.getTipoQuarto() + 
                               ", Quartos reservados: " + reserva.getNumeroQuartos());
        }
    }
}
