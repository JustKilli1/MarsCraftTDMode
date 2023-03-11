package net.marscraft.shared.database;

import net.marscraft.shared.logging.ILogger;
import net.marscraft.shared.logging.LogLevel;
import net.marscraft.shared.logging.LoggingUtils;
import net.marscraft.shared.logging.type.ConsoleLogger;

public class DatabaseLogger extends ConsoleLogger implements ILogger {

    private static final DatabaseLogger instance = new DatabaseLogger();
    private String name = "DatabaseLogger";

    public static DatabaseLogger getInstance() { return instance; }

    @Override
    public void log(LogLevel logLevel, String message, Exception ex) {
        if(logLevel.equals(LogLevel.DEBUG)) System.out.println(LoggingUtils.formatMessage(logLevel, name, message, null));
        else System.out.println(LoggingUtils.formatMessage(logLevel, name, message, ex));
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
