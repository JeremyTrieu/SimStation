package Flocking;
import mvc.*;
import simStation.*;
import java.util.*;

class FlockingkFactory extends SimulationFactory {
  public Model makeModel() {
    return new FlockingSimulation();
  }

  public String getTitle() {
    return "Flocking";
  }
}

public class FlockingSimulation extends Simulation {
  public void populate() {
    for (int i = 0; i < 15; i++) {
      addAgent(new Bird());
    }
    public String[] getStats() {
      HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

      map.put(1, 0);
      map.put(2, 0);
      map.put(3, 0);
      map.put(4, 0);

      Iterator hmIterator = map.entrySet().iterator();
      List<String> temp = new LinkedList<String>();
      for (int i = 0; i < this.getAgents.size(); i++) {
          if (!this.getAgents.get(i).isStopped()) {
            while (hmIterator.hasNext()) {
              
            }
          }
      }
      String[] stats =
    }
  }
}
