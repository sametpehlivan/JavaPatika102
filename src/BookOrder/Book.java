package BookOrder;

public class Book implements Comparable
{


    private String author;
    private String name;
    private int pageSize;
    public Book(String author,String name,int pageSize){
        this.author = author;
        this.name = name;
        this.pageSize = pageSize;
    }
    public String getAuthor() {
        return author;
    }
    public String getName() {
        return name;
    }
    public int getPageSize() {
        return pageSize;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Book)) return false;
        if (obj.hashCode() == this.hashCode())
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        String authorName = name.trim().toLowerCase() + author.trim().toLowerCase();
        return authorName.hashCode();
    }

    @Override
    public String toString() {
        return "[ Name: "+name+", Author: "+author+", Page Size: "+pageSize+" ]";
    }

    @Override
    public int compareTo(Object obj) {
        if (obj == null) return -1;
        if (!(obj instanceof Book)) return -1;
        return name.compareTo(((Book) obj).name);
    }
}
