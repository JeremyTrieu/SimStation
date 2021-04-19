package plague;

import simStation.SimPanel;
import Boids.BoidsPanel;


public class PlaguePanel extends SimPanel{
    public PlaguePanel(PlagueFactory factory) {
        super(factory);
    }

    public static void main(String[] args) {
        PlaguePanel panel = new PlaguePanel(new PlagueFactory());
        panel.display();
    }
}
