import java.util.HashMap;
import java.util.Map;

public class MorseTree {
    private Node root;
    private Map<Character, String> morseCodeMap;  // Mapeamento do caractere para código morse

    public MorseTree() {
        root = new Node(' ');  // Raiz vazia
        morseCodeMap = new HashMap<>();
        buildMorseTree();      // Constrói a árvore binária
        buildMorseCodeMap();   // Constrói o mapa de código morse para codificação
    }

    // Método para construir a árvore binária morse
    private void buildMorseTree() {
        insert(".", 'E');
        insert("-", 'T');
        insert("..", 'I');
        insert(".-", 'A');
        insert("-.", 'N');
        insert("--", 'M');
        insert("...", 'S');
        insert("..-", 'U');
        insert(".-.", 'R');
        insert(".--", 'W');
        insert("-..", 'D');
        insert("-.-", 'K');
        insert("--.", 'G');
        insert("---", 'O');
        insert("....", 'H');
        insert("...-", 'V');
        insert("..-.", 'F');
        insert(".-..", 'L');
        insert(".--.", 'P');
        insert(".---", 'J');
        insert("-...", 'B');
        insert("-..-", 'X');
        insert("-.-.", 'C');
        insert("-.--", 'Y');
        insert("--..", 'Z');
        insert("--.-", 'Q');
    }

    // Método para inserir um caractere com base no código morse
    private void insert(String morseCode, char character) {
        Node current = root;
        for (char symbol : morseCode.toCharArray()) {
            if (symbol == '.') {
                if (current.left == null) {
                    current.left = new Node(' ');
                }
                current = current.left;
            } else if (symbol == '-') {
                if (current.right == null) {
                    current.right = new Node(' ');
                }
                current = current.right;
            }
        }
        current.character = character;
    }

    // Método para construir o mapa de codificação morse para caracteres
    private void buildMorseCodeMap() {
        morseCodeMap.put('E', ".");
        morseCodeMap.put('T', "-");
        morseCodeMap.put('I', "..");
        morseCodeMap.put('A', ".-");
        morseCodeMap.put('N', "-.");
        morseCodeMap.put('M', "--");
        morseCodeMap.put('S', "...");
        morseCodeMap.put('U', "..-");
        morseCodeMap.put('R', ".-.");
        morseCodeMap.put('W', ".--");
        morseCodeMap.put('D', "-..");
        morseCodeMap.put('K', "-.-");
        morseCodeMap.put('G', "--.");
        morseCodeMap.put('O', "---");
        morseCodeMap.put('H', "....");
        morseCodeMap.put('V', "...-");
        morseCodeMap.put('F', "..-.");
        morseCodeMap.put('L', ".-..");
        morseCodeMap.put('P', ".--.");
        morseCodeMap.put('J', ".---");
        morseCodeMap.put('B', "-...");
        morseCodeMap.put('X', "-..-");
        morseCodeMap.put('C', "-.-.");
        morseCodeMap.put('Y', "-.--");
        morseCodeMap.put('Z', "--..");
        morseCodeMap.put('Q', "--.-");
    }

    // Método para decodificar uma palavra em morse para texto
    public String decode(String morseSequence) {
        String[] morseLetters = morseSequence.split(" ");
        StringBuilder decodedWord = new StringBuilder();

        for (String letter : morseLetters) {
            Node current = root;
            for (char symbol : letter.toCharArray()) {
                if (symbol == '.') {
                    current = current.left;
                } else if (symbol == '-') {
                    current = current.right;
                }
            }
            decodedWord.append(current.character);
        }

        return decodedWord.toString();
    }

    // Método para codificar uma palavra em texto para código morse
    public String encode(String word) {
        StringBuilder morseSequence = new StringBuilder();
        for (char letter : word.toUpperCase().toCharArray()) {
            if (morseCodeMap.containsKey(letter)) {
                morseSequence.append(morseCodeMap.get(letter)).append(" ");
            }
        }
        return morseSequence.toString().trim();
    }

    // Método para imprimir a árvore binária no formato visual (letra) / \ (letra) (letra)
    public void printTree() {
        printTree(root, "", true);
    }

    // Método auxiliar para impressão recursiva da árvore com visualização em formato
    private void printTree(Node node, String prefix, boolean isTail) {
        if (node != null) {
            System.out.println(prefix + (isTail ? "└── " : "├── ") + "(" + node.character + ")");
            if (node.left != null || node.right != null) {
                printTree(node.left, prefix + (isTail ? "    " : "│   "), false);
                printTree(node.right, prefix + (isTail ? "    " : "│   "), true);
            }
        }
    }

    // Classe interna Node para construir a árvore
    private static class Node {
        char character;
        Node left, right;

        Node(char character) {
            this.character = character;
            this.left = this.right = null;
        }
    }
}

