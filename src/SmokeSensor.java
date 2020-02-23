public class SmokeSensor extends sensor {

    public SmokeSensor(String typ, String loc, String manuf) {
        super(typ, loc, manuf);
    }

    private boolean heatDetect = false;

    public void setHeatDetect(boolean set){
        heatDetect = set;
    }

}
