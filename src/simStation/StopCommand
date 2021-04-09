package simstation;

import mvc.*;

public class StopCommand extends Command 
{
	public StopCommand(Model model)
	{
		super(model);
	}
	
	public void execute()
	{
		Simulation s = (Simulation) this.model;
		List<Agent> agents = s.getAgents();
		for (Agent a : agents)
		{
			a.state = AgentState.STOPPED;
		}
		s.stop();
	}
}
