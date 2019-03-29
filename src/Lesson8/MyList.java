package Lesson8;

import homework5.List;
import homework5.Queue;
import homework5.Stack;

import java.util.Iterator;

public class MyList<T> /*implements*/ /*List, Queue, Stack, Iterable*/ {
    private Node firstNode;
    private Node lastNode;
    private int length = 0;

   /* @Override
    public Iterator iterator() {
        return new ListIterator(firstNode);
    }

    // внутренний нестатический класс
    private class ListIterator implements Iterator {
        Node next;

        public ListIterator(Node node) {
            this.next = node;
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public Object next() {
            Object cur = next.getValue();
            next = next.getNextNode();
            return cur;
        }
    }*/
    public T get(int idx){
        Node<T> iter = this.firstNode;
        for (int i = 0; i < idx ; i++) {
            iter = iter.getNextNode();

        }
        return iter.getValue();
    }

    public void addLast(T object) {

        if (length == 0) {
            this.firstNode = this.lastNode = new Node<>(object);
        } else {
            Node iter = this.lastNode;
            this.lastNode.setNextNode(new Node<>(object));
            this.lastNode = this.lastNode.getNextNode();
            this.lastNode.setPrevNode(iter);
        }
        length++;
    }


    public void removeLast() {
        if (length > 1) {
            this.lastNode = this.lastNode.getPrevNode();
            this.lastNode.setNextNode(null);
        } else {
            this.firstNode = this.lastNode = null;
        }
        length--;

    }


    public void removeFirst() {
        if (length > 1) {
            this.firstNode = this.firstNode.getNextNode();
            this.firstNode.setPrevNode(null);
        } else {
            this.firstNode = this.lastNode = null;
        }
        length--;
    }


    public void addFirst(T object) {
        if (length == 0) {
            this.firstNode = this.lastNode = new Node<>(object);
        } else {
            Node iter = this.firstNode;
            this.firstNode.setPrevNode(new Node<>(object));
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
