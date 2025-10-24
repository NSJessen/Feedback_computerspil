public class Player {
    private final int playerId;
    private final String name;
    private final int age;
    private double score;

    public Player(int playerId, String name, int age, double score) {
        this.playerId = playerId;
        this.name = name;
        this.age = age;
        this.score = score;

    }

    public int getPlayerId() {
        return playerId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public static void displayDetails(Player player) {
        Tools.printToConsole("--------------------"
                + "\nPlayer ID: " + player.getPlayerId()
                + "\nName: " + player.getName()
                + "\nAge: " + player.getAge()
                + "\nScore: " + player.getScore()
                + "\n--------------------");
    }

}
