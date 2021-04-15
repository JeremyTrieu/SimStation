package Boids;

import mvc.View;
import simStation.Agent;
import simStation.Heading;
import simStation.Simulation;

import java.awt.*;
import java.util.Collections;
import java.util.List;

public class BoidsView extends View {

    public BoidsView(Object model) {
        super(model);
    }

    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        Simulation sim = (Simulation) model;
        List<Boid> agents = Collections.singletonList((Boid) sim.getAgents());
        int mapWidth = sim.getWidth();
        int mapHeight = sim.getHeight();
        Graphics2D g2d = (Graphics2D) gc;
        int currentDisplayHeight = this.getHeight();
        int currentDisplayWidth = this.getWidth();
        double widthScale  = currentDisplayWidth  / (double) mapWidth;
        double heightScale = currentDisplayHeight / (double) mapHeight;
//        g2d.setFont(new Font("DialogInput", Font.PLAIN, (int) tileSize));
        // Background
        g2d.setColor(new Color(50, 50, 50));
        g2d.fillRect(
          0,
          0,
          currentDisplayWidth,
          currentDisplayHeight);
        for (Boid a : agents) {
            g2d.setColor(new Color(50, 200, 100));  //
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
              RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            int x = (int)(a.getX()*widthScale);
            int y = (int)(a.getY()*heightScale);

            int x1 = x + (int)(5*a.getXPart());
            int y1 = y + (int)(5*a.getYPart());
            int x2 = x - (int)(5*a.getXPart()-0.6);
            int y2 = y - (int)(5*a.getYPart()-0.6);
            int x3 = x - (int)(5*a.getXPart()+0.6);
            int y3 = y - (int)(5*a.getYPart()+0.6);
            g2d.drawPolygon(new int[]{x1,x2,x3}, new int[]{y1,y2,y3}, 3);
//            g2d.drawString(n,
//                    Math.round(ix * tileSize),
//                    Math.round(iy * tileSize) + tileSize
//            );
//            }
        }
    }
}

