public class lightSensor extends sensor {

    public lightSensor (String typ, String loc, String manuf) {
        super(typ, loc, manuf);
    }

    private boolean light;

    public void setLight (boolean l){
        light = l;
    }
}
