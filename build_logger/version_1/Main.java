package build_logger.version_1;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        CustomLogger logger = new CustomLogger("TestLogger");
        logger.setLevel(LogLevel.INFO);
        logger.addHandler(new FileHandler("logs.txt"));
        logger.addHandler(new ConsoleHandler());
        logger.addHandler(new EmailHandler());

        System.out.printf("Current Level: - %s\n", logger.getLevel());

        logger.debug("This is a debug message.");
        logger.info("This is an informational message.");
        logger.warning("This is a warning message.");
        logger.error("This is an error message.");
        logger.critical("This is a critical message.");
    }
}
