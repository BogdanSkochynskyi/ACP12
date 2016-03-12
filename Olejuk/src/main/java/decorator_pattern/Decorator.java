package decorator_pattern;

/**
 * Created by dexter on 25.02.16.
 */
public abstract class Decorator implements Price {

    private Price price;

    public Decorator(Price price){
        this.price = price;
    }

    @Override
    public int getPrice(){
        return price.getPrice();
    }
}
