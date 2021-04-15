package Boids;

import simStation.Agent;
import simStation.Heading;
import simStation.Simulation;

public class Boid extends Agent {
    double x, y;  // so that speed < 1.0 doesn't get lost
    double speed, angle;
    public Boid(int x, int y, String name, Heading heading, Simulation sim, double speed, double angle) {
        super(x, y, name, heading, sim);
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.angle = angle;
    }

    protected void update() {
        Boid n = (Boid) world.getNeighbor(this, 50);
        speed = speed*0.8 + n.speed*0.2;
        speed = Math.max(2, Math.min(speed + Math.random()-0.5, 10));
        updateAngle(0.0005 * getDiff(n.getAngle()));
        move(speed);
    }

    protected void move(double steps) {
        x += steps * getXPart();
        y += steps * getYPart();
        if( x > world.getWidth() )
            x -= world.getWidth();
        if( x < 0 )
            x += world.getWidth();
        if( y > world.getHeight() )
            y -= world.getHeight();
        if( y < 0 )
            y += world.getHeight();
    }

    public int getX() {
        return (int)x;
    }

    public int getY() {
        return (int)y;
    }
    public double getXPart() {
        return Math.cos(angle);
    }
    public double getYPart() { return Math.sin(angle); }
    public void updateAngle(double dAngle) {
        angle += dAngle;
        if(angle < 0)
            angle+=360;
        if(angle > 360)
            angle-=360;
    }
    public double getDiff(double pangle) {
        double diff = angle - pangle;
        if(diff < -180)
            diff+=360;
        if(diff > 180)
            diff-=360;
        return diff;
    }
    public double getAngle() {
        return angle;
    }
}
