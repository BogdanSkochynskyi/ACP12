package week1.ds.tree;

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
        return (size==0);
    }

    @Override
    public boolean containsKey(Object key) {
        MyHashMapIterator iter = new MyHashMapIterator();
        while (iter.hasNext()){
            if(iter.currNode.key.equals(key)) return true;
            iter.next();
        }

        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        MyHashMapIterator iter = new MyHashMapIterator();
        while (iter.hasNext()){
            if (iter.currNode.value.equals(value))
                return true;
        }

        return false;
    }

    @Override
    public V get(Object key) {
        MyHashMapIterator iter = new MyHashMapIterator();
        while (iter.hasNext()){
            if(iter.currNode.key.equals(key)) return iter.currNode.value ;
            iter.next();
        }

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
                if(iter.next!=null)iter = iter.next;
            } while (iter.next != null);

            table[position] = new MyNode<K, V>(key,value,table[position]);
        }

        size++;
        return null;
    }

    @Override
    public V remove(Object key) {
        MyHashMapIterator iter = new MyHashMapIterator();
        do{
            if(iter.currNode.key.equals(key)){
                V value = iter.currNode.value;
                if(table[iter.currIndex].equals(iter.currNode)) {
                    table[iter.currIndex] = iter.currNode.next;
                    size--;
                }
                iter = null;
                return value;
            }  else if (iter.currNode.next!=null && iter.currNode.next.key.equals(key)) {
                V value = iter.currNode.next.value;
                iter.currNode.next = iter.currNode.next.next;
                size--;
                iter = null;
                return value;
            }
            iter.next();
        }while (iter.hasNext());

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
                currIndex++;
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
        public NV getValue()  {
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
