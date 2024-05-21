import java.util.Random;
import java.util.Scanner;

public class Classic_Mode {

    public static void main(String[] args) {
        System.out.println("Advanced Number Guessing Game");
        System.out.println("---------------------------------");
        System.out.println("Directions");
        System.err.println("The program generates a random number between 1 and 100.\n" + //
                        "The user has to guess the number, and the program provides hints (higher or lower) until the user guesses correctly.\n" + //
                        "The number of attempts will be displayed at the end.");
        System.out.println("---------------------------------");
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        int current = 1+rand.nextInt(100);
        int attempts = 0;


        while (true) {
            System.out.println("Guess The number: ");
            int number = scanner.nextInt();
            attempts+=1;
            if (number < current) {
                System.out.println("Higher");
            } else if (number > current) {
                System.out.println("Lower");
            } else {
                System.out.println("Correct!!");
                System.out.println("The number of Attempts is "+ attempts);
                break;
            }

            

        }
        return;

    }
}