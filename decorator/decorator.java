public interface Coffee {
    double getCost();
    String getDescription();
}

public class BasicCoffee implements Coffee {
    @Override
    public double getCost() {
        return 2.0;
    }

    @Override
    public String getDescription() {
        return "Basic coffee";
    }
}

public abstract class CoffeeDecorator implements Coffee {
    protected final Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee decoratedCoffee) {
        this.decoratedCoffee = decoratedCoffee;
    }

    public double getCost() {
        return decoratedCoffee.getCost();
    }

    public String getDescription() {
        return decoratedCoffee.getDescription();
    }
}

public class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    public double getCost() {
        return super.getCost() + 0.5;
    }

    public String getDescription() {
        return super.getDescription() + ", with milk";
    }
}

public class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    public double getCost() {
        return super.getCost() + 0.2;
    }

    public String getDescription() {
        return super.getDescription() + ", with sugar";
    }
}

public class CoffeeShop {
    public static void main(String[] args) {
        Coffee basicCoffee = new BasicCoffee();
        System.out.println("Cost: " + basicCoffee.getCost() + "; Description: " + basicCoffee.getDescription());

        Coffee milkCoffee = new MilkDecorator(basicCoffee);
        System.out.println("Cost: " + milkCoffee.getCost() + "; Description: " + milkCoffee.getDescription());

        Coffee sugarMilkCoffee = new SugarDecorator(milkCoffee);
        System.out.println("Cost: " + sugarMilkCoffee.getCost() + "; Description: " + sugarMilkCoffee.getDescription());
    }
}
