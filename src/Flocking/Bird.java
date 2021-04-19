package Flocking;
import mvc.Utilities;
import simStation.*;
import java.util.*;

public class Bird extends Agent {
    protected int speed;
    public Bird(int x, int y, String name, Heading heading, Simulation sim, int speed) {
        super(x, y, name, heading, sim);
        this.speed = speed;
    }
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public void update() {
        Bird neighbor = (Bird) this.world.getNeighbor(this,10);
        this.setHeading(neighbor.getHeading());
        this.setSpeed(neighbor.getSpeed());
        int steps = this.getSpeed();
        move(steps);
    }

}
