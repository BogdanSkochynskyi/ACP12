package decorator_pattern;

/**
 * Created by dexter on 25.02.16.
 */
public class TestDecorator {
    public static void main(String[] args) {

        Decorator carKit = new Navigator(new WheelDiscs(new ClimateControl(new Car())));
        System.out.printf("total - %s $", carKit.getPrice());
    }
}
