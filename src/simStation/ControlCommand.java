package simStation;

import mvc.*;

public class ControlCommand extends Command 
{
    private String command;

    public ControlCommand(Model model, String type)
    {
        super(model);
        command = type;
    }

    public void execute()
    {
        Simulation s = (Simulation) this.model;
        if (command == "Start")
        {
            s.start();
        } else if (command == "Stop")
        {
            s.stop();
        } else if (command == "Suspend")
        {
            s.suspend();
        } else if (command == "Resume")
        {
          s.resume();
        } else if (command == "Stats")
        {
            s.stats();
        } else {
            Utilities.inform("Invalid Command");
        }
	  }
}