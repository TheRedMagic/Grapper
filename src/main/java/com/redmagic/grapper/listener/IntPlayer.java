package com.redmagic.grapper.listener;

import net.minecraft.world.entity.projectile.FishingHook;
import org.bukkit.Material;
import org.bukkit.entity.FishHook;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class IntPlayer implements Listener {

    @EventHandler
    public void onin(PlayerInteractEvent e){
        if (e.getItem().getType().equals(Material.LEAD)){
            if (e.getAction().equals(Action.LEFT_CLICK_AIR) || e.getAction().equals(Action.LEFT_CLICK_BLOCK)){
                e.getPlayer().launchProjectile();
            }
        }
    }

}
