package Flocking;
import mvc.*;
import simStation.*;
import java.util.*;

public class FlockingSimulation extends Simulation {
  public void populate() {
    int newSpeed = Utilities.rng.nextInt(5);
    for (int i = 0; i < 15; i++) {
      agents.add(new Bird(
              (int) (Math.random() * AppPanel.FRAME_WIDTH),
              (int) (Math.random() * AppPanel.FRAME_HEIGHT),
              "" + hashCode(),
              Heading.random(),
              this, newSpeed));
    }

  }
    public void stats() {
    String temp = new String("");
      for (int i = 0; i < getStats().length;i++) {
        temp += getStats()[i];
      }
      Utilities.inform(temp);
    }
    public String[] getStats() {
      HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
      map.put(1, 0);
      List<String> temp = new LinkedList<String>();
      for (int i = 0; i < agents.size(); i++) {
          Integer tempKey = ((Bird)(agents.get(i))).getSpeed();
          if (map.containsKey(tempKey)) {
            map.put(tempKey, map.get(tempKey) + 1);
          }
          else {
            map.put(tempKey, 1);
          }
      }
      for (Map.Entry<Integer, Integer> e : map.entrySet()) {
        temp.add("#birds @ speed " + e.getKey() + " = " + e.getValue() + "\n");
      }
      String[] tempStats = new String[temp.size()];
      tempStats[0] ="";
      for (int i = 0; i < tempStats.length; i++) {
        tempStats[i] = temp.get(i);
      }
      return tempStats;
    }
  public static void main(String[] args) {
    AppPanel panel = new SimPanel(new FlockingkFactory());
    panel.display();
  }
}
