package randomWalk;
import mvc.*;
import simStation.*;

class RandomWalkFactory extends SimulationFactory {
  public Model makeModel() {
    return new RandomWalkSimulation();
  }

  public String getTitle() {
    return "Random walks";
  }
}

public class RandomWalkSimulation extends Simulation {
  AppPanel panel = new SimulationPanel(new RandomFactory());
  panel.display();
}
