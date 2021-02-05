package Exercises.E04_RawData;

public class Tier {
    private double pressure;
    private int age;

    public Tier(double pressure, int age) {
        this.pressure = pressure;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public double getPressure() {
        return pressure;
    }
}
