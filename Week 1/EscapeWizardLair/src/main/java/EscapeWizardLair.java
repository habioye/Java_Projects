import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class EscapeWizardLair {
    // generates assets used for game into the collection
    private static ArrayList<Room> generateAssets() {
//        ArrayList<Room> asset_collection = new ArrayList<>();
//        String see, String smell, String taste, String listen, String touch, String challenge, String answer
        ArrayList<Room> rooms = new ArrayList<>();
        String see = "A cozy, neatly made bed with fluffy pillows.";
        String smell = "The clean scent of freshly laundered sheets.";
        String taste = "Not typically associated with taste.";
        String listen = "The soft rustling of sheets as you lie down.";
        String touch = "The soft, comfortable feel of the mattress and blankets.";
        String challenge = "I provide rest for the weary, and dreams for the sleepy. What am I?";
        String answer = "A bed.";
        String name = "Bed";

        Item bed = new Item(see,smell,taste,listen,touch,challenge,answer,name);
        name = "Mirror";
        see = "A reflective surface that shows your own reflection.";
        smell = "No distinct smell.";
        taste = "Not typically associated with taste.";
        listen = "No sound.";
        touch = "A smooth, hard surface.";
        challenge = "I reflect your image, but I'm not you. What am I?";
        answer = "Reflection";
        Item mirror = new Item(see,smell,taste,listen,touch,challenge,answer,name);
        name = "Cabinet";
        see = "A piece of furniture with shelves, drawers, or compartments for storing or displaying items.";
        smell = "No distinct smell.";
        taste = "Not typically associated with taste.";
        listen = "No sound.";
        touch = "Wooden, metal, or plastic construction with various textures.";
        challenge = "I have doors but no windows. Inside, you'll find things in rows. What am I?";
        answer = "A cabinet";

        Item cabinet = new Item(see,smell,taste,listen,touch,challenge,answer,name);
        String description = """
                You enter a dimly lit bedroom in the wizard's lair. A grand bed draped in 
                velvet stands against one wall, while a towering mirror reflects your every 
                move. Nearby, a sturdy cabinet, adorned with intricate carvings, holds secrets 
                within its closed doors. The air crackles with magic, hinting at the mysteries that lie 
                within this enchanted chamber.
                """;
        Room bedroom = new Room("bedroom",description);
        bedroom.objects.add(bed);
        bedroom.objects.add(mirror);
        bedroom.objects.add(cabinet);

        name = "Table";
        see = "A flat surface supported by legs, used for eating, working, or placing things on.";
        smell = "No distinct smell.";
        taste = "Not typically associated with taste.";
        listen = "No sound.";
        touch = "Smooth or textured surface, depending on the material.";
        challenge = "I have legs but cannot walk, a flat surface but cannot talk. What am I?";
        answer = "Table";
        Item table = new Item(see,smell,taste,listen,touch,challenge,answer,name);
        name = "Chair";
        see = "A piece of furniture with a raised surface supported by legs, used for sitting.";
        smell = "No distinct smell.";
        taste = "Not typically associated with taste.";
        listen = "No sound.";
        touch = "Seat may be cushioned or firm, with a backrest for support.";
        challenge = "I have legs but cannot walk, and a back but no arms. What am I?";
        answer = "Chair";

        Item chair = new Item(see,smell,taste,listen,touch,challenge,answer,name);
        name = "Carpet";
        see = "A mysterious rug lying on the dungeon floor, its intricate patterns hinting at ancient magic.";
        smell = "Faint traces of damp earth and mildew waft from the depths of the dungeon.";
        taste = "Not typically associated with taste, but the air carries a metallic tang of ancient secrets.";
        listen = "Soft footsteps echo through the dungeon chamber, muffled by the thick weave of the carpet.";
        touch = "Run your fingers over the plush fibers, feeling the comforting warmth it offers in the cold dungeon.";
        challenge = "I cover the stone floor, a soft path through the darkness. What am I?";
        answer = "Carpet";
        Item carpet = new Item(see,smell,taste,listen,touch,challenge,answer,name);
        description = """
                You step into the living room, aglow with mystic light. A sturdy table, etched with arcane 
                symbols, holds an ancient tome. A plush chair awaits, its velvet cushions whispering of magic. 
                Beneath, a luxurious carpet pulses with arcane energy. Despite the tranquility, a sense of being 
                watched lingers, the room alive with hidden enchantments.          
                                
                """;
        Room livingroom = new Room("livingroom",description);
        livingroom.objects.add(table);
        livingroom.objects.add(chair);
        livingroom.objects.add(carpet);

        name = "Boxes";
        see = "A collection of dusty crates scattered throughout the dungeon, their contents shrouded in mystery.";
        smell = "The musty aroma of old wood and ancient treasures fills the air around the boxes.";
        taste = "Not typically associated with taste, but the air carries hints of the metallic tang of hidden treasures.";
        listen = "Faint creaks and groans emanate from the wooden crates as they settle in their forgotten corners.";
        touch = "Reach out and run your fingers over the rough, weathered surfaces of the crates, feeling the weight of untold stories within.";
        challenge = "I hold secrets untold, treasures of old. What am I?";
        answer = "Boxes";
        Item boxes = new Item(see,smell,taste,listen,touch,challenge,answer,name);
        name = "Lamp";
        see = "A flickering oil lamp hanging from a rusty chain, casting eerie shadows on the dungeon walls.";
        smell = "The faint scent of burning oil mingles with the dank air of the dungeon.";
        taste = "Not typically associated with taste, but the air carries a faint metallic tang.";
        listen = "The soft hiss of the burning oil mixes with the distant echoes of creatures lurking in the darkness.";
        touch = "Gently touch the warm, metal surface of the lamp, feeling the comforting glow it emits in the gloomy dungeon.";
        challenge = "I cast light in the dark, dispelling shadows with my spark. What am I?";
        answer = "Lamp";

        Item Lamp = new Item(see,smell,taste,listen,touch,challenge,answer,name);
        name = "Chest";
        see = "A sturdy wooden chest, adorned with ornate carvings and secured with a heavy padlock.";
        smell = "The faint scent of aged wood and ancient secrets emanates from the chest.";
        taste = "Not typically associated with taste, but the air carries a metallic tang of hidden treasures.";
        listen = "Faint clicks and clinks can be heard from within the chest as you approach.";
        touch = "Run your hand over the rough, weathered surface of the chest, feeling the weight of untold riches hidden within.";
        challenge = "I guard treasures of old, my secrets waiting to be told. What am I?";
        answer = "Chest";

        Item Chest = new Item(see,smell,taste,listen,touch,challenge,answer,name);
        name = "Basement";
        see = "A dimly lit chamber hidden beneath the surface, its stone walls echoing with the whispers of forgotten secrets.";
        smell = "The musty scent of damp earth and decay fills the air, mingling with the faint aroma of ancient magic.";
        taste = "Not typically associated with taste, but the air carries hints of the metallic tang of hidden treasures.";
        listen = "The soft drip of water echoes through the chamber, accompanied by the occasional scurrying of unseen creatures.";
        touch = "Run your hand along the cold, rough surface of the stone walls, feeling the weight of centuries of history pressing in.";
        challenge = "I lie beneath the world above, a hidden realm where secrets rove. What am I?";
        answer = "Basement";
        description = """
                You descend into the dimly lit basement of the wizard's lair, where shadows dance eerily across the 
                stone walls. Stacks of dusty boxes line the walls, their contents obscured by the darkness.
                                
                In one corner, an ancient lamp flickers softly, casting a warm glow that barely penetrates the gloom. 
                Its light reveals a weathered chest, its lid closed tight as if guarding long-forgotten treasures.
                                
                As you navigate the labyrinth of crates and cobwebs, the air grows heavy with the scent of age and 
                mystery. You can't help but feel a sense of anticipation, as if the secrets of the wizard's lair are 
                hidden within the very walls of this dimly lit chamber.
                """;
        Room basement = new Room("basement",description);
        basement.objects.add(boxes);
        basement.objects.add(Lamp);
        basement.objects.add(Chest);

        description = """
                You step outside the wizard's lair, greeted by a world bathed in the soft light of the moon and stars. 
                The cool night air carries with it the scent of dewy grass and distant forests, a welcome respite from 
                the confines of the underground passages.
                As you look around, you see the looming silhouette of the wizard's tower against the night sky, its 
                spires reaching towards the heavens like fingers grasping at the stars. The sound of crickets chirping 
                fills the air, punctuated by the occasional hoot of an owl in the nearby woods.
                In the distance, you catch a glimpse of winding paths leading into the darkness of the surrounding
                forest, beckoning you to explore further. But for now, you revel in the freedom of the open air, 
                knowing that adventure awaits beyond the walls of the wizard's lair.
                """;
        Room outside = new Room("outside",description);
        name = "Scroll";
        see = "A weathered parchment adorned with mystical symbols and arcane writings, rolled and sealed with wax.";
        smell = "The faint scent of ancient ink and parchment fills the air, carrying whispers of forgotten spells.";
        taste = "Not typically associated with taste, but the air carries hints of the metallic tang of hidden magic.";
        listen = "No sound, but the air around the scroll seems to hum with latent magical energy.";
        touch = "Gently run your fingers over the delicate parchment, feeling the smooth texture of the surface and the weight of ancient knowledge within.";
        challenge = "I hold secrets untold, wisdom of old. What am I?";
        answer = "Scroll";
        Item scroll = new Item(see,smell,taste,listen,touch,challenge,answer,name);
        name = "Hat";
        see = "A worn, tattered hat with a wide brim, its fabric faded from years of travel and adventure.";
        smell = "The faint scent of leather and sweat lingers on the hat, a testament to its long journey.";
        taste = "Not typically associated with taste, but the air carries hints of the dust of distant lands.";
        listen = "No sound, but the hat seems to whisper tales of far-off places and daring deeds.";
        touch = "Run your fingers over the rough, weathered fabric of the hat, feeling the weight of countless adventures woven into its fibers.";
        challenge = "I travel far and wide, atop heads with pride. What am I?";
        answer = "Hat";
        Item hat = new Item(see,smell,taste,listen,touch,challenge,answer,name);
        name = "Boulder";
        see = "A massive stone monolith, blocking the passage with its imposing presence.";
        smell = "The scent of damp earth and moss clings to the boulder, hinting at its long years in the dungeon.";
        taste = "Not typically associated with taste, but the air carries hints of the mineral-rich soil from which the boulder was formed.";
        listen = "No sound, but the boulder seems to echo with the weight of centuries resting upon it.";
        touch = "Run your hand along the rough, uneven surface of the boulder, feeling the cool solidity of the stone beneath your fingertips.";
        challenge = "I stand in your path, a barrier of stone. What am I?";
        answer = "Boulder";
        Item Bolder = new Item(see,smell,taste,listen,touch,challenge,answer,name);
        description = """
                You awaken in the dimly lit cave, your senses slowly adjusting to the darkness that surrounds you. 
                The air is cool and damp, carrying with it the scent of earth and stone. As you sit up, you take in 
                your surroundings, the rocky walls of the cavern stretching into the shadows above.
                                
                With a groan, you push yourself to your feet, the memory of how you came to be here still fuzzy in 
                your mind. As you stumble forward, you notice a faint glimmer of light up ahead, drawing you deeper 
                into the labyrinthine passages of the cave.
                                
                With each step, the air grows colder, and the silence of the cave presses in on you like a weight. 
                You can't shake the feeling of being watched, the shadows seeming to shift and dance as if alive.
                                
                But despite the sense of unease, you press on, driven by a sense of curiosity and the hope of 
                finding a way out of this dark and mysterious place.
                                
                                
                                
                                
                                
                                
                                
                """;
        Room cave = new Room("cave",description);
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

    // Game logic
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
        Room current = assets.getFirst();
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
