package org.example.alorithms;
import lombok.Getter;

@Getter
public class DoublyLinkedListNode<E> {

     DoublyLinkedListNode<E> prev;
     DoublyLinkedListNode<E> next;

     E element;

    public DoublyLinkedListNode(E element) {
        this.element = element;
        this.prev = null;
        this.next = null;
    }
}
