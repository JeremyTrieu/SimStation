package plague;

import mvc.Model;
import mvc.View;
import randomWalk.RandomWalkSimulation;
import simStation.SimStationFactory;

public class PlagueFactory extends SimStationFactory {
    public Model makeModel() {
        return new Plague();
    }

    public View makeView(Model model) {
        return new PlagueView(model);
    }

    public String getTitle() {
        return "Plague";
    }
}
