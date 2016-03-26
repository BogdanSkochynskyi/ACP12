package week6.shop.src.main.java.entities;


public class Screen extends AbstractEntity {
    private int size;

    public Screen(int id, String manufacture, int size) {
        super(id, null);
        this.size = size;

    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String getManufacture() {
        return null;
    }

    @Override
    public void setManufacture(String manufacture) {}
}
