package snakes;
import java.util.Random;
public class Dice {
    Random rand = new Random();
    public int getNumber() {
            int num;
            num = rand.nextInt(6)+1;
            return num;
        }
}