package decorator_pattern;

/**
 * Created by dexter on 25.02.16.
 */
public class Car implements Price {

    @Override
    public int getPrice(){
        return 5000;
    }
}
