package Exercises.E04_RawData;

public class Car {
    private final String model;
    private final int enginePower;
    private final String cargoType;
    private final double tire1;
    private final double tire2;
    private final double tire3;

    public Car(String model, int enginePower, String cargoType, double tire1, double tire2, double tire3, double tire4) {
        this.model = model;
        this.enginePower = enginePower;
        this.cargoType = cargoType;
        this.tire1 = tire1;
        this.tire2 = tire2;
        this.tire3 = tire3;
        this.tire4 = tire4;
    }

    Boolean tirePressure() {
        return getTire1() < 1 || getTire2() < 1
                || getTire3() < 1 || getTire4() < 1;
    }

    @Override
    public String toString() {
        return String.format("%s", getModel());
    }

    public String getModel() {
        return model;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public String getCargoType() {
        return cargoType;
    }

    public double getTire1() {
        return tire1;
    }

    public double getTire2() {
        return tire2;
    }

    public double getTire3() {
        return tire3;
    }

    public double getTire4() {
        return tire4;
    }

    private final double tire4;

}
