package org.example.storage;

import org.example.exception.StorageFullException;
import org.example.exception.ValueNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class HashMapBasedStorage<Key, Value> implements Storage<Key, Value>{

    Map<Key, Value> storage;
    private final Integer capacity;

    public HashMapBasedStorage(Integer capacity) {
        this.capacity = capacity;
        storage = new HashMap<>();
    }

    @Override
    public void add(Key key, Value value) throws StorageFullException {

        if(isStorageFull()) throw new StorageFullException("Capacity is full. can add more items.");

        storage.put(key, value);

    }

    @Override
    public Value get(Key key) throws ValueNotFoundException {
        if(!storage.containsKey(key)) throw new ValueNotFoundException("No value is present with this key");
        return storage.get(key);
    }

    @Override
    public void remove(Key key) throws ValueNotFoundException {
        if(!storage.containsKey(key)) throw new ValueNotFoundException("No value is present with this key");
        storage.remove(key);
    }

    private boolean isStorageFull() {

        return capacity == storage.size();
    }
}
