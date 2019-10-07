package project;


// Special square that moves the player to another square.
// Has no player on its own.
public class TeleportSquare extends Square{

    private Square teleportDestination = null;

    public TeleportSquare(int numberSquare, Square destination) {
        this.numberSquare=numberSquare;
        teleportDestination = destination;
    }

    public int getNumberSquare() {
        return numberSquare;
    }

    public void addPlayer(Player player) {
        teleportDestination.addPlayer(player);
    }

    // remove a player from the square
    public void removePlayer() { }

    public boolean isOccupied() {
        return teleportDestination.isOccupied();
    }

    @Override
    public String toString() {
        return "[" + numberSquare + "->" + teleportDestination.getNumberSquare() + "]";
    }

    public String getPlayerName() {
        return "";
    }
}