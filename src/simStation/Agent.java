package simStation;

import static java.lang.Thread.sleep;

public class Agent implements Runnable {
    protected int x;
    protected int y;
    boolean stopped = false;
    boolean suspend = false;
    String name;
    protected Simulation world;
    protected Heading heading;
    Thread thread;
    public Agent(int x, int y, String name, Heading heading, Simulation sim) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.heading = heading;
        this.world = sim;
    }

    @Override
    public void run() {
        thread = Thread.currentThread();
        while ( !stopped ) {
            try {
                if(suspend)
                    wait();
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            update();
        }
    }

    public void start() {
        thread.start();
    }

    public void suspend() {
        suspend = true;
    }

    public void resume() {
        suspend = false;
        notify();
    }

    public void stop() {
        stopped = true;
    }

    protected void update() {    }

    public void move(int steps) {
        int[] diff = Heading.diff(heading);
        this.x += diff[0] * steps;
        this.y += diff[1] * steps;
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

    public void setHeading(Heading heading) {
        this.heading = heading;
    }

    public String getName() {
        return name;
    }
}
