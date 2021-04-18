package simStation;
import java.util.*;
import mvc.*;


public class Simulation extends Model {
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
            try {
                a.thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        agents = new LinkedList<Agent>();
        changed();
    }
    public void stats() {
        Utilities.inform("#agents = " + getAgents().size()
            + "\nclock = " + getClock());
    }
    // return a neighbour agent in range; return a random neighbour if no agent is in range
    public Agent getNeighbor(Agent a1, int range) {
        Agent flagAgent;
        ArrayList<Agent> inRange = new ArrayList<Agent>();
        for (Agent a2: agents) {
            double newDist = dist(a1, a2);
            if ( newDist < range && a2!=a1 ) {
                inRange.add(a2);
            }
        }
        if (inRange.isEmpty())
            flagAgent = agents.get((int)(Math.random()*(agents.size()-1)));
        else
            flagAgent = inRange.get((int)(Math.random()*(inRange.size()-1)));
        return flagAgent;
    }
    public static double dist(Agent a1, Agent a2) {
        return Math.sqrt(
            Math.pow(a1.getX() - a2.getX(), 2) + Math.pow(a1.getY() - a2.getY(), 2));
    }
    public void populate() {

    }
}

