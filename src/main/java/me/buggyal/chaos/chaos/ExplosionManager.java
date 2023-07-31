package me.buggyal.chaos.chaos;

import me.buggyal.chaos.ChaosManager;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExplosionPrimeEvent;

public class ExplosionManager implements Listener {

    @EventHandler
    public void onExplode(ExplosionPrimeEvent event) {
        if (!ChaosManager.isStarted()) { return; }

        if (ChaosManager.startTNT.contains(event.getEntity().getUniqueId())) {
            event.setRadius(event.getRadius() * 3);
        } else if (Nuke.nuke.equals(event.getEntity())) {
            event.setRadius(event.getRadius() * 5);
        } else {
            event.setRadius(event.getRadius() * 2);
        }

    }

}
