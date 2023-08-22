package me.buggyal.chaos.chaos;

import me.buggyal.chaos.ChaosEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerResourcePackStatusEvent;

public class TrollResourcePack implements ChaosEvent, Listener {

    public static boolean isLoaded = false;

    @Override
    public void run(Player player) {
        if (isLoaded) { return; }
        player.setResourcePack("https://texture-packs.com/wp-content/uploads/2022/04/Moving-Blocks-1.19.X.zip");
    }

    @EventHandler
    public void onResourcePackDecline(PlayerResourcePackStatusEvent packStatusEvent) {
        if (packStatusEvent.getStatus() == PlayerResourcePackStatusEvent.Status.DECLINED) {
            Player player = packStatusEvent.getPlayer();
            player.setHealthScale(Math.ceil(player.getHealthScale() / 2));
            player.setHealth(0);
        } else if (packStatusEvent.getStatus() == PlayerResourcePackStatusEvent.Status.SUCCESSFULLY_LOADED) {
            isLoaded = true;
        }
    }

}
