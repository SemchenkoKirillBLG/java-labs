package zoo;

import zoo.animals.Elephant;
import zoo.animals.Feedable;
import zoo.animals.Lion;

public class Zoo {
    public static void main(String[] args) {
        Feedable[] animals = {new Lion("Лев"), new Elephant("Слон")};

        for (Feedable animal : animals) {
            animal.feed();
        }
    }
}