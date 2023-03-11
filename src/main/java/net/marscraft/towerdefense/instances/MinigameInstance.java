package net.marscraft.towerdefense.instances;

import net.minestom.server.entity.Player;
import net.minestom.server.instance.InstanceContainer;

public record MinigameInstance(int id, Player owner, InstanceContainer instanceContainer) {
    @Override
    public String toString() {
        return id + ". " + owner.getName();
    }
}
