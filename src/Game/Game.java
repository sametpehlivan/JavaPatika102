package Game;

import java.util.Scanner;

public class Game {
    private Scanner sc =new Scanner(System.in);
    public void start(){
        System.out.println("Macera oyununa hoşgeldiniz !");
        System.out.print("Lütfen bir isim giriniz :");
        String playerName=sc.nextLine();
        Player player = new Player(playerName);
        System.out.println("Sayın "+player.getName()+" bu karanlık ve sisli adaya hoşgeldiniz !");
        System.out.println("Lütfen oyuna başlamak için bir karakter seçiniz !");
        player.selectChar();
        Location location = null;
        while(true){
            player.printInfo();
            System.out.println();
            System.out.println("#########Bölgeler#########");
            System.out.println();
            System.out.println("1- Güvenli Ev -->Düşman yoktur Sağlığınız yenilenir.");
            System.out.println("2- Eşya Dükkanı --> Silah veya zırh satın alabilirsiniz.");
            System.out.println("3- Mağara --> Mağaraya Git ama dikkatli ol Zombiler Cirit atıyor!");
            System.out.println("4- Orman  --> Ormana Git ama dikkatli ol Vampirler Dişliyor !");
            System.out.println("5- Nehir  --> Nehire Git ama dikkatli ol Ayılar  Pençeliyor !");
            System.out.println("6- Maden  --> Madene Git ama dikkatli ol Yılanlar Seni Bekliyor !");
            System.out.println("0- Çıkış Yap --> Oyunu Sonlandır.");
            System.out.println("Lütfen gitmek istediğiniz bölgeyi seçiniz.");
            int selectLoc= sc.nextInt();
            switch (selectLoc){
                case 0:location =null;break;
                case 1:location= new SafeHouse(player);break;
                case 2: location= new ToolStore(player);break;
                case 3: if(player.getInventory().getFood()!=1){location=new Cave(player);}
                    break;
                case 4:if(player.getInventory().getFirewood()!=1){location=new Forest(player);}break;
                case 5:if(player.getInventory().getWater()!=1){location=new River(player);}break;
                case 6:new Coal(player);break;
                default:
                    System.out.println("Lütfen geçerli bir bölge giriniz !")  ;break;
            }

            if(location==null){
                System.out.println("Bu karanlıktan aydınlığa çıkıyorsun !!!");
                break;
            }
            if(!location.onLocation()){
                System.out.println("GAME OVER !!!");
                break;
            }
        }

    }
}
