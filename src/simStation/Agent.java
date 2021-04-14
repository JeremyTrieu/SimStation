package simulation;
import java.util.*;
public class Agent extends Bean implements Runnable, Serializable {
  protected Simulation world;
  protected String name;
  protected Heading heading;
  protected int xc;
  protected int yc;
  protected AgentState state;
  protected Thread thread;
  protected boolean stopped;
  protected boolean suspend;


  public Agent(String name, Heading heading, int xc, int yc, Simulation world) {
    this.name = name;
    this.heading = heading;
    this.xc = xc;
    this.yc = yc;
    this.state = AgentState.READY;
    this.thread = null;
    this.world = world;
    this.stopped = false;
    this.suspend = false;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getName() {
    return name;
  }
  public void setXCoor(int xc) {
    this.xc = xc;
  }
  public void getXCoor() {
    return xc;
  }
  public void setYCoor(int yc) {
    this.yc = yc;
  }
  public void getYCoor() {
    return yc;
  }

  public void setHeading(Heading heading) {
    this.heading = heading;
  }

  public synchronized void start() {
    this.state = AgentState.READY;
  }

  public void run(){
    if(this.state == AgentState.READY){
        this.state = AgentState.RUNNING;
    }
    thread = Thread.currentThread();
    while(this.state != AgentState.STOPPED){
        update();
        cooperate();
        checkSuspended();
    }
  }

  public synchronized void suspend() {
    this.suspend = true;
  }
  public synchronized boolean checkSuspend() {
    return this.suspend;
  }
  public synchronized void checkSuspended() {
       try {
           while(!checkStop() && checkSuspend()) {
               wait();
               //this.state = AgentState.SUSPEND;
               this.suspend = false;
           }
       } catch (InterruptedException e) {
           System.out.println(e);
       }
   }
  public synchronized void resume() {
    notify();
  }

  public synchronized void stop() {
  this.stopped = true;
  }
  public synchronized boolean checkStop() {
    return this.stopped;
  }

  public abstract void update() {
    //this.state = state;
  }

  public void run(){
    thread = Thread.currentThread();
    while (!checkStop()) {
        try {
            update();
            Thread.sleep(2000);
            checkSuspended();
        }
        catch(InterruptedException e) {
            System.err.println(e);
        }
    }
  }

    public synchronized void join() throws InterruptedException {
        try{
            if (thread != null) thread.join();
        }
        catch(InterruptedException e){
            System.out.println(e);
        }
    }

    public double distance(Agent a){
         return Math.sqrt(Math.pow((this.getXCoor()- a.getXCoor()), 2) + Math.pow((this.getYCoor()- a.getYCoor()), 2));
     }

  public void move(int steps) {
    while(steps > 0){
      if(this.headTo == Heading.SOUTH){
        if(getYCoor() == world.SIZE){
            this.yc = 0;
        }
        this.yc ++;
      }
      else if(this.headTo == Heading.NORTH){
        if(getYCoor() == 0){
          this.yc = world.SIZE;
        }
        this.yc --;
      }
      else if(this.headTo == Heading.WEST){
        if(getXCoor() == 0){
            this.xc = world.SIZE;
        }
        this.xc --;
      }
      else if(this.headTo == Heading.EAST){
        if(getXCoor() == world.SIZE){
            this.xc = 0;
        }
        this.xc ++;
      }
      steps--;
      this.world.changed();
    }
  }
}
