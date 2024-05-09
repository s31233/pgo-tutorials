import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Airfield airfield = new Airfield("Test Airfield", 30, "Test Address");

        Helicopter helicopter1 = new Helicopter("WPI1", "Red", "Helicopter1", 2021, 5, 6000);
        Helicopter helicopter2 = new Helicopter("WU1", "Pink", "Helicopter2", 2015, 4, 4000);
        Drone drone1 = new Drone("WE1", "Gray", "Drone1", 2022, 6, true);
        Glider glider1 = new Glider("WT1", "Black", "Glider1", 2016, 13);

        airfield.addAerialVehicle(helicopter1);
        airfield.addAerialVehicle(helicopter2);
        airfield.addAerialVehicle(drone1);
        airfield.addAerialVehicle(glider1);

        helicopter1.displayInfo();
        helicopter2.displayInfo();
        drone1.displayInfo();
        glider1.displayInfo();

        airfield.removeAerialVehicle(helicopter1);
        airfield.removeAerialVehicle(drone1);

        airfield.addAerialVehicle(helicopter2);
        airfield.addAerialVehicle(helicopter1);
    }
}
class AerialVehicle {
    private String registrationNumber;
    private String color;
    private String model;
    private int yearOfProduction;

    public AerialVehicle(String registrationNumber, String color, String model, int yearOfProduction) {
        this.registrationNumber = registrationNumber;
        this.color = color;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getColor() {
        return color;
    }

    public String getModel() {
        return model;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }
}

class Helicopter extends AerialVehicle {
    private int rotorCount;
    private int maxAttitude;

    public Helicopter(String registrationNumber, String color, String model, int yearOfProduction, int rotorCount, int maxAttitude) {
        super(registrationNumber, color, model, yearOfProduction);
        this.rotorCount = rotorCount;
        this.maxAttitude = maxAttitude;
    }

    public void displayInfo() {
        System.out.println("Helicopter: " + getModel() + " (Registration Number: " + getRegistrationNumber() + ")");
    }
}

class Drone extends AerialVehicle {
    private double batteryLife;
    private boolean cameraEquipped;

    public Drone(String registrationNumber, String color, String model, int yearOfProduction, double batteryLife, boolean cameraEquipped) {
        super(registrationNumber, color, model, yearOfProduction);
        this.batteryLife = batteryLife;
        this.cameraEquipped = cameraEquipped;
    }

    public void displayInfo() {
        System.out.println("Drone: " + getModel() + " (Registration Number: " + getRegistrationNumber() + ")");
    }
}

class Glider extends AerialVehicle {
    private double wingLength;

    public Glider(String registrationNumber, String color, String model, int yearOfProduction, double wingLength) {
        super(registrationNumber, color, model, yearOfProduction);
        this.wingLength = wingLength;
    }

    public void displayInfo() {
        System.out.println("Glider: " + getModel() + " (Registration Number: " + getRegistrationNumber() + ")");
    }
}

class Airfield {
    private String name;
    private int capacity;
    private String address;
    private List<AerialVehicle> aerialVehicles;

    public Airfield(String name, int capacity, String address) {
        this.name = name;
        this.capacity = capacity;
        this.address = address;
        this.aerialVehicles = new ArrayList<>();
    }

    public void addAerialVehicle(AerialVehicle aerialVehicle) {
        if (aerialVehicles.size() >= capacity) {
            System.out.println("Cannot add vehicle.");
            return;
        }
        for (AerialVehicle vehicle : aerialVehicles) {
            if (vehicle.getRegistrationNumber().equals(aerialVehicle.getRegistrationNumber())) {
                System.out.println("Vehicle with the same registration number already exists.");
                return;
            }
        }
        aerialVehicles.add(aerialVehicle);
        System.out.println("Vehicle added.");
    }

    public void removeAerialVehicle(AerialVehicle aerialVehicle) {
        if (!aerialVehicles.contains(aerialVehicle)) {
            System.out.println("Vehicle not found.");
            return;
        }
        aerialVehicles.remove(aerialVehicle);
        System.out.println("Vehicle removed.");
    }
}

