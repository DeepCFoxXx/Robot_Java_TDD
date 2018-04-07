public class Grid {

    private int x;
    private int y;
    private char[][] squares;

    public Grid(int x, int y) {
        this.x = x;
        this.y = y;
        this.squares = new char[x+1][y+1];
    }


    public char[][] getSquares() {
        return this.squares;
    }

    public boolean hasWarningScent(int x, int y) {
        return (this.squares[x][y] == 'x');
    }

}
