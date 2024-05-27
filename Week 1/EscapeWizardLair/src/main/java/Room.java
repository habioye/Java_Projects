import java.util.ArrayList;

public class Room {
    public ArrayList<Item> objects;
    public Room[] connections = new Room[4];
    public String roomName;
    public String extractName (Room room) {
        if (room == null) return "Dirt";
        return this.roomName;
    }
    public void display() {

        String room1, room2, room3, room4;
        room1 = extractName(connections[0]);
        if (room1.length() > 10) {

        }
        room2 = extractName(connections[1]);
        room3 = extractName(connections[2]);
        room4 = extractName(connections[3]);


//        if (connections[0] == None)
        // Top, Left, Right, Down
        System.out.printf(String.format("""
                ________________| % |______________
                                |                                |
                 %s    |        %s       |         %s
               _________________|________________________________|_____________
                                | %s |
                """,extractName(connections[0]),extractName(connections[1]),extractName(connections[2])),extractName(connections[3]));


        for (Item item : objects) {
            System.out.println(item.getName());
        }
    }
}
