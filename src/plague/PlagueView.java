package plague;

import mvc.AppPanel;
import mvc.View;
import simStation.Agent;
import simStation.Simulation;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class PlagueView extends View {

    public PlagueView(Object model) {
        super(model);
    }

    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        Simulation sim = (Simulation) model;
        List<Agent> agents = sim.getAgents();

        Graphics2D g2d = (Graphics2D) gc;
        int currentDisplayHeight = this.getHeight();
        int currentDisplayWidth = this.getWidth();
        double widthScale  = currentDisplayWidth  / (double) AppPanel.FRAME_WIDTH;
        double heightScale = currentDisplayHeight / (double) AppPanel.FRAME_HEIGHT;
        g2d.setColor(new Color(50, 50, 50));
        g2d.fillRect(
            0,
            0,
            currentDisplayWidth,
            currentDisplayHeight);
        for (Agent a : agents) {
            if(((PlagueAgent)a).isInfected())
                g2d.setColor(new Color(190, 0, 20));
            else
                g2d.setColor(new Color(50, 200, 100));
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            g2d.fillOval(
                (int)(a.getX()*widthScale),
                (int)(a.getY()*heightScale),
                (int)(10*widthScale),
                (int)(10*heightScale));
        }
    }
}
