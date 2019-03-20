package homework5;

public class MyList implements List, Queue, Stack {
    private Node firstNode;
    private Node lastNode;
    private int length = 0;





    @Override
    public void addLast(Object object) {

        if (length==0) {
            this.firstNode = this.lastNode = new Node(object);
            } else {
            Node iter = this.lastNode;
            this.lastNode.setNextNode(new Node(object));
            this.lastNode = this.lastNode.getNextNode();
            this.lastNode.setPrevNode(iter);
        }
        length++;
    }

    @Override
    public void removeLast() {
        if (length>1){
            this.lastNode = this.lastNode.getPrevNode();
            this.lastNode.setNextNode(null);
        } else {
            this.firstNode = this.lastNode = null;
        }
        length--;

    }

    @Override
    public void removeFirst() {
        if (length>1){
            this.firstNode = this.firstNode.getNextNode();
            this.firstNode.setPrevNode(null);
        } else {
            this.firstNode = this.lastNode = null;
        }
        length--;
    }

    @Override
    public void addFirst(Object object) {
        if (length==0) {
            this.firstNode = this.lastNode = new Node(object);
        } else {
            Node iter = this.firstNode;
            this.firstNode.setPrevNode(new Node(object));
            this.firstNode = this.firstNode.getPrevNode();
            this.firstNode.setNextNode(iter);
        }
        length++;
    }

    @Override
    public String toString() {
        String s = "";
        Node iter = this.firstNode;
        while (iter != null) {
            s += iter.getValue() + " ";
            iter = iter.getNextNode();
        }
        return s;
    }

}
