package simStation;

public class Agent implements Runnable {
    int x;
    int y;
    boolean stopped=false;
    boolean suspended=false;
    String name;
    Heading heading;
    Thread myThread;
    public Agent(int x, int y, String name, Heading heading) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.heading = heading;
    }

    @Override
    public void run() {
        while ( !stopped ) {
            if( suspended ) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            update();
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
    }

    public void stop() {
        stopped = true;
    }

    private void update() {}

    private void move(int steps) {
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
