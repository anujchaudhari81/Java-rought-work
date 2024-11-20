import java.util.Random;
import java.util.Scanner;

class Dice {
    private int value;

    public Dice() {
        this.value = 1;
    }

    public void roll() {
        Random rand = new Random();
        this.value = rand.nextInt(6) + 1; // Generates a random number between 1 and 6
    }

    public int getValue() {
        return this.value;
    }
}

class Game {
    private Dice dice1;
    private Dice dice2;
    private int score;
    private int targetScore;

    public Game(int targetScore) {
        this.dice1 = new Dice();
        this.dice2 = new Dice();
        this.score = 0;
        this.targetScore = targetScore;
    }

    public void rollDice() {
        dice1.roll();
        dice2.roll();
        System.out.println("Dice 1: " + dice1.getValue());
        System.out.println("Dice 2: " + dice2.getValue());

        this.score += dice1.getValue() + dice2.getValue();

        if (dice1.getValue() == dice2.getValue()) {
            System.out.println("You rolled a double! Bonus points added.");
            this.score += 1;
        }
    }

    public void displayScore() {
        System.out.println("Current score: " + this.score);
        System.out.println("Target score: " + this.targetScore);
    }

    public boolean isTargetReached() {
        return this.score >= this.targetScore;
    }
}

public class LuckyDiceAdventure {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Lucky Dice Adventure!");
        System.out.println("Enter the target score to win:");
        int targetScore = scanner.nextInt();

        Game game = new Game(targetScore);
        boolean playing = true;

        while (playing) {
            System.out.println("Press 'r' to roll the dice, 's' to stop:");
            char choice = scanner.next().charAt(0);

            if (choice == 'r') {
                game.rollDice();
                game.displayScore();
                if (game.isTargetReached()) {
                    System.out.println("Congratulations! You reached the target score and won the game!");
                    playing = false;
                }
            } else if (choice == 's') {
                System.out.println("You stopped. Your final score is:");
                game.displayScore();
                playing = false;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
