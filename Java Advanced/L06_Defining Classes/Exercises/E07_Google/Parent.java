package Exercises.E07_Google;

public class Parent {

    private final String name;
    private final String birthday;

    public Parent(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return String.format("%s %s", name, birthday);
    }
}
