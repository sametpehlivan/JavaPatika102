package Game;

public class Snake extends Obstacle{
    private static int randomNum;
    Snake(int damage) {
        super(4, "Yılan",damage,12,0, 12);
    }
    public static int randomNumber(){
        randomNum =(int)((Math.random()*4)+3);
    return randomNum;
    }
}
