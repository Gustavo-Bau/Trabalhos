import java.util.Scanner;

    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      Sistem.out.println("Servico de troca de oleo. \n");
      Sistem.out.println("1-Carro.\n2-Moto. \n");
        scanner.nextInt();
        scanner.nextLine();
        
        switch (scanner) {
            case 1:
                getplaca();
                
                System.out.println("Carro selecionado.\n");
                break;
            case 2:
                System.out.println("Moto selecionada.\n");
                break;
            default:
                System.out.println("Opcao invalida.\n");
        }
    }