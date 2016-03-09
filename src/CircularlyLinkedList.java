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
public class CircularlyLinkedList<E> {

    //Nested node class for storing the data

    public static class Node<E> {

        private E element;
        private Node<E> next;

        public Node(E e, Node<E> next) {
            this.element = e;
            this.next = next;
        }

        // get stored element
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
    
    private Node<E> tail = null;
    private int size = 0;
    public CircularlyLinkedList(){
        
    }
    
    // return size
    public int size(){
        return size;
    }
    
    // check if empty
    public boolean isEmpty(){
        return size == 0;
    }
    
    // get first element
    public E first(){
        if(isEmpty()){
            return null;
        }
        return tail.getNext().element;
    }
    
    // rotate list
    public void rotate(){
        if(tail != null){
            tail = tail.getNext();
        }
    }
    
    // add to front of list
    public void addFirst(E e){
        if(size == 0){
            tail = new Node<>(e, null);
            tail.setNext(tail);
        } else{
            Node<E> newest = new Node<>(e, tail.getNext());
            tail.setNext(newest);
        } 
        size++;
    }
    
    // add to last of list
    public void addLast(E e){
        addFirst(e);
        tail = tail.getNext();
    }
    
    // remove first element
    public E removeFirst(){
        if(isEmpty()){
            return null;
        }
        
        Node<E> head = tail.getNext();
        if(head == tail){
            tail = null;
        } else{
            tail.setNext(head.getNext());
        }
        size--;
        return head.getElement();
    }
    
}
