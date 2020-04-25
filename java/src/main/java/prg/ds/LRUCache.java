package prg.ds;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K,V> {

    private LinkedHashMap<K,V> lru ;
    private Map.Entry<K,V> headTobeRemoved;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        lru = new LinkedHashMap<>(capacity){
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                headTobeRemoved = eldest;
                return size() > capacity ? true : false;
            }
        };
    }

    public V get( K key) {
        return lru.get(key);
    }

    public boolean put(K key,V val) {
        boolean result = lru.size() < capacity;
        lru.put(key, val);
        return result;
    }

    public K headTobeRemoved() {
        return headTobeRemoved.getKey();
    }
}
