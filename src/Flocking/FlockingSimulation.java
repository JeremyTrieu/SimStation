package Flocking;
import mvc.*;
import simStation.Heading;
import simStation.SimStationFactory;
import simStation.Simulation;

import java.util.*;


class FlockingkFactory extends SimStationFactory {
    public Model makeModel() {
        return new FlockingSimulation();
    }

    public String getTitle() {
        return "Flocking";
    }
}

public class FlockingSimulation extends Simulation {
    public void populate() {
        for (int i = 0; i < 15; i++) {
            agents.add(new Bird(
                (int)(Math.random()*width),
                (int)(Math.random()*height),
                "" + hashCode(),
                Heading.random(),
                this
            ));
        }
    }
    public String[] getStats() {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        map.put(1, 0);
        map.put(2, 0);
        map.put(3, 0);
        map.put(4, 0);

        Iterator hmIterator = map.entrySet().iterator();
        List<String> temp = new LinkedList<String>();
//        for (int i = 0; i < agents.size(); i++) {
//            if (!agents.get(i).isStopped()) {
//                while (hmIterator.hasNext()) {
//
//                }
//            }
//        }
//        String[] stats =
        return null;
    }
}

