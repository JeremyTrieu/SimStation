package simStation;

import static java.lang.Thread.sleep;

public class Agent implements Runnable {
    protected int x;
    protected int y;
    boolean stopped=false;
    boolean suspended=false;
    String name;
    protected Simulation sim;
    protected Heading heading;
    Thread myThread;
    public Agent(int x, int y, String name, Heading heading, Simulation sim) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.heading = heading;
        this.sim = sim;
    }

    @Override
    public void run() {
        while ( !stopped ) {
            try {
                if( suspended )
                    wait();
                update();
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void start() {
        myThread = new Thread(this);
        myThread.start();
    }

    public void suspend() {
        suspended = true;
    }

    public void resume() {
        suspended = false;
        notify();
    }

    public void stop() {
        stopped = true;
    }

    protected void update() {

    }

    protected void move(int steps) {
        x += (int)(steps * heading.getXPart());
        y += (int)(steps * heading.getYPart());
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public Heading getHeading() {
        return heading;
    }
}
