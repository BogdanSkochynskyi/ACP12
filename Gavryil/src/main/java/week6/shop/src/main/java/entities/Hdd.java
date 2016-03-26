package week6.shop.src.main.java.entities;


public class Hdd extends AbstractEntity {
    private int capacity;

    public Hdd(int id, String manufacture, int capacity) {
        super(id, manufacture);
        this.capacity = capacity;

    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
