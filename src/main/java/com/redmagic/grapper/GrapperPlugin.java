package com.redmagic.grapper;

import com.redmagic.grapper.command.grappelCommand;
import com.redmagic.grapper.listener.IntPlayer;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class GrapperPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getCommand("grappel").setExecutor(new grappelCommand(this));

        Bukkit.getPluginManager().registerEvents(new IntPlayer(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
