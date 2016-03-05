package test_data_struecture;

import data_structure.recursion.RecursionUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by dexter on 18.02.16.
 */
public class TestRecursion {

    @Before
    public void setUp(){
    }
    @Test
    public void testSplitArray(){
        Assert.assertTrue(RecursionUtils.splitArray2(new int []{5, 2, 3}));
        Assert.assertTrue(RecursionUtils.splitArray2(new int []{4, 2, 2, 2, 2}));
        Assert.assertFalse(RecursionUtils.splitArray2(new int []{4, 2, 2, 2}));
        Assert.assertFalse(RecursionUtils.splitArray2(new int []{2, 2, 10, 10, 1, 1}));
        Assert.assertFalse(RecursionUtils.splitArray2(new int []{1, 2, 3, 10, 10, 1, 1,}));
    }
}
