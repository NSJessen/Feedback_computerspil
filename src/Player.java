import java.util.Scanner;

public class Player {
    Scanner input = new Scanner(System.in);

    private int playerId;
    private String name;
    private int age;
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

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void displayDetails(Player player) {
        Tools.printToConsole("--------------------"
                + "\nPlayer ID: " + player.getPlayerId()
                + "\nName: " + player.getName()
                + "\nAge: " + player.getAge()
                + "\nScore: " + player.getScore()
                + "\n--------------------");
    }

    public void updateScore(double newScore) {
        this.score = newScore;
    }
}
