package net.marscraft.towerdefense;

import net.marscraft.general.database.MySQL;
import net.marscraft.towerdefense.commands.GamemodeCommand;
import net.marscraft.towerdefense.commands.TestCommand;
import net.marscraft.towerdefense.instances.MinigameInstanceHandler;
import net.minestom.server.MinecraftServer;
import net.minestom.server.coordinate.Pos;
import net.minestom.server.entity.Player;
import net.minestom.server.event.GlobalEventHandler;
import net.minestom.server.event.player.PlayerLoginEvent;
import net.minestom.server.instance.InstanceContainer;
import net.minestom.server.instance.InstanceManager;
import net.minestom.server.instance.block.Block;

public class Main {

    public static void main(String[] args) {
        // Initialization
        MinecraftServer minecraftServer = MinecraftServer.init();
        InstanceManager instanceManager = MinecraftServer.getInstanceManager();
        // Create the instance
        InstanceContainer instanceContainer = instanceManager.createInstanceContainer();
        // Set the ChunkGenerator
        instanceContainer.setGenerator(unit ->
                unit.modifier().fillHeight(0, 40, Block.GRASS_BLOCK));
        // Add an event callback to specify the spawning instance (and the spawn position)
        GlobalEventHandler globalEventHandler = MinecraftServer.getGlobalEventHandler();
        globalEventHandler.addListener(PlayerLoginEvent.class, event -> {
            final Player player = event.getPlayer();
            event.setSpawningInstance(instanceContainer);
            player.setRespawnPoint(new Pos(0, 42, 0));
        });
        // Start the server on port 25565
        minecraftServer.start("0.0.0.0", 25565);
        MinecraftServer.getCommandManager().register(new TestCommand(instanceContainer));
        MinecraftServer.getCommandManager().register(new GamemodeCommand());
        MySQL mySQL = new MySQL();
        MinigameInstanceHandler minigameInstanceHandler = new MinigameInstanceHandler();
    }
}