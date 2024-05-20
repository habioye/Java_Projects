import java.util.Random;
import java.util.Scanner;

public class Classic_Mode {
    // private int current;
    // private int attempts;
    // public Advanced_Number_Guessing_Game() {
    //     // Random rand = new Random();

    //     // this.current = 1 + rand.nextInt(100);
    //     // this.attempts = 0;



    // }
    public static void main(String[] args) {
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