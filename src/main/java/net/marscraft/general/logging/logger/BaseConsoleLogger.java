package net.marscraft.general.logging.logger;

import net.marscraft.general.logging.ILogger;
import net.marscraft.general.logging.LogLevel;
import net.marscraft.general.logging.type.LoggerTypeConsole;

/***/
public class BaseConsoleLogger extends LoggerTypeConsole implements ILogger {
    private String name;

    public BaseConsoleLogger(String name) {
        this.name = name;
    }

    @Override
    public void log(LogLevel logLevel, String message, Exception ex) {
        if(logLevel.equals(LogLevel.DEBUG)) logToConsole(formatMessage(logLevel, name, message, null));
        else logToConsole(formatMessage(logLevel, name, message, ex));
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
