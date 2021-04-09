package simStation;

import mvc.View;
import stopLight.Stoplight;

import java.awt.*;

public class SimStationView extends View {

    public SimStationView(Simulation light) {
        super(light);
    }

    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        Simulation sim = (Simulation)model;
        Color oldColor = gc.getColor();
        gc.setColor(light.getColor());
        Agent[] agents = sim.getAgents();
        gc.fillOval(100, 100, 20, 20);
        gc.setColor(oldColor);
    }
}