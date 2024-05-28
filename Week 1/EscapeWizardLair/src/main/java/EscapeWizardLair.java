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
                Press 4 to move up.
                Press 5 to move left.
                Press 6 to move right
                Press 7 to move down
                Press 8 to exit interaction/Challenge
                """);
        ArrayList<Room> assets = generateAssets();
        Room current = assets.getLast();
        Item curr = new Item();
        Scanner scanner = new Scanner(System.in);
        int decision;
        boolean exit;

        while (true) {
            if (Objects.equals(current.roomName, "outside")) {
                System.out.println("You have escaped the Wizard Lair!!!");
                break;

            }
            current.display();
            scanner.nextInt();
            decision = scanner.nextInt();
            switch (decision) {
                case 1:
                case 2:
                case 3:

                    curr = current.objects.get(decision-1);

                    while (true) {
                        System.out.println("""
                                1. touch
                                2. smell
                                3. taste
                                4. listen
                                5. see
                                6. challenge
                                7. exit
                                """);
                        decision = scanner.nextInt();
                        exit = false;
                        switch (decision) {
                            case 1 -> {
                                curr.touch();
                            }
                            case 2 -> {
                                curr.smell();
                            }
                            case 3 -> {
                                curr.taste();
                            }
                            case 4 -> {
                                curr.listen();
                            }
                            case 5 -> {
                                curr.see();
                            }
                            case 6 -> {
                                curr.challenge();
                            }
                            case 7 -> {
                                exit = true;
                            }
                            default -> {
                                continue;
                            }
                        }
                        if (exit) {
                            break;
                        }



                    }
                    break;


                case 4:
                case 5:
                case 6:
                case 7:
                    if (!current.connections[decision].equals(null)) {
                        current = current.connections[decision-4];
                    }

                default:
                    throw new IllegalStateException("Unexpected value: " + decision);
            }


        }



    }
}
