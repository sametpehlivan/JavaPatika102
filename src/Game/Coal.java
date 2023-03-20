package Game;

public class Coal extends BattleLoc{
    static Player player ;
    public Coal(Player player) {
        super(player, "Maden",new Snake(Snake.randomNumber()),probabilityItems(), 5);
        Coal.player=player;
    }
    public static Object probabilityItems(){

        String bbb="Hiçbir Şey kazanamadınız";
       double chance = Math.random()*100;
       double chanceTwo= Math.random()*100;
       if(chance<=15){
            if(chanceTwo<=20){
                return new Weapon("Tüfek",3,7,45);
            }else if(chanceTwo>20&&chanceTwo<=50){
                return  new Weapon("Kılıç",2,3,35);
            }else if(chanceTwo>50){
                return new Weapon("Tabanca",1,2,25);
            }
        }
        chanceTwo= Math.random()*100;
        if(chance<15&&chance<=30 ){
           if(chanceTwo<=20){
               return new Armor(3,5,40,"Ağır Zırh");
           }else if(chanceTwo>20&&chanceTwo<=50){
               return  new Armor(2,3,25,"Orta Zırh");
           }else if(chanceTwo>50){
               return  new Armor(1,1,15,"Hafif Zırh");
           }

       }
        if(chance<30&&chance<=55 ){
            int balance;
            if(chanceTwo<=20){
                balance=10;
                return balance;
            }else if(chanceTwo>20&&chanceTwo<=50){
                balance=5;
                return balance;
            }else if(chanceTwo>50){
                balance=1;
                return balance;
            }
        }
        return bbb;
    }
}
