package Game;

public class ToolStore extends NormalLoc{

    public ToolStore(Player player){
        super(player,"Mağaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Mağazaya hoşgeldiniz !");
        boolean showMenu=true;
       while(showMenu){
           System.out.println("1- Silahlar ");
           System.out.println("2- Zırhlar ");
           System.out.println("3- Çıkış Yap ");
           System.out.print("Yapmak istediğiniz işlemi Seçiniz :");
           int selectCase= Location.sc.nextInt();
           while(selectCase<1||selectCase>3){
               System.out.println("Yanlış Değer Girdiniz Tekrar Giriniz :");
               selectCase=sc.nextInt();
           }
           switch (selectCase){
               case 1 :printWeapon();buyWeapon();break;
               case 2 :printArmor();buyWeapon();break;
               case 3 :System.out.println("Tekrar Bekleriz ");
               showMenu=false;
               break;

           }
       }
        return true;
    }

    private void printArmor() {
        System.out.println("----------Zırhlar----------");
        for(Armor a :Armor.armors()){
            System.out.println(a.getId()+" - "+a.getName()+" <Engelleme : >"+a.getBlock()+" <Fiyatı :>"+ a.getPrice());
        }
        System.out.println("0 - Çıkış Yap");
    }

    private void printWeapon() {
        System.out.println("Silahlar");
        System.out.println();
        for(Weapon w:Weapon.weapons()){
            System.out.println(w.getName()+" Para : "+w.getPrice()+" Hasarı :"+w.getDamage());
        }
        System.out.println("0 - Çıkış Yap");
    }
    public void buyArmor(){
        System.out.print("Bir Zırh Seçiniz: ");
        int selectArmorID=sc.nextInt();
        while(selectArmorID<0||selectArmorID>Armor.armors().length){
            System.out.print("Lütfen geçerli bir ifade giriniz! ");
            selectArmorID=sc.nextInt();
        }
        if(selectArmorID!=0){
            Armor selectedArmor = Armor.getArmorObjById(selectArmorID);
            if(selectedArmor!=null){
                if(selectedArmor.getPrice()>this.getPlayer().getMoney()){
                    System.out.println("Malesef yeterli paranız bulunmamaktadır.");
                }else{
                    System.out.println(selectedArmor.getName()+" Zırhını almış bulunmaktasınız .");
                    int balance = this.getPlayer().getMoney()-selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan paranız :"+ this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                }
            }
        }
    }
    public void buyWeapon(){
        System.out.print("Bir Silah Seçiniz: ");
        int selectWeaponID=sc.nextInt();
        while(selectWeaponID<0||selectWeaponID>Weapon.weapons().length){
            System.out.print("Lütfen geçerli bir ifade giriniz! ");
            selectWeaponID=sc.nextInt();
        }
        if(selectWeaponID!=0){
            Weapon selectedWeapon=Weapon.getWeaponObjById(selectWeaponID);
            if(selectedWeapon != null){
                if(selectedWeapon.getPrice()>this.getPlayer().getMoney()){
                    System.out.println("Malesef Yeterli Paranız Bulunmamaktadır.");
                }else{
                    System.out.println(selectedWeapon.getName()+" Silahını satın almış Bulundunuz.");
                    int balance = this.getPlayer().getMoney()-selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan paranız :"+ this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);

                }
            }
        }

    }
}
