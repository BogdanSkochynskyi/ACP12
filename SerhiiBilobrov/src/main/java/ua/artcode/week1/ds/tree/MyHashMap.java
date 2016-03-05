package ua.artcode.week1.ds.tree;

import java.util.*;


public class MyHashMap<K,V> implements Map<K,V> {

    public static final int DEFAULT_TABLE_SIZE = 16;

    private MyNode<K,V>[] table = new MyNode[DEFAULT_TABLE_SIZE];
    private int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V get(Object key) {
        return null;
    }

    @Override
    public V put(K key, V value) {
        // get hashCode of key
        // find position
        // if empty bucket -> just put
        // else add to head(change linked list)
        // if found duplicate(same) use equals -> replace and return old value

        int hash = Math.abs(key.hashCode());
        int position = hash % table.length;
        if(table[position] == null){
            table[position] = new MyNode<K, V>(key,value,null);
        } else {
            MyNode<K,V> iter = table[position];

            do{
                if(iter.key.equals(key)){
                    V oldValue = iter.value;
                    iter.value = value;
                    return oldValue;
                }
                iter = iter.next;
            } while (iter.next != null);

            iter.next = new MyNode<K, V>(key,value, null);
        }

        size++;
        return null;
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {

        Set<Entry<K,V>> entrySet = new HashSet<Entry<K, V>>();

        Iterator<MyNode<K,V>> iterator = new MyHashMapIterator();

        while(iterator.hasNext()){
            entrySet.add(iterator.next());
        }


        return entrySet;
    }

    @Override
    public void putAll(Map m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        Set<K> keys = new HashSet<K>();

        Iterator<MyNode<K,V>> iterator = new MyHashMapIterator();

        while(iterator.hasNext()){
            keys.add(iterator.next().key);
        }

        return keys;
    }

    @Override
    public Collection<V> values() {
        Collection<V> values = new ArrayList<V>();

        Iterator<MyNode<K,V>> iterator = new MyHashMapIterator();

        while(iterator.hasNext()){
            values.add(iterator.next().value);
        }


        return values;
    }

    private class MyHashMapIterator implements Iterator<MyNode<K,V>> {

        int currIndex;
        MyNode<K,V> currNode;

        public MyHashMapIterator() {
            // find first non null
            findFirstNonNull();

        }

        private void findFirstNonNull() {
            for (;currIndex < table.length && table[currIndex] == null; currIndex++) {}

            currNode = currIndex < table.length ? table[currIndex] : null;
        }

        @Override
        public boolean hasNext() {
            return currNode != null;
        }

        @Override
        public MyNode<K, V> next() {
            MyNode<K,V> ret = currNode;

            if(currNode.next != null){
                currNode = currNode.next;
            } else {
                findFirstNonNull();
            }


            return ret;
        }
    }

    private static class MyNode<NK,NV> implements Entry<NK,NV> {

        NK key;
        NV value;
        MyNode<NK,NV> next;

        public MyNode(NK key, NV value, MyNode<NK, NV> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public NK getKey() {
            return key;
        }

        @Override
        public NV getValue() {
            return value;
        }

        @Override
        public NV setValue(NV value) {
            NV old = this.value;
            this.value = value;
            return old;
        }
    }


}
