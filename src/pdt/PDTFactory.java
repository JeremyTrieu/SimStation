package pdt;

import mvc.*;
import simStation.*;

public class PDTFactory extends SimStationFactory
{
    public Model makeModel() { return new PDTournament(); }
    public View makeView(Model model) { return new PrisonerView(model); }
    public String getTitle() { return "Prisoner's Dilemma Tournament"; }

    public Command makeEditCommand(Model model, String type)
    {
        return new PDTCommand(model, type);
    }

    public String about()
    {
        return "SimStation Customization, Prisoner's Dilemma by Team 8: Jeremy Trieu, Vlad Makarenko, Veronica Hu";
    }
}
