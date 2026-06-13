package Test.B_medium;

import java.util.HashMap;
import java.util.LinkedHashMap;
/**
 * 146. LRU 缓存
 *
 * 请你设计并实现一个满足 LRU (最近最少使用) 缓存 [https://baike.baidu.com/item/LRU] 约束的数据结构。
 * 实现 LRUCache 类：
 * * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；
 * 如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 * 提示：
 * * 1 <= capacity <= 3000
 * * 0 <= key <= 10000
 * * 0 <= value <= 105
 * * 最多调用 2 * 105 次 get 和 put
 *
 * 链接：https://leetcode.cn/problems/lru-cache/
 */

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