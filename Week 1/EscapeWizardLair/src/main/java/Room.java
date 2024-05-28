import java.util.ArrayList;

public class Room {
    public ArrayList<Item> objects = new ArrayList<>();
    public Room[] connections = new Room[4];
    public String roomName;
    public Room(String name) {
        this.roomName = name;
    }
    // encapsulation for room name
    public String extractName (Room room) {
        if (room == null) return "Dirt";
        return this.roomName;
    }

//    Displays the rooms that surround and gives them the names for the objects in the room
    public void display() {
        String room1, room2, room3, room4;
        room1 = extractName(connections[0]);
//        if (room1.length() > 10) {
//
//        }
        room2 = extractName(connections[1]);
        room3 = extractName(connections[2]);
        room4 = extractName(connections[3]);

        System.out.println("Room Name: "+this.roomName);
//        if (connections[0] == None)
        // Top, Left, Right, Down
        System.out.printf(String.format("""
                ________________| %s |______________
                                |                                |
                 %s    |        %s       |         %s
               _________________|________________________________|_____________
                                | %s |
                """,extractName(connections[0]),extractName(connections[1]),this.roomName,extractName(connections[2]),extractName(connections[3]));


        for (int i = 0; i < this.objects.size();i++) {
            Item item = new Item();
            System.out.println((i+1)+".)"+item.getName());

        }
    }
}
