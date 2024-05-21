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

        while (true) {
            System.out.println("Guess the number(you have ten seconds): ");
            Timer timer = new Timer();
            scanner = new Scanner(System.in);
            AtomicInteger currentTime = new AtomicInteger(duration);

            timerfail = false;
            scannerfail = false;

            number = new AtomicInteger(-1);

            Thread scanthread = new Thread() {

                public void run() {
                    try {
                        number.set(scanner.nextInt());
                        timer.cancel();
                        System.out.println("scanned " + number);

                    } catch (Exception e) {
                        System.out.println("Exception caught: " + e.getMessage());
                        scannerfail = true;
                    }

                }
            };

            scanthread.start();
            // System.out.println("waiter");

            timer.scheduleAtFixedRate(new TimerTask() {
                public void run() {
                    System.out.println(currentTime);
                    if (currentTime.intValue() <= 0) {
                        timerfail = true;
                        timer.cancel();
                        scanner.close();
                        // System.out.print("breach");
                        return;
                    }
                    currentTime.decrementAndGet();
                }
            }, delay, second);

            while (true) {
                if (number.intValue() != -1) {
                    System.out.println("output");
                    break;
                }
                if (timerfail == true) {
                    System.out.println("Ran out of time");
                    break;
                }
                if (scannerfail == true) {
                    System.out.println("Scanner failed");
                    break;
                }

            }
            // System.out.println("pasted");

            // scanthread.suspend();
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
        System.out.println("The number of attempts is " + attempts);
        System.exit(0);

    }

}
