package simstation;

import mvc.*;

public class SimStationFactory implements AppFactory 
{
	public Model makeModel() { return new Simulation(); }
	
	public View makeView(Model m) 
	{
		return new SimStationView( (Simulation) m);
	}
	
	public String getTitle()
	{
		return "SimStation";
	}
	
	public String[] getEditCommands()
	{
		return new String[] {"Start", "Suspend", "Stop", "Resume", "Stats"};
	}
	
	public Command makeEditCommand(Model model, String type)
	{
		return new ControlCommand(model, type);
	}
	
	public String[] getHelp()
	{
		return new String[] {"Click Start to begin the simulation."
				+ "Suspend will pause the simulation and resume will continue the simultion."
				+ "Click Stop the end the simulation."};
	}

	public String about()
	{
		return "SimStation by Team 8: Jeremy Trieu, Vlad Makarenko, Veronica Hu";
	}
}
