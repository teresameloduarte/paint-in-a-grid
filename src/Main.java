public class Main {

    public static void main(String[] args) {
        String playerName = "Teresa";

        Grid grid = new Grid();
        Player player = new Player(playerName, grid);
        new MyKeyboardHandler(player);
    }
}
