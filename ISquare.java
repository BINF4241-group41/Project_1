package project;


public interface ISquare {

    public boolean isOccupied();

    private int numberSquare;

    public void addPlayer(Player player); // Game should check if already occupied.
    public void removePlayer();
}
