package com.redmagic.grapper;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.FishingHook;
import net.minecraft.world.level.Level;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_20_R1.entity.CraftEntity;

public class FishingHookUtil {

    public CraftEntity spawnFish(Location location, CraftEntity entityhuman, Level world) {
        net.minecraft.world.entity.Entity hook = new FishingHook(e,world);
        world.addFreshEntity(hook);
        return hook.getBukkitEntity();
    }
}
