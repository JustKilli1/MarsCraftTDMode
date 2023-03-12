package net.marscraft.shared.logging.type;

import net.marscraft.shared.files.FileHandler;

import java.util.Arrays;
import java.util.List;

public class ConsoleLogger {

    /**
     * Writes A LogMessage to a File
     * @param message The Message that gets written to the File
     * @see FileHandler
     * */
    public void logToConsole(List<String> message) {
        message.forEach(System.out::println);
    }

    /**
     * Writes A LogMessage to a File
     * @param message The Message that gets written to the File
     * */
    public void logToConsole(String message) {
        logToConsole(Arrays.asList(message));
    }

}
