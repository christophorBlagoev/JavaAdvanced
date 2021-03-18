package dealership;

import java.util.ArrayList;
import java.util.List;

public class Dealership {

    private String name;
    private int capacity;
    private List<Car> data;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (data.size() < capacity) {
            this.data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model) {
        return this.data.removeIf(car -> (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)));
    }

    public Car getLatestCar() {
        return this.data.stream().min((p1, p2) -> Integer.compare(p2.getYear(), p1.getYear())).orElse(null);
    }

    public Car getCar(String manufacturer, String model) {
        return this.data.stream().filter(e -> e.getManufacturer().equals(manufacturer) && e.getModel().equals(model))
                .findFirst().orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder output = new StringBuilder("The cars are in a car dealership ");
        output.append(getName()).append(":").append(System.lineSeparator());
        data.forEach(e -> output.append(e).append(System.lineSeparator()));
        return output.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List< Car > getData() {
        return data;
    }

    public void setData(List< Car > data) {
        this.data = data;
    }
}
