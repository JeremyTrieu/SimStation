package simstation;

import mvc.*;

public class ResumeCommand extends Command 
{
	public ResumeCommand(Model model)
	{
		super(model);
	}
	
	public void execute()
	{
		Simulation s = (Simulation) this.model;
		List<Agent> agents = s.getAgents();
		for (Agent a : agents)
		{
			a.state = AgentState.READY;
		}
		s.resume();
	}
}
