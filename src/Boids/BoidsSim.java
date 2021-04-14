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
    for( int x=0; x<40; x++ )
      agents.add( new Boid(
          (int)(Math.random()*width),
          (int)(Math.random()*height),
          "" + hashCode(),
          new Heading((int)(Math.random()*360)),
          this
        ));
  }
}
