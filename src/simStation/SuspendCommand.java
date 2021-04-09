package simstation;

import mvc.*;

public class SuspendCommand extends Command
{
	public SuspendCommand(Model model)
	{
		super(model);
	}
	
	public void execute()
	{
		Simulation s = (Simulation) this.model;
		List<Agent> agents = s.getAgents();
		for (Agent a : agents)
		{
			a.state = AgentState.SUSPENDED;
		}
		s.suspend();
	}
}
