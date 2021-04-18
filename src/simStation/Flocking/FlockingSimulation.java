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
      List<String> temp = new LinkedList<String>();
      for (int i = 0; i < this.getAgents.size(); i++) {
          if map.containsKey(this.getAgents.get(i).getSpeed()) {
            map.get(i) += 1;
          }
          else {
            map.put(this.getAgents.get(i).getSpeed(), 1);
          }
      }
      for (Map.Entry<Integer, Integer> e : map.entrySet()) {
        temp.add("#birds @ speed " + e.getKey() + " = " + e.getValue());
      }
      String[] stats = new String[temp.size()];
      for (int i = 0; i < stats.length; i++) {
        stats[i] = temp.get(i) + "\n";
      }
      return stats;
    }
  }
}
