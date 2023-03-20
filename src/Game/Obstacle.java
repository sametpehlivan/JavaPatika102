package Game;

public class Obstacle {
    private int id ;
    private String name ;
    private int damage;
    private int health;
    private int award;
    private int defHealth;


    Obstacle(int id, String name, int damage, int health, int award,int defHealth){
        this.damage= damage;
        this.health=health;
        this.id=id;
        this.name=name;
        this.award=award;
        this.defHealth = defHealth;
    }

    public int getDefHealth() {
        return defHealth;
    }

    public void setDefHealth(int defHealth) {
        this.defHealth = defHealth;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
        if(health<0){
            this.health=0;
        }
    }
}
