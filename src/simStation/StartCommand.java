package simStation;

import mvc.*;

import java.util.List;

public class StartCommand extends Command
{
	public StartCommand(Model model)
	{
		super(model);
	}
	
	public void execute()
	{
		Simulation s = (Simulation) this.model;
		s.start();
	}
}
