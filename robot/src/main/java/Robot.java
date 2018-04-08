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

    public String getPosition() {
        if (this.lost) {
            this.reinstatePreviousCoords();
        }
        String pos = xPosition + " " + yPosition + " " + orientation;
        return this.lost ? pos + " LOST" : pos;
    }

    public void reinstatePreviousCoords() {
        this.xPosition = this.prevXposition;
        this.yPosition = this.prevYPosition;
    }

    public void changeOrientation(char direction) {
        if (direction == 'L') {
            this.turnLeft();
        } else if (direction == 'R') {
            this.turnRight();
        }
    }

    public void turnLeft() {
        switch (this.orientation) {
            case 'N':
                this.orientation = 'W';
                break;
            case 'E':
                this.orientation = 'N';
                break;
            case 'S':
                this.orientation = 'E';
                break;
            case 'W':
                this.orientation = 'S';
                break;
        }
    }

    public void turnRight() {
        switch (this.orientation) {
            case 'N':
                this.orientation = 'E';
                break;
            case 'E':
                this.orientation = 'S';
                break;
            case 'S':
                this.orientation = 'W';
                break;
            case 'W':
                this.orientation = 'N';
                break;
        }
    }

}
