package net.marscraft.general.logging.logger;

import net.marscraft.general.logging.ILogger;
import net.marscraft.general.logging.LogCategory;
import net.marscraft.general.logging.LogLevel;
import net.marscraft.general.logging.type.LoggerTypeFile;

/**
 * Base File Logger Implementation
 * */
public class BaseFileLogger extends LoggerTypeFile implements ILogger {

    private String name;

    public BaseFileLogger(String name, LogCategory logCategory, String logFileName) {
        super(logCategory, (logFileName.contains(".txt") ? logFileName : logFileName + ".txt"));
        this.name = name;
    }

    @Override
    public void log(LogLevel logLevel, String message, Exception ex) {
        logToFile(formatMessage(logLevel, name, message, ex));
    }

    @Override
    public void log(LogLevel logLevel, String message) {
        log(logLevel, message, null);
    }

    @Override
    public void log(LogLevel logLevel, Exception ex) {
        log(logLevel, null, ex);
    }

    @Override
    public String getName() {
        return name;
    }
}
