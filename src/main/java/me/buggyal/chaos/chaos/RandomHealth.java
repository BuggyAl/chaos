package me.buggyal.chaos.chaos;

import me.buggyal.chaos.ChaosEvent;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;

public class RandomHealth implements ChaosEvent {

    @Override
    public void run(Player player) {
        player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(random.nextInt(20) + 1);
    }

}
