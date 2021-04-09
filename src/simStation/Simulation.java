package simStation;
import java.util.*;
import mvc.*;


public class Simulation extends Model {
  private Timer timer;
  int clock;
  List<Agent> agents;
  public Simulation() {
    clock = 0;
    agents = new ArrayList<Agent>();
  }

  private void startTimer() {
	 timer = new Timer();
     timer.scheduleAtFixedRate(new ClockUpdater(), 1000, 1000);
  }

  private void stopTimer() {
	  timer.cancel();
	  timer.purge();
  }

    public int getClock() {
      return clock;
    }

    private class ClockUpdater extends TimerTask {
   public void run() {
     clock++;
     //changed();
   }
 }


  public void start() {
    for(int i = 0; i < agents.size(); i++) {
        agents.get(i).start();
     }
  }
  public void suspend() {
    for(int i = 0; i < agents.size(); i++) {
        agents.get(i).suspend();
     }
  }
  public void resume() {
    for(int i = 0; i < agents.size(); i++) {
        agents.get(i).resume();
    }
  }
  public void stop() {
    for(int i = 0; i < agents.size(); i++) {
        agents.get(i).stop();
    }
  }
  public Agent getNeighbor(Agent a) {
    Agent flagAgent = null;
    int ay = a.getY();
    int ax = a.getX();
    double dist = Math.sqrt((ay - agents.get(0).getY())*(ay - agents.get(0).getY()) +(ax - agents.get(0).getX())*(ax - agents.get(0).getX()));
    for (int i = 0; i < agents.size(); i++) {   
      int iay =  agents.get(i).getY();
      int iax =  agents.get(i).getX();
      double newDist = Math.sqrt(Math.pow(ay - iay, 2) + Math.pow(ax - iax, 2));
      if ( newDist < dist && agents.get(i)!=a ) {
        dist = newDist;
        flagAgent = agents.get(i);
      }
    }
    return flagAgent;
  }

    public List<Agent> getAgents() {
        return agents;
    }

    public void populate() {

  }
}
