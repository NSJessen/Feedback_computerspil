import java.util.Scanner;

public class Game {
    Scanner input = new Scanner(System.in);

    private int gameId;
    private String title;
    private String genre;
    private double price;


    public Game(int gameId, String title, String genre, double price) {
        this.gameId = gameId;
        this.title = title;
        this.genre = genre;
        this.price = price;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void displayDetails() {
        Tools.printToConsole("Game ID: " + gameId
                + "\nTitle: " + title
                + "\nGenre: " + genre
                + "\nPrice: $" + price);
    }

}
