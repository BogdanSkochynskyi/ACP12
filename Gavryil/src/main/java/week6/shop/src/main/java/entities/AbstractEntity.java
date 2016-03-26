package week6.shop.src.main.java.entities;

public abstract class AbstractEntity {
    private int id;
    private String manufacturer;

    public AbstractEntity(int id, String manufacturer) {
        this.id = id;
        this.manufacturer = manufacturer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManufacture() {
        return manufacturer;
    }

    public void setManufacture(String manufacture) {
        this.manufacturer = manufacture;
    }
}
