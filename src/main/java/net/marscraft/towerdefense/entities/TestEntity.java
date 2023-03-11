package net.marscraft.towerdefense.entities;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.marscraft.towerdefense.entities.ai.goal.PathGoalSelector;
import net.minestom.server.coordinate.Pos;
import net.minestom.server.entity.EntityCreature;
import net.minestom.server.entity.EntityType;
import net.minestom.server.entity.ai.EntityAIGroup;
import net.minestom.server.entity.ai.EntityAIGroupBuilder;
import net.minestom.server.entity.ai.TargetSelector;
import net.minestom.server.entity.ai.goal.RandomLookAroundGoal;
import net.minestom.server.entity.ai.goal.RandomStrollGoal;
import net.minestom.server.entity.metadata.monster.skeleton.SkeletonMeta;
import net.minestom.server.instance.EntityTracker;

public class TestEntity extends EntityCreature {

    public TestEntity() {
        super(EntityType.SKELETON);
        SkeletonMeta meta = (SkeletonMeta) getEntityMeta();
        meta.setNotifyAboutChanges(false);
        meta.setOnFire(true);
        meta.setHealth(200);
        meta.setCustomNameVisible(true);
        meta.setCustomName(Component.text("Bogenschuetze", NamedTextColor.RED));
        meta.setNotifyAboutChanges(true);
        addAIGroup(new EntityAIGroupBuilder()
                .addGoalSelector(new RandomLookAroundGoal(this, 20))
                .addGoalSelector(new PathGoalSelector(this))
                .build());
        setAutoViewable(true);

    }
}
