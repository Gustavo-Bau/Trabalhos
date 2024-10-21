package fag;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Scanner scanner = new Scanner(System.in);

        while (true) {
        	System.out.print("Escolha uma opção:\n");
            System.out.println("1. Adicionar quarto\n");
            System.out.println("2. Adicionar reserva\n");
            System.out.println("3. Check-in\n");
            System.out.println("4. Check-out\n");
            System.out.println("5. Relatório de ocupação\n");
            System.out.println("6. Histórico de reserva por nome\n");
            System.out.println("7. Sair\n");
            System.out.println("\n");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    System.out.print("Número do quarto: ");
                    int numero = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("\nTipo de quarto: ");
                    String tipo = scanner.nextLine();
                    System.out.print("\nPreço diário: ");
                    double preco = scanner.nextDouble();
                    hotel.adicionarQuarto(numero, tipo, preco);
                    break;

                case 2:
                    System.out.print("Nome do hóspede: ");
                    String nome = scanner.nextLine();
                    System.out.print("\nData de check-in (dd/MM/yyyy): ");
                    String checkinStr = scanner.nextLine();
                    System.out.print("\nData de check-out (dd/MM/yyyy): ");
                    String checkoutStr = scanner.nextLine();
                    System.out.print("\nNúmero de quartos: ");
                    int numeroQuartos = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("\nTipo de quarto reservado: ");
                    String tipoQuarto = scanner.nextLine();
                    
                    Hospede hospede = new Hospede(nome);
                    hotel.adicionarReserva(hospede, checkinStr, checkoutStr, numeroQuartos, tipoQuarto);
                    break;

                case 3:
                    System.out.print("Nome do hóspede para check-in: ");
                    nome = scanner.nextLine();
                    hotel.registrarCheckin(nome);
                    break;

                case 4:
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
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.\n");
                    break;
            }
}
}
}
