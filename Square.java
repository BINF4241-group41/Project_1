package project;


public abstract class Square {

    protected int numberSquare;


    public int getNumberSquare() {
        return numberSquare;
    }

    public abstract boolean isOccupied();

    public abstract void addPlayer(Player player); // Game should check if already occupied.
    public abstract void removePlayer();

    public abstract String getPlayerName();

    public abstract String toString();
}
