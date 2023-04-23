package me.buggyal.chaos.chaos;

import me.buggyal.chaos.ChaosEvent;
import me.buggyal.chaos.ChaosManager;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExplosionPrimeEvent;
import org.bukkit.metadata.MetadataValue;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Nuke implements ChaosEvent, Listener {

    Location nukeLocation;
    private static final List<UUID> entityIds = new ArrayList<>();

    @Override
    public void run(Player player) {
        nukeLocation = player.getLocation();
        nukeLocation.setY(nukeLocation.getBlockY() + 100.0);
        TNTPrimed tnt = (TNTPrimed) player.getWorld().spawnEntity(player.getLocation(), EntityType.PRIMED_TNT);
        tnt.setFuseTicks(200);
        entityIds.add(tnt.getUniqueId());
    }

    @EventHandler
    public void onExplode(ExplosionPrimeEvent event) {
        if (ChaosManager.isStarted() && entityIds.contains(event.getEntity().getUniqueId())) {
            event.setRadius((event.getRadius() * 10));
        }
    }

    public static List<UUID> getEntityIds() {
        return entityIds;
    }

}
