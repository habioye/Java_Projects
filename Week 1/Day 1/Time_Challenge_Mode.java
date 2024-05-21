import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class Time_Challenge_Mode {

    static boolean timerfail;
    static boolean scannerfail;
    static Scanner scanner;
    static AtomicInteger number;

    // The program will generate a random number and the user has to guess the
    // answer(with hints).
    // When the correct answer is given the number of attempts is displayed.
    // The number of allowed attempts and the random number range changes with
    // difficulty
    // When guessing there will be a ten second timer and the game fails if the ten
    // seconds are up.
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

        scanner = new Scanner(System.in);
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

        long second = 1000;
        int duration = 10;

        long delay = 0;

        // Loop to keep checking if the given number matches the target.
        // Exit loop if correct answer found or reached attempt limit.
        while (true) {
            System.out.println("Guess the number(you have ten seconds): ");
            Timer timer = new Timer();
            scanner = new Scanner(System.in);
            AtomicInteger currentTime = new AtomicInteger(duration);

            timerfail = false;
            scannerfail = false;

            number = new AtomicInteger(-1);

            // Create a separate thread to scan for user input.
            Thread scanthread = new Thread() {

                public void run() {
                    try {
                        number.set(scanner.nextInt());
                        timer.cancel();

                    } catch (Exception e) {
                        System.out.println("Exception caught: " + e.getMessage());
                        scannerfail = true;
                    }

                }
            };

            scanthread.start();

            // Create a separate timer thread to update the time left every second.
            timer.scheduleAtFixedRate(new TimerTask() {
                public void run() {
                    System.out.println(currentTime);
                    if (currentTime.intValue() <= 0) {
                        timerfail = true;
                        timer.cancel();
                        scanner.close();
                        return;
                    }
                    currentTime.decrementAndGet();
                }
            }, delay, second);

            while (true) {
                if (number.intValue() != -1) {
                    break;
                }
                if (timerfail == true) {
                    System.out.println("Ran out of time!");
                    break;
                }
                if (scannerfail == true) {
                    System.out.println("Scanner failed!");
                    break;
                }

            }

            if (timerfail || scannerfail) {
                break;
            }
            attempts += 1;

            if (number.intValue() < target) {
                System.out.println("The answer is higher");

            } else if (number.intValue() > target) {
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
        if (timerfail || scannerfail) {
            System.out.println("The correct answer is " + target);
        }
        System.out.println("The number of attempts is " + attempts);
        System.exit(0);

    }

}
