package pdt;

import java.util.Random;

public class RandomStrategy extends Strategy
{
    private Random generator = new Random();

    public RandomStrategy(Prisoner p)
    {
        super(p);
    }

    // This prisoner randomly cooperates.
    public boolean cooperate()
    {
        return generator.nextBoolean();
    }

    public String toString() { return "RandomStrategy"; }
}
