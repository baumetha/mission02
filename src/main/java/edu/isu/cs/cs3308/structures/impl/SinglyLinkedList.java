package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.List;

/**
 * @author Ethan Baumgartner with references from Isaac Griffith code and the textbook examples
 */
public class SinglyLinkedList<E> implements List<E> {

    private Node<E> Head = null;

    private Node<E> Tail = null;

    private int size = 0;

    // Node Class based off in-class and book examples
    public class Node<E> {

        private E data;

        private Node<E> next;

        public Node(E data) {
            this.data = data;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {data = data;}

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> node) {next = node;}
    }
    /**
     * @return first element in the list or null if the list is empty.
     */
    public E first() {
        if (isEmpty()) return null;
        return Head.getData();
    }
    /**
     * @return last element in the list or null if the list is empty.
     */
    public E last() {
        if (isEmpty())return null;
        return Tail.getData();
    }
    /**
     * Adds the provided element to the end of the list, only if the element is
     * not null.
     * Reference to textbook example
     * @param element Element to be added to the end of the list.
     */
    public void addLast(E element) {
        if(element == null)
            return;
        Node<E> newest = new Node<>(element);
        if (isEmpty()) {
            Head = newest;
        }
        else {
            Tail.setNext(newest);
        }
        Tail = newest;
        size++;
    }
    /**
     * Adds the provided element to the front of the list, only if the element
     * is not null.
     *
     * @param element Element to be added to the front of the list.
     * Code example from in-class
     */
    public void addFirst(E element) {
        if (element == null)
            return;
        Node<E> nodeHead = new Node<>(element);
        nodeHead.setNext(Head);
        Head = nodeHead;
        if (size == 0) {
            Tail = Head;
        }
        size++;
    }
    /**
     * Removes the element at the front of the list.
     * Code with a basis off book examples
     * @return Element at the front of the list, or null if the list is empty.
     */
    public E removeFirst(){
        if(isEmpty()) return null;
        E headData = Head.getData();
        Head = Head.getNext();
        size--;
        if(size == 0)
            Tail = null;
        return headData;
    }

    /**
     * Removes the element at the end of the list.
     *Code with a basis off book examples
     * @return Element at the end of the list, or null if the list is empty.
     */
    public E removeLast(){
        if (isEmpty()) return null;
        E tailData = Tail.getData();
        Tail = Tail.getNext();
        size--;
        if (size == 0)
            Head = null;
        return  tailData;
    }
    /**
     * Inserts the given element into the list at the provided index. The
     * element will not be inserted if either the element provided is null or if
     * the index provided is less than 0. If the index is greater than or equal
     * to the current size of the list, the element will be added to the end of
     * the list.
     *
     * @param element Element to be added (as long as it is not null).
     * @param index Index in the list where the element is to be inserted.
     */
    public void insert(E element, int index) {
        if (element == null || index < 0)
            return;
        if (index >= size) {
            addLast(element);
            return;
        }
        else {
            Node<E> insert = Head;
            for (int j = 0; j < index-1; j++) {
                insert = insert.getNext();
            }
            Node<E> newInsert = new Node<>(element);
            newInsert.setNext(insert.getNext());
            insert.setNext(newInsert);
            size++;
        }
    }
    /**
     * Removes the element at the given index and returns the value.
     *
     * @param index Index of the element to remove
     * @return The value of the element at the given index, or null if the index
     * is greater than or equal to the size of the list or less than 0.
     * Code example from in-Class
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node<E> current = Head;
        for (int i = 0; i < index - 1; i++) {
            current = current.getNext();
        }
        Node<E> toRemove = current.getNext();
        current.setNext(toRemove.getNext());
        toRemove.setNext(null);
        size--;
        return toRemove.getData();
    }
    /**
     * Retrieves the value at the specified index. Will return null if the index
     * provided is less than 0 or greater than or equal to the current size of
     * the list.
     *
     * @param index Index of the value to be retrieved.
     * @return Element at the given index, or null if the index is less than 0
     * or greater than or equal to the list size.
     */
    public E get(int index){
        if(isEmpty() || index < 0 || index >= size)
            return null;
        Node<E> getNode = Head;
        for (int i = 0; i < index; i++){
            getNode = getNode.getNext();
        }
        return  getNode.getData();
    }
    /**
     * @return The current size of the list. Note that 0 is returned for an
     * empty list.
     */
    public int size(){
        return size;
    }

    /**
     * @return true if there are no items currently stored in the list, false
     * otherwise.
     */
    public boolean isEmpty(){
        if(size == 0)
            return true;
        else{
            return false;
        }
    }

    /**
     * Prints the contents of the list in a single line separating each element
     * by a space to the default System.out
     */
    public void printList(){
        Node<E> text = Head;
        for(int i = 0; i < size; i++ ){

            System.out.println(text.getData().toString());
            text = text.getNext();
        }
    }
}



