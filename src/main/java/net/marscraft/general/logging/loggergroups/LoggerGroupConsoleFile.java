package net.marscraft.general.logging.loggergroups;


import net.marscraft.general.logging.ILogger;
import net.marscraft.general.logging.LogCategory;
import net.marscraft.general.logging.LogLevel;
import net.marscraft.general.logging.loggers.BaseConsoleLogger;
import net.marscraft.general.logging.loggers.BaseFileLogger;

import java.util.Arrays;
import java.util.List;

public class LoggerGroupConsoleFile implements ILoggerGroup {

    private String name;
    private List<ILogger> loggers;

    public LoggerGroupConsoleFile(String loggerName, LogCategory logCategory, String logFileName) {
        name = loggerName;
        loggers = Arrays.asList(
                new BaseFileLogger(logCategory, logFileName, name),
                new BaseConsoleLogger(name)
        );
    }

    @Override
    public void log(LogLevel logLevel, List<String> message, Exception ex) {
        loggers.forEach(logger -> logger.log(logLevel, message, ex));
    }

    @Override
    public void log(LogLevel logLevel, List<String> message) {
        loggers.forEach(logger -> logger.log(logLevel, message));
    }

    @Override
    public void log(LogLevel logLevel, String message, Exception ex) {
        log(logLevel, Arrays.asList(message), ex);
    }

    @Override
    public void log(LogLevel logLevel, String message) {
        log(logLevel, Arrays.asList(message));
    }

    @Override
    public void log(LogLevel logLevel, Exception ex) {
        loggers.forEach(logger -> logger.log(logLevel, ex));
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<ILogger> getLogger() {
        return loggers;
    }
}
