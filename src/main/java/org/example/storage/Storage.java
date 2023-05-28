package org.example.storage;

import org.example.exception.StorageFullException;
import org.example.exception.ValueNotFoundException;

/**
 * Interface to store key value pair in storage
 * @param <Key>
 * @param <Value>
 */
public interface Storage<Key, Value> {

    public void add(Key key, Value value) throws StorageFullException;

    Value get(Key key) throws ValueNotFoundException;

    void remove(Key key) throws ValueNotFoundException;

}
