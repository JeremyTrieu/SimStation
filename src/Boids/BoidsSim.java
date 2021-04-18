package Boids;

import mvc.AppPanel;
import mvc.Utilities;
import simStation.Agent;
import simStation.Heading;
import simStation.Simulation;


public class BoidsSim extends Simulation {
    public BoidsSim() {
        super();
    }

    public void populate() {
        for( int x=0; x<40; x++ )
            agents.add( new Boid(
                (int)(Math.random() * AppPanel.FRAME_WIDTH),
                (int)(Math.random() * AppPanel.FRAME_HEIGHT),
                "" + hashCode(),
                Heading.random(),
                this,
                Math.random()*3,
                Math.random()*360
            ));
    }

    public void stats() {
        int[] speedCounts = new int[(int)(Boid.MAXSPEED - Boid.MINSPEED)+1];
        for(Agent a: agents) {
            Boid b = (Boid) a;
            speedCounts[(int)(b.getSpeed()-Boid.MINSPEED)]++;
        }
        String report="";
        for(int i=0; i<speedCounts.length; i++)
            report += "#boids @ speed " + (i+1) + " " + speedCounts[i] + "\n";
        Utilities.inform(report);
    }
}
