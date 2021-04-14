package simStation;

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
//        g2d.setFont(new Font("DialogInput", Font.PLAIN, (int) tileSize));
        // Background
        g2d.setColor(new Color(50, 50, 50));
        g2d.fillRect(
                0,
                0,
                currentDisplayWidth,
                currentDisplayHeight);
        for (Agent a : agents) {
            g2d.setColor(new Color(50, 200, 100));  //
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                    RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            // use pixels as (x, y)? or specify map size in the simulation?
            g2d.drawRect(a.getX()-2, a.getY()-2, a.getX()+2, a.getY()+2);
//            g2d.drawString(n,
//                    Math.round(ix * tileSize),
//                    Math.round(iy * tileSize) + tileSize
//            );
//            }
        }
    }
}