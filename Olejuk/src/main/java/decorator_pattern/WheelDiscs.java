package decorator_pattern;

/**
 * Created by dexter on 25.02.16.
 */
public class WheelDiscs extends Decorator{

    public WheelDiscs(Price price){
        super(price);
    }

    @Override
    public int getPrice(){
        return super.getPrice() + 600;
    }
}
