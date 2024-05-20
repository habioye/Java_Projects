import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;


public class Time_Challenge_Mode {

    static boolean timerfail;
    static Scanner scanner;
    static AtomicInteger number;
    
    public static void main(String[] args) {
        System.out.println("Advanced Number Guessing Game");
        System.out.println("------------------------");
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
            default -> {
            }
        }
        int current = 1+rand.nextInt(bound);
        int attempts = 0;
        
        long second = 1000;
        int duration = 10;
        // long currentTime;
        long delay = 0;

        while (true) {
            System.out.println("Guess The number(you have ten seconds): ");
            Timer timer = new Timer();
            scanner = new Scanner(System.in);
            // currentTime = duration;
            AtomicInteger currentTime = new AtomicInteger(duration);

            timerfail = false;

            number = new AtomicInteger(-1);

            System.out.println("before");
            Thread scanthread = new Thread() {

                public void run() {
                try {
                    number.set(scanner.nextInt());
                    timer.cancel();
                    // scanner.close();
                    System.out.println("scanned "+number);

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    System.out.println("There is an exception");
                }

                return;
                

                
                }
            };

            scanthread.start();
            System.out.println("waiter");


            timer.scheduleAtFixedRate(new TimerTask() {
                public void run() {
                    System.out.println(currentTime);
                    if (currentTime.intValue() <= 0) {
                        timerfail = true;
                        timer.cancel();
                        // scanner.close();
                        // System.out.print("breach");
                        return;
                    } 
                    currentTime.decrementAndGet();
                    return;
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

            }
            System.out.println("pasted");

            // scanthread.suspend();
            if (timerfail) {
                break;
            }
            attempts+=1;

            if (number.intValue() < current) {
                System.out.println("Higher");
            } else if (number.intValue() > current) {
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
