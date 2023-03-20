package Game;

import java.util.Scanner;

public class Player {
    private Scanner sc = new Scanner(System.in);
    Inventory inventory;
    private int damage;
    private int health;
    private int money;
    private String  name;
    private String charName;
    private int defHealth;

    public Player(String name ){
        this.name=name;
        inventory=new Inventory();
    }

    public int getDefHealth() {
        return defHealth;
    }

    public void setDefHealth(int defHealth) {
        this.defHealth = defHealth;
    }

    void selectChar(){
        GameChar[] charList={new Samurai(),new Archer(),new Knight()};
        System.out.println("------------------------------------------------------");
        System.out.println("Karakterler  : ");

        for(GameChar gameChar:charList){
            System.out.println("ID :"+gameChar.getId()+"\tKarakter "+gameChar.getName()+"\t Hasar :"+gameChar.getDamage()+"\t Sağlık: "+gameChar.getHealth()+"\t Para : "+gameChar.getMoney());
        }
        System.out.println("------------------------------------------------------");
        System.out.print("Lütfen Bir karakter Seçiniz : ");
        int selectChar = sc.nextInt();

        switch (selectChar){
            case 1:initPlayer(new Samurai());break;
            case 2:initPlayer(new Archer());break;
            case 3:initPlayer(new Knight());break;
            default:initPlayer(new Samurai());break;
        }
        System.out.println("Seçilen Karakter : "+this.charName+"\t Hasar :"+this.getDamage()+"\t Sağlık: "+this.getHealth()+"\t Para : "+this.  getMoney());
    }
    public void selectLoc(){

    }

    public void initPlayer(GameChar gameChar){
        this.damage=gameChar.getDamage();
        this.health=gameChar.getHealth();
        this.money=gameChar.getMoney();
        this.charName=gameChar.getName();
        this.setDefHealth(gameChar.getHealth());
    }
    public void printInfo(){
        System.out.println("Silahınız :"+this.getInventory().getWeapon().getName()+"  Zırhınız :"+getInventory().getArmor().getName()+ "Bloklama değeri :"+getInventory().getArmor().getBlock()+"  Hasar :"+this.getDamage()+"\t Sağlık: "+this.getHealth()+"\t Para : "+this.  getMoney());
    }
    public int getTotalDamage(){
    return this.damage+getInventory().getWeapon().getDamage();
    }

    public int getDamage(){
        return this.damage;
    }
    public void setDamage(int damage){
        this.damage=damage;
    }
    public int getHealth(){
        return this.health;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public void setHealth(int health){
        this.health=health;
        if(this.health<0){
            this.health=0;

        }
    }
    public int getMoney(){
        return this.money;
    }
    public void setMoney(int money){
        this.money=money;
    }
    public Weapon   getWeapon(){
        return getInventory().getWeapon();
    }
}
