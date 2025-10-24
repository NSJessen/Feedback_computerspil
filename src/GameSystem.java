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

    private GameSystem(){
    }

    public static void addGame(String title, String genre, double price) {
        usedGameIds++;
        games.add(new Game((usedGameIds), title, genre, price));

    }

    public static void addPlayer(String name, int age, double score) {
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

    public static void displayAllPlayers() {

        System.out.printf("%-5s %-25s %-15s %-10s%n", "ID", "Name", "Age", "Score");
        System.out.println("---------------------------------------------------------------");

        for (Player player : players){
            System.out.printf("%-5d %-25s %-15s %8.2f%n",
                    player.getPlayerId(),
                    player.getName(),
                    player.getAge(),
                    player.getScore()
            );
        }
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

    public static Player findPlayerById(int playerId) {
        for (Player player : players){
            if (player.getPlayerId() == playerId)
                return player;
        }
        return null;
    }

    double calculateTotalRevenue() {

        return 0;
    }

    public static Player findTopScoringPlayer() {
        if (players.isEmpty()){
            return null;
        }

        Player topPlayer = players.getFirst();

        for (Player player : players){
            if (player.getScore() > topPlayer.getScore()){
                topPlayer = player;
            }
        }
        return topPlayer;
    }

}
