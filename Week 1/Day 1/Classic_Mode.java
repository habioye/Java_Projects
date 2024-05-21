import java.util.Random;
import java.util.Scanner;

public class Classic_Mode {

    // The program will generate a random number and the user has to guess the
    // answer(with hints).
    // When the correct answer is given the number of attempts is displayed.
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
        try (Scanner scanner = new Scanner(System.in)) {
            Random rand = new Random();

            int target = 1 + rand.nextInt(100);
            int attempts = 0;

            // Loop to keep checking if the given number matches the target.
            while (true) {
                System.out.println("Guess The number: ");
                int number = scanner.nextInt();
                attempts += 1;
                if (number < target) {
                    System.out.println("The answer is higher");
                } else if (number > target) {
                    System.out.println("The answer is lower");
                } else {
                    System.out.println("Correct!!");
                    System.out.println("The number of attempts is " + attempts);
                    break;
                }

            }
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

    }
}