class Animal {
    public void eat() {
        System.out.println("Животное ест");
    }
}

public class Dog extends Animal {
    public void bark() {
        System.out.println("Собака лает");
    }

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat();
        dog.bark();
    }
}
