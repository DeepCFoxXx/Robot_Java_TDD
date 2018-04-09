import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestRobot {

    Grid grid;
    Robot robot1;
    Robot robot2;
    Robot robot3;
    Robot robot4;

    @Before
    public void setUp() {
        grid = new Grid(5,3);
        robot1 = new Robot("1 1 E", grid);
        robot2 = new Robot("1 1 E", grid);
        robot3 = new Robot("3 2 N", grid);
        robot4 = new Robot("0 3 W", grid);
    }

    @Test
    public void hasStartingPosition() {
        assertEquals("1 1 E", robot1.getPosition());
    }

    @Test
    public void changeOrientationLeftBecomesNorth() {
        robot1.changeOrientation('L');
        assertEquals("1 1 N", robot1.getPosition());
    }

    @Test
    public void changeOrientationRightBecomesSouth() {
        robot1.changeOrientation('R');
        assertEquals("1 1 S", robot1.getPosition());
    }

    @Test
    public void moveForwardsEast() {
        robot1.changeCoords('F');
        assertEquals("2 1 E", robot1.getPosition());
    }

    @Test
    public void turnAndMoveRightEastToSouth() {
        robot1.changeOrientation('R');
        robot1.changeCoords('F');
        assertEquals("1 0 S", robot1.getPosition());
    }

    @Test
    public void carryOutInstructions() {
        robot1.carryOutInstructions("RF");
        assertEquals("1 0 S",robot1.getPosition());
    }

    @Test
    public void carryOutInstructionsFullCircle() {
        robot1.carryOutInstructions("RFRFRFRF");
        assertEquals("1 1 E",robot1.getPosition());
    }

    @Test
    public void checkOnGridReturnsFalse() {
        robot1.carryOutInstructions("RFF");
        assertFalse(robot1.isOnGrid());
    }

    @Test
    public void checkOnGridReturnsTrue() {
        assertTrue(robot1.isOnGrid());
    }

    @Test
    public void positionLostIfMovesOffGridNegative() {
        robot1.carryOutInstructions("RFF");
        assertEquals("1 0 S LOST", robot1.getPosition());
    }

    @Test
    public void positionLostIfMovesOffGridPositive() {
        robot1.carryOutInstructions("FFFFF");
        assertEquals("5 1 E LOST", robot1.getPosition());
    }

}
