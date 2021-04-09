package simStation;

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
        s.resume();
    }
}
