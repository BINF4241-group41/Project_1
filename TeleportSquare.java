package project;


// Square without functionality (no snakes/ladders).
public class NormalSquare extends Square{


    private Player myPlayer=null;
    private Ladder ladder=null;
    private Snake snake=null;

    //3 different constructors for different parameters
    public NormalSquare(int numberSquare) {
        this.numberSquare=numberSquare;
    }

    public NormalSquare(int numberSquare, Ladder ladder) {
        this.numberSquare=numberSquare;
        this.ladder=ladder;
    }

    public NormalSquare(int numberSquare, Snake snake ) {
        this.numberSquare=numberSquare;
        this.snake=snake;
    }

    public int getNumberSquare() {
        return numberSquare;
    }

    // move a player to the square
    @Override
    public void addPlayer(Player player) {
        // TODO: check for ladders/snakes -> trigger corresponding action
        myPlayer=player;
    }
    // remove a player from the square
    public void removePlayer() {
        myPlayer=null;
    }

    public boolean isOccupied() {
        return (myPlayer != null);
    }

    @Override
    public String toString() {
        return "["+numberSquare+getNamePlayer()+getLadder()+getSnake()+"]";
    }


    //These are controll for my output string
    private String getNamePlayer() {
        if (isOccupied()) {
            return myPlayer.getName();
        }
        return "";
    }
    private String getLadder() {
        if(ladder!=null) {
            return ladder.getStringStart()+"->"+ladder.getStringEnd();
        }
        return "";
    }

    private String getSnake() {
        if(snake!=null) {
            return snake.getStringEnd()+"<-"+snake.getStringEnd();
        }
        return "";
    }
}