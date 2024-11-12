public interface Contract {

    void grab(String item);
    String drop(String item);
    void examine(String item);
    void use(String item);
    boolean walk(String direction);
    boolean fly(int x, int y);
    Number shrink();
    Number grow();
    void rest();
    void undo();

}

class Main {
    public static void main(String[] args) {
        Adventurer Jordan = new Adventurer();
        Jordan.fly(8,9);
    }
}
