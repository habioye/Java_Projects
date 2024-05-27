import java.util.Scanner;

public class Item implements Interact {
    String see = "Doesn't look like you can see this item";
    String smell = "Doesn't seem like you can or should smell this item";
    String taste = "Doesn't seem like you can taste this item";
    String listen = "Doesn't seem like you can listen to this item";
    String touch = "Doesn't seem like you can touch";
    String challenge = "Doesn't seem like there is a challenge";
    String answer;
    String name;

    public void Item(String see, String smell, String taste, String listen, String touch, String challenge, String answer, String name) {
        if (!see.isEmpty()) this.see = see;
        if (!smell.isEmpty()) this.smell = smell;
        if (!taste.isEmpty()) this.taste = taste;
        if (!listen.isEmpty()) this.listen = listen;
        if (!touch.isEmpty()) this.touch = touch;
        if (!challenge.isEmpty()) {
            this.challenge = challenge;
            this.answer = answer;
        }
        this.name = name;

    }
    public String getName() {
        return this.name;
    }

    public void see() {
        System.out.println(this.see);

    }
    public void smell() {
        System.out.println(this.smell);

    }
    public void taste() {
        System.out.println(this.taste);

    }
    public void listen() {
        System.out.println(this.listen);

    }

    public void touch() {
        System.out.println(this.touch);
    }

    public boolean challenge() {
        System.out.println(this.challenge);
        Scanner scanner = new Scanner(System.in);
        String response = scanner.next();
        return response.equals(this.answer);

    }



}
