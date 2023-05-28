package org.example.policies;

/**
 * Interface to define eviction policy methods
 * @param <Key>
 */
public interface EvictionPolicy<Key> {

    void keyAccessed(Key key);

    Key evictKey();
}
