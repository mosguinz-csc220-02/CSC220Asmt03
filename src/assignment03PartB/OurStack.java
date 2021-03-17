/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: OurStack.java
 * Author: Frank M. Carrano
 * Author: Timothy M. Henry
 * Author: Duc Ta
 * Author: Kullathon Sitthisarnwattanachai
 * **********************************************
 */

package assignment03PartB;

import java.util.EmptyStackException;

public class OurStack<T> implements StackInterface<T> {

    private Node topNode;

    public OurStack() {
        topNode = null;
    }

    @Override
    public void push(T newEntry) {
        topNode = new Node(newEntry, topNode);
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            // Nothing to peek if it's empty!
            throw new EmptyStackException();
        }
        return topNode.getData();
    }

    @Override
    public T pop() {
        T element = peek();
        assert topNode != null;
        topNode = topNode.getNext();
        return element;
    }

    @Override
    public boolean isEmpty() {
        return topNode == null;
    }

    @Override
    public void clear() {
        topNode = null;
    }

    private class Node {

        private Node next;
        private T data;

        private Node(T data) {
            this(data, null);
        }

        private Node(T data, Node nextNode) {
            this.data = data;
            this.next = nextNode;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext() {
            this.next = next;
        }

    }
}