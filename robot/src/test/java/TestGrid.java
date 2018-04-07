import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestGrid {


    Grid grid;

    @Before
    public void setUp() {
        grid = new Grid(5,3);
    }

    @Test
    public void gridXSetUp() {
        assertEquals(6, grid.getSquares().length);
    }

}
