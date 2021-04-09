package simStation;

public class Agent implements Runnable {
    int x;
    int y;
    String name;
    Heading heading;
    public Agent(int x, int y, String name, Heading heading) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.heading = heading;
    }

    @Override
    public void run() {

    }

    public void start() {
    }

    public void suspend() {
    }

    public void resume() {
    }

    public void stop() {
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}
