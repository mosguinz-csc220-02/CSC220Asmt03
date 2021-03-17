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

public class OurStack<T> implements StackInterface<T> {

    public OurStack() {
    }

    @Override
    public void push(T newEntry) {
    }

    @Override
    public T peek() {
    }

    @Override
    public T pop() {
    }

    @Override
    public boolean isEmpty() {
    }

    @Override
    public void clear() {
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