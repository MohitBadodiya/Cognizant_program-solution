public class SingletonPatternExample {
    public static void main(String[] args) {

        Logger logger1 = Logger.getInstance();
        logger1.log("This is the first log message.");

        Logger logger2 = Logger.getInstance();
        logger2.log("This is the second log message.");

        if (logger1 == logger2) {
            System.out.println("Both logger instances are the same.");
        } else {
            System.out.println("Different logger instances found.");
        }
    }
}

// Singleton Logger class 
class Logger {

    // Private static instance (eager initialization)
    private static Logger instance = new Logger();

    // Private constructor
    private Logger() {
        System.out.println("Logger instance created.");
    }

    
    public static Logger getInstance() {
        return instance;
    }

    
    public void log(String message) {
        System.out.println("Log: " + message);
    }
}
