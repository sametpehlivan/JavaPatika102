package PatikaStore;


import java.util.*;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class PatikaStore
{
    public static List<Brand> brands = new ArrayList<>();
    public static List<Group> groups = new ArrayList<>();
    public static List<Product> products = new ArrayList<>();
    public final static String CHOICE_REGEX = "\\d+";
    public final static Scanner scanner = new Scanner(System.in);
    public static void initGroupList()
    {
        groups.add(new Group("Cep Telefonu"));
        groups.add(new Group("Notebook"));
        Collections.sort(groups);
    }
    public static void initBranList(){
        brands.add(new Brand("samsung"));
        brands.add(new Brand("lenovo"));
        brands.add(new Brand("apple"));
        brands.add(new Brand("casper"));
        brands.add(new Brand("asus"));
        brands.add(new Brand("hp"));
        brands.add(new Brand("xiaomi"));
        brands.add(new Brand("monster"));
        Collections.sort(brands);
    }
    public static void initProductList()
    {
        products.add(new Notebook("samsung",brands.get(0),groups.get(1),(short)3,(double)1.2,(double)0.1,(short)10,(short)10,(float)3.4));
        products.add(new Mobile("samsung s20",brands.get(0),groups.get(0),(short)3,(double)1.2,(double)0.1,(short)10,(short)10,(float)3.4,"red",(short)128,1200));
    }

    public static void initLists()
    {
        initBranList();
        initGroupList();
        initProductList();
    }
    public static void showProducts(Predicate<? super Product> predicate)
    {
        products.stream().filter(predicate).forEach(System.out::println);
    }
    public static void showBrands()
    {
        brands.stream()
                .map(brand ->"- "+ brand.getName().toUpperCase())
                .forEach(System.out::println);
    }
    public static void showGroups()
    {
        groups.stream()
                .map(brand ->"- "+ brand.getName().toUpperCase())
                .forEach(System.out::println);
    }
    public static void showMainPageSelectMessage()
    {
        System.out.println("1 - MARKALARI GÖRÜNTÜLE");
        for (int i = 0;i<groups.size();i++)
            System.out.println(groups.get(i).getId()+1+" - "+groups.get(i).getName().toUpperCase()+" İŞLEMLERİ");
        System.out.println("0 - ÇIKIŞ YAP");
    }
    public static int mainPageSelectChoice()
    {
        int choice = -1;
        String value = scanner.nextLine().trim();

        while (true)
        {
            if (value.matches(CHOICE_REGEX))
            {
                choice = Integer.parseInt(value);
                if (choice == 0 || choice == 1) break;
                var r = groups.stream()
                        .map(g -> g.getId())
                        .collect(Collectors.toList());
                if (r.contains(choice-1)) break;
            }
            System.out.println("\n*** GEÇERSİZ İŞLEM ***\n");
            showMainPageSelectMessage();
            value = scanner.nextLine();
        }
        return choice;
    }
    public static void mainPageTransaction(int choice)
    {
        if (choice == 0)
        {
            System.out.println("ittihat ve terakki iyi günler diler...");
            System.exit(0);
        }
        else if (choice == 1) showBrands();
        else
        {
            int c =  choice-1;
            var group = groups.stream()
                                .filter(g-> g.getId() == c )
                                .collect(Collectors.toList()).get(0);
            System.out.println(group.getName().toUpperCase()+" İŞLEMLERİ");
            crudPageSelectMessage();
            crudPageTransaction(crudPageSelectChoice(),group);
        }


    }
    public static void crudPageSelectMessage()
    {
        System.out.println("1 - Ürünleri listele");
        System.out.println("2 - Ürün Ekle");
        System.out.println("3 - Ürün Sil");
        System.out.println("0 - GERI");
    }
    public static void crudPageTransaction(int choice,Group group)
    {
        if(choice == 0)
        {
            showMainPageSelectMessage();
            mainPageTransaction(mainPageSelectChoice());
        }
        else if (choice == 1)
        {
            showProducts(p-> p.getGroup().equals(group));
        }
    }
    public static int crudPageSelectChoice()
    {
        int choice = -1;
        String value = scanner.nextLine().trim();

        while (true)
        {
            if (value.matches(CHOICE_REGEX))
            {
                choice = Integer.parseInt(value);
                if (choice >= 0 && choice <=3) break;
            }
            System.out.println("\n*** GEÇERSİZ İŞLEM ***\n");
            crudPageSelectMessage();
            value = scanner.nextLine();
        }
        return choice;
    }
    public static void start()
    {
        initLists();
        groups.add(new Group("mobil"));
        System.out.println("PatikaStore Ürün Yönetim Paneli !");
        while (true)
        {
            showMainPageSelectMessage();
            mainPageTransaction(mainPageSelectChoice());
        }
    }
}
