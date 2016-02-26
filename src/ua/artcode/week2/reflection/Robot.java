package ua.artcode.week2.reflection;

/**
 * Created by serhii on 21.02.16.
 */
public class Robot {

    private String model;
    private double price;
    private int power;

    public Robot(String model, double price, int power) {
        this.model = model;
        this.price = price;
        this.power = power;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "model='" + model + '\'' +
                ", price=" + price +
                ", power=" + power +
                '}';
    }
}
