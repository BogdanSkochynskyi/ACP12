package week1.test;

import week1.ds.tree.MyHashMap;

import java.util.Map;

/**
 * Created by gavri on 20.02.2016.
 */
public class TestMyHashMap {
    public static void main(String[] args) {
        Map<Integer, String> map = new MyHashMap<>();

        map.put(12,"Voava");
        boolean putResult = map.size()==1;
        String input1 = "map.put(12,\"Voava\")";
        int expectedPut = 1;
        int actualPut = map.size();

        System.out.printf("result %b, input %s, expected size %d, actual size %d \n",
                                    putResult,input1,expectedPut,actualPut);


        map.put(10,"Sasha");
        boolean putResult2 = map.size()==2;
        String input2 = "map.put(10,\"Sasha\")";
        int expectedPut2 = 2;
        int actualPut2 = map.size();

        System.out.printf("result %b, input %s, expected size %d, actual size %d \n",
                putResult2,input2,expectedPut2,actualPut2);


        map.put(26,"Linked");
        boolean putResult3 = map.size()==3;
        String input3 = "map.put(26,\"Linked\")";
        int expectedPut3 = 3;
        int actualPut3 = map.size();

        System.out.printf("result %b, input %s, expected size %d, actual size %d \n",
                putResult3,input3,expectedPut3,actualPut3);


        Object expexted = "Sasha";
        Object actual = map.remove(10);
        boolean removeResult = actual.equals(expexted);
        String input4 = " map.remove(10)";
        int size  = map.size();

        System.out.printf("result %b, input %s, expected value %s, actual value %s, actual size %d \n",
                removeResult,input4,expexted,actual,size );

    }
}
