package plague;

import mvc.Utilities;
import randomWalk.Drunk;
import simStation.Heading;
import simStation.Simulation;

public class PlagueAgent extends Drunk {
    boolean infected;
    PlagueAgent(int x, int y, String name, Heading heading, Simulation sim, boolean infected) {
        super(x, y, name, heading, sim);
        this.infected = infected;
    }

    public void update() {
        super.update();
        if(infected){
            PlagueAgent a = (PlagueAgent)world.getNeighbor(this, Plague.VIRULENCE);
            if(Simulation.dist(this, a) < Plague.VIRULENCE && this!=a)
                a.infect();
        }
    }
    public boolean isInfected(){
        return infected;
    }
    private void infect() {
        if( Utilities.rng.nextDouble()*100 > Plague.RESISTANCE)
            infected = true;
    }
}
