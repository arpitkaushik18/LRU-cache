package org.example.factories;

import org.example.Cache;
import org.example.policies.LRUEvictionPolicy;
import org.example.storage.HashMapBasedStorage;


public class CacheFactory<Key, Value> {

    public Cache<Key,Value> defaultCache(int capacity){

        return new Cache<Key, Value>(new LRUEvictionPolicy<Key>(), new HashMapBasedStorage<Key,Value>(capacity));

    }

}
