package me.buggyal.chaos.chaos;

import me.buggyal.chaos.ChaosEvent;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;

public class Nuke implements ChaosEvent {

    private static final int NUKE_FUSE_SECONDS = 10; // seconds before the TNT explodes
    public static TNTPrimed nuke;

    @Override
    public void run(Player player) {
        nuke = (TNTPrimed) player.getWorld().spawnEntity(player.getLocation().add(0, 100, 0), EntityType.PRIMED_TNT);
        nuke.setFuseTicks(20 * NUKE_FUSE_SECONDS);
        player.playSound(player.getLocation(), Sound.BLOCK_BELL_RESONATE, 10F, 1);
    }

}
