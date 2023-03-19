package net.marscraft.towerdefense.entities.ai.goal;

import net.minestom.server.coordinate.Pos;
import net.minestom.server.coordinate.Vec;
import net.minestom.server.entity.EntityCreature;
import net.minestom.server.entity.ai.GoalSelector;
import net.minestom.server.instance.Instance;
import net.minestom.server.instance.InstanceContainer;
import net.minestom.server.instance.block.Block;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PathGoalSelector extends GoalSelector {


    private static final long DELAY = 2500;
    private final Random random = new Random();
    private List<Pos> path;

    private long lastStroll;

    public PathGoalSelector(EntityCreature entityCreature) {
        super(entityCreature);
        path = new ArrayList<>();
    }

    @Override
    public boolean shouldStart() {
        return System.currentTimeMillis() - lastStroll >= DELAY;
    }

    @Override
    public void start() {
        final Pos target = entityCreature.getPosition().add(new Pos(0, 40, 10));
        boolean result = entityCreature.getNavigator().setPathTo(target);
        System.out.println(result);
    }

    @Override
    public void tick(long time) {
    }

    @Override
    public boolean shouldEnd() {
        return true;
    }

    @Override
    public void end() {
        this.lastStroll = System.currentTimeMillis();
    }

    private static List<Vec> getNearbyBlocks(int radius) {
        List<Vec> blocks = new ArrayList<>();
        for (int x = -radius; x <= radius; x++) {
            for (int y = -radius; y <= radius; y++) {
                for (int z = -radius; z <= radius; z++) {
                    blocks.add(new Vec(x, y, z));
                }
            }
        }
        return blocks;
    }

    public void setPath(List<Pos> path) {
        this.path = path;
    }

}
