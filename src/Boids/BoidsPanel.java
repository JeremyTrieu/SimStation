package Boids;

import mvc.AppFactory;
import mvc.AppPanel;
import simStation.SimPanel;


public class BoidsPanel extends SimPanel {
    public BoidsPanel(AppFactory factory) {
        super(factory);
    }

    public static void main(String[] args) {
        AppFactory factory = new BoidsFactory();
        AppPanel panel = new BoidsPanel(factory);
        panel.display();
    }
}