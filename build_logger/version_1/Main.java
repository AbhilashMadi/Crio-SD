package build_logger.version_1;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        CustomLogger logger = CustomLogger.getLogger("MyLogger");
        logger.setLevel(LogLevel.CRITICAL);
        // add handlers
        logger.addHandler(LogLevel.DEBUG,new ConsoleHandler());
        logger.addHandler(new FileHandler("log.txt"));

        System.out.println("Current Level:- " + logger.getLevel());
        logger.debug("This is a debug message.");
        logger.info("This is an informational message.");
        logger.warning("This is a warning message.");
        logger.error("This is an error message.");
        logger.critical("This is a critical message.");

    }
}
