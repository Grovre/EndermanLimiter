package me.grovre.endermanlimiter;

import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class OnEntitySpawn implements Listener {

    @EventHandler
    public void OnEntitySpawnInWorld(EntitySpawnEvent event) {
        FileConfiguration config = EndermanLimiter.getPlugin().getConfig();
        Entity entity = event.getEntity();
        World world = entity.getWorld();
        if(world.getEnvironment() == World.Environment.THE_END) {
            if(entity instanceof Enderman) {
                double percentageToKeep = config.getDouble("PercentageOfEndermenToKeep");
                if(Math.random() > percentageToKeep) {
                    event.setCancelled(true);
                }
            }
        }
    }

}
