package Lesson8;

// Дженерики! общий тип Т
public class Node<T> {
    private Node prevNode;
    private  Node nextNode;
    T value;

    public Node(T value){
        this.value = value;
    }
    public Node(T value, Node nextNode){
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

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value.toString();
    }
}

