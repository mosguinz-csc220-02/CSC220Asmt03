/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: LinkedBag.java
 * Author: Frank M. Carrano
 * Author: Timothy M. Henry
 * Author: Duc Ta
 * Author: Kullathon Sitthisarnwattanachai
 * **********************************************
 */

package assignment03PartA;

import java.util.ArrayList;

public final class LinkedBag<T> implements PrimaryDataStructureBagInterface<T> {

    private Node firstNode;
    private int numberOfEntries;

    public LinkedBag() {
        firstNode = null;
        numberOfEntries = 0;
    }

    private Node getNodeReference(T anEntry) {
        Node thisNode = firstNode;
        for (int i = 0; i < numberOfEntries; i++) {
            if (anEntry.equals(thisNode.data)) {
                return thisNode;
            }
            thisNode = thisNode.next;
        }
        return null;
    }

    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    @Override
    public boolean add(T newEntry) {
        Node newNode = new Node(newEntry);
        newNode.next = firstNode;
        firstNode = newNode;
        numberOfEntries++;
        return true;
    }

    @Override
    public boolean removeAllOccurrences(T[][] entries) {
        System.out.println("[+] Removing 2D test array items from the bag...");
        ArrayList<T> uniqueElements = new ArrayList<>();

        System.out.println(" [-] Converting 2D array to 1D...");
        System.out.println(" [-] Removing duplicates in 1D array...");
        for (T[] row : entries) {
            for (T item : row) {
                if(!uniqueElements.contains(item)) {
                    uniqueElements.add(item);
                }
            }
        }

        System.out.print(" [>] The final 1D array now contains: ");
        for (T element : uniqueElements) {
            System.out.print(element + " ");
        }
        System.out.println();

        System.out.println(" [-] Removing the final 1D array items from the bag...");
        Node thisNode = firstNode;
        while (thisNode != null) {
            if (uniqueElements.contains(thisNode.data)) {
                thisNode.data = firstNode.data;
                firstNode = firstNode.next;
                numberOfEntries--;
            }
            thisNode = thisNode.next;
        }
        return true;
    }

    @Override
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] results = (T[]) new Object[numberOfEntries];

        Node thisNode = firstNode;
        for (int i = 0; i < numberOfEntries; i++) {
            if (thisNode != null) {
                results[i] = thisNode.data;
                thisNode = thisNode.next;
            }
        }

        return results;
    }

    private class Node {
        private T data;
        private Node next;

        private Node(T dataPortion) {
            this(dataPortion, null);
        } // end constructor

        private Node(T dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        }
    }
}