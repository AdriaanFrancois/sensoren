public class COSensor extends sensor {

    public COSensor(String typ, String loc, String manuf) {
        super(typ, loc, manuf);
    }
    private double COconcentration;

    public void setCOconcentration(double conc){
        COconcentration = conc;
    }
}
