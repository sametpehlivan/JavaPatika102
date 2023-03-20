package Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OddEven
{
    private List<Integer> list = new ArrayList<>();
    private  List<Integer> listOdd = new ArrayList<>();
    private  List<Integer> listEven = new ArrayList<>();
    private Lock LOCK1 = new ReentrantLock();
    private  Lock LOCK2 = new ReentrantLock();

    public OddEven(int capacity)
    {
        for (int i=0;i<capacity;i++){
            list.add(i);
        }
    }
    public void evenAdd(int value)
    {
        LOCK1.lock();
            listEven.add(value);
        LOCK1.unlock();

    }
    public void oddAdd(int value)
    {
        LOCK2.lock();
        listOdd.add(value);
        LOCK2.unlock();
    }

    public List<Integer> getList() {
        return list;
    }
    public void print()
    {
        System.out.println("Even Size: " +listEven.size());
        System.out.println("Odd  Size: " +listOdd.size());
    }
}
