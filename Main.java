public class Main {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Corolla", 2020, 15000, 500);
        Truck truck = new Truck("Volvo", "FH16", 2019, 20000, 1000, 10);

        car.displayInfo();
        System.out.println("Fuel Efficiency: " + car.calculateFuelEfficiency() + " miles per gallon");
        System.out.println();

        truck.displayInfo();
        System.out.println("Fuel Efficiency: " + truck.calculateFuelEfficiency() + " miles per gallon");
    }
}
// klasa Vehicle
abstract class Vehicle {
    protected String make;
    protected String model;
    protected int year;

    public Vehicle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public abstract double calculateFuelEfficiency();

    public void displayInfo() {
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
    }

}
//klasa Car
class Car extends Vehicle{
    private double milesDriven;
    private double fuelConsumed;


    public Car(String make, String model, int year, double milesDriven, double fuelConsumed) {
        super(make, model, year);
        this.milesDriven = milesDriven;
        this.fuelConsumed = fuelConsumed;
    }


    @Override
    public double calculateFuelEfficiency() {
        return milesDriven / fuelConsumed;
    }
}
//klasa Truck
class Truck extends Vehicle{
    private double milesDriven;
    private double fuelConsumed;
    private double cargoWeight;


    public Truck(String make, String model, int year, double milesDriven, double fuelConsumed, double cargoWeight) {
        super(make, model, year);
        this.milesDriven = milesDriven;
        this.fuelConsumed = fuelConsumed;
        this.cargoWeight = cargoWeight;
    }


    @Override
    public double calculateFuelEfficiency() {
        return milesDriven / (fuelConsumed + (cargoWeight * 0.5));
    }
}
