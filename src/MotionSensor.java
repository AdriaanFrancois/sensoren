public class MotionSensor extends sensor{

    public MotionSensor(String typ, String loc, String manuf) {
        super(typ, loc, manuf);
    }

    private double distance;

    public void setDistance(double dist){
        distance = dist;
    }

}
