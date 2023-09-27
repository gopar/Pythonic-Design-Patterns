public class Sheep implements Cloneable {
    private String name;

    public Sheep(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Override the clone method from the Object class
    @Override
    public Object clone() {
        try {
            // Perform a shallow copy
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        return "Sheep [name=" + name + "]";
    }
}

// Main class to test cloning
public class PrototypeDemo {
    public static void main(String[] args) {
        // Create a new Sheep object
        Sheep originalSheep = new Sheep("Dolly");
        System.out.println("Original Sheep: " + originalSheep);

        // Clone the original Sheep object
        Sheep clonedSheep = (Sheep) originalSheep.clone();
        System.out.println("Cloned Sheep: " + clonedSheep);

        // Modify the name of the cloned object
        clonedSheep.setName("Molly");
        System.out.println("Modified Cloned Sheep: " + clonedSheep);
        System.out.println("Original Sheep after cloning: " + originalSheep);
    }
}
