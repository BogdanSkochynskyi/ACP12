package data_structure.my_hashmap;

import java.util.*;

/**
 * Created by dexter on 13.02.16.
 */
public class MyHashMap<K, V> implements Map<K, V> {

    private static final int DEFAULT_SIZE = 16;
    private static final float MAX_CAPACITY = 0.75f;
    private MyNode<K, V> [] mass = new MyNode[DEFAULT_SIZE];
    private int size;

    public MyHashMap(){
    }

    public MyHashMap(int initialCapacity){
        mass = new MyNode[initialCapacity];
    }

    @Override
    public V put(K key, V value) {
        int hash = key.hashCode();
        return putValue(key, value, hash);
    }

    private int getPosition(int hash, int length){
        return Math.abs(hash) % length;
    }

    private V putValue(K key, V value, int hash) {

        int position = getPosition(hash, mass.length);

        if (mass[position] == null) {
            mass[position] = new MyNode<>(key, value, null, hash);
        } else {
            V oldValue = putInTheEnd(key, value, mass[position], hash);
            if (oldValue != null) return oldValue;
        }

        size++;
        if((double) size / (double) mass.length >= MAX_CAPACITY) reHashing();

        return null;
    }

    private void reHashing(){
        MyNode<K, V> [] tmp = new MyNode[size*2];

        MyHashMapIterator iter = new MyHashMapIterator();
        for(; iter.hasNext(); iter.next()){
            tmp[getPosition(iter.currNode.hash, tmp.length)] = iter.currNode;
        }

        mass = tmp;
    }

    private V putInTheEnd(K key, V value, MyNode<K, V> mas, int hash) {

        do {
            if(mas.next == null) {

                if(!mas.nodeKey.equals(key)) {
                    mas.next = new MyNode<>(key, value, null, hash);
                }
                else {
                    V oldValue = mas.nodeValue;
                    mas.nodeValue = value;
                    return oldValue;
                }
                break;
            }
            mas = mas.next;
        }while(true);

        return null;
    }

    @Override
    public V get(Object key) {
        if(key == null){
            throw new NullPointerException("not initialization key");
        }
        int position = getPosition(key.hashCode(), mass.length);
        return mass[position] != null ? mass[position].nodeValue : null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public V remove(Object key) {
        if(key == null){
            throw new NullPointerException("not initialization key");
        }
        return removeValue(key, getPosition(key.hashCode(), mass.length));
    }

    private V removeValue(Object key, int position){

        MyNode<K, V> tmp = mass[position];
        MyNode<K, V> previous = mass[position];
        V removedValue = null;

        do {
            if(tmp.nodeKey.equals(key)){

                removedValue = tmp.nodeValue;
                if(mass[position].next == null) mass[position] = null;
                else previous.next = tmp.next;

                size--;
                return removedValue;

            } else{
                previous = tmp;
                tmp = tmp.next;
            }
        }while (tmp != null);

        return removedValue;
    }

    @Override
    public boolean containsKey(Object key) {

        MyHashMapIterator iter = new MyHashMapIterator();

        while(iter.hasNext()){
            if(iter.currNode.nodeKey.equals(key)) return true;
            iter.next();
        }

        return false;
    }

    @Override
    public boolean containsValue(Object value) {

        MyHashMapIterator iter = new MyHashMapIterator();

        while(iter.hasNext()){
            if(iter.currNode.nodeValue.equals(value)) return true;
            iter.next();
        }

        return false;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

        if(m == null || m.size() <= 0) return;

        for (Map.Entry<? extends K, ? extends V> e : m.entrySet()) {
            K key = e.getKey();
            V value = e.getValue();
            put(key, value);
        }
    }

    @Override
    public void clear() {
        MyHashMapIterator iter = new MyHashMapIterator();

        while(iter.hasNext()){
            mass[iter.currIndex] = null;
            iter.next();
        }
        size = 0;
    }

    @Override
    public Set<K> keySet() {

        MyHashMapIterator iter = new MyHashMapIterator();
        Set<K> set = new HashSet<>();

        while(iter.hasNext()){
            set.add(iter.currNode.nodeKey);
            iter.next();
        }

        return set;
    }

    @Override
    public Collection<V> values() {

        MyHashMapIterator iter = new MyHashMapIterator();
        Collection<V> collection = new ArrayList<>();

        while(iter.hasNext()){
            collection.add(iter.currNode.nodeValue);
            iter.next();
        }

        return collection;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {

        Set<Entry<K, V>> set = new HashSet<>();
        MyHashMapIterator iter = new MyHashMapIterator();

        while(iter.hasNext()){
            set.add(iter.currNode);
            iter.next();
        }

        return set;
    }

    private static class MyNode<NK, NV> implements Entry<NK, NV>{

        final int hash;
        NK nodeKey;
        NV nodeValue;
        MyNode<NK, NV> next;

        MyNode(NK key, NV value, MyNode<NK, NV> next, int hash){
            nodeKey = key;
            nodeValue = value;
            this.next = next;
            this.hash = hash;
        }

        @Override
        public NK getKey() {
            return nodeKey;
        }

        @Override
        public NV getValue() {
            return nodeValue;
        }

        private int getHash() {
            return hash;
        }

        @Override
        public NV setValue(NV value) {
                NV oldValue = nodeValue;
                nodeValue = value;
                return oldValue;
        }
    }

    private class MyHashMapIterator implements Iterator<MyNode<K,V>>{

        MyNode<K, V> currNode;
        int currIndex;

        MyHashMapIterator(){
            findFirstNonNull();
        }

        private void findFirstNonNull() {
            for (;currIndex < mass.length && mass[currIndex] == null; currIndex++) {}

            currNode = currIndex < mass.length ? mass[currIndex] : null;
        }

        @Override
        public boolean hasNext() {
            return currNode != null;
        }

        @Override
        public MyNode<K, V> next() {

            MyNode<K, V> tmp = currNode;

            if(currNode.next != null) currNode = currNode.next;
            else {
                currIndex++;
                findFirstNonNull();
            }

            return tmp;
        }
    }
}
