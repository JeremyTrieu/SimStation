package pdt;

import mvc.AppPanel;
import mvc.View;
import plague.PlagueAgent;
import simStation.Agent;
import simStation.Simulation;

import java.awt.*;
import java.util.List;

public class PrisonerView extends View {
    public PrisonerView(Object model) {
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
        int[] minMax = null;
        int range=0;
        if(!sim.getAgents().isEmpty()) {
            minMax = ((PDTournament)sim).getMinMax();
            range = minMax[1] - minMax[0];
        }
        for (Agent a : agents) {
            int afit = ((Prisoner)a).getFitness();
            Color fintess = Color.getHSBColor((afit-minMax[0])/(float)range/3, 1, 1);
            g2d.setColor(fintess);
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            g2d.drawChars(
                ((Prisoner)a).getStrat().toChars(),
                0,1,
                (int)(a.getX()*widthScale),
                (int)(a.getY()*heightScale)
                );

        }
    }
}
