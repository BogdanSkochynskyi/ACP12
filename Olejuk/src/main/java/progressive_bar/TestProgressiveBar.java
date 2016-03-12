package progressive_bar;

import java.util.Arrays;

/**
 * Created by dexter on 09.03.16.
 */
public class TestProgressiveBar {
    public static void main(String[] args) throws InterruptedException {


        double doub = roundTo(2.666, 2);
        System.out.println(doub);

    }

    private static int[] merge(int[] array1, int[] array2) throws InterruptedException {
        int[] newArray = new int[array1.length + array2.length];

        int indexFirstArray = 0;
        int indexSecondArray = 0;

        for (int i = 0; i < newArray.length-1; i++) {

            if(array1[indexFirstArray] < array2[indexSecondArray]){
                if(i+1 == newArray.length-1){
                    newArray[i] = array1[indexFirstArray];
                    newArray[i+1] = array2[indexSecondArray];
                } else{
                    newArray[i] = array1[indexFirstArray++];
                }
            } else {
                if(i+1 == newArray.length-1){
                    newArray[i] = array2[indexSecondArray];
                    newArray[i+1] = array1[indexFirstArray];
                } else{
                    newArray[i] = array2[indexSecondArray++];
                }
            }
            ProgressiveBar.updateProgress(((double)i / newArray.length) * 100);
            Thread.sleep(500);
        }
        ProgressiveBar.updateProgress(100);

        System.out.println();
        return newArray;
    }

    public static double roundTo(double number, int degree){

        int pow = (int) Math.pow(10, degree);

        double tmp = number * pow;

        return (double)
                (int)(
                        (tmp - (int) tmp) >= 0.5f ? tmp + 1 : tmp
                ) / pow;
    }
}
