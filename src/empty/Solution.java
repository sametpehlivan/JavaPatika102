package empty;
import java.util.*;
/*
 * Create the Student and Priorities classes here.
 */
class Priorities {

    public Priorities(){}
    public  List<Student> getStudents(List<String> events){
        int n = events.size();
        PriorityQueue<Student> pq = new PriorityQueue<Student>();
        for(String i:events)
        {
            String[] s = new String[4];
            s = i.split("\\s");
            if(s.length>1)
            {
                pq.add(new Student(Integer.valueOf(s[3]),s[1],Double.valueOf(s[2])));
            }
            else
            {
                pq.poll();
            }
        }
        while(pq.size()>1)
        {
            System.out.println(pq.poll().getName());
        }
        return new ArrayList<Student>(pq);
    }
}
class Student implements Comparable<Student>
{

    public Student(int id,String name,double cpga)
    {
        this.id = id;
        this.name=name;
        this.cpga=cpga;
    }
    private int id ;
    private String name;
    private double cpga;

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCPGA() {
        return cpga;
    }
    public int compareTo(Student s2)
    {

        if (this.getCPGA() > s2.getCPGA()){
            return -1;
        }
        else if (this.getCPGA() < s2.getCPGA()) {
            return 1;
        }
        if (this.getName().compareTo(s2.getName()) == 0){
            if (this.getID() < s2.getID()) return -1;
            return 1;
        }
        return this.getName().compareTo(s2.getName());

    }
}


public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}