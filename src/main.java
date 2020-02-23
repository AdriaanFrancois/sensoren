import com.sun.source.tree.WhileLoopTree;

import java.util.Scanner;


public class main {
    public static void main (String[] arg) {
        Scanner input = new Scanner(System.in);
        System.out.println("name of the central ?");
        String nameOfCentral = input.nextLine();
        Central central = new Central(nameOfCentral);

        while (true) { // hoofdloop
            System.out.println("Choose one of the following: add / search / delete / test / stop");
            String inputChoice = input.nextLine();

            if (inputChoice.equals("add")) {
                System.out.println("Location of sensor ?");
                String sensLoc = input.nextLine();
                System.out.println("Manufacturer of sensor ?");
                String manuf = input.nextLine();
                System.out.println("Type of sensor ? ( CO / motion / smoke)");
                String sensType = input.nextLine();
                if(central.findSensor(sensType, sensLoc, manuf) == null) {

                    //add motion senor
                    if (sensType.equals("motion")) {
                        MotionSensor sens = new MotionSensor(sensType, sensLoc, manuf);
                        sens.setNoodBericht("contact the popo's");
                        System.out.println("radius of sensing");
                        sens.setDistance(input.nextDouble());
                        central.addSensor(sens);
                    }

                    //add smoke senor
                    if (sensType.equals("smoke")) {
                        SmokeSensor sens = new SmokeSensor(sensType, sensLoc, manuf);
                        sens.setNoodBericht("close the windows");
                        System.out.println("options: sense heat / sense heat & smoke");
                        System.out.println("sense heat & smoke    y/n");
                        if (input.nextLine().equals("y")){
                            sens.setHeatDetect(true);
                        }
                        central.addSensor(sens);
                    }

                    //add CO sensor
                    if (sensType.equals("CO")) {
                        COSensor sens = new COSensor(sensType, sensLoc, manuf);
                        sens.setNoodBericht("open the windows");
                        System.out.println("minimum CO concentration ?");
                        sens.setCOconcentration(input.nextDouble());
                        central.addSensor(sens);
                    }
                }

                else{
                    System.out.println("Sensor allready exists!");
                }
            }

            //search
            if (inputChoice.equals("search")) {
                System.out.println("Choose what to search on: type / location / manufacturer");
                String choice = input.nextLine();
                if (choice.equals("type")) {
                    System.out.println("type ?");
                    central.getSensorByType(input.nextLine());
                }

                if (choice.equals("location")) {
                    System.out.println("location ?");
                    central.getSensorByLocation(input.nextLine());
                }

                if (choice.equals("manufacturer")){
                    System.out.println("manufacturer ?");
                    central.getSensorByManufacturer(input.nextLine());
                }
            }

            //delete
            if (inputChoice.equals("delete")) {
                System.out.println("Give sensor information: location ?");
                String loc = input.nextLine();
                System.out.println("type ?");
                String type = input.nextLine();
                System.out.println("Manufacturer of sensor ?");
                String manuf = input.nextLine();
                if (central.findSensor(loc, type, manuf) != null){
                    central.deleteSensor(central.findSensor(loc, type, manuf));
                }
                else{
                    System.out.println("sensor not found");
                }
            }

            if (inputChoice.equals("test")) {
                System.out.println("Give sensor information: location ?");
                String loc = input.nextLine();
                System.out.println("type ? (CO / motion / smoke)");
                String type = input.nextLine();
                System.out.println("Manufacturer of sensor ?");
                String manuf = input.nextLine();
                if (central.findSensor(loc, type, manuf) != null){
                    central.findSensor(loc, type, manuf).setState(true);
                }
                else{
                    System.out.println("sensor not found");
                }
            }

            if (inputChoice.equals("stop")){
                break;
            }
            central.checkSensors(); //controleer de sensoren
        }
    }
}
