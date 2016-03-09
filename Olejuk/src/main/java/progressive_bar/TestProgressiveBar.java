package progressive_bar;

import java.util.Arrays;

/**
 * Created by dexter on 09.03.16.
 */
public class TestProgressiveBar {
    public static void main(String[] args) throws InterruptedException {

        int[] firstSortedArray = {1, 1, 7, 9};
        int[] secondSortedArray = {2, 4, 4, 8};

        System.out.println(Arrays.toString(merge(firstSortedArray, secondSortedArray)));
    }

    private static int[] merge(int[] array1, int[] array2) throws InterruptedException {
        int[] newArray = new int[array1.length + array2.length];

        int indexFirstArray = 0;
        int indexSecondArray = 0;

        for (int i = 0; i < newArray.length-1; i++) {

            if(array1[indexFirstArray] < array2[indexSecondArray]){
                newArray[i] = array1[indexFirstArray++];
            } else {
                newArray[i] = array2[indexSecondArray++];
            }
            ProgressiveBar.updateProgress(((double)i / newArray.length) * 100);
            Thread.sleep(500);
        }
        ProgressiveBar.updateProgress(100);

        System.out.println();
        return newArray;
    }

}
