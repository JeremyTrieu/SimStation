package pdt;

import simStation.*;
import java.util.*;

public class Prisoner extends Agent
{
    private int fitness = 0;
    private Strategy strat;
    private Prisoner opponent;
    
    // Whether the previous opponent cooperated or not (assumes prisoners are cooperative on startup).
    private boolean lastMove = true;               

    public Prisoner(int x, int y, String name, Heading heading, PDTournament sim)
    {
        super(x, y, name, heading, sim);
    }

    public int getFitness()             { return fitness; }

    public void setStrat(Strategy s)
    {
        strat = s;
        strat.setMyPrisoner(this);
    }
    public Strategy getStrat()          { return strat; }

    public void setOpponent(Prisoner p) { opponent = p; }

    public boolean getLastMove()        { return lastMove; }

    public boolean cooperate()          { return strat.cooperate(); }

    public void update()
    {
        PDTournament sim = (PDTournament) world;
        this.setOpponent(sim.getNeighbor(this, 10));

        boolean myMove = this.cooperate();
        boolean otherMove = opponent.cooperate();

        if (myMove)
        {
            // Both prisoners cooperate
            if (otherMove) { fitness += PDTournament.MID_PAYOFF; }

            // This prisoner cooperates, but the other prisoner doesn't
            // Fitness doesn't change (fitness += 0)
        } else {
            // This prisoner doesn't cooperate, but the other does
            if (otherMove) { fitness += PDTournament.MAX_PAYOFF; }

            // Neither prisoner cooperates
            else { fitness += PDTournament.MIN_PAYOFF; }
        }

        // Set lastMove for this prisoner to the opponent's move in advance of the next match
        lastMove = otherMove;

        // Prisoner then moves in a random direction like Drunks
        this.setHeading(Heading.random());
        double tmp = Math.random() * 10;
        move((int) tmp);
    }
}
