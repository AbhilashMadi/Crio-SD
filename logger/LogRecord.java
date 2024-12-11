package logger;

import java.io.IOException;
import java.util.Date;
import java.util.logging.*;

class JsonFormatter extends Formatter {
    @Override
    public String format(java.util.logging.LogRecord record) {
        return String.format("{\"timestamp\": \"%1$tF %1$tT\", \"level\": \"%2$s\", \"message\": \"%3$s\"}\n",
                new Date(record.getMillis()),  // Convert millis to a Date for proper formatting
                record.getLevel().getName(),
                record.getMessage());
    }
}

public class LogRecord {  // Renamed to avoid conflict with java.util.logging.LogRecord
    private static final Logger logger = Logger.getLogger(LogRecord.class.getName());

    public static void main(String[] args) {
        try {
            // Create a FileHandler to save logs to a file
            FileHandler fileHandler = new FileHandler("application.log", true); // Append mode
            fileHandler.setFormatter(new JsonFormatter()); // Set the custom JSON formatter
            logger.addHandler(fileHandler); // Add FileHandler to the logger

            // Log messages of various levels
            logger.info("This is an INFO level message");
            logger.warning("This is a WARNING level message");
            logger.severe("This is a SEVERE level message");

        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to initialize file handler", e);
        }
    }
}
