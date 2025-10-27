public class Game {

    private final int gameId;
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

    public static void displayDetails(Game game) {
        Tools.printToConsole("--------------------"
                + "\nGame ID: " + game.getGameId()
                + "\nTitle: " + game.getTitle()
                + "\nGenre: " + game.getGenre()
                + "\nPrice: $" + game.getPrice()
                + "\n--------------------");
    }

    @Override
    public String toString() {
        return String.format(
                "🎮 Game #%d%n" +
                        "   • Title: %s%n" +
                        "   • Genre: %s%n" +
                        "   • Price: $%.2f",
                gameId, title, genre, price
        );
    }
}
