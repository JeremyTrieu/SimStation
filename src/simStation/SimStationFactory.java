package simStation;

import mvc.*;

public class SimStationFactory implements AppFactory 
{
	public Model makeModel() { return new Simulation(); }
	
	public View makeView(Model m) 
	{
		return new SimView ( (Simulation) m);
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
				+ "\nSuspend will pause the simulation and resume will continue the simulation."
				+ "\nClick Stop the end the simulation."};
	}

	public String about()
	{
		return "SimStation by Team 8: Jeremy Trieu, Vlad Makarenko, Veronica Hu";
	}
}
