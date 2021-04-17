package pdt;

public class NaiveStrategy extends Strategy
{
    public NaiveStrategy(Prisoner p)
    {
        super(p);
    }

    // This agent will always cooperate.
    public boolean cooperate()
    {
        return true;
    }

    public String toString() { return "NaiveStrategy"; }
}
