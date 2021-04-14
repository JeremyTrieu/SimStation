package Boids;

import mvc.AppFactory;
import mvc.Model;
import simStation.Agent;
import simStation.Heading;
import simStation.Simulation;


public class BoidsSim extends Simulation {
  public BoidsSim() {
    super();
  }

  public void populate() {
    for( int x=0; x<20; x++ )
      agents.add( new Boid(
          (int)(Math.random()*400),
          (int)(Math.random()*400),
          "" + hashCode(),
          new Heading((int)(Math.random()*360))
        ));
  }
}
