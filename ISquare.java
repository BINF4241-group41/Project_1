package project;


public interface ISquare {

    public boolean isOccupied();

    private int numberSquare;

    public void addPlayer(); // Game should check if already occupied.
    public void removePlayer();
}
