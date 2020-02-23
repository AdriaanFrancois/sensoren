import java.util.ArrayList;

public class Central {
    private String nameOfCentrale;
    private ArrayList<sensor> sensoren = new ArrayList<sensor>();

    public Central(String name){
        nameOfCentrale = name;
    }

    public void  addSensor(sensor sens){
        sensoren.add(sens);
    }

    public void getSensorByType(String sensType){
        boolean found = false;
        for(sensor x:sensoren){
            if (x.getType().equals(sensType)){
                System.out.println("location: "+ x.getLocation() + ", manufacturer: " + x.getManufacturer()+ " STATE = "+ x.getState());
                found = true;
            }
        }
        if (!found){
            System.out.println("no sensors found with this type");
        }
    }

    public void getSensorByLocation(String sensLoc){
        boolean found = false;
        for(sensor x:sensoren){
            if (x.getLocation().equals(sensLoc)){
                System.out.println("sensor: "+ x.getType() + " sensor, manufacturer: " + x.getManufacturer()+ " STATE = "+ x.getState());
                found = true;
            }
        }
        if (!found){
            System.out.println("no sensors found with this location");
        }
    }

    public void getSensorByManufacturer(String sensManu){
        boolean found = false;
        for(sensor x:sensoren){
            if (x.getManufacturer().equals(sensManu)){
                System.out.println("sensor: "+ x.getType() + " sensor, location: " + x.getLocation()+ " STATE = "+ x.getState());
                found = true;
            }
        }
        if (!found){
            System.out.println("no sensors found with this manufacturer");
        }
    }

    public sensor findSensor (String loc, String type, String m){
        for (sensor x:sensoren){
            if (x.getType().equals(type) && x.getLocation().equals(loc) && x.getManufacturer().equals(m)){
                return x;
            }
        }
        return null;
    }

    public void deleteSensor(sensor sens){
        sensoren.remove(sens);
        System.out.println("succes");
    }

    public void checkSensors(){
        boolean found = false;
        for (sensor x:sensoren){
            if (x.getState()){
                System.out.println();
                System.out.println("ACTIVE sensor: "+ x.getType() + " sensor, location: " + x.getLocation()+ ", manufacturer: " + x.getManufacturer());
                System.out.println(x.getNoodBericht());
                found = true;
            }
        }

        if (found == false) {
            System.out.println("alles OK");
        }
        System.out.println();
        System.out.println();
    }
}
