package com.redmagic.grapper.command;

import com.redmagic.grapper.GrapperPlugin;
import com.redmagic.grapper.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class grappelCommand implements CommandExecutor {

    private final Map<UUID, Integer> cooldownMap = new HashMap<>();
    private final GrapperPlugin plugin;

    public grappelCommand(GrapperPlugin plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player){

            Player player = (Player) commandSender;

            if (cooldownMap.containsKey(player.getUniqueId())){

                player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                        plugin.getConfig().getString("messages.prefix") +

                        plugin.getConfig().getString("messages.cooldown").replace("{seconds}",
                                cooldownMap.get(player.getUniqueId()).toString())));

                return false;
            }

            ItemStack stack = new ItemBuilder(Material.LEAD)
                    .setCustomModelData(1)
                    .setName("Grappel")
                    .setLore(Arrays.asList(ChatColor.GRAY + "Left-Click to shot grappel."))
                    .build();

            player.getInventory().addItem(stack);




            new BukkitRunnable() {
                int timer = plugin.getConfig().getInt("command-cooldown");
                @Override
                public void run() {
                    if (timer != 0){
                        timer--;
                        cooldownMap.put(player.getUniqueId(), timer);
                    }else {
                        cooldownMap.remove(player.getUniqueId());
                    }
                }
            }.runTaskTimer(plugin, 0, 20);


        }else {
            Bukkit.getLogger().info("This is a player command");
        }
        return false;
    }
}
