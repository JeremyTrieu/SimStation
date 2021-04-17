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
  public void populate() {
    for(int i = 0; i < 15; i++)
      addAgent(new Drunk());
  }
  public static void main(String[] args) {
    AppPanel panel = new SimulationPanel(new RandomFactory());
    panel.display();
  }
}
