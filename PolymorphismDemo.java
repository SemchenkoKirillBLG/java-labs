public class PolymorphismDemo {
    static abstract class Animal {
        abstract void makeSound();
    }

    static class Dog extends Animal {
        @Override
        void makeSound() {
            System.out.println("Гав");
        }
    }

    static class Cat extends Animal {
        @Override
        void makeSound() {
            System.out.println("Мяу");
        }
    }

    public static void main(String[] args) {
        Animal[] animals = {new Dog(), new Cat()};

        for (Animal animal : animals) {
            animal.makeSound();
        }
    }
}
