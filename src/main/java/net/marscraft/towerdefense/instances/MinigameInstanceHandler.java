package net.marscraft.towerdefense.instances;

import net.minestom.server.entity.Player;
import net.minestom.server.instance.InstanceContainer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MinigameInstanceHandler {

    private List<MinigameInstance> instances;
    private int instanceIdCounter;

    public MinigameInstanceHandler() {
        instances = new ArrayList<>();
        instanceIdCounter = 0;
        createFolderStructure();
    }

    public void addInstance(MinigameInstance instance) {
        instances.add(instance);
    }

    public void addInstance(Player owner, InstanceContainer instance) {
        addInstance(new MinigameInstance(getNextId(), owner, instance));
    }
    public void removeInstance(MinigameInstance instance) {
        instances.remove(instance);
    }

    public void removeInstance(int id) {
        Optional<MinigameInstance> instance = getInstance(id);
        if(instance.isEmpty()) return;
        removeInstance(instance.get());
    }
    public void removeInstance(Player player) {
        Optional<MinigameInstance> instance = getInstance(player);
        if(instance.isEmpty()) return;
        removeInstance(instance.get());
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
/*        FileHandler fileHandler = new FileHandler("Instances/TowerDefense");
        fileHandler.createFileWithDirectorys();*/
    }
}
