package project;


public class Player {

    private String name;
    private Square position;

    Player(String playerName) {
        this.name = playerName;
        // TODO: Initialize to first square.
    }

    public String getName() {
        return name;
    }

    public void setName(playerName) {
        this.name = playerName;
    }

    public void leavePosition() {
        position.removePlayer();
    }

    public void setPosition(Square destination) {
        this.position = destination;
        position.addPlayer(this);
    }

    public Square getPosition() {
        return position;
    }
}