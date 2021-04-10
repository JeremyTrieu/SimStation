package simStation;

public class Agent implements Runnable {
    int x;
    int y;
    String name;
    Heading heading;
    AppState state;
    public Agent(int x, int y, String name, Heading heading) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.heading = heading;
        this.state = AppState.READY;
    }

    @Override
    public void run() {
    }

    public void start() {
        this.state = AppState.RUNNING;
    }

    public void suspend() {
        this.state = AppState.SUSPENDED;
    }

    public void resume() {
        this.state = AppState.RUNNING;
    }

    public void stop() {
        this.state = AppState.STOPPED;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}
