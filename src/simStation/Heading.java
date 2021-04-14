package simStation;

public class Heading
{
    double angle;
    public Heading(int angle ) {
        this.angle = angle;
    }
    public double getXPart() {
        return Math.cos(angle);
    }
    public double getYPart() {
        return Math.sin(angle);
    }
    public void updateAngle(double dAngle) {
        angle += dAngle;
        if(angle < 0)
            angle+=360;
        if(angle > 360)
            angle-=360;
    }
    public double getDiff(double pangle) {
        double diff = angle - pangle;
        if(diff < -180)
            diff+=360;
        if(diff > 180)
            diff-=360;
        return diff;
    }
    public double getAngle() {
        return angle;
    }
}