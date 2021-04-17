package Boids;

import mvc.AppFactory;
import mvc.AppPanel;
import mvc.Model;
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
}
