package ua.artcode.week1.rec;

/**
 * Created by master on 14.02.16.
 */
public class TestReverse {


    public static void main(String[] args) {
        String exp = "dcba";
        String res = RecursionUtils.reverse("abcd");

        System.out.println(exp.equals(res));
        System.out.println("RecursionUtils.reverse");
        System.out.println("in " + "abcd");
        System.out.println("out " + res);
        System.out.println("exp " + exp);
    }
}
