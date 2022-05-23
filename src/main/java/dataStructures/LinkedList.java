package dataStructures;

import java.util.Iterator;

public class LinkedList <T> implements Iterable<T>{
    private Node<T> first;
    private Node<T> last;

    public Node<T> getFirst() {
        return first;
    }

    public void add(T el) {
        Node<T> node = new Node<>();
        node.setData(el);

        if (last == null) {
            first = last = node;
        }
        else {
            last.setNextNode(node);
            last = node;
        }
    }

    public void add(T el, int index) {
        Node<T> previousNode = first;
        Node<T> currentNode = first;

        Node<T> node = new Node<>();
        node.setData(el);

        int counter = 0;

        if (currentNode == null) {
            first = node;
            last = node;
            return;
        }

        if (indexBiggerThanSize(index)) {
            last.setNextNode(node);
            return;
        }

        if (indexIsZero(index)) {
            node.setNextNode(first);
            first = node;
            return;
        }

        if (indexIsLessThanZero(index))
            throw new IllegalArgumentException();


        while (counter != index) {
            previousNode = currentNode;
            currentNode = currentNode.getNextNode();
            counter++;
        }
        previousNode.setNextNode(node);
        node.setNextNode(currentNode);
    }

    private boolean indexIsLessThanZero(int index) {
        return index < 0;
    }

    private boolean indexBiggerThanSize(int index) {
        return index > this.size();
    }

    private boolean indexIsZero(int index) {
        return index == 0;
    }

    public T get(int index) {
        Node<T> currentNode = first;
        int counter = 0;

        if (indexBiggerThanSize(index))
            throw new IllegalArgumentException();

        while(counter != index) {
            currentNode = first.getNextNode();
            counter++;
        }
        return currentNode.getData();
    }

    public void remove(int index) {
        Node<T> previousNode = first;
        Node<T> currentNode = first;

        int counter = 0;

        if (indexBiggerThanSize(index))
            throw new IllegalArgumentException();


        if (indexIsZero(index)) {
            first = first.getNextNode();
            return;
        }

        if (indexIsLessThanZero(index))
            throw new IllegalArgumentException();

        while (counter != index) {
            previousNode = currentNode;
            currentNode = currentNode.getNextNode();
            counter++;
        }
        previousNode.setNextNode(currentNode.getNextNode());
    }

    public int size() {
        Node<T> currentNode = first;
        int size = 0;

        if (currentNode == null)
            return size;

        while (currentNode != null) {
            size++;
            currentNode = currentNode.getNextNode();
        }

        return size;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node<T> currentNode = first;
        while (currentNode != null) {
            result.append(currentNode.getData() + " ");
            currentNode = currentNode.getNextNode();
        }
        return result.toString();
    }


    @Override
    public Iterator<T> iterator() {
        return new ListIterator<>(this);
    }
}

class ListIterator<T> implements Iterator<T> {
    Node<T> currentNode;

    public ListIterator(LinkedList<T> list) {
        currentNode = list.getFirst();
    }

    @Override
    public boolean hasNext() {
        return currentNode != null;
    }

    @Override
    public T next() {
        T data = currentNode.getData();
        currentNode = currentNode.getNextNode();
        return data;
    }
}

class Node <T>{
    private T data;
    private Node nextNode = null;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}
