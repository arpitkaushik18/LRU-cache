package org.example;


import lombok.SneakyThrows;
import org.example.factories.CacheFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CacheTest {

    Cache<Integer,Integer> integerCache;

    @BeforeEach
    void setup(){
        integerCache = new CacheFactory<Integer,Integer>().defaultCache(3);
    }
    @SneakyThrows
    @Test
    public void itShouldBeAbleToGetAndAddItemsInTheCache() {
        //cache.put(2, 2);
        integerCache.put(1,1);
        integerCache.put(2,2);

        assertEquals(1, integerCache.get(1)); // Accessing 1 after 2 got inserted which makes 2 the least recently used till now.
        //cache.put(3, 3);
        integerCache.put(3,3);
        //assertEquals(3, cache.get(3));

        // Now if i try to add any element, the eviction should happen
        // Also eviction should happen based on LeastRecentlyUsedItem
        // which is 2 in this case.
        integerCache.put(4, 4);

        //cache.get(2); // This should throw exception "Tried to access non-existing key."
    }

}
