package Boids;

import simStation.Agent;
import simStation.Heading;
import simStation.Simulation;

public class Boid extends Agent {
    double x, y;  // so that speed < 1.0 doesn't get lost
    double speed=3;
    public Boid(int x, int y, String name, Heading heading, Simulation sim) {
        super(x, y, name, heading, sim);
        this.x = x;
        this.y = y;
    }

    protected void update() {
        Boid n = (Boid)sim.getNeighbor(this, 50);
        heading.updateAngle(0.0005 * heading.getDiff(n.getHeading().getAngle()));
        move(speed);
    }

    protected void move(double steps) {
        x += steps * heading.getXPart();
        y += steps * heading.getYPart();
        if( x > sim.getWidth() )
            x -= sim.getWidth();
        if( x < 0 )
            x += sim.getWidth();
        if( y > sim.getHeight() )
            y -= sim.getHeight();
        if( y < 0 )
            y += sim.getHeight();
    }

    public int getX() {
        return (int)x;
    }

    public int getY() {
        return (int)y;
    }
}
