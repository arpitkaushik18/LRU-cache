package org.example.policies;

import lombok.SneakyThrows;
import org.example.alorithms.DoublyLinkedList;
import org.example.alorithms.DoublyLinkedListNode;
import org.example.exception.InvalidElementException;
import org.example.storage.HashMapBasedStorage;

import javax.lang.model.element.Element;
import java.util.HashMap;
import java.util.Map;

public class LRUEvictionPolicy<Key> implements EvictionPolicy<Key>{

    private DoublyLinkedList<Key> dll;
    private Map<Key, DoublyLinkedListNode<Key>> mapper;

    public LRUEvictionPolicy() {
        this.dll = new DoublyLinkedList<>();
        this.mapper = new HashMap<>();
    }

    @SneakyThrows
    @Override
    public void keyAccessed(Key key) {

        if(mapper.containsKey(key)){

            dll.detachNode(mapper.get(key));
            dll.addNodeAtLast(mapper.get(key));

        } else{
            DoublyLinkedListNode<Key> newNode = dll.addElementAtLast(key);
            mapper.put(key,newNode);
        }

    }

    @Override
    public Key evictKey() {

        DoublyLinkedListNode<Key> evictedNode = dll.getFirstNode();

        if(evictedNode == null)
            return null;

        dll.detachNode(evictedNode);

        mapper.remove(evictedNode.getElement());

        return evictedNode.getElement();

    }
}
