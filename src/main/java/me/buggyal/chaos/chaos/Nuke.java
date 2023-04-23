package me.buggyal.chaos.chaos;

import me.buggyal.chaos.ChaosEvent;
import me.buggyal.chaos.ChaosManager;
import me.buggyal.chaos.util.Chat;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExplosionPrimeEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Nuke implements ChaosEvent, Listener {

    private static final List<UUID> entityIds = new ArrayList<>();
    Location nukeLocation;

    public static List<UUID> getEntityIds() {
        return entityIds;
    }

    @Override
    public void run(Player player) {
        nukeLocation = player.getLocation();
        nukeLocation.setY(nukeLocation.getBlockY() + 100.0);
        TNTPrimed tnt = (TNTPrimed) player.getWorld().spawnEntity(nukeLocation, EntityType.PRIMED_TNT);
        tnt.setFuseTicks(200);
        entityIds.add(tnt.getUniqueId());
        player.sendMessage(Chat.format("&4&lWARNING &7- &c&lNUKE DETECTED, TAKE COVER"));
    }

    @EventHandler
    public void onExplode(ExplosionPrimeEvent event) {
        if (ChaosManager.isStarted() && entityIds.contains(event.getEntity().getUniqueId())) {
            event.setRadius((event.getRadius() * 10));
        }
    }

}
