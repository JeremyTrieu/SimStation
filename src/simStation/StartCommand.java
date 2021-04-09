package simstation;

import mvc.*;

public class StartCommand extends Command
{
	public StartCommand(Model model)
	{
		super(model);
	}
	
	public void execute()
	{
		Simulation s = (Simulation) this.model
		List<Agent> agents = s.getAgents();
		for (Agent a : agents)
		{
			a.state = AgentState.READY;
		}
		s.start();
	}
}
