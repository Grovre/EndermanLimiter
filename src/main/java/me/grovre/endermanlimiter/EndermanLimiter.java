package me.grovre.endermanlimiter;

import org.bukkit.plugin.java.JavaPlugin;

public final class EndermanLimiter extends JavaPlugin {

    private static EndermanLimiter plugin;

    public static EndermanLimiter getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        plugin = this;
        getServer().getPluginManager().registerEvents(new OnEntitySpawn(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
