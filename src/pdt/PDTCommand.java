package pdt;

import simStation.*;
import mvc.*;

public class PDTCommand extends ControlCommand
{
    private String command;

    public PDTCommand(Model model, String type)
    {
        super(model, type);
        command = type;
    }

    @Override
    public void execute()
    {
        PDTournament pdt = (PDTournament) model;

        if (command == "Stats")
        {
            int[] i = pdt.averages();
            Utilities.inform("#agents = " + pdt.getAgents().size()
                    + "\nclock = " + pdt.getClock()
                    + "\n-------------------------------------"
                    + "\n        Average Fitnesses"
                    + "\nNaive Strategy:  " + i[0]
                    + "\nEvil Strategy:   " + i[1]
                    + "\nRandom Strategy: " + i[2]
                    + "\nMimic Strategy:  " + i[3]);

        } else {
            super.execute();
        }
    }
}
