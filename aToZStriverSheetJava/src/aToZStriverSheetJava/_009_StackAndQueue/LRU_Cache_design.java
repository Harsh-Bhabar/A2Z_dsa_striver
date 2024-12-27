package aToZStriverSheetJava._009_StackAndQueue;

import java.util.*;

//link - https://leetcode.com/problems/lru-cache/

public class LRU_Cache_design {

    class Node{
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val){
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    class LRUCache {

        Node head = new Node(-1, -1);
        Node tail = new Node(-1, -1);
        int capacity;
        HashMap<Integer, Node> mp ;

        public LRUCache(int capacity) {
            head.next = tail;
            tail.prev = head;
            this.mp = new HashMap<>();
            this.capacity = capacity;
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
            // always check if it exist
            if(mp.containsKey(key)){
                remove(mp.get(key)); // remove from list just to add again at front
            }
            if(mp.size() == capacity){
                remove(tail.prev);
            }
            insertAtHead(new Node(key, value));
        }

        public void insertAtHead(Node newNode){
            mp.put(newNode.key, newNode);
            // adding ele after head
            newNode.next = head.next;
            head.next.prev =
                    head.next = newNode;
            newNode.prev = head;
        }

        public void remove(Node node){
            mp.remove(node.key);
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }
    }

}
