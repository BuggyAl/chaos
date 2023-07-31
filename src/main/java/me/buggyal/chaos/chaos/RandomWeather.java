package me.buggyal.chaos.chaos;

import me.buggyal.chaos.ChaosEvent;
import org.bukkit.entity.Player;

public class RandomWeather implements ChaosEvent {

    @Override
    public void run(Player player) {
        switch (random.nextInt(3)) {
            case 0: // CLEAR WEATHER
                player.getWorld().setStorm(false);
                player.getWorld().setThundering(false);
                break;
            case 1: // RAIN
                player.getWorld().setStorm(true);
                player.getWorld().setThundering(false);
                break;
            case 2: // THUNDERSTORM
                player.getWorld().setStorm(true);
                player.getWorld().setThundering(true);
                break;
            default:
                break;
        }
    }

}
