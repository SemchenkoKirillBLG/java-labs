package zoo.animals;

public class Lion extends Animal {
    public Lion(String name) {
        super(name);
    }

    @Override
    protected String food() {
        return "мясо";
    }
}