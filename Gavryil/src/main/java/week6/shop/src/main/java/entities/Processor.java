package week6.shop.src.main.java.entities;


public class Processor extends AbstractEntity {

    private String clockSpeed;

    public Processor(int id, String manufacture, String clockSpeed) {
        super(id, manufacture);
        this.clockSpeed = clockSpeed;

    }

    public String getClockSpeed() {
        return clockSpeed;
    }

    public void setClockSpeed(String clockSpeed) {
        this.clockSpeed = clockSpeed;
    }
}
