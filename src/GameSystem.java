import java.util.ArrayList;

public class GameSystem {

    private Game[] games;
    private Player[] players;

    private static int usedGameIds = 0;
    private static int usedPlayerIds;

    public GameSystem() {
        this.games = new Game[0];
        this.players = new Player[0];

    }

    public void addGame(String title, String genre, double price) {
        usedGameIds++;
        Game newGame = new Game(usedGameIds, title, genre, price);

        Game[] newGames = new Game[games.length + 1];

        for (int i = 0; i < games.length; i++) {
            newGames[i] = games[i];
        }

        newGames[newGames.length - 1] = newGame;
        games = newGames;

    }

    public void addPlayer(String name, int age, double score) {
        usedPlayerIds++;
        Player newPlayer = new Player(usedPlayerIds, name, age, score);

        Player[] newPlayers = new Player[players.length + 1];
        for (int i = 0; i < players.length; i++) {
            newPlayers[i] = players[i];
        }

        newPlayers[newPlayers.length - 1] = newPlayer;
        players = newPlayers;
    }

    public String displayAllGames() {
        StringBuilder sb = new StringBuilder();

        sb.append("\n🎮================= GAME LIBRARY =================🎮\n");
        sb.append(String.format("%-5s %-25s %-15s %-10s%n", "🆔", "🎯 Title", "🎭 Genre", "💰 Price"));
        sb.append("---------------------------------------------------------------\n");

        for (Game game : games) {
            sb.append(String.format(
                    "%-5d %-25s %-15s $%8.2f%n",
                    game.getGameId(),
                    game.getTitle(),
                    game.getGenre(),
                    game.getPrice()
            ));
        }

        sb.append("===============================================================\n");

        return sb.toString();
    }

    public String displayAllPlayers() {
        StringBuilder sb = new StringBuilder();

        sb.append("\n👥================= PLAYER ROSTER =================👥\n");
        sb.append(String.format("%-5s %-25s %-15s %-10s%n", "🆔", "🧍 Name", "🎂 Age", "🏆 Score"));
        sb.append("---------------------------------------------------------------\n");

        for (Player player : players) {
            sb.append(String.format(
                    "%-5d %-25s %-15d %8.2f%n",
                    player.getPlayerId(),
                    player.getName(),
                    player.getAge(),
                    player.getScore()
            ));
        }

        sb.append("===============================================================\n");

        return sb.toString();
    }

    public String updatePlayerScore(int playerId, double newScore) {

        Player foundPlayer = null;
        for (Player player : players) {
            if (player.getPlayerId() == playerId) {
                foundPlayer = player;
                break;
            }
        }

        if (foundPlayer == null) {
            return "Player " + playerId + " not found!";

        }

        if (newScore >= 0) {
            foundPlayer.setScore(newScore);
            return "✅ Score updated successfully!";
        } else {
            return "Score can't be negative.";
        }
    }

    public Game findGameById(int gameId) {
        for (Game game : games) {
            if (game.getGameId() == gameId)
                return game;
        }
        return null;
    }

    public Player findPlayerById(int playerId) {
        for (Player player : players) {
            if (player.getPlayerId() == playerId)
                return player;
        }
        return null;
    }

    public double calculateTotalRevenue(ArrayList<Game> basket) {
        double sum = 0;

        for (Game game : basket) {
            sum += game.getPrice();
        }
        return sum;
    }

    public Player findTopScoringPlayer() {
        if (players == null || players.length == 0) {
            return null;
        }

        Player topPlayer = players[0];

        for (Player player : players) {
            if (player.getScore() > topPlayer.getScore()) {
                topPlayer = player;
            }
        }
        return topPlayer;
    }

}
