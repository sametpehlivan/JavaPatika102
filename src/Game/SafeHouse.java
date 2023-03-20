package Game;

public  class SafeHouse extends NormalLoc{
    public SafeHouse(Player player){
        super(player,"Güvenli Ev");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Güvenli evdesiniz canınız Yenilendi.");
        this.getPlayer().setDefHealth(this.getPlayer().getDefHealth());
        return true;
    }
}
