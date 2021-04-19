package Boids;

import mvc.*;
import simStation.ControlCommand;
import simStation.SimStationFactory;
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
        return "Boids";
    }

    public String[] getHelp()
    {
        return new String[] {super.getHelp()
            + "Boids are agents that try to move similarly to their neighbours"
            + "\nEach tick boids are modifying their speed and direction to be the average"
            + "\nof their old value and the value of the randomly picked agent around them"
        };
    }

    public String about()
    {
        return "SimStation by Team 8: Jeremy Trieu, Vlad Makarenko, Veronica Hu";
    }
}

