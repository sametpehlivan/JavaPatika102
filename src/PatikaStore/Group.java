package PatikaStore;

public class Group implements Comparable<Group>
{
    private static int count=0;
    private final int id;
    private String name;
    public Group()
    {
        count++;
        id=count;
    }
    public Group(String name) {
        this();
        this.setName(name);
    }
    public int getId() {
        return id;
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
        if (!(o instanceof Group)) return false;
        Group other = (Group)o;
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
    public int compareTo(Group group)
    {
        return this.getName().compareTo(group.getName());
    }


}
