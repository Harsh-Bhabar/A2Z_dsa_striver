package aToZStriverSheetJava._006_LinkedList.Hard;

import java.util.HashMap;

//link - https://leetcode.com/problems/lru-cache/

public class Design_LRU {
    class Node{
        int key;
        int val;
        Node next;
        Node prev;

        Node(int key, int val){
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    class LRUCache {
        HashMap<Integer, Node> mp = new HashMap<>();
        int cap = 0;
        Node head = new Node(-1, -1);
        Node tail = new Node(-1, -1);

        public LRUCache(int capacity) {
            head.next = tail;
            tail.prev = head;
            cap = capacity;
        }

        public int get(int key) {
            if(mp.containsKey(key)){
                Node node = mp.get(key);
                remove(node);
                insertAtHead(node);
                return node.val;
            }else{
                return -1;
            }
        }

        public void put(int key, int value) {
            if(mp.containsKey(key)){
                mp.remove(mp.get(key));
                remove(mp.get(key));
            }
            if(mp.size() == cap){
                remove(tail.prev);
            }
            insertAtHead(new Node(key, value));
        }

        public void insertAtHead(Node node){
            mp.put(node.key, node);
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            node.prev = head;
        }

        public void remove(Node node){
            mp.remove(node.key);
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
