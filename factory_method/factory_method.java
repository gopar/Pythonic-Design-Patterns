// The Product Interface
interface Enemy {
    void attack();
}

// ConcreteProduct1
class Zombie implements Enemy {
    public void attack() {
        System.out.println("Zombie attacks!");
    }
}

// ConcreteProduct2
class Alien implements Enemy {
    public void attack() {
        System.out.println("Alien attacks!");
    }
}

// The Creator Interface
interface EnemyFactory {
    Enemy createEnemy();
}

// ConcreteCreator1
class ZombieFactory implements EnemyFactory {
    public Enemy createEnemy() {
        return new Zombie();
    }
}

// ConcreteCreator2
class AlienFactory implements EnemyFactory {
    public Enemy createEnemy() {
        return new Alien();
    }
}

// Factory Selector
class EnemyFactorySelector {
    public static EnemyFactory getFactory() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(2); // Generates 0 or 1

        if (randomNumber == 0) {
            return new ZombieFactory();
        } else {
            return new AlienFactory();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Get a factory based on external value (in this case, random number)
        EnemyFactory factory = EnemyFactorySelector.getFactory();

        // Create enemy using the selected factory
        Enemy enemy = factory.createEnemy();

        // Enemy attacks
        enemy.attack();
    }
}
