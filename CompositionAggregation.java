public class CompositionAggregation {
    static class Engine {
    }

    static class Driver {
    }

    static class Car {
        private final Engine engine = new Engine();
        private final Driver driver;

        Car(Driver driver) {
            this.driver = driver;
        }
    }

    public static void main(String[] args) {
        Driver driver = new Driver();
        Car firstCar = new Car(driver);
        Car secondCar = new Car(driver);
    }
}
