package randomWalk;
import mvc.Utilities;
import simStation.Agent;
import simStation.Heading;
import simStation.Simulation;

public class Drunk extends Agent {
  public Drunk(int x, int y, String name, Heading heading, Simulation sim) {
    super(x, y, name, heading, sim);
  }

  public void update() {
    heading = Heading.random();
    int steps = Utilities.rng.nextInt(10) + 1;
    move(steps);
  }
}
