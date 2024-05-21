import java.util.Random;
import java.util.Scanner;

public class Difficulty_Levels {

    public static void main(String[] args) {
        System.out.println("Advanced Number Guessing Game");
        System.out.println("---------------------------------");
        System.out.println("Directions:");
        System.err.println(
                """
                        The program generates a random number between 1 and 100.
                        The user has to guess the number, and the program provides hints (higher or lower) until the user guesses correctly.
                        The number of attempts will be displayed at the end.""");
        System.out.println("---------------------------------");
        System.out.println("Choose Your Difficulty Level");
        System.out.println("1.) Easy : Number between 1 and 50. 30 Attempts.");
        System.out.println("2.) Medium : Number between 1 and 100. 25 Attempts.");
        System.out.println("3.) Hard : Number between 1 and 500. 20 Attempts.");

        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        int difficulty = scanner.nextInt();
        int bound = 0;
        int attemptlimit = 0;
        switch (difficulty) {
            case 1 -> {
                bound = 50;
                attemptlimit = 30;
            }
            case 2 -> {
                bound = 100;
                attemptlimit = 25;
            }
            case 3 -> {
                bound = 500;
                attemptlimit = 20;
            }
            default -> throw new IllegalArgumentException("No valid input detected");
        }
        int target = 1 + rand.nextInt(bound);
        int attempts = 0;

        while (true) {
            System.out.println("Guess The number: ");
            int number = scanner.nextInt();
            attempts += 1;

            if (number < target) {
                System.out.println("The answer is higher");

            } else if (number > target) {
                System.out.println("The answer is lower");
            } else {
                System.out.println("Correct!");
                break;
            }

            if (attempts >= attemptlimit) {
                System.out.println("Ran out of attempts!");
                break;
            }
        }
        System.out.println("The number of attempts is " + attempts);

    }

}
