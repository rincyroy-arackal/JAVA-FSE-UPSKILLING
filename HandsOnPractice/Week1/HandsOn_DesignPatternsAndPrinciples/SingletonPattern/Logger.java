package Week1.HandsOn_DesignPatternsAndPrinciples.SingletonPattern;

public class Logger {
     private static Logger instance;

    // Step 2: Private constructor to prevent instantiation
    private Logger() {
        System.out.println("Logger Initialized.");
    }

    // Step 3: Public static method to provide access to the instance
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Utility method to simulate logging
    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}
