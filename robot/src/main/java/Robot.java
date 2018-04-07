import java.util.HashMap;

public class Robot {

    private int xPosition;
    private int yPosition;
    private int prevXposition;
    private int prevYPosition;
    private char orientation;
    private Grid grid;
    private HashMap<Character, Integer[]> moves;
    boolean lost;

    public Robot(String initialPosition, Grid grid) {
        this.setupPosition(initialPosition);
        this.setUpMoves();
        this.grid = grid;
        this.lost = false;
    }

    private void setupPosition(String pos) {
        String[] positions = pos.split(" ");
        this.xPosition = Integer.parseInt(positions[0]);
        this.yPosition = Integer.parseInt(positions[1]);
        this.orientation = positions[2].charAt(0);
    }

    private void setUpMoves() {
        this.moves = new HashMap<>();
        Integer[] north = {0, 1};
        Integer[] east = {1, 0};
        Integer[] south = {0, -1};
        Integer[] west = {-1, 0};
        this.moves.put('N', north);
        this.moves.put('E', east);
        this.moves.put('S', south);
        this.moves.put('W', west);
    }

}
