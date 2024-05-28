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
        return room.roomName;
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
        System.out.println(room3);
//        if (connections[0] == None)
        // Top, Left, Right, Down
        int cellwidth = 10;
        StringBuilder sb = new StringBuilder();

        String border = String.format("""
                +%s+%s+%s+
                ""","-".repeat(cellwidth),"-".repeat(cellwidth),"-".repeat(cellwidth));

        // Function to generate a row with names
            sb.append(border);
            sb.append(String.format("""
                    |%-10s|%-10s|%-10s|
                    ""","",room1,""));
            sb.append(border);
            sb.append(String.format("""
                    |%-10s|%-10s|%-10s|
                    """,room2,this.roomName,room3));
            sb.append(border);
            sb.append(String.format("""
                    |%-10s|%-10s|%-10s|
                    ""","",room4,""));
            sb.append(border);
            System.out.println(sb.toString());
//        System.out.printf(String.format("""
//                ________________| %s |______________
//                                |                                |
//                 %s    |        %s       |         %s
//               _________________|________________________________|_____________
//                                | %s |
//                """,room1,room2,this.roomName,room3,room4);

        Item item = new Item();

        for (int i = 0; i < this.objects.size();i++) {
            item = this.objects.get(i);
            System.out.println((i+1)+".)"+item.getName());

        }
    }
}
