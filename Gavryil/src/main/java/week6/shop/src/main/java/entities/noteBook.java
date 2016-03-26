package week6.shop.src.main.java.entities;

public class NoteBook extends AbstractEntity {

    private int processorId;
    private int gpuId;
    private int ramId;
    private int screenId;
    private int hddId;

    public NoteBook(int id, String manufacturer, int processor, int gpu, int ram, int screen, int hdd) {
        super(id, manufacturer);
        this.processorId = processor;
        this.gpuId = gpu;
        this.ramId = ram;
        this.screenId = screen;
        this.hddId = hdd;
    }

    @Override
    public String toString() {
        return "NoteBook{" +
                "manufacturer = " + super.getManufacture()+
                ", processorId =" + processorId +
                ", gpuId=" + gpuId +
                ", ramId=" + ramId +
                ", screenId=" + screenId +
                ", hddId=" + hddId +
                '}';
    }

    public int getProcessorId() {
        return processorId;
    }

    public void setProcessorId(int processorId) {
        this.processorId = processorId;
    }

    public int getGpuId() {
        return gpuId;
    }

    public void setGpuId(int gpuId) {
        this.gpuId = gpuId;
    }

    public int getRamId() {
        return ramId;
    }

    public void setRamId(int ramId) {
        this.ramId = ramId;
    }

    public int getScreenId() {
        return screenId;
    }

    public void setScreenId(int screenId) {
        this.screenId = screenId;
    }

    public int getHddId() {
        return hddId;
    }

    public void setHddId(int hddId) {
        this.hddId = hddId;
    }
}
