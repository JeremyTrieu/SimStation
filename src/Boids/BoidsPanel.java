package Boids;

import mvc.AppFactory;
import mvc.AppPanel;
import simStation.SimPanel;

import javax.swing.*;


public class BoidsPanel extends SimPanel {
//    private JButton change;
    public BoidsPanel(AppFactory factory) {
        super(factory);
//        change = new JButton("Change");
//        change = new JButton("Start");
//        change.addActionListener(this);
//        controlPanel.add(change);
        //add(buttonPanel);
        //add(view);
    }

    public static void main(String[] args) {
        AppFactory factory = new BoidsFactory();
        AppPanel panel = new BoidsPanel(factory);
        panel.display();
    }

}