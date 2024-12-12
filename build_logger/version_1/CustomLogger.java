package build_logger.version_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomLogger {
    private final String name;
    private LogLevel level;
    private final Map<LogLevel, List<LogHandler>> handlerMapping;

    // singleton
    private static CustomLogger instance;

    public static CustomLogger getLogger(String name) {
        if (instance == null) {
            instance = new CustomLogger(name);
        }

        return instance;
    }

    public CustomLogger(String name) {
        this.name = name;
        this.level = LogLevel.DEBUG;
        this.handlerMapping = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setLevel(LogLevel level) {
        this.level = level;
    }

    public LogLevel getLevel() {
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

    public void addHandler(LogHandler handler) {
        for (LogLevel level : LogLevel.values()) {
            this.addHandler(level, handler);
        }
    }

    public void removeHandler(LogHandler handler) {
        for (LogLevel level : LogLevel.values()) {
            this.removeHandler(level, handler);
        }
    }

    public void addHandler(LogLevel level, LogHandler handler) {
        List<LogHandler> handlers = handlerMapping.get(level);

        if (handlers == null) {
            handlers = new ArrayList<>();
            handlers.add(handler);
            handlerMapping.put(level, handlers);
        }

        handlers.add(handler);
    }

    public void removeHandler(LogLevel level, LogHandler handler) {
        List<LogHandler> handlers = handlerMapping.get(level);
        if (handlers != null) {
            handlers.remove(handler);
        }
    }

    public void notifyHandlers(LogRecord record) {
        List<LogHandler> handlers = handlerMapping.get(record.severity());

        if (handlers != null) {
            for (LogHandler handler : handlers) {
                handler.publish(record);
            }
        }
    }

    public void log(LogLevel severity, String message) {
        if (severity.getCode() >= level.getCode()) {
            LogRecord record = new LogRecord(severity, name, message);
            notifyHandlers(record);
        }
    }
}
