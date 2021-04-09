package simStation;

public class Agent implements Runnable {
    private Thread thread;
    boolean stopped = false;
    public Agent() {

    }
    @Override
    public void run() {
        thread = Thread.currentThread();
        while(!stopped) {

        }
    }
    public void stop() {
        stopped = true;
    }
}
