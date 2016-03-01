package ua.artcode.week3.serializer.obj_xml;

/**
 * Created by Олександр on 29.02.2016.
 */
public class Price {

    private double price;

    @Override
    public String toString() {
        return "" + price;
    }

    public Price(double price) {
        this.price = price;
    }

}