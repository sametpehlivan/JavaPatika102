package Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App
{
    public static void main(String[] args) throws InterruptedException {
        int n = 4;
        int capacity = 10000;
        int part = (capacity/n);
        OddEven lists = new OddEven(capacity);
        List<Thread> threads = new ArrayList<>();
        for (int i=0;i<n;i++){
            int startIndex = i*part;
            int lastIndex = i == (n-1) ? capacity : (i+1)*part;
            threads.add(new Thread(()->{
                for (int j = startIndex; j<lastIndex; j++)
                {
                    if (lists.getList().get(j) % 2 == 0) lists.evenAdd(lists.getList().get(j));
                    else lists.oddAdd(lists.getList().get(j));
                }
            }));
        }
        threads.forEach(t -> t.start());
        threads.forEach(t-> {
            try{
                t.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });
        lists.print();
    }

}
