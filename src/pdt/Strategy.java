package pdt;

public abstract class Strategy
{
    protected Prisoner agent;

    public Strategy(Prisoner p)
    {
        agent = p;
    }

    public void setMyPrisoner(Prisoner p) { agent = p; }

    public abstract boolean cooperate();

    public abstract char[] toChars();
}