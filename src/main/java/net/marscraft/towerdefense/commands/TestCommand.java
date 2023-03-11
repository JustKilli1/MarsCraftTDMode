package net.marscraft.towerdefense.commands;

import net.marscraft.towerdefense.entities.TestEntity;
import net.minestom.server.command.builder.Command;
import net.minestom.server.command.builder.arguments.ArgumentType;
import net.minestom.server.coordinate.Pos;
import net.minestom.server.instance.InstanceContainer;

public class TestCommand extends Command {

    public TestCommand(InstanceContainer instanceContainer) {
        super("test", "t");

        setDefaultExecutor((sender, context) -> {
            sender.sendMessage("Usage: /command <number>");
        });

        var numberArgument = ArgumentType.Integer("my-number");

        // Callback executed if the argument has been wrongly used
        numberArgument.setCallback((sender, exception) -> {
            final String input = exception.getInput();
            sender.sendMessage("The number " + input + " is invalid!");
        });

        addSyntax((sender, context) -> {
            final int number = context.get(numberArgument);
            sender.sendMessage("You typed the number " + number);
            for(int i = 0; i < number; i++) {
                TestEntity entity = new TestEntity();
                entity.setInstance(instanceContainer, new Pos(0D, 42D, 0D));
            }
        }, numberArgument);

    }

}
