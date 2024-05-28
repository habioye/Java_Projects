//package EscapeWizardLair;
// shows various ways to interact with the object.
public interface Interact {
    default void touch() {
        System.out.println("Doesn't seem like you can touch");
    }

    default void smell(){
        System.out.println("Doesn't seem like you can or should smell this item.");
    }

    default void taste() {
        System.out.println("Doesn't seem like you can taste this item");
    }

    default void listen() {
        System.out.println("Doesn't seem like you can listen to this item");
    }
    default void see() {
        System.out.println("Doesn't seem like you can taste this item");
    }
    default boolean challenge() {
        System.out.println("There is no challenge");
        return false;
    }




}