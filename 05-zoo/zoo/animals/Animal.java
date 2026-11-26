package zoo.animals;

public abstract class Animal implements Feedable {
    private final String name;

    protected Animal(String name) {
        this.name = name;
    }

    protected abstract String food();

    @Override
    public void feed() {
        System.out.println(name + " ест " + food());
    }
}