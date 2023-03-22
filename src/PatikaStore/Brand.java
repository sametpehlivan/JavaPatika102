package PatikaStore;

public class Brand implements Comparable<Brand>
{
    private static int count=0;
    private final int id;
    private String name;
    public Brand()
    {
        count++;
        id=count;
    }
    public Brand(String name)
    {
        this();
        this.setName(name);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.trim().toLowerCase();
    }
    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o == this) return true;
        if (!(o instanceof Brand)) return false;
        Brand other = (Brand)o;
        boolean nameEquals = false;
        if (getName() != null && other.getName() != null) nameEquals = getName().equals(other.getName());
        if (getName() == null && other.getName() == null) nameEquals = true;
        return nameEquals;
    }

    @Override
    public int hashCode() {

       return  31 * 17 + (this.name != null ? this.name.hashCode() : 0);
    }

    @Override
    public String toString() {
        return "["+this.getName()+"]";
    }


    @Override
    public int compareTo(Brand brand)
    {
        return this.getName().compareTo(brand.getName());
    }

    public int getId() {
        return id;
    }
}
