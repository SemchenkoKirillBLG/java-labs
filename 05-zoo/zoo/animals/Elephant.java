package zoo.animals;

public class Elephant extends Animal {
    public Elephant(String name) {
        super(name);
    }

    @Override
    protected String food() {
        return "траву";
    }
}