package pdt;

public class MimicStrategy extends Strategy
{
    public MimicStrategy(Prisoner p)
    {
        super(p);
    }

    // This agent only cooperates if their previous opponent cooperated.
    public boolean cooperate()
    {
        return this.agent.getLastMove();
    }

    public String toString() { return "MimicStrategy"; }
}
