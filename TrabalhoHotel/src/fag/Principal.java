package fag;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Adicionar Quarto");
            System.out.println("2. Adicionar Reserva");
            System.out.println("3. Registrar Check-in");
            System.out.println("4. Registrar Check-out");
            System.out.println("5. Gerar Relatório de Ocupação");
            System.out.println("6. Gerar Histórico de Reservas");
            System.out.println("7. Listar Reservas");
            System.out.println("8. Sair");

            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (escolha) {
                case 1:
                    System.out.print("Número do quarto: ");
                    int numero = scanner.nextInt();
                    scanner.nextLine(); // Consumir a nova linha
                    System.out.print("Tipo de quarto: ");
                    String tipo = scanner.nextLine();
                    System.out.print("Preço diário: ");
                    double preco = scanner.nextDouble();
                    hotel.adicionarQuarto(numero, tipo, preco);
                    break;

                case 2:
                    hotel.listarQuartos();
                    System.out.print("Escolha o número do quarto a ser reservado: ");
                    int numeroQuartoEscolhido = scanner.nextInt();
                    scanner.nextLine(); // Consumir a nova linha
                    if (!hotel.verificarQuartoExiste(numeroQuartoEscolhido)) {
                        System.out.println("Quarto não encontrado. Tente novamente.");
                        break;
                    }
                    System.out.print("Nome do hóspede: ");
                    String nome = scanner.nextLine();
                    System.out.print("Data de check-in (dd/MM/yyyy): ");
                    String checkinStr = scanner.nextLine();
                    System.out.print("Data de check-out (dd/MM/yyyy): ");
                    String checkoutStr = scanner.nextLine();

                    Hospede hospede = new Hospede(nome);
                    hotel.adicionarReserva(hospede, checkinStr, checkoutStr, numeroQuartoEscolhido);
                    break;

                case 3:
                    hotel.listarReservasDisponiveisParaCheckin();
                    System.out.print("Nome do hóspede para check-in: ");
                    nome = scanner.nextLine();
                    hotel.registrarCheckin(nome);
                    break;

                case 4:
                    hotel.listarReservasCheckinFeito();
                    System.out.print("Nome do hóspede para check-out: ");
                    nome = scanner.nextLine();
                    hotel.registrarCheckout(nome);
                    break;

                case 5:
                    hotel.gerarRelatorioOcupacao();
                    break;

                case 6:
                    hotel.gerarHistoricoReservas();
                    break;

                case 7:
                    hotel.listarReservas();
                    break;

                case 8:
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }
    }
}

