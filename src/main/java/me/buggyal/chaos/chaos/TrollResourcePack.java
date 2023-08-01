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
        player.setResourcePack("https://www.dropbox.com/scl/fo/4mr20o08njcl3qnxw1k0e/h?rlkey=fmkps25prfobvozvpqtxv8iz5&dl=1");
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
