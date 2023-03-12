package net.marscraft.towerdefense.instances;

import net.marscraft.shared.logging.ILogger;
import net.marscraft.shared.logging.LogLevel;
import net.marscraft.shared.logging.type.ConsoleLogger;

public class InstanceLogger extends ConsoleLogger implements ILogger {



    @Override
    public void log(LogLevel logLevel, String message, Exception ex) {

    }

    @Override
    public void log(LogLevel logLevel, String message) {

    }

    @Override
    public void log(LogLevel logLevel, Exception ex) {

    }

    @Override
    public String getName() {
        return null;
    }
}
