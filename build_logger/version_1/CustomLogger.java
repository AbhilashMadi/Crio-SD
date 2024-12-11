package build_logger.version_1;

import java.util.ArrayList;
import java.util.List;

public class CustomLogger {
    private final String name;
    private LogLevel level;
    private final List<LogHandler> handlers;

    public CustomLogger(String name) {
        this.name = name;
        this.level = LogLevel.DEBUG;
        handlers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setLevel(LogLevel level) {
        this.level = level;
    }

    public LogLevel getLevel(){
        return level;
    }

    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    public void warning(String message) {
        log(LogLevel.WARNING, message);
    }

    public void error(String message) {
        log(LogLevel.ERROR, message);
    }

    public void critical(String message) {
        log(LogLevel.CRITICAL, message);
    }

    public void addHandler(LogHandler handler){
        handlers.add(handler);
    }

    public void removeHandler(LogHandler handler){
        handlers.remove(handler);
    }

    public void notifyHandlers(LogRecord record){
        for(LogHandler handler: handlers){
            handler.publish(record);
        }
    }

    public void log(LogLevel severity, String message) {
        if (severity.getCode() >= level.getCode()) {
            LogRecord record = new LogRecord(severity, name, message);
            notifyHandlers(record);
        }
    }
}
