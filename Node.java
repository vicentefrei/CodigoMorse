class Node {
    char character;
    Node left;  // Representa o ponto '.'
    Node right; // Representa o traço '-'

    public Node(char character) {
        this.character = character;
        this.left = null;
        this.right = null;
    }
}
