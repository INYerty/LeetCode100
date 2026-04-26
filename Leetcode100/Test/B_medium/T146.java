package Test.B_medium;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class T146 {
    class LRUCache {
        int cap;
        LinkedHashMap<Integer,Integer> cache = new LinkedHashMap<>(); //修改后最后一个即为修改的元素
        public LRUCache(int capacity) {
            this.cap = capacity;
        }

        public int get(int key) {
            if (cache.containsKey(key)) {
                makeRecently(key);
                return cache.get(key);
            }
            return -1;
        }
        public void put(int key, int value) {
            if (cache.containsKey(key)) {
                cache.put(key, value);
                makeRecently(key);
                return;
            }
            if (cache.size() >= cap) {
                Integer oldestKey = cache.keySet().iterator().next(); //迭代器取第一个元素  即最后一个修改的元素
                cache.remove(oldestKey);
            }
            cache.put(key,value);
        }

        private void makeRecently(int key) {
            Integer val = cache.get(key); //添加到最前面  也就是将元素先删除后再插入，相当于简单修改一下
            cache.remove(key);
            cache.put(key,val);
        }
    }
}
