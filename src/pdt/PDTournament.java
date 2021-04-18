package pdt;

import simStation.*;
import mvc.*;
import java.util.*;

public class PDTournament extends Simulation
{
    private Prisoner[] prisoners;
    public static int MIN_PAYOFF = 1;           // if neither agent cooperates
    public static int MID_PAYOFF = 3;           // if both agents cooperate
    public static int MAX_PAYOFF = 5;           // if only one agent cooperates

    public PDTournament()
    {
        super();
    }

    public Prisoner getNeighbor(Prisoner p, int range)
    {
        Agent a = super.getNeighbor(p, 10);
        return (Prisoner) a;
    }

    public void populate()
    {
        // Set the amount of agents here
        prisoners = new Prisoner[40];

        for (int i = 0; i < prisoners.length; i++)
        {
            // Randomize the coordinates for each prisoner
            double tmp = Math.random() * AppPanel.FRAME_WIDTH;
            int x = (int) tmp;
            tmp = Math.random() * AppPanel.FRAME_HEIGHT;
            int y = (int) tmp;
            Heading h = Heading.random();

            String name = "Prisoner #" + i;
            prisoners[i] = new Prisoner(x, y, name, h, this);
            // agents.set(i, new Prisoner(x, y, name, h, this));
        }

        strategies();
    }

    protected void strategies()
    {
        List<Agent> agents = this.getAgents();

        for (int i = 0; i < prisoners.length; i++) {
            switch (i % 4)
            {
                case 0:
                    prisoners[i].setStrat(new NaiveStrategy(prisoners[i]));
                    break;
                case 1:
                    prisoners[i].setStrat(new EvilStrategy(prisoners[i]));
                    break;
                case 2:
                    prisoners[i].setStrat(new MimicStrategy(prisoners[i]));
                    break;
                default:
                    prisoners[i].setStrat(new RandomStrategy(prisoners[i]));
            }
            agents.add(i, prisoners[i]);
        }
    }

    public int[] averages()
    {
        List<Agent> agents = this.getAgents();

        // Number of prisoners that have the corresponding strategy
        int naive = 0;
        int evil = 0;
        int random = 0;
        int mimic = 0;

        // Total fitness for each strategy
        int totalN = 0;
        int totalE = 0;
        int totalR = 0;
        int totalM = 0;

        for (Agent a : agents)
        {
            Prisoner p = (Prisoner) a;
            String s = p.getStrat().toString();
            if (s == "NaiveStrategy")
            {
                totalN += p.getFitness();
                naive++;
            }
            else if (s == "EvilStrategy")
            {
                totalE += p.getFitness();
                evil++;
            }
            else if (s == "RandomStrategy")
            {
                totalR += p.getFitness();
                random++;
            }
            else if (s == "MimicStrategy")
            {
                totalM += p.getFitness();
                mimic++;
            }
            else
            {
                System.out.println("Invalid Strategy Name");
            }
        }

        return new int[] {(totalN/naive), (totalE/evil), (totalR/random), (totalM/mimic)};
    }
    
    public void stats()
    {
        int[] i = this.averages();
        Utilities.inform("#agents = " + this.getAgents().size()
                + "\nclock = " + this.getClock()
                + "\n-------------------------------------"
                + "\n        Average Fitnesses"
                + "\nNaive Strategy:  " + i[0]
                + "\nEvil Strategy:   " + i[1]
                + "\nRandom Strategy: " + i[2]
                + "\nMimic Strategy:  " + i[3]);
    }

    public int[] getMinMax() {
        int min = ((Prisoner)agents.get(0)).getFitness();
        int max = min;
        for(Agent a : agents) {
            int fit = ((Prisoner)a).getFitness();
            if(fit < min)
                min=fit;
            else if(fit > max)
                max=fit;
        }
        return new int[]{min, max};
    }

    public static void main(String[] args)
    {
        AppPanel panel = new SimPanel(new PDTFactory());
        panel.display();

    }
}
