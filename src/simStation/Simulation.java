package simStation;
import java.util.*;
import mvc.*;


public class Simulation extends Model
{
    protected int width=1000;
    protected int height=1000;
    private Timer timer;
    int clock;
    protected List<Agent> agents;
    public Simulation() {
        clock = 0;
        agents = new LinkedList<Agent>();
    }

    private void startTimer() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new ClockUpdater(), 10, 10);
    }

    private void stopTimer() {
        timer.cancel();
        timer.purge();
    }

    public int getClock() {
        return clock;
    }

    public List<Agent> getAgents() {
        return agents;
    }

    private class ClockUpdater extends TimerTask {
        public void run() {
            clock++;
            changed();
        }
    }


    public void start() {
        populate();
        startTimer();
        for( Agent a : agents ) {
            a.start();
        }
    }
    public void suspend() {
        stopTimer();
        for( Agent a : agents ) {
            a.suspend();
        }
    }
    public void resume() {
        startTimer();
        for(Agent a : agents) {
            a.resume();
        }
    }
    public void stop() {
        stopTimer();
        for(Agent a : agents) {
            a.stop();
        }
    }
    public Agent getNeighbor(Agent a, int range) {
        Agent flagAgent;
        ArrayList<Agent> inRange = new ArrayList<Agent>();
        int ay = a.getY();
        int ax = a.getX();
        double dist = Math.sqrt((ay - agents.get(0).getY())*(ay - agents.get(0).getY()) +(ax - agents.get(0).getX())*(ax - agents.get(0).getX()));
        for (int i = 0; i < agents.size(); i++) {
            int iay =  agents.get(i).getY();
            int iax =  agents.get(i).getX();
            double newDist = Math.sqrt(Math.pow(ay - iay, 2) + Math.pow(ax - iax, 2));
            if ( newDist < dist && agents.get(i)!=a ) {
                dist = newDist;
                inRange.add(agents.get(i));
            }
        }
        if (inRange.isEmpty())
            flagAgent = agents.get((int)(Math.random()*(agents.size()-1)));
        else
            flagAgent = inRange.get((int)(Math.random()*(inRange.size()-1)));
        return flagAgent;
    }
    public void populate() {

    }
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}