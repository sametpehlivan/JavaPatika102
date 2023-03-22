package PatikaStore;

public class Mobile extends Product
{
    private String color;
    private short cameraPixel;
    private double battery;
    public Mobile()
    {
        super();
    }
    public Mobile(String name,
                  Brand brand,
                  Group group,
                  short stockSize,
                  double unitPrice,
                  double discountRate,
                  short memoryGB,
                  short ramGB,
                  float monitorSize,
                  String color,
                  short cameraPixel,
                  double battery) {
        super(name, brand, group, stockSize, unitPrice, discountRate, memoryGB, ramGB, monitorSize);
        setColor(color);
        setCameraPixel(cameraPixel);
        setBattery(battery);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public short getCameraPixel() {
        return cameraPixel;
    }

    public void setCameraPixel(short cameraPixel) {
        this.cameraPixel = cameraPixel;
    }

    public double getBattery() {
        return battery;
    }

    public void setBattery(double battery) {
        this.battery = battery;
    }

    @Override
    public String toString() {
        return super.toString()+"| "+cameraPixel+"     |"+"| "+battery+"    |"+"| "+color+"     | ";
    }
}
