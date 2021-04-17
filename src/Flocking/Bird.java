package Flocking;
import mvc.Utilities;
import simStation.Agent;
import simStation.Heading;
import simStation.Simulation;


public class Bird extends Agent {
  protected int speed;
  public Bird(int x, int y, String name, Heading heading, Simulation sim) {
    super(x, y, name, heading, sim);
    speed = Utilities.rng.nextInt(5);
  }
  public int getSpeed() {
    return speed;
  }
  public void setSpeed(int speed) {
    this.speed = speed;
  }
  public void update() {
    Bird neighbor = (Bird) this.world.getNeighbor(this,10);
//    this.setDirection(neighbor.getDirection());
    heading = Heading.random();
    this.setSpeed(neighbor.getSpeed());
    int steps = this.getSpeed();
    move(steps);
  }

}
