/**
 * A node in a singly linked list
 */
public class Node {
    private final int data;
    private final String name;
    private Node next;

    /**
     * Makes a new Node
     * @param data The data of the node
     * @param name The name of the node
     * @param next The next node
     */
    public Node(int data, String name, Node next) {
        this.data = data;
        this.name = name;
        this.next = next;
    }
    
    /**
     * Makes a new Node with no next Node
     * @param data The data of the node
     * @param name The name of the node
     */
    public Node(int data, String name) {
        this(data, name, null);
    }

    /**
     * Gets the data of the node
     * @return The data of the node
     */
    public int getData() {
        return data;
    }

    /**
     * Gets the name of the node
     * @return The name of the node
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the next node
     * @return The next node
     */
    public Node getNext() {
        return next;
    }

    /**
     * Sets the next node
     * @param next The next node or null if there is no next node
     */
    public void setNext(Node next) {
        this.next = next;
    }
}
