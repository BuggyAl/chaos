package me.buggyal.chaos.chaos;

import me.buggyal.chaos.ChaosEvent;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;

import java.util.Objects;

public class RandomHealth implements ChaosEvent {

    @Override
    public void run(Player player) {
        Objects.requireNonNull(player.getAttribute(Attribute.GENERIC_MAX_HEALTH)).setBaseValue(random.nextInt(30) + 1);
    }

}
