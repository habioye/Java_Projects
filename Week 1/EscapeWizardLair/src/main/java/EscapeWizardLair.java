import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class EscapeWizardLair {
    private static ArrayList<Room> generateAssets() {
//        ArrayList<Room> asset_collection = new ArrayList<>();
//        String see, String smell, String taste, String listen, String touch, String challenge, String answer
        ArrayList<Room> rooms = new ArrayList<>();

        Item bed = new Item();
        Item mirror = new Item();
        Item cabinet = new Item();
        Room bedroom = new Room();
        bedroom.objects.add(bed);
        bedroom.objects.add(mirror);
        bedroom.objects.add(cabinet);

        Item table = new Item();
        Item chair = new Item();
        Item carpet = new Item();
        Room livingroom = new Room();
        livingroom.objects.add(table);
        livingroom.objects.add(chair);
        livingroom.objects.add(carpet);

        Item boxes = new Item();
        Item Lamp = new Item();
        Item Chest = new Item();
        Room basement = new Room();
        basement.objects.add(boxes);
        basement.objects.add(Lamp);
        basement.objects.add(Chest);

        Room outside = new Room();
//        Room lavoratory = new Room();
//        Room Subbasement = new Room();
        Item scroll = new Item();
        Item hat = new Item();
        Item Bolder = new Item();
        Room cave = new Room();
        cave.objects.add(scroll);
        cave.objects.add(hat);
        cave.objects.add(Bolder);

        rooms.add(cave);
        rooms.add(bedroom);
        rooms.add(livingroom);
        rooms.add(basement);
        rooms.add(outside);

        cave.connections[2] = livingroom;
        livingroom.connections[1] = cave;

        livingroom.connections[0] = bedroom;
        bedroom.connections[3] = livingroom;

        livingroom.connections[3] = basement;
        basement.connections[0] = basement;

        livingroom.connections[2] = outside;
        outside.connections[1] = livingroom;

        return rooms;

    }
    public static void main(String[] args) {
        System.out.println("""
                You are stuck in a mad wizard's lair. 
                The wizard will not allow you to leave.
                You must explore the lair to figure out 
                clues to help you escape.
                -------------------------------------------
                Directions:
                You must find a way to escape.
                In each room that you are in, you can choose
                to interact with items and interact with 
                challenges.
                Press (1-3) to Interact with objects
                Press 4 to start a challenge for a room
                Press 5 to move up.
                Press 6 to move left.
                Press 7 to move right;
                Press 8 to move down;
                """);
        ArrayList<Room> assets = generateAssets();
        Room current = assets.getLast();
        Scanner scanner = new Scanner(System.in);
        int decision;

        while (true) {
            current.display();
            scanner.nextInt();
            decision = scanner.nextInt();


        }



    }
}
