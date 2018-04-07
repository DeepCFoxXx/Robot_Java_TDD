import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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

}
