package lrucache;

import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashMap;


public class LRUCacheMain {

    static class Node{
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    static class LRUCache {
        int capacity;
        LinkedHashMap<Integer, Node> map = new LinkedHashMap<Integer, Node>();
        Node head=null;
        Node end=null;

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if(map.containsKey(key)){
                Node n = map.get(key);
                del(n);
                setHead(n);
                return n.value;
            }

            return -1;
        }

        public void add(int key, int value) {
            Node created = new Node(key, value);
            if(map.size()>=capacity){
                map.remove(end.key);
                del(end);
                setHead(created);
            }else{
                setHead(created);
            }
            map.put(key, created);
        }

        public int remove(int key) {
            if(map.containsKey(key)){
                Node n = map.get(key);
                int value = n.value;
                del(n);
                return value;
            }
            return -1;
        }

        public void evict() {
            Iterator<Integer> keys = map.keySet().iterator();
            Integer evictKey = null;
            while (keys.hasNext()) {
                evictKey = keys.next();
            }
            System.out.println(evictKey);
            System.out.println(map.get(evictKey).key);
            System.out.println(map.get(evictKey).value);
            if(evictKey != null) remove(map.get(evictKey).key);
        }

        private void del(Node n){
            if(n.pre!=null){
                n.pre.next = n.next;
            }else{
                head = n.next;
            }

            if(n.next!=null){
                n.next.pre = n.pre;
            }else{
                end = n.pre;
            }
        }

        private void setHead(Node n){
            n.next = head;
            n.pre = null;

            if(head!=null)
                head.pre = n;

            head = n;

            if(end ==null)
                end = head;
        }
    }


    public static void main(String[] args) {
        LRUCache cache = new LRUCache(10);

        cache.add(5,3);
        cache.add(1,2);
        System.out.println(cache.get(5));
        cache.evict();
        System.out.println(cache.remove(1));
        System.out.println(cache.get(1));
        System.out.println(cache.remove(5));


    }

}
