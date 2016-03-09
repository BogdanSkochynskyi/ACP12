package blasoUtils;

public class Math_BS {

    public static double roundTo(double number, int degree){

        int pow = 10;
        for (int i = 1; i < degree; i++)
            pow *= 10;
        double tmp = number * pow;
        return (double) (int) ((tmp - (int) tmp) >= 0.5f ? tmp + 1 : tmp) / pow;

    }

}
