package com.udit.geeks_for_geeks.cache.lru;

import java.util.LinkedHashMap;
import java.util.Map;

public class JavaBased {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(5);
        cache.put("udit1", "1");
        cache.put("udit2", "2");
        cache.put("udit3", "3");
        cache.put("udit4", "4");
        cache.put("udit5", "5");
        cache.put("udit6", "6");


        System.out.println(cache.get("udit1"));
        System.out.println(cache.get("udit2"));
        System.out.println(cache.get("udit3"));
        System.out.println(cache.get("udit4"));
    }

    public static class LRUCache extends LinkedHashMap<String, String> {

        private int capacity;

        public LRUCache(int capacity) {
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
            return size() > capacity;
        }
    }
}
