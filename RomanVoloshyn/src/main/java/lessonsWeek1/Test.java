package lessonsWeek1;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {

//        int[] nums = {10, 2, 2, 5};
//        int target = 17;
        int[] nums = {2, 4, 8};
        int target = 9;

        boolean res = rec(0, nums, target);
        System.out.println(res);

    }

    static boolean rec(int start, int[] nums, int target){

        if(start >= nums.length){
            return true;
        }

        int tempRes = (target > nums[start]) ? target - nums[start] : target;
        if (tempRes == 0) {
            return true;
        }
        if(start+1 >= nums.length){
        }
        return rec(start + 1, nums, tempRes);

    }

}
//        ArrayList<Integer> sums = new ArrayList<Integer>();
//        for (int i = 0; i < nums.length; i++) {
//
//            int k = sums.size();
//            for (int j = 0; j < k; j++) {
//                sums.add(sums.get(j) + nums[i]);
//            }
//
//            sums.add(nums[i]);
//        }
//
//        System.out.println(sums.size());
//        System.out.println(sums.toString());
