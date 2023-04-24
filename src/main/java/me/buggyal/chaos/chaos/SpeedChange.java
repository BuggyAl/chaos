package me.buggyal.chaos.chaos;

import me.buggyal.chaos.ChaosEvent;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

public class SpeedChange implements ChaosEvent {

    @Override
    public void run(Player player) {
        if (random.nextBoolean()) {
            player.addPotionEffect(PotionEffectType.SPEED.createEffect(random.nextInt(105) + 15, 9));
        } else {
            player.addPotionEffect(PotionEffectType.SLOW.createEffect(random.nextInt(105) + 15, 9));
        }
    }

}
