package Game;

public class Inventory {

    private Weapon weapon;
    private Armor armor;
    private int food;
    private int firewood;
    private int water;
    public Inventory()
    {   this.armor = new Armor(-1,0,0,"Kafakol");
        this.weapon=new Weapon("Yumruk",-1,0,0);
        this.food=0;
        this.firewood=0;
        this.water=0;
    }

    public int getFood() {
        return food;
    }

    public int getFirewood() {
        return firewood;
    }

    public int getWater() {
        return water;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public void setFirewood(int firewood) {
        this.firewood = firewood;
    }

    public void setWater(int water) {
        this.water = water;
    }
}
