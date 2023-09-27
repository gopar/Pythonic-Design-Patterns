public class Singleton {

    // Private constructor to prevent instantiation
    private Singleton() {}

    // Inner static class responsible for holding the Singleton instance
    private static class Holder {
        private static final Singleton INSTANCE = new Singleton();
    }

    // Public method to provide access to the Singleton instance
    public static Singleton getInstance() {
        return Holder.INSTANCE;
    }
}
