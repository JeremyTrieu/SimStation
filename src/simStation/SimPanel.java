package simStation;
import javax.swing.*;

import mvc.*;


public class SimPanel extends AppPanel {
    private JButton change;
    public SimPanel(AppFactory factory) {
        super(factory);
        change = new JButton("Change");
        change.addActionListener(this);
        controlPanel.add(change);
        //add(buttonPanel);
        //add(view);
    }

    public static void main(String[] args) {
        AppFactory factory = new SimStationFactory();
        AppPanel panel = new SimPanel(factory);
        panel.display();
    }
}