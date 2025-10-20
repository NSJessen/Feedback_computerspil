import java.util.Scanner;

public class Game {
    Scanner input = new Scanner(System.in);

    private int gameId;
    private String title;
    private String genre;
    private double price;


    public Game(int gameId, String title, String genre, double price){
        this.gameId = gameId;
        this.title = title;
        this.genre = genre;
        this.price = price;
    }

    public int getGameId(){
        return gameId;
    }

    public void setGameId(int gameId){

    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){

    }

    public String getGenre(){
        return genre;
    }

    public void setGenre(){

    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price){

    }

    public void displayDetails(){

    }

}
