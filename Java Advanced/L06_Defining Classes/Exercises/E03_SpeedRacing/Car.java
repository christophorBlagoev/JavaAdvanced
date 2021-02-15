package Exercises.E03_SpeedRacing;

public class Car {

    private final String model;
    private double fuelAmount;
    private final double fuelPricePerKilometer;
    private int traveledDistance;

    public String getModel() {
        return model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public double getFuelPricePerKilometer() {
        return fuelPricePerKilometer;
    }

    public int getTraveledDistance() {
        return traveledDistance;
    }

    public static void drivingCar(Car info, int distance) {
        if (info.getFuelAmount() >= distance * info.getFuelPricePerKilometer()) {
            info.setFuelAmount(info.getFuelAmount() - distance * info.getFuelPricePerKilometer());
            info.setTraveledDistance(info.getTraveledDistance() + distance);
        } else {
            System.out.println("Insufficient fuel for the drive");
        }
    }

    public Car(String model, double fuelAmount, double fuelPricePerKilometer, int traveledDistance) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelPricePerKilometer = fuelPricePerKilometer;
        this.traveledDistance = traveledDistance;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public void setTraveledDistance(int traveledDistance) {
        this.traveledDistance = traveledDistance;
    }
}
