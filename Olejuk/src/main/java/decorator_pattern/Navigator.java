package decorator_pattern;

/**
 * Created by dexter on 25.02.16.
 */
public class Navigator extends Decorator {

    public Navigator(Price price) {
        super(price);
    }

    public int getPrice(){
        return super.getPrice() + 500;
    }
}
