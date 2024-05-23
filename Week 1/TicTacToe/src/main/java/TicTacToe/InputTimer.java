package TicTacToe;// package Week

// 1. Tic-Tac_Toe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class InputTimer {
    private final BufferedReader getInput = new BufferedReader(new InputStreamReader(System.in));
    private final ExecutorService executors = Executors.newVirtualThreadPerTaskExecutor();
    private String input;
    private int timeoutDuration;
    private Thread scanthread;
    private Thread timerthread;

    void waitForInput() {
        try {
            while (!getInput.ready()) {
                Thread.sleep(16);
                input = getInput.readLine();
                executors.shutdownNow();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    void timerCountdown() {
        IntStream.range(1, 10)
                .mapToObj(i -> i)
                .toList()
                .reversed()
                .forEach(i -> {
                try {
                    Thread.sleep(1000);
                    System.out.printf("Time Left: %d\n", i);
//                    System.out.println("checkiing if reached");
//                    if (i == 1) {
//                        Thread.sleep(1000);
//                        System.out.println("Ran out of time");
//                        executors.shutdownNow();
//                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
        });
    }

    private void InputTimer(int timeoutDuration) throws InterruptedException {

//        this.timeoutDuration = timeoutDuration;

        input = "invalid";
        executors.submit(this::waitForInput);
        executors.submit(this::timerCountdown);

        executors.awaitTermination(timeoutDuration, TimeUnit.MILLISECONDS);

        if (input.equals("invalid")) {
            System.out.println("Took too long");

        }
        executors.shutdownNow();

    }

    public String getInput(int timeOut) throws InterruptedException {
        // return new InputTimer(timeOut).input;
        input = "invalid";
        InputTimer(timeOut);

        return input;
    }
}
