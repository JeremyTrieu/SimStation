package simStation;

import mvc.*;

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
