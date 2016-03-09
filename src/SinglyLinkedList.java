/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dav
 * @param <E>
 */
public class SinglyLinkedList<E> {

    //Nested node class for storing the data

    public static class Node<E> {

        private E element;
        private Node<E> next;

        public Node(E e, Node<E> next) {
            this.element = e;
            this.next = next;
        }

        // get element stored in node
        public E getElement() {
            return element;
        }

        // get next node
        public Node<E> getNext() {
            return next;
        }

        // set next node
        public void setNext(Node<E> next) {
            this.next = next;
        }

    }

    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    public SinglyLinkedList() {

    }

    // get list size
    public int size() {
        return size;
    }

    // check if empty
    public boolean isEmpty() {
        return size == 0;
    }

    // get first stored element
    public E first() {
        if (isEmpty()) {
            return null;
        }

        return head.getElement();
    }

    // get last stored element
    public E last() {
        if (isEmpty()) {
            return null;
        }

        return tail.getElement();
    }

    // add to front of link
    public void addFirst(E e) {
        head = new Node<>(e, head);
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    // add to back of link
    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()) {
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    // remove first element
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        E answer = head.getElement();
        head = head.getNext();
        size--;
        if (size == 0) {
            tail = null;
        }
        return answer;
    }
}
