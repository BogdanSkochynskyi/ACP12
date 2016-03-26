package week6.shop.src.main.java.entities;


public class Gpu extends AbstractEntity {
    private int vRamCapacity;

    public Gpu(int id, String manufacture, int vRamCapacity) {
        super(id, manufacture);
        this.vRamCapacity = vRamCapacity;

    }

    public int getvRamCapacity() {
        return vRamCapacity;
    }

    public void setvRamCapacity(int vRamCapacity) {
        this.vRamCapacity = vRamCapacity;
    }
}
