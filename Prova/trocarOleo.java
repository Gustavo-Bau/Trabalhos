import java.util.Scanner;  
import java.util.ArrayList;
import java.util.List;

public class TrocaOleo{
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> veiculosplaca = new ArrayList<>();
        
        veiculos.add("Qual A placa do veiculo? \n");
        String placa = scanner.nextLine();
        veiculosplaca.add(placa);

        System.out.println("A troca de oleo ocorre a cada 50.000 km.\n");
        System.out.println("Quando foi a ultima troca de oleo? \n");
        int kmUltimaTroca = scanner.nextInt();
        scanner.nextLine(); 
        
        System.out.println("Qual a kilometragem atual? \n");
        double KmAtual = scanner.nextDouble();
        scanner.nextLine();
       
        boolean placaEncontrada = false;
        for (String p : veiculosplaca) {
            if (p.equalsIgnoreCase(placa)) {
            placaEncontrada = true;
            break;
            }
        }
        
        if (veiculoEncontrado) {
            System.out.println("Veiculo encontrado!!\n");
        } else {
            System.out.println("Veiculo não encontrado!!\n");
        }
    
        if (kmUltimaTroca + 49000 > KmAtual && kmUltimaTroca + 51000 < KmAtual) {
            System.out.println("A troca de oleo foi realizada com sucesso!!\n");
        } else {
            System.out.println("A troca de oleo não pode ser feita.\n");
        }

    }
