package randomWalk;
import mvc.Utilities;
import simulation.*;

public class Drunk extends Agent {
  public Drunk() {
    super();
    heading = Heading.random();
  }

  public void update() {
    heading = Heading.random();
    int steps = Utilities.rng.nextInt(10) + 1;
    move(steps);
  }
}
