package simulation;
import java.util.*;
import mvc.*;
public class Simulation extends Model {
  private Timer timer;
  int clock;
  List<Agent> agents;
  public Simulation() {
    clock = 0;
    agents = new List<Agent>();
  }

  private void startTimer() {
	   timer = new Timer();
     timer.scheduleAtFixedRate(new ClockUpdater(), 1000, 1000);
  }

  private void stopTimer() {
	  timer.cancel();
	  timer.purge();
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
        agents.get(i).resume();
     }
  }
  public Agent getNeighbor(Agent a) {
    Agent flagAgent;
    double dist = sqrt((a.getY() - agents.get(0).getY())*(a.getY() - agents.get(0).getY()) +(a.getX() - agents.get(0).getX())*(a.getX() - agents.get(0).getX()));
    for (int i = 0; i < agents.size(); i++) {
      if ((sqrt((a.getY() - agents.get(i).getY())*(a.getY() - agents.get(i).getY()) +(a.getX() - agents.get(i).getX())*(a.getX() - agents.get(i).getX())) < dist)
      && (sqrt((a.getY() - agents.get(i).getY())*(a.getY() - agents.get(i).getY()) +(a.getX() - agents.get(i).getX())*(a.getX() - agents.get(i).getX())) > 0)) {
        dist = sqrt((a.getY() - agents.get(i).getY())*(a.getY() - agents.get(i).getY()) +(a.getX() - agents.get(i).getX())*(a.getX() - agents.get(i).getX()));
        flagAgent = agents.get(i);
      }
    }
    return flagAgent;
  }
  public void populate() {

  }
}
