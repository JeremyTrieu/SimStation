package randomWalk;
import mvc.*;
import simStation.*;

class RandomWalkFactory extends SimStationFactory {
  public Model makeModel() {
    return new RandomWalkSimulation();
  }

  public String getTitle() {
    return "Random walks";
  }
}

public class RandomWalkSimulation extends Simulation {
  public void populate() {
    for(int i = 0; i < 15; i++)
      agents.add(new Drunk(
          (int)(Math.random()*width),
          (int)(Math.random()*height),
          "" + hashCode(),
          Heading.random(),
          this
      ));
  }
  public static void main(String[] args) {
    AppPanel panel = new SimPanel(new RandomWalkFactory());
    panel.display();
  }
}
