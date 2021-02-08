package Exercises.E04_RawData;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tier[] tiers;

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return this.model;
    }

    public Tier[] getTiers() {
        return tiers;
    }

    public Engine getEngine() {
        return engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Car(String model, Engine engine, Cargo cargo, Tier[] tiers) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tiers = tiers;
    }

    public boolean hasTierWithLessPressureThanOne() {
        for (Tier tier : tiers) {
            if (tier.getPressure() < 1) {
                return true;
            }
        }
        return false;
    }
}
