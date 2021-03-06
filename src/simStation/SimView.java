package simStation;

import mvc.AppPanel;
import mvc.View;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class SimView extends View {

    public SimView(Object model) {
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
//        g2d.setFont(new Font("DialogInput", Font.PLAIN, (int) tileSize));
        // Background
        g2d.setColor(new Color(50, 50, 50));
        g2d.fillRect(
                0,
                0,
                currentDisplayWidth,
                currentDisplayHeight);
        g2d.setColor(new Color(50, 200, 100));  //
        for (Agent a : agents) {
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                    RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            // use pixels as (x, y)? or specify map size in the simulation?
            g2d.fillOval(
                (int)(a.getX()*widthScale),
                (int)(a.getY()*heightScale),
                (int)(15*widthScale),
                (int)(15*heightScale));
        }
    }
}
