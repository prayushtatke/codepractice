package prg.ds;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LRUCacheTest {
    private LRUCache lru;

    public LRUCacheTest() {
        this.lru = lru;
    }

    @Test
    public void test() {
        LRUCache<Integer,String> lru = new LRUCache<>(2);
        Assertions.assertNull(lru.get(2));

        lru.put(2,"TWO");
        Assertions.assertEquals("TWO", lru.get(2));
        Assertions.assertEquals(2, lru.headTobeRemoved().intValue());
        lru.put(1,"ONE");
        Assertions.assertEquals(2, lru.headTobeRemoved().intValue());
        lru.put(3,"THREE");
        Assertions.assertEquals(2, lru.headTobeRemoved().intValue());
        lru.put(4,"FOUR");
        Assertions.assertEquals(1, lru.headTobeRemoved().intValue());
    }

}
