/**
 * The Adventurer class create a character in a fantasy adventure game.
 * This class implements the Contract interface, allowing the character to
 * perform actions in Contract.java.
 */
public class Adventurer implements Contract {
    
    private String currentItem; // Item currently held by the Adventurer
    private int x, y; // Adventurer's current position
    private int size; // Adventurer's current size (1 as defult)
    private String lastAction; // Last action performed for undo functionality
    
    /**
     * Constructs an Adventurer starting at position (0,0) with normal size.
     */
    public Adventurer() {
        this.x = 0;
        this.y = 0;
        this.size = 1; // normal size
        this.lastAction = "";
    }

    /**
     * Grabs an item and stores it as the current item.
     * @param item the item to grab
     */
    public void grab(String item) {
        currentItem = item;
        lastAction = "grabbed " + item;
        System.out.println("You grabbed a " + item + "!");
    }

    /**
     * Drops the currently held item, if any.
     * @param item the item to drop
     * @return a message about the dropped item
     */
    public String drop(String item) {
        if (currentItem != null && currentItem.equals(item)) {
            String droppedItem = currentItem;
            currentItem = null;
            lastAction = "dropped " + item;
            System.out.println("You dropped the " + item + ".");
            return "Dropped " + droppedItem;
        } else {
            return "You don't have a " + item + " to drop.";
        }
    }

    /**
     * Examines the specified item to get a description.
     * @param item the item to examine
     */
    public void examine(String item) {
        System.out.println("Examining the " + item + ". It looks interesting!");
        lastAction = "examined " + item;
    }

    /**
     * Uses the specified item.
     * @param item the item to use
     */
    public void use(String item) {
        System.out.println("You use the " + item + " with great effect!");
        lastAction = "used " + item;
    }

    /**
     * Walks in the specified direction if possible.
     * @param direction the direction to walk (e.g., "north", "south")
     * @return true if walking was successful, false if the direction is invalid
     */
    public boolean walk(String direction) {
        if (direction.equalsIgnoreCase("north")) {
            y = y+1;
        } else if (direction.equalsIgnoreCase("south")) {
            y = y-1;
        } else if (direction.equalsIgnoreCase("west")) {
            x = x-1;
        } else if (direction.equalsIgnoreCase("east")) {
            x = x+1;
        }
        else {
            System.out.println("Unknown direction: " + direction);
            return false;
        }
        
        lastAction = "walked " + direction;
        System.out.println("You walk " + direction + ". Your new position is (x: " + x + ", y: " + y + ").");
        return true;
    }

    /**
     * Flies to the specified coordinates.
     * @param x the x-coordinate to fly to
     * @param y the y-coordinate to fly to
     * @return true if the flight was successful, false if it was not allowed
     */
    public boolean fly(int x, int y) {
        this.x = x;
        this.y = y;
        lastAction = "flew to (" + x + ", " + y + ")";
        System.out.println("You soar through the sky to position (" + x + ", " + y + ").");
        return true;
    }

    /**
     * Shrinks the adventurer, decreasing the size by 1.
     * @return the new size after shrinking
     */
    public Number shrink() {
        size = Math.max(1, size - 1);
        lastAction = "shrank";
        System.out.println("You shrink down to size " + size + ".");
        return size;
    }

    /**
     * Grows the adventurer, increasing the size by 1.
     * @return the new size after growing
     */
    public Number grow() {
        size = size + 1;
        lastAction = "grew";
        System.out.println("You grow to size " + size + "!");
        return size;
    }

    /**
     * Rests, allowing the adventurer to regain stamina or recover.
     */
    public void rest() {
        lastAction = "rested";
        System.out.println("You take a moment to rest and recover.");
    }

    /**
     * Undoes the last action, if possible.
     */
    public void undo() {
        System.out.println("Undoing the last action: " + lastAction);
        lastAction = "undone";
    }
}

