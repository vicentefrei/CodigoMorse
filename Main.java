import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MorseTree morseTree = new MorseTree();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Codificar palavra");
            System.out.println("2. Decodificar sequência Morse");
            System.out.println("3. Imprimir Árvore Morse");
            System.out.println("4. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine();  

            switch (opcao) {
                case 1:
                    System.out.print("Digite a palavra a ser codificada: ");
                    String palavra = scanner.nextLine();
                    String codigoMorse = morseTree.encode(palavra);
                    System.out.println("Código Morse: " + codigoMorse);
                    break;

                case 2:
                    System.out.print("Digite a sequência Morse a ser decodificada (use espaço para separar as letras): ");
                    String sequenciaMorse = scanner.nextLine();
                    String palavraDecodificada = morseTree.decode(sequenciaMorse);
                    System.out.println("Palavra Decodificada: " + palavraDecodificada);
                    break;

                case 3:
                    System.out.println("Imprimindo a árvore Morse:");
                    morseTree.printTree();
                    break;

                case 4:
                    System.out.println("Saindo...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }
}
