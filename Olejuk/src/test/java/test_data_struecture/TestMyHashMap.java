package test_data_struecture;

import data_structure.my_hashmap.MyHashMap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * Created by dexter on 13.02.16.
 */
public class TestMyHashMap {

    Map<String, Integer> map = new MyHashMap<>();

    @Before
    public void setUp() throws Exception {
        map.put("Oleg", 28);
        map.put("Dex", 29);
        map.put("James", 30);
    }

    @Test
    public void testGetSize() throws Exception {
        Assert.assertNotNull(map.put("Oleg", 28));
        Assert.assertEquals(map.put("James", 33), new Integer(30));
        Assert.assertEquals(3, map.size());
    }

    @Test
    public void testGet() throws Exception {
        Assert.assertEquals(map.get("Oleg"), new Integer(28));
        Assert.assertNull(map.get("Ivan"));
    }

    @Test
    public void testRemove() throws Exception {
        Assert.assertEquals(map.remove("Oleg"), new Integer(28));
        Assert.assertNull(map.get("Oleg"));
    }

    @Test
    public void testSet() throws Exception {
        Set<String> set = map.keySet();
        Assert.assertEquals(set.size(), 3);
        Assert.assertEquals(set.contains("Dex"), true);
    }

    @Test
    public void testValues() throws Exception {
        Collection<Integer> collection = map.values();
        Assert.assertEquals(collection.size(), 3);
        Assert.assertEquals(collection.contains(30), true);
    }

    @Test
    public void testEntrySet() throws Exception {
        Set<Map.Entry<String, Integer>> set = map.entrySet();
        Assert.assertEquals(set.size(), 3);
    }

    @Test
    public void testClear() throws Exception {
        map.clear();
        Assert.assertEquals(0, map.size());
        Assert.assertEquals(map.get("Oleg"), null);
    }

    @Test
    public void testContainsKey() throws Exception {
        Assert.assertEquals(map.containsKey("Oleg"), true);
        Assert.assertEquals(map.containsKey("Rick"), false);
   }

    @Test
    public void testContainsValue() throws Exception {
        Assert.assertEquals(map.containsValue(30), true);
        Assert.assertEquals(map.containsValue(55), false);
    }

    @Test
    public void testPutAll(){
        Map<String, Integer> testMap1 = new HashMap<>();
        testMap1.put("Larson", 45);
        testMap1.put("Jason", 46);
        Map<String, Integer> testMap2 = new HashMap<>();
        map.putAll(testMap1);
        map.putAll(testMap2);
        Assert.assertEquals(5, map.size());
        Assert.assertEquals(map.containsValue(45), true);
        Assert.assertEquals(map.containsKey("Jason"), true);
    }

    @Test
    public void testReHashing(){
        map.put("Michael", 44);
        map.put("Oliver", 23);
        map.put("Arnold", 43);
        map.put("Alf", 35);
        map.put("Ben", 26);
        map.put("Rafael", 13);
        map.put("Jimmy", 35);
        map.put("Harry", 24);
        map.put("Dan", 23);
        map.put("Denis", 21);
        map.put("Burton", 24);
        map.put("Billy", 15);
        map.put("Bob", 11);
        map.put("Anna", 43);
        map.put("Lisa", 51);
        map.put("Gregor", 55);
        map.put("Goofy", 50);
        map.put("Micky", 48);
        Assert.assertEquals(map.size(), 21);
    }
}
