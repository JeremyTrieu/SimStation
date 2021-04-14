package Boids;

import mvc.View;
import simStation.Agent;
import simStation.Heading;
import simStation.Simulation;

import java.awt.*;
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
            Heading h = a.getHeading();
            int x = a.getX();
            int y = a.getY();
            int x1 = x + (int)(5*h.getXPart());
            int y1 = y + (int)(5*h.getYPart());
            int x2 = x - (int)(5*(h.getXPart()-0.6));
            int y2 = y - (int)(5*(h.getYPart()-0.6));
            int x3 = x - (int)(5*(h.getXPart()+0.6));
            int y3 = y - (int)(5*(h.getYPart()+0.6));
            g2d.drawPolygon(new int[]{x1,x2,x3}, new int[]{y1,y2,y3}, 3);
//            g2d.drawString(n,
//                    Math.round(ix * tileSize),
//                    Math.round(iy * tileSize) + tileSize
//            );
//            }
        }
    }
}
