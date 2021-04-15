import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.*;

import simStation.Heading;


public class SimTests {
    @Test
    public void basicTest() {
        simStation.Heading h = simStation.Heading.parse("south");
        assertEquals(simStation.Heading.SOUTH, h);
        assertEquals(simStation.Heading.EAST, "east");
    }
}