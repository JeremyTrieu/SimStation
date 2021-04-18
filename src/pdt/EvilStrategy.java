package pdt;

public class EvilStrategy extends Strategy
{
    public EvilStrategy(Prisoner p)
    {
        super(p);
    }

    // This agent will never cooperate.
    public boolean cooperate()
    {
        return false;
    }

    public String toString() { return "EvilStrategy"; }

    public char[] toChars() { return  new char[]{'E'};}
}
