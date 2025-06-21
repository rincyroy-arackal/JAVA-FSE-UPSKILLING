package Week1.HandsOn_DesignPatternsAndPrinciples.SingletonPattern;

public class Main {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        logger1.log("Starting application...");

        Logger logger2 = Logger.getInstance();
        logger2.log("Application running...");

        // Check if both references point to the same object
        if (logger1 == logger2) {
            System.out.println("Both logger instances are the same.");
        } else {
            System.out.println("Different logger instances exist!");
        }
    }
}
