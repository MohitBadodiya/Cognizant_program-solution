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
    private Logger() {
        System.out.println("Logger instance created.");
    }

    private static class LoggerHelper {
        private static final Logger INSTANCE = new Logger();
    }

    public static Logger getInstance() {
        return LoggerHelper.INSTANCE;
    }

    public void log(String message) {
        System.out.println("Log: " + message);
    }
}

