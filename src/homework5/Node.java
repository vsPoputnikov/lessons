package homework5;

public class Node {
    private Node prevNode;
    private  Node nextNode;
    Object value;

    Node(Object value){
        this.value = value;
    }
    Node(Object value, Node nextNode){
        this.value = value;
        this.nextNode = nextNode;
    }

    public Node getPrevNode() {
        return prevNode;
    }

    public void setPrevNode(Node prevNode) {
        this.prevNode = prevNode;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value.toString();
    }
}
