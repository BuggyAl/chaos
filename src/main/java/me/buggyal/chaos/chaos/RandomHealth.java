package me.buggyal.chaos.chaos;

import me.buggyal.chaos.ChaosEvent;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.Objects;

public class RandomHealth implements ChaosEvent, Listener {

    @Override
    public void run(Player player) {
        Objects.requireNonNull(player.getAttribute(Attribute.GENERIC_MAX_HEALTH)).setBaseValue(random.nextInt(25) + 5);
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent deathEvent) {
        Player player = deathEvent.getEntity();
        player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20);
    }

}
