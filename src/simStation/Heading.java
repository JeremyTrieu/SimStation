package simStation;

public class Heading
{
    int angle;
    public Heading(int angle ) {
        this.angle = angle;
    }
    public double getXPart() {
        return Math.cos(angle);
    }

    public double getYPart() {
        return Math.sin(angle);
    }

//    public
}