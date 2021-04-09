package simstation;

import mvc.*;
import tools.Utilities;

public class StatsCommand extends Command 
{
	public StatsCommand(Model model)
	{
		super(model);
	}
	
	public void execute()
	{
		Simulation s = (Simulation) this.model;
		Utilities.inform("#agents = " + s.getAgents().size()
				+ "\nclock = " + s.getClock());
	}
}
