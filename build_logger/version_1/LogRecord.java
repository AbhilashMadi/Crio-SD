package build_logger.version_1;

import java.text.SimpleDateFormat;
import java.util.Date;

public record LogRecord(LogLevel severity, String loggerName, String message) {

    @Override
    public String toString() {
        return String.format(
                "LogRecord %s [severity=%s, loggerName=%s, message=%s]",
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), severity, loggerName, message
        );
    }
}
