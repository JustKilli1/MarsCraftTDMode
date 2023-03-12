package net.marscraft.towerdefense.instances;

import net.marscraft.general.logging.ILogger;
import net.marscraft.general.logging.LogLevel;
import net.marscraft.general.logging.files.FileHandler;
import net.marscraft.general.logging.logger.BaseConsoleLogger;
import net.minestom.server.entity.Player;
import net.minestom.server.instance.InstanceContainer;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MinigameInstanceHandler {

    private ILogger logger;
    private List<MinigameInstance> instances;
    private int instanceIdCounter;

    public MinigameInstanceHandler() {
        logger = new BaseConsoleLogger("MinigameInstanceHandler");
        instances = new ArrayList<>();
        instanceIdCounter = 0;
        createFolderStructure();
    }

    public void addInstance(MinigameInstance instance) {
        instances.add(instance);
    }

    public MinigameInstance addInstance(Player owner, InstanceContainer instance) {
        MinigameInstance minigameInstance = new MinigameInstance(getNextId(), owner, instance);
        addInstance(minigameInstance);
        return minigameInstance;
    }
    public void removeInstance(MinigameInstance instance) {
        instances.remove(instance);
    }

    public Optional<MinigameInstance> removeInstance(int id) {
        Optional<MinigameInstance> instance = getInstance(id);
        if(instance.isEmpty()) return instance;
        removeInstance(instance.get());
        return instance;
    }
    public Optional<MinigameInstance> removeInstance(Player player) {
        Optional<MinigameInstance> instance = getInstance(player);
        if(instance.isEmpty()) return instance;
        removeInstance(instance.get());
        return instance;
    }
    public Optional<MinigameInstance> getInstance(int id) {
        for(MinigameInstance instance : instances)
            if(instance.id() == id) return Optional.of(instance);
        return Optional.empty();
    }
    public Optional<MinigameInstance> getInstance(Player player) {
        for(MinigameInstance instance : instances)
            if(instance.owner().equals(player)) return Optional.of(instance);
        return Optional.empty();
    }
    public List<MinigameInstance> getInstances() {
        return instances;
    }

    private int getNextId() {
        return instanceIdCounter++;
    }

    private void createFolderStructure() {
        try {
            if(Files.createDirectories(Path.of("Instances/TowerDefense")) != null) logger.log(LogLevel.INFO, "Tower Defense Directory created.");
        } catch(Exception ex) {
            //Ignore
        }
    }
}
