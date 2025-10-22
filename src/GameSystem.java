import java.util.ArrayList;
import java.util.Scanner;

public class GameSystem {
    Scanner input = new Scanner(System.in);

    static ArrayList<Game> games = new ArrayList<>();
    static ArrayList<Player> players = new ArrayList<>();

    private int gameCount;
    private int playerCount;

    private static int usedGameIds = 0;
    private static int usedPlayerIds;

    GameSystem(int maxGames, int maxPlayers) {
    }

    public static void addGame(String title, String genre, double price) {
        usedGameIds++;
        games.add(new Game((usedGameIds), title, genre, price));

    }

    public void addPlayer(String name, int age, double score) {
        usedPlayerIds++;
        players.add(new Player((usedPlayerIds), name, age, score));

    }

    public static void displayAllGames() {

        System.out.printf("%-5s %-25s %-15s %-10s%n", "ID", "Title", "Genre", "Price ($)");
        System.out.println("---------------------------------------------------------------");

        for (Game game : games) {
            System.out.printf(
                    "%-5d %-25s %-15s $%8.2f%n",
                    game.getGameId(),
                    game.getTitle(),
                    game.getGenre(),
                    game.getPrice()
            );
        }

    }

    public void displayAllPlayers() {

    }

    public void updatePlayerScore(int playerId, double newScore) {

    }

    public static Game findGameById(int gameId) {
        for (Game game : games) {
            if (game.getGameId() == gameId)
                return game;
        }
        return null;
    }

    Player findPlayerById(int playerId) {

        return null;
    }

    double calculateTotalRevenue() {

        return 0;
    }

    Player findTopScoringPlayer() {

        return null;
    }

}
