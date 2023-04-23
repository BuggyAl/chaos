package me.buggyal.chaos.chaos;

import me.buggyal.chaos.ChaosEvent;
import org.bukkit.entity.Player;

public class WeatherChange implements ChaosEvent {

    @Override
    public void run(Player player) {
        int weather = random.nextInt(3);
        if (weather == 0) {
            player.getWorld().setStorm(true);
        } else if (weather == 1) {
            player.getWorld().setThundering(true);
        } else {
            player.getWorld().setStorm(false);
            player.getWorld().setThundering(false);
        }
    }

}
