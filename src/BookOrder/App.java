package BookOrder;

import java.nio.charset.Charset;
import java.util.*;

public class App
{
    public static void main(String[] args) {
        Random random  = new Random();
        Set<Book> books = new TreeSet<>();
        for (int i=0;i<5;i++)
        {
            byte[] array = new byte[7]; // length is bounded by 7
            random.nextBytes(array);
            String author = generateString() ;
            random.nextBytes(array);
            String name = generateString();
            int pageSize = (int)( Math.random()*1000)+1;
            books.add(new Book(author,name,pageSize));
        }

        books.forEach(b -> System.out.println(b.toString()));
        var list = new ArrayList<Book>(books);
        list.sort((b1,b2)->{
            return b1.getPageSize() - b2.getPageSize();
        });
        System.out.println("----------------------");
        list.forEach(b -> System.out.println(b.toString()));

    }
    public static String generateString(){
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }
}
