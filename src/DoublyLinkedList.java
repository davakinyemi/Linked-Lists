/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dav
 */
public class DoublyLinkedList<E> {

    //Nested node class for storing the data

    public static class Node<E> {

        private E element;
        private Node<E> next;
        private Node<E> prev;

        public Node(E e, Node<E> prev, Node<E> next) {
            this.element = e;
            this.next = next;
            this.prev = prev;
        }

        // return node element
        public E getElement() {
            return element;
        }

        // get next node
        public Node<E> getNext() {
            return next;
        }

        // get previous node
        public Node<E> getPrev(){
            return this.prev;
        }
        
        // set next node
        public void setNext(Node<E> next) {
            this.next = next;
        }
        
        // set previous node
        public void setPrev(Node<E> prev){
            this.prev = prev;
        }

    }
    
    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;
    
    public DoublyLinkedList(){
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }
    
    // get link size
    public int size(){
        return size;
    }
    
    // check if empty
    public boolean isEmpty(){
        return size == 0;
    }
    
    // get first element
    public E first(){
        if(size == 0){
            return null;
        }
        
        return header.getNext().getElement();
    }
    
    // get last element
    public E last(){
        if(size == 0){
            return null;
        }
        
        return trailer.getPrev().getElement();
    }
    
    // add to front of list
    public void addFirst(E e){
        addBetween(e, this.header, this.header.getNext());
    }
    
    // add to end of list
    public void addLast(E e){
        addBetween(e, this.trailer.getPrev(), this.trailer);
    }
    
    // remove first element
    public E removeFirst(){
        if(size == 0){
            return null;
        }
        
        return remove(header.getNext());
    }
    
    // remove last element
    public E removeLast(){
        if(size == 0){
            return null;
        }
        
        return remove(trailer.getPrev());
    }
    
    // pred = predecessor, succ = successor
    public void addBetween(E e, Node<E> succ, Node<E> pred){
        Node<E> newest = new Node<>(e, pred, succ);
        pred.setNext(newest);
        succ.setPrev(newest);
        size++;
    }
    
    // main remove method (removes and resets link)
    public E remove(Node<E> node){
        Node<E> prev = node.getPrev();
        Node<E> next = node.getNext();
        
        prev.setNext(next);
        next.setPrev(prev);
        size--;
        
        return node.getElement();
    }
    
}
