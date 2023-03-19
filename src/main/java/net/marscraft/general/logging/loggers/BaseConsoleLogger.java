package net.marscraft.general.logging.loggers;

import net.marscraft.general.logging.ILogger;
import net.marscraft.general.logging.LogLevel;
import net.marscraft.general.logging.type.LoggerTypeConsole;

import java.util.Arrays;
import java.util.List;

public class BaseConsoleLogger extends LoggerTypeConsole implements ILogger {

    private String name;

    public BaseConsoleLogger(String name) {
        this.name = name;
    }

    @Override
    public void log(LogLevel logLevel, List<String> message, Exception ex) {
        message.forEach(msg -> logToConsole(formatMessage(logLevel, name, msg, ex)));
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
