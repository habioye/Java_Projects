import java.util.Random;
import java.util.Scanner;

public class Difficulty_Levels {

    public static void main(String[] args) {
        System.out.println("Advanced Number Guessing Game");
        System.out.println("------------------------");
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
            case 1:
                bound = 50;
                attemptlimit = 30;
                break;
            case 2:
                bound = 100;
                attemptlimit = 25;
                break;
            case 3:
                bound = 500;
                attemptlimit = 20;
                break;
            default:
                break;
        }
        int current = 1+rand.nextInt(bound);
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
                break;
            }
            attempts+=1;
            if (attempts >= attemptlimit) {
                System.out.println("Above the number of Attempts limit");
                break;
            }
        }
        System.out.println("The number of Attempts is "+ attempts);
        return;

    }

}
