package Flocking;
import mvc.*;
import simStation.*;
import java.util.*;

public class FlockingSimulation extends Simulation {
  public static int MAXSPEED = 5;

  public void populate() {
    int newSpeed = Utilities.rng.nextInt(MAXSPEED);
    for (int i = 0; i < 100; i++) {
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
      for (int i = 1; i < MAXSPEED + 1; i++)
      {
        int num = 0;
        if (map.get(i) != null)
        {
            num = map.get(i);
        }
        temp.add("#birds @ speed " + i + " = " + num + "\n");
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
