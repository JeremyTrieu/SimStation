package simStation;

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
		s.stop();
	}
}
