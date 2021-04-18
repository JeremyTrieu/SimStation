package Boids;

import mvc.AppPanel;
import simStation.Agent;
import simStation.Heading;
import simStation.Simulation;

public class Boid extends Agent {
    double x, y;  // so that speed < 1.0 doesn't get lost
    double speed, angle;
    static double MAXSPEED = 5;
    static double MINSPEED = 1;
    double ANGLEDIFF = 0.0005;
    public Boid(int x, int y, String name, Heading heading, Simulation sim, double speed, double angle) {
        super(x, y, name, heading, sim);
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.angle = angle;
    }

    protected void update() {
        Boid n = (Boid) world.getNeighbor(this, 50);
        speed = speed*0.5 + n.speed*0.5;
        speed = Math.max(MINSPEED, Math.min(speed + Math.random()-0.5, MAXSPEED));
        updateAngle(ANGLEDIFF * getDiff(n.getAngle()));
        move(speed);
    }

    protected void move(double steps) {
        x += steps * getXPart();
        y += steps * getYPart();
        if( x > AppPanel.FRAME_WIDTH )
            x -= AppPanel.FRAME_WIDTH;
        if( x < 0 )
            x += AppPanel.FRAME_WIDTH;
        if( y > AppPanel.FRAME_HEIGHT )
            y -= AppPanel.FRAME_HEIGHT;
        if( y < 0 )
            y += AppPanel.FRAME_HEIGHT;
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

    public double getSpeed() {
        return speed;
    }
}
