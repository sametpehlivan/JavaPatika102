package PatikaStore;

public abstract class Product
{
    private static int count=0;
    private  int id;
    private String name;
    private Brand brand;
    private Group group;
    private short stockSize;
    private double unitPrice;
    private double discountRate;
    private short memoryGB;
    private short ramGB;
    private float monitorSize;



    public Product()
    {
        count++;
        id=count;
    }
    public Product(String name,
                   Brand brand,
                   Group group,
                   short stockSize,
                   double unitPrice,
                   double discountRate,
                   short memoryGB,
                   short ramGB,
                   float monitorSize){
        super();
        setName(name);
        setBrand(brand);
        setGroup(group);
        setStockSize(stockSize);
        setUnitPrice(unitPrice);
        setDiscountRate(discountRate);
        setMemoryGB(memoryGB);
        setRamGB(ramGB);
        setMonitorSize(monitorSize);

    }
    public int getId() {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name) {
        this.name = name.trim().toLowerCase();
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o == this) return true;
        if (!(o instanceof Product)) return false;
        Product other = (Product) o;

        boolean nameEquals = false;
        boolean brandEquals = false;
        boolean groupEquals = false;

        if (getName() == null && other.getName() == null) nameEquals = true;
        if (getName() != null && other.getName() != null) nameEquals = getName().equals(other.getName());

        if (getBrand() == null && other.getBrand() == null) brandEquals = true;
        if (getBrand() != null && other.getBrand() != null) brandEquals = getBrand().equals(other.getBrand());

        if (getGroup() == null && other.getGroup() == null) groupEquals = true;
        if (getGroup() != null && other.getGroup() != null) groupEquals = getGroup().equals(other.getGroup());

        return  nameEquals &&
                brandEquals &&
                groupEquals;
    }

    @Override
    public int hashCode() {
        int result = 17;
        if (getGroup() != null) result = 31 * result + getGroup().hashCode();
        if (getBrand() != null) result = 31 * result + getBrand().hashCode();
        if (getName() != null ) result = 31 *result + getName().hashCode();
        return  result;
    }

    @Override
    public String toString() {
        return "| "+id+"  | "+getName()+"           | "+unitPrice+" | "+brand.getName()+"    | "+memoryGB+"       | "+monitorSize+"      | "+ramGB+"          |";
    }

    public short getStockSize() {
        return stockSize;
    }

    public void setStockSize(short stockSize) {
        this.stockSize = stockSize;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public short getMemoryGB() {
        return memoryGB;
    }

    public void setMemoryGB(short memoryGB) {
        this.memoryGB = memoryGB;
    }

    public short getRamGB() {
        return ramGB;
    }

    public void setRamGB(short ramGB) {
        this.ramGB = ramGB;
    }

    public float getMonitorSize() {
        return monitorSize;
    }

    public void setMonitorSize(float monitorSize) {
        this.monitorSize = monitorSize;
    }

}
