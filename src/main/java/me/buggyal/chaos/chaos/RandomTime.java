package me.buggyal.chaos.chaos;

import me.buggyal.chaos.ChaosEvent;
import org.bukkit.entity.Player;

public class RandomTime implements ChaosEvent {

    @Override
    public void run(Player player) {
        player.getWorld().setTime(random.nextInt(24000));
    }

}
