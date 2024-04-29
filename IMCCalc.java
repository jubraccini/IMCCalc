import java.util.Scanner;

public class IMCCalc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome:");
        String nome = scanner.nextLine();

        char genero;

        do {
            System.out.println("Digite o gênero ((M)asculino (F)eminino ou (N)ão Especificar): ");
            genero = Character.toUpperCase(scanner.next().charAt(0));
            if (genero != 'M' && genero != 'F' && genero != 'N') {
                System.out.println("Gênero inválido. Por favor, digite M, F ou N.");
            }
        } while (genero != 'M' && genero != 'F' && genero != 'N');
        
        
        
        double altura = 0;
        double peso = 0;

        while (true) {
            System.out.println("Digite a altura em metros:");
            String input = scanner.nextLine();

            try {
                altura = Double.parseDouble(input);
                break; // Sai do loop se a conversão for bem-sucedida
            } catch (NumberFormatException e) {
                System.out.println("Altura inválida. Digite novamente.");
            }
        }

        while (true) {
            System.out.println("Digite o peso em Kg:");
            String input = scanner.nextLine();

            try {
                peso = Double.parseDouble(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Peso inválido. Digite novamente.");
            }
        }

        double imc;
        if (genero == 'M') {
            imc = peso / (altura * altura);
        } else {
            imc = peso / (altura * altura) - 1;
        }

        System.out.printf("Seu IMC é: %.2f%n", imc);

        System.out.println("Diagnóstico:");
        if (genero == 'M' && imc < 20 || genero != 'M' && imc < 19) {
            System.out.println("Abaixo do normal");
        } else if (genero == 'M' && imc < 25 || genero != 'M' && imc < 24) {
            System.out.println("normal");
        } else if (genero == 'M' && imc < 30 || genero != 'M' && imc < 29) {
            System.out.println("Obesidade Leve");
        } else if (genero == 'M' && imc < 40 || genero != 'M' && imc < 39) {
            System.out.println("Obesidade Moderada");
        } else {
            System.out.println("Obesidade Mórbida");
        }
        scanner.close();
    }
}