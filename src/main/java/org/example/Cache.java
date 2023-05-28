package org.example;

import org.example.exception.StorageFullException;
import org.example.exception.ValueNotFoundException;
import org.example.policies.EvictionPolicy;
import org.example.storage.Storage;

public class Cache <Key, Value>{

    private final EvictionPolicy<Key> evictionPolicy;

    private final Storage<Key, Value> storage;

    public Cache(EvictionPolicy<Key> evictionPolicy, Storage<Key, Value> storage) {
        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
    }

    public void put(Key key, Value value) throws ValueNotFoundException, StorageFullException {

        try{
            this.storage.add(key,value);
            this.evictionPolicy.keyAccessed(key);
        } catch (StorageFullException e) {
            System.out.println("Storage is full. let's evict the least accessed key");
            Key evictedKey = this.evictionPolicy.evictKey();
            this.storage.remove(evictedKey);
            System.out.println("Space created after eviction key : " + evictedKey);
            this.storage.add(key, value);
        }

    }

    public Value get(Key key){
        try{
            Value value = this.storage.get(key);
            this.evictionPolicy.keyAccessed(key);
            return value;
        } catch (ValueNotFoundException e) {
            System.out.println("Value is not there!!");
            return null;
        }
    }
}
