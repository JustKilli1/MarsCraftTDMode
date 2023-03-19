package net.marscraft.general.logging.loggers;


import net.marscraft.general.logging.ILogger;
import net.marscraft.general.logging.LogCategory;
import net.marscraft.general.logging.LogLevel;
import net.marscraft.general.logging.type.LoggerTypeFile;

import java.util.Arrays;
import java.util.List;

public class BaseFileLogger extends LoggerTypeFile implements ILogger {

    private String name;

    public BaseFileLogger(LogCategory logCategory, String logFileName, String name) {
        super(logCategory, logFileName + ".txt");
        this.name = name;
    }

    @Override
    public void log(LogLevel logLevel, List<String> message, Exception ex) {
        logToFile(formatMessage(logLevel, name, message, ex));
    }

    @Override
    public void log(LogLevel logLevel, List<String> message) {
        log(logLevel, message, null);
    }

    @Override
    public void log(LogLevel logLevel, String message, Exception ex) {
        log(logLevel, Arrays.asList(message), ex);
    }

    @Override
    public void log(LogLevel logLevel, String message) {
        log(logLevel, message, null);
    }

    @Override
    public void log(LogLevel logLevel, Exception ex) {
        log(logLevel, (String) null, ex);
    }

    @Override
    public String getName() {
        return name;
    }
}
