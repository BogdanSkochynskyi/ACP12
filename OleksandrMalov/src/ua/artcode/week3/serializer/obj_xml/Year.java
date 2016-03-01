package ua.artcode.week3.serializer.obj_xml;

/**
 * Created by Олександр on 29.02.2016.
 */
public class Year {

    private int year;

    public Year(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "" + year;
    }

}
