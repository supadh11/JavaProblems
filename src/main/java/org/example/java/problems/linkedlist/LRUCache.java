package org.example.java.problems.linkedlist;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


/*
146. LRU Cache
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.

Solution : We need to use both HashMap and DoublyLinkedList for the implementation of the LRU Cache
HashMap to get the node quickly and DoubleLinkedList to maintain the least recently used nodes

Create a node class containing key, value pair and to maintain next and prev for doubly linked list
In the Constructor of the LRUCache -> initiate the header and tail node and assign the values
also initialize the hashmap

in the get method -> check if the hm contains key, if yes return the node and now we have to put the
node in the front as it is least recently used, so for that we have to create a remove method where we will
get the prev node and the next node for the node and assign prev.next = nextNode
also we have to move it to the front -> so for that also we have to create a addToFront method

in the put method -> checck if the hm already contains the node, if yes then we have to replace existing node
from hm and linkedlist. Then we have to check for the capacity of hm, if it exceeds the limit then we have to remove
the lruNode maintained by tailNode. also from the hm. Once these two steps are done we need to put the node in
hashmap and also addToFront.


 */
public class LRUCache {

    public static void main(String args[]){

    }
    private Map<Integer, Node> hm;
    LinkedList<Node> queue;
    Node head, tail;
    int capcaity;
    public LRUCache(int capacity) {
        queue = new LinkedList<Node>();
        hm = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        this.capcaity = capacity;
    }

    public int get(int key) {
        Node node  = hm.get(key);

        remove(node);
        addToFront(node);
        return node == null? -1:node.val;

    }

    private void remove(Node node){
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    private void addToFront(Node node){
        head.next = node;
        node.prev = head;
        node.next = tail;
        tail.prev = node;

    }



    public void put(int key, int value) {
        if (hm.containsKey(key)) {
            Node existingNode = hm.get(key);
            hm.remove(existingNode);
            remove(existingNode);
        }
        if(hm.size() >= capcaity){
            Node lruNode = tail.prev;
            remove(lruNode);
            hm.remove(lruNode.key);
        }
        Node newNode = new Node(key,value);
        hm.put(key, newNode);
        addToFront(newNode);
    }

    private static class Node {
        int key, val;
        Node prev,next;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }


    }
}
