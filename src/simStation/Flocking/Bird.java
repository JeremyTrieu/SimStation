package Mocking;
import mvc.Utilities;
import simulation.*;
import java.util.*;

public class Bird extends Agent {
  protected int speed;
  public Bird() {
    super();
    heading = Heading.random();
    Random random = new Random();
    speed = random.nextInt(5);
  }
  public int getSpeed() {
    return speed;
  }
  public void setSpeed(int speed) {
    this.speed = speed;
  }
  public void update() {
    Bird neighbor = (Bird) this.world.getNeighbor(this,10);
    this.setDirection(neighbor.getDirection());
    this.setSpeed(neighbor.getSpeed());
    int steps = this.getSpeed();
    move(steps);
  }

}
