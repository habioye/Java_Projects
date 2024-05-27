import java.util.ArrayList;
import java.util.Objects;

public class EscapeWizardLair {
    private static void generateAssets() {
        ArrayList<Objects> asset_collection = new ArrayList<>();
//        String see, String smell, String taste, String listen, String touch, String challenge, String answer
        ArrayList<Room> rooms = new ArrayList<>();

        Item bed = new Item();
        Item mirror = new Item();
        Item cabinet = new Item();
        Room bedroom = new Room();
        bedroom.objects.add(bed);
        bedroom.objects.add(mirror);
        bedroom.objects.add(cabinet);

        Item item = new Item();
        Room livingroom = new Room();

        Item table = new Item();
        Room basement = new Room();
        Room outside = new Room();
//        Room lavoratory = new Room();
//        Room Subbasement = new Room();
        Room cave = new Room();








    }
    public static void main(String[] args) {
        System.out.println("""
                You are stuck in a mad wizard's lair. 
                The wizard will not allow you to leave.
                You must explore the lair to figure out 
                clues to help you escape.
                """);
        ArrayList<Objects> assets = generateAssets();

    }
}
