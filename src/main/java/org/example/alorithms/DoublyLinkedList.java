package org.example.alorithms;


import org.example.exception.InvalidElementException;

import javax.lang.model.element.Element;
import java.util.NoSuchElementException;

public class DoublyLinkedList <E>{

    DoublyLinkedListNode<E> dummyHead;

    DoublyLinkedListNode<E> dummyTail;

    public DoublyLinkedList(){

        dummyHead = new DoublyLinkedListNode<>(null);

        dummyTail = new DoublyLinkedListNode<>(null);

        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    public void detachNode(DoublyLinkedListNode<E> node){

        if(node!=null){
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

    }
    public void addNodeAtLast(DoublyLinkedListNode<E> node){

        dummyTail.prev.next = node;
        node.prev = dummyTail.prev;
        node.next = dummyTail;

        dummyTail.prev = node;

    }

    public DoublyLinkedListNode<E> addElementAtLast(E element) throws InvalidElementException {

        if(element == null) {

            throw new InvalidElementException(" Not a valid Element ");

        }

        DoublyLinkedListNode<E> newNode = (DoublyLinkedListNode<E>) new DoublyLinkedListNode<>(element);

        addNodeAtLast(newNode);
        return newNode;


    }

    public boolean IsItemPresent() {
        return dummyHead.next!=dummyTail;
    }

    public DoublyLinkedListNode getFirstNode() throws NoSuchElementException {

        if(!IsItemPresent()){
            return null;
        }
        return dummyHead.next;
    }

    public DoublyLinkedListNode getLastNode() throws NoSuchElementException {

        if(!IsItemPresent()){
            return null;
        }
        return dummyTail.prev;
    }



}
