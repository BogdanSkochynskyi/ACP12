package lessonsWeek1;

import java.util.*;

public class MyBinarySearchTreeMap<K extends Comparable, V> implements Map<K, V> {

    private Node root;
    private int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size != 0;
    }

    @Override
    public boolean containsKey(Object key) {

        K searchingKey = (K) key;

        Node searchingNode = binarySearch(searchingKey);
        return searchingNode != null;

    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V get(Object key) {

        K searchingKey = (K) key;

        Node searchingNode = binarySearch(searchingKey);
        return searchingNode == null ? null : searchingNode.value;

    }

    @Override
    public V put(K key, V value) {

        if (root == null) {
            root = new Node(key, value);
            size++;
            return null;
        }

        Node curNode = root;
        while (true) {
            int a = key.compareTo(curNode.key);
            if (a < 0) {
                if (curNode.leftChild == null) {
                    curNode.leftChild = new Node(key, value, curNode);
                    size++;
                    return null;
                } else {
                    curNode = curNode.leftChild;
                }
            } else if (a > 0) {
                if (curNode.rightChild == null) {
                    curNode.rightChild = new Node(key, value, curNode);
                    size++;
                    return null;
                } else {
                    curNode = curNode.rightChild;
                }
            } else {
                V oldV = curNode.value;
                curNode.value = value;
                return oldV;
            }
        }

    }

    private Node binarySearch(K searchKey) {

        Node curNode = root;
        while (curNode != null) {
            int compare = searchKey.compareTo(curNode.key);
            if (compare < 0) {
                curNode = curNode.leftChild;
            } else if (compare > 0) {
                curNode = curNode.rightChild;
            } else {
                break;
            }
        }

        return curNode;
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    private class Node {

        K key;
        V value;
        Node parent = null;
        Node leftChild = null;
        Node rightChild = null;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Node(K key, V value, Node parent) {
            this.key = key;
            this.value = value;
            this.parent = parent;
        }

    }

}