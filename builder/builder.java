class Car {
    // Required parameters
    private String make;
    private String model;

    // Optional parameters
    private String color;
    private int year;
    private boolean isAutomatic;

    private Car(Builder builder) {
        this.make = builder.make;
        this.model = builder.model;
        this.color = builder.color;
        this.year = builder.year;
        this.isAutomatic = builder.isAutomatic;
    }

    public static class Builder {
        // Required parameters
        private String make;
        private String model;

        // Optional parameters - initialized to default values
        private String color = "Unspecified";
        private int year = 0;
        private boolean isAutomatic = false;

        public Builder(String make, String model) {
            this.make = make;
            this.model = model;
        }

        public Builder color(String color) {
            this.color = color;
            return this;
        }

        public Builder year(int year) {
            this.year = year;
            return this;
        }

        public Builder isAutomatic(boolean isAutomatic) {
            this.isAutomatic = isAutomatic;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", year=" + year +
                ", isAutomatic=" + isAutomatic +
                '}';
    }
}

public class BuilderPatternExample {
    public static void main(String[] args) {
        Car car1 = new Car.Builder("Toyota", "Camry")
                        .color("Black")
                        .year(2020)
                        .isAutomatic(true)
                        .build();

        Car car2 = new Car.Builder("Honda", "Civic")
                        .color("Red")
                        .build();

        System.out.println(car1);
        System.out.println(car2);
    }
}
