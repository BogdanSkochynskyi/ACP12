package data_structure.recursion;

/**
 * Created by dexter on 18.02.16.
 */
public class RecursionUtils {

    public static boolean splitArray(int[] nums) {

        int [] arr2 = new int [nums.length-1];
        System.arraycopy(nums, 1, arr2, 0, arr2.length);
        int [] arr3 = new int [1];
        System.arraycopy(nums, 0, arr3, 0, arr3.length);

        return subtract(arr3, arr2);
    }

    public static boolean splitArray2(int[] nums) {
        return nums.length == 0 || helper(1, nums);
    }

    public static boolean helper(int start, int[] nums){
        return start < nums.length && (sum(0, start, nums) - sum(start, nums.length, nums) == 0 || helper(++start, nums));
    }

    private static int sum(int start, int end, int [] arr){
        return start == end? 0 : arr[start] + sum(++start, end, arr);
    }

    public static int sum(int[] nums) {

        if(nums.length == 1) return nums[0];

        int [] tmp = new int [nums.length-1];
        System.arraycopy(nums, 0, tmp, 0, tmp.length);

        return nums[nums.length - 1] + sum(tmp);
    }

    private static boolean subtract(int[] nums1, int[] nums2){

        if(nums2.length == 1){
            return sum(nums1) - sum(nums2) == 0;
        } else {

            int [] tmp1 = new int[nums1.length+1];
            System.arraycopy(nums1, 0, tmp1, 0, nums1.length);
            System.arraycopy(nums2, 0, tmp1, nums1.length, 1);

            int [] tmp2 = new int [nums2.length-1];
            System.arraycopy(nums2, 1, tmp2, 0, nums2.length-1);

            return sum(nums1) - sum(nums2) == 0 || subtract(tmp1, tmp2);
        }
    }


}
