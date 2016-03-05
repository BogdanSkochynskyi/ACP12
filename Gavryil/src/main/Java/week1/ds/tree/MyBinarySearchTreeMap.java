package week1.ds.tree;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;

/**
 * Created by master on 14.02.16.
 */
public class MyBinarySearchTreeMap<K,V> implements Map<K,V> {


    private TreeNode<K,V> root;
    private int size;

    private Comparator<K> comparator;

    public MyBinarySearchTreeMap(Comparator<K> comparator) {
        this.comparator = comparator;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
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


        if(root == null){
            root = new TreeNode<K, V>(key,value,null,null,null);
            size++;
        } else {

            int compareRes = comparator.compare(key,root.key);

            TreeNode<K,V> iter = root;
            while(iter != null){
                if(compareRes < 0){
                    if(iter.left == null){
                        iter.left = new TreeNode<K, V>(key,value,null,null,root);
                        size++;
                        return null;
                    } else {
                        iter = iter.left;// step
                    }
                } else if(compareRes > 0) {
                    if(iter.right == null){
                        iter.right = new TreeNode<K, V>(key,value,null,null,root);
                        size++;
                        return null;
                    } else {
                        iter = iter.right;// step right
                    }
                } else {
                    V forRet = iter.value;
                    iter.value = value;
                    return forRet;
                }
            }




        }


        return null;
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

    private static class TreeNode<NK,NV> {
        final NK key;
        NV value;
        TreeNode<NK,NV> left;
        TreeNode<NK,NV> right;
        TreeNode<NK,NV> parent;

        public TreeNode(NK key, NV value, TreeNode<NK, NV> left,
                        TreeNode<NK, NV> right, TreeNode<NK, NV> parent) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }

}
