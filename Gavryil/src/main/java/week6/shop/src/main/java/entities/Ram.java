package week6.shop.src.main.java.entities;


public class Ram extends AbstractEntity {
    private int ramCapacity;

    public Ram(int id, String manufacture, int ramCapacity) {
        super(id, manufacture);
        this.ramCapacity = ramCapacity;

    }

    public int getRamCapacity() {
        return ramCapacity;
    }

    public void setRamCapacity(int ramCapacity) {
        this.ramCapacity = ramCapacity;
    }
}
