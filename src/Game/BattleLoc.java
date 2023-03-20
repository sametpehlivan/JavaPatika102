package Game;

import java.util.Random;

public class BattleLoc extends Location{
    private Obstacle obstacle;
    private Object award;
    private int maxObstacle;
    private int obsNumber;
    private int caveFinished=0;
    private int riverFinished=0;
    private int forestFinished=0;

    public BattleLoc(Player player, String name, Obstacle obstacle, Object award,int maxObstacle ){
        super(player,name);
        this.obstacle=obstacle;
        this.award=award;
        this.maxObstacle=maxObstacle;
    }

    public boolean onLocation(){
        if(this.getName().equals("Mağara")&&caveFinished==1){
            System.out.println("Bu Bölümü Bitirdiniz :)");
            return true;
        }if(this.getName().equals("Nehir")&&riverFinished==1){
            System.out.println("Bu Bölümü Bitirdiniz :)");
            return true;
        }if(this.getName().equals("Orman")&&forestFinished==1){
            System.out.println("Bu Bölümü Bitirdiniz :)");
            return true;
        }
        this.getObstacle().setHealth(getObstacle().getDefHealth());
        System.out.println("Şu an buradasınıZ :"+this.getName());
        obsNumber=randomObstacleNumber();
        System.out.println("Dikkatli ol burada "+this.obsNumber+" "+this.getObstacle().getName()+" Yaşıyor!");
        System.out.print("<S>avaş ya da <K>aç : ");
        String selectCase = sc.nextLine();
        selectCase=selectCase.toUpperCase();
        if(selectCase.equals("S")){
            System.out.println("Savaşmayı Seçtiniz !");
                if(combat(obsNumber)){
                    System.out.println(getName()+" etrafındaki tüm düşmanları yendiniz !");
                    return true;
                }
        }
        if(this.getPlayer().getHealth()<=0){
            System.out.println("Öldünüz ");
            return false;
        }

        return true;
    }

    public boolean combat(int obstacleNumber){
        double chance=(int)(Math.random()*2);
        for(int i = 1;i<=obstacleNumber;i++){
        playerStatus();
        obstacleStatus(i);

        while(this.getPlayer().getHealth()>0 && this.getObstacle().getHealth()>0){
            System.out.print("<V>ur ya da <K>aç");
            String battleChoice=sc.nextLine().toUpperCase();
            if(battleChoice.equals("V")){
                if(chance==1){
                    System.out.println("Oyuncu Saldırdı !");
                    this.obstacle.setHealth(this.getObstacle().getHealth()-getPlayer().getTotalDamage());
                    afterHit();
                    chance--;
                }

                if(this.getObstacle().getHealth()>0){
                    System.out.println();
                    if(chance==0){

                    System.out.println("Canavar saldırıyor !");
                    int obstacleDamage=this.getObstacle().getDamage()-this.getPlayer().getInventory().getArmor().getBlock();

                    if(obstacleDamage>0){
                        this.getPlayer().setHealth(this.getPlayer().getHealth()-this.getObstacle().getDamage());
                    }
                        chance++;
                    }
                    afterHit();

                }
            }
        }
        if(this.getObstacle().getHealth()<this.getPlayer().getHealth()){
            System.out.println("Düşmanı yendiniz !");
            System.out.println(this.getObstacle().getAward()+" para kazandınız .");
            this.getPlayer().setMoney(this.getPlayer().getMoney()+this.getObstacle().getAward());
            System.out.println("Güncel Paranız : "+this.getPlayer().getMoney());
            if(this.getName().equals("Maden")){
                if(!getAward().equals("Hiçbir Şey kazanamadınız")){
                    if(getAward().getClass().getName().equals("Weapon")){
                        getPlayer().getInventory().setWeapon((Weapon)getAward());
                    }else if(getAward().getClass().getName().equals("Armor")){
                        getPlayer().getInventory().setArmor((Armor)getAward());
                    }else{
                        getPlayer().setMoney(getPlayer().getMoney()+(int)getAward());
                    }

                }
            }
            if(i==obstacleNumber){
                System.out.println("Bölümü Bitirdiniz ödülünüz :"+this.getAward());
                if(this.getName().equals("Mağara")){
                    caveFinished=1;
                    this.getPlayer().getInventory().setFood(1);
                }if(this.getName().equals("Orman")){
                    forestFinished=1;
                    this.getPlayer().getInventory().setFirewood(1);
                }if(this.getName().equals("Nehir")){
                    riverFinished=1;
                    this.getPlayer().getInventory().setWater(1);
                }
            if(this.getPlayer().getInventory().getFood()==1 &&this.getPlayer().getInventory().getFirewood()==1 &&this.getPlayer().getInventory().getWater()==1 ){
                System.out.println("Tebrikler Gerçek Bir Survivorsın Bu Lanetli Adadan Kaçmayı Başardın !!!");
                System.exit(0);
            }
            }


        }else{
            return false;
        }
        }
        return true;
    }

    public void afterHit() {
        System.out.println("Canınız :"+getPlayer().getHealth());
        System.out.println(getObstacle().getName()+" canı :"+getObstacle().getHealth());
        System.out.println();
    }


    public void obstacleStatus(int i) {
        System.out.println(i+"."+this.getObstacle().getName()+" Belasının Değerleri");
        System.out.println("-------------------------------");
        System.out.println("Sağlık : "+this.getObstacle().getHealth());
        System.out.println("Hasar : "+getObstacle().getDamage());
        System.out.println("Para : "+getObstacle().getAward());
    }

    public void playerStatus(){
        System.out.println("Oyuncu Değerleri");
        System.out.println("-------------------------------");
        System.out.println("Sağlık : "+this.getPlayer().getHealth());
        System.out.println("Silahınız : "+getPlayer().getWeapon().getName());
        System.out.println("Zırh : "+getPlayer().getInventory().getArmor().getName());
        System.out.println("Bloklama : "+getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Hasar : "+this.getPlayer().getTotalDamage());
        System.out.println("Para : "+this.getPlayer().getMoney());

    }

    public  int randomObstacleNumber(){

        int number=(int)(Math.random()*this.getMaxObstacle())+1;
        Random r=new Random();
         //r.nextInt(this.getMaxObstacle())+1;
        return number;
    }
    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public Object getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }


    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}
