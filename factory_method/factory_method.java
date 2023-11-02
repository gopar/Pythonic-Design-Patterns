interface Enemy {
    void attack();
}

class Zombie implements Enemy {
    public void attack() {
        System.out.println("Zombie attacks!");
    }
}

class Alien implements Enemy {
    public void attack() {
        System.out.println("Alien attacks!");
    }
}

class EnemyFactorySelector {
    public static Enemy getEnemy() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(2); // Generates 0 or 1

        if (randomNumber == 0) {
            return new Zombie();
        } else {
            return new Alien();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Get an enemy based on external value (in this case, random number)
        Enemy enemy = EnemyFactorySelector.getEnemy();

        // Enemy attacks
        enemy.attack();
    }
}
