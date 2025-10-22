import java.util.Scanner;


public class Main {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        addInitialGames();

        promptMainMenu();


    }

    private static void promptMainMenu() {
        while (true) {

            int userInput = -1;
            Tools.titlePrinter("MAIN MENU", true);
            Tools.printToConsole("""
                    1... Games
                    2... Players
                    
                    0... Exit
                    """);
            do {

                String inputStr = input.nextLine().trim();

                try {
                    userInput = Integer.parseInt(inputStr);

                    if (userInput == 1) {
                        promptGamesMenu();
                    } else if (userInput == 2) {
                        promptPlayersMenu();
                    } else if (userInput == 0) {
                        Tools.printToConsole("Exiting program...");
                        return;
                    } else {
                        Tools.printToConsole("Invalid choice. Please enter 0, 1, or 2.");
                    }

                } catch (NumberFormatException e) {
                    Tools.printToConsole("Invalid input. Please enter a number (0, 1, or 2).");
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
                    
                    0... Back to main menu
                    """);
            int userInput = input.nextInt();
            input.nextLine();

            switch (userInput) {
                case 0:
                    return;

                case 1:
                    // Display players
                    break;
                case 2:
                    // Add player
                    break;
                default:
                    // print error message and continue (restart loop)
            }
        }
    }

    private static void promptGamesMenu() {
        while (true) {
            Tools.titlePrinter("GAMES MENU", true);
            Tools.printToConsole("""
                    1... Display all games
                    2... Add game
                    3... Find game by ID
                    4... Edit game
                    
                    0... Back to main menu
                    """);
            int userInput = input.nextInt();
            input.nextLine();

            switch (userInput) {
                case 0:
                    return;

                case 1:
                    GameSystem.displayAllGames();
                    Tools.waitForUser(input);
                    break;
                case 2:
                    promptAddGame();
                    break;
                case 3:
                    promptFindGameById();
                    break;
                case 4:
                    GameSystem.displayAllGames();
                    promptEditGame();
                    break;
                default:
                    Tools.printToConsole("Invalid input. Try again.");
            }
        }
    }

    private static void promptFindGameById() {
        while (true) {
            Tools.titlePrinter("GAME ID SEARCH", true);
            System.out.print("Game ID: ");

            int gameId = input.nextInt();
            input.nextLine();

            Game game = GameSystem.findGameById(gameId);
            if (game != null) {
                Tools.printToConsole("Success - game has been found!", true);
                GameSystem.displayGame(game);
                Tools.waitForUser(input);
                return;
            }

            Tools.printToConsole("No game with that ID was found, Try again.");
            Tools.waitForUser(input);
        }
    }

    private static void promptEditGame() {
        Tools.titlePrinter("\nEDIT GAME");

        System.out.println("Enter Game ID to edit: ");
        int gameId = input.nextInt();
        input.nextLine();

        Game game = GameSystem.findGameById(gameId);

        if (game == null) {
            Tools.printToConsole("No game with that ID was found. Try again.");
            Tools.waitForUser(input);
            return;
        }

        Tools.printToConsole("Game found: ", true);
        GameSystem.displayGame(game);

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

        System.out.println("New price: ");
        String priceInput = input.nextLine().trim().replace(",", ".");
        if (!priceInput.isEmpty()) {
            try {
                double newPrice = Double.parseDouble(priceInput);
                if (newPrice >= 0) {
                    game.setPrice(newPrice);
                } else {
                    System.out.println("Price can't be negative. Game will keep it's current price. ");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid price input. Game will keep it's current price. ");
            }
        }

        Tools.printToConsole("Game has been updated: ");
        GameSystem.displayGame(game);
        Tools.waitForUser(input);

    }


    private static void addInitialGames() {
        GameSystem.addGame("Minecraft", "Survival", 39.99);
        GameSystem.addGame("Stardew Valley", "Simulation", 14.99);
        GameSystem.addGame("Elden Ring", "Action RPG", 59.99);
        GameSystem.addGame("Among Us", "Party", 4.99);
        GameSystem.addGame("Cyberpunk 2077", "RPG", 49.99);
        GameSystem.addGame("The Witcher 3: Wild Hunt", "RPG", 29.99);
        GameSystem.addGame("Terraria", "Adventure", 9.99);
        GameSystem.addGame("Overwatch 2", "Shooter", 0.00);
        GameSystem.addGame("The Sims 4", "Simulation", 19.99);
        GameSystem.addGame("Red Dead Redemption 2", "Action", 69.99);
        GameSystem.addGame("Portal 2", "Puzzle", 9.99);
        GameSystem.addGame("Phasmophobia", "Horror", 13.99);
    }

    private static void promptAddGame() {
        String title;
        Tools.titlePrinter("ADD GAME", true);
        do {
            System.out.print("Game title: ");
            title = input.nextLine().trim();

            if (title.isEmpty()) Tools.printToConsole("Invalid input. Please enter a valid game title.");

        } while (title.isEmpty());


        String genre;
        Tools.titlePrinter("ADD GAME", true);
        do {
            System.out.print("Game genre: ");
            genre = input.nextLine().trim();
            if (genre.isEmpty()) Tools.printToConsole("Invalid input. Please enter a valid game genre.");

        } while (genre.isEmpty());


        double price = 0.0;
        boolean validInput = false;

        do {
            Tools.titlePrinter("ADD GAME", true);
            System.out.print("Game price: ");

            String priceInput = input.nextLine().trim();

            if (priceInput.isEmpty()) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            priceInput = priceInput.replace(',', '.');

            try {
                price = Double.parseDouble(priceInput);
                if (price < 0) {
                    System.out.println("Price cannot be negative. Try again.");
                } else {
                    validInput = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }

        } while (!validInput);

        GameSystem.addGame(title, genre, price);

    }

}