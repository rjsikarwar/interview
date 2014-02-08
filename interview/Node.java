public class Node {
    public int value;
    public Node next;
    public Node() {
            value = 0;
            next = null;
    }
    public Node(int value, Node next) {
            this.value = value;
            this.next = next;
    }
}