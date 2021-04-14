package Boids;

import mvc.*;
import simStation.ControlCommand;
import simStation.SimStationFactory;
import simStation.SimView;
import simStation.Simulation;

public class BoidsFactory extends SimStationFactory
{
  public Model makeModel() { return new BoidsSim(); }

  public View makeView(Model m)
  {
    return new BoidsView( (Simulation) m);
  }

  public String getTitle()
  {
    return "BoidsSim";
  }

  public String[] getHelp()
  {
    return new String[] {"Click Start to begin the simulation."
      + "Suspend will pause the simulation and resume will continue the simultion."
      + "Click Stop the end the simulation."
      + "Boids are agents that try to move similarly to their neighbours"};
  }

  public String about()
  {
    return "SimStation by Team 8: Jeremy Trieu, Vlad Makarenko, Veronica Hu";
  }
}

