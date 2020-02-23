abstract class sensor{
    private boolean state = false;
    private String type;
    private String location;
    private String manufacturer;
    private String noodBericht;


    public sensor (String typ, String loc, String manuf){
        location = loc;
        type = typ;
        manufacturer = manuf;
    }

    public boolean getState() {
        return state;
    }

    public String getType() {
        return type;
    }

    public String getLocation() {
        return location;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public void setNoodBericht(String bericht){
        noodBericht = bericht;
    }

    public String getNoodBericht(){
        return noodBericht;
    }
}
