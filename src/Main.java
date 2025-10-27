import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    static Scanner input = new Scanner(System.in);
    static GameSystem gameSystem = new GameSystem();

    public static void main(String[] args) {
        addInitialGames();
        addInitialPlayers();


        promptMainMenu();
    }

    private static void promptMainMenu() {
        int userInput;
        while (true) {

            Tools.titlePrinter("MAIN MENU", true);
            Tools.printToConsole("""
                    1... Games
                    2... Players
                    
                    0... Exit
                    """);
            do {

                userInput = Tools.validateInt(input, "Enter choice");

                if (userInput == 1) {
                    promptGamesMenu();
                } else if (userInput == 2) {
                    promptPlayersMenu();
                } else if (userInput == 0) {
                    Tools.printToConsole(Tools.GREEN + "👋 Exiting program... See you soon!" + Tools.RESET);
                    return;
                } else {
                    Tools.printToConsole(Tools.RED + "❌ Invalid choice. Please enter 0, 1, or 2." + Tools.RESET);
                }

            } while (userInput < 0 || userInput > 2);
        }
    }

    private static void promptPlayersMenu() {
        while (true) {
            Tools.titlePrinter("PLAYERS MENU", true);
            Tools.printToConsole("""
                    1... Display all players
                    2... Add player
                    3... Find player by ID
                    4... Find top scoring player
                    5... Update player score
                    
                    0... Back to main menu
                    """);
            int userInput = Tools.validateInt(input, "Enter choice");

            switch (userInput) {
                case 0:
                    return;

                case 1:
                    Tools.clearConsole();
                    System.out.println(gameSystem.displayAllPlayers());
                    Tools.waitForUser(input);
                    break;
                case 2:
                    promptAddPlayer();
                    break;
                case 3:
                    promptFindPlayerById();
                    break;
                case 4:
                    promptFindTopScoringPlayer();
                    break;
                case 5:
                    promptUpdatePlayerScore();
                    break;
                default:
                    Tools.printToConsole(Tools.RED + "❌ Invalid input. Try again." + Tools.RESET);
                    break;
            }
        }
    }

    private static void promptAddPlayer() {
        String name;
        Tools.titlePrinter("ADD PLAYER", true);
        do {
            System.out.print("Player name: ");
            name = input.nextLine().trim();

            if (name.isEmpty())
                Tools.printToConsole(Tools.RED + "❌ Invalid input. Please enter a valid name." + Tools.RESET);

        } while (name.isEmpty());


        int age;
        Tools.titlePrinter("ADD PLAYER", true);
        do {
            age = Tools.validateInt(input, "Enter age");
            if (age < 1) Tools.printToConsole(Tools.RED + "❌ Invalid input. Please enter a valid age." + Tools.RESET);

        } while (age < 1);

        Tools.titlePrinter("ADD PLAYER", true);
        double score = Tools.validateDouble(input, "Enter score");

        gameSystem.addPlayer(name, age, score);

        Tools.printToConsole(Tools.GREEN + "✅ " + name + " has been added successfully!" + Tools.RESET);
        Tools.waitForUser(input);
    }


    private static void promptGamesMenu() {
        while (true) {
            Tools.titlePrinter("GAMES MENU", true);
            Tools.printToConsole("""
                    1... Display all games
                    2... Add game
                    3... Find game by ID
                    4... Edit game
                    5... Calculate basket
                    
                    0... Back to main menu
                    """);
            int userInput = Tools.validateInt(input, "Enter choice");

            switch (userInput) {
                case 0:
                    return;

                case 1:
                    System.out.println(gameSystem.displayAllGames());
                    Tools.waitForUser(input);
                    break;
                case 2:
                    promptAddGame();
                    break;
                case 3:
                    promptFindGameById();
                    break;
                case 4:
                    System.out.println(gameSystem.displayAllGames());
                    promptEditGame();
                    break;
                case 5:
                    promptCalculateBasket();
                    break;
                default:
                    Tools.printToConsole(Tools.RED + "❌ Invalid input. Try again." + Tools.RESET);
            }
        }
    }

    private static void promptFindGameById() {
        while (true) {
            Tools.titlePrinter("GAME ID SEARCH", true);

            int gameId = Tools.validateInt(input, "Enter game ID");

            Game game = gameSystem.findGameById(gameId);
            if (game != null) {
                Tools.printToConsole("Success - game has been found!", true);
                Game.displayDetails(game);
                Tools.waitForUser(input);
                return;
            }

            Tools.printToConsole(Tools.RED + "❌ No game with that ID was found, Try again." + Tools.RESET);
            Tools.waitForUser(input);
        }
    }

    private static void promptFindPlayerById() {
        while (true) {
            Tools.titlePrinter("PLAYER ID SEARCH", true);

            int playerId = Tools.validateInt(input, "Enter player ID: ");

            Player player = gameSystem.findPlayerById(playerId);
            if (player != null) {
                Tools.printToConsole("Success - player has been found!", true);
                Player.displayDetails(player);
                Tools.waitForUser(input);
                return;
            }

            Tools.printToConsole(Tools.RED + "❌ No player with that ID was found, Try again." + Tools.RESET);
            Tools.waitForUser(input);
        }
    }

    private static void promptEditGame() {
        Tools.printToConsole("");
        Tools.titlePrinter("EDIT GAME");

        int gameId = Tools.validateInt(input, "Enter Game ID to edit");

        Game game = gameSystem.findGameById(gameId);

        if (game == null) {
            Tools.printToConsole(Tools.RED + "❌ No game with that ID was found. Try again." + Tools.RESET);
            Tools.waitForUser(input);
            return;
        }

        Tools.printToConsole(Tools.GREEN + "✅ Game found: " + Tools.RESET, true);
        Game.displayDetails(game);

        System.out.println("New title: ");
        String newTitle = input.nextLine().trim();
        if (!newTitle.isEmpty()) {
            game.setTitle(newTitle);
        }

        System.out.println("New genre: ");
        String newGenre = input.nextLine().trim();
        if (!newGenre.isEmpty()) {
            game.setGenre(newGenre);
        }

        double newPrice = Tools.validateDouble(input, "New price");
        game.setPrice(newPrice);

        Tools.printToConsole(Tools.GREEN + "✅ Game has been updated: " + Tools.RESET);
        Game.displayDetails(game);
        Tools.waitForUser(input);

    }

    private static void addInitialGames() {
        gameSystem.addGame("Minecraft", "Survival", 39.99);
        gameSystem.addGame("Stardew Valley", "Simulation", 14.99);
        gameSystem.addGame("Elden Ring", "Action RPG", 59.99);
        gameSystem.addGame("Among Us", "Party", 4.99);
        gameSystem.addGame("Cyberpunk 2077", "RPG", 49.99);
        gameSystem.addGame("The Witcher 3: Wild Hunt", "RPG", 29.99);
        gameSystem.addGame("Terraria", "Adventure", 9.99);
        gameSystem.addGame("Overwatch 2", "Shooter", 0.00);
        gameSystem.addGame("The Sims 4", "Simulation", 19.99);
        gameSystem.addGame("Red Dead Redemption 2", "Action", 69.99);
        gameSystem.addGame("Portal 2", "Puzzle", 9.99);
        gameSystem.addGame("Phasmophobia", "Horror", 13.99);
    }

    private static void addInitialPlayers() {
        gameSystem.addPlayer("Havre", 26, 1337.69);
        gameSystem.addPlayer("Ravn", 31, 982.45);
        gameSystem.addPlayer("Luna", 22, 1543.10);
        gameSystem.addPlayer("Blitz", 28, 867.32);
        gameSystem.addPlayer("Nova", 19, 1204.77);
        gameSystem.addPlayer("Echo", 35, 2010.55);
        gameSystem.addPlayer("Pixel", 24, 945.88);
        gameSystem.addPlayer("Rune", 27, 1111.11);
        gameSystem.addPlayer("Kiro", 30, 1723.64);
        gameSystem.addPlayer("Mira", 23, 1349.50);
        gameSystem.addPlayer("Storm", 29, 999.99);
        gameSystem.addPlayer("Vex", 21, 1402.73);
    }

    private static void promptAddGame() {
        String title;
        Tools.titlePrinter("ADD GAME", true);
        do {
            System.out.print("Game title: ");
            title = input.nextLine().trim();

            if (title.isEmpty())
                Tools.printToConsole(Tools.RED + "❌ Invalid input. Please enter a valid game title." + Tools.RESET);

        } while (title.isEmpty());


        String genre;
        Tools.titlePrinter("ADD GAME", true);
        do {
            System.out.print("Game genre: ");
            genre = input.nextLine().trim();
            if (genre.isEmpty())
                Tools.printToConsole(Tools.RED + "❌ Invalid input. Please enter a valid game genre." + Tools.RESET);

        } while (genre.isEmpty());

        Tools.titlePrinter("ADD GAME", true);
        double price = Tools.validateDouble(input, "Game price");

        gameSystem.addGame(title, genre, price);

        Tools.printToConsole(Tools.GREEN + "✅ " + title + " has been added successfully!" + Tools.RESET);
        Tools.waitForUser(input);
    }

    private static void promptUpdatePlayerScore() {

        System.out.println(gameSystem.displayAllPlayers());
        System.out.println("\nType in the Id of the player you want to update: ");
        int playerId = Tools.validateInt(input, "Enter player ID");

        Player player = gameSystem.findPlayerById(playerId);

        while (true) {
            System.out.println("Type in score for " + player.getName() + ": ");
            double newScore = Tools.validateDouble(input, "Enter new score");

            String updateFeedback = gameSystem.updatePlayerScore(playerId, newScore);
            if (updateFeedback.equalsIgnoreCase("✅ Score updated successfully!")) {
                Tools.printToConsole(Tools.GREEN + updateFeedback + Tools.RESET);
                return;
            } else {
                Tools.printToConsole(updateFeedback);
            }
        }
    }

    private static void promptCalculateBasket() {
        ArrayList<Game> basket = new ArrayList<>();

        while (true) {
            Tools.clearConsole();
            System.out.println(gameSystem.displayAllGames());

            Tools.printToConsole("\nEnter the ID of the game you want to add (or 0, to calculate total): ");

            int gameId = Tools.validateInt(input, "Enter ID");

            if (gameId == 0) {
                break;
            }

            Game selectedGame = gameSystem.findGameById(gameId);

            if (selectedGame == null) {
                Tools.printToConsole(Tools.RED + "❌ No game found with that ID. Try again!" + Tools.RESET);
                continue;
            }

            Tools.printToConsole("How many copies of \"" + selectedGame.getTitle() + "\" do you want to add?", true);
            int quantity = Tools.validateInt(input, "Amount");

            for (int n = 0; n < quantity; n++) {
                basket.add(selectedGame);
            }

            Tools.printToConsole(quantity + " x " + selectedGame.getTitle() + " added to basket!");
            Tools.waitForUser(input);
        }
        Tools.titlePrinter("YOUR BASKET", true);
        double total = gameSystem.calculateTotalRevenue(basket);
        for (Game game : basket) {
            System.out.printf("%-25s $%.2f%n", game.getTitle(), game.getPrice());
        }
        Tools.printToConsole("-----------------------------");
        System.out.printf("TOTAL: $%.2f%n", total);
        Tools.waitForUser(input);
    }

    private static void promptFindTopScoringPlayer() {
        Tools.titlePrinter("TOP SCORING PLAYER", true);

        Player topPlayer = gameSystem.findTopScoringPlayer();

        if (topPlayer == null) {
            Tools.printToConsole(Tools.RED + "❌ No players found." + Tools.RESET);
        } else {
            Tools.printToConsole("The top scoring player is:", true);
            Player.displayDetails(topPlayer);
        }

        Tools.waitForUser(input);
    }

}