public class Player {

    public String name;
    public Square position;

    Player(String playerName) {
        this.name = playerName;
        // TODO: Initialize to first square.
    }
    
    public void setPosition(Square destination) {
        this.position = destination;
    }
}