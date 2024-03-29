package me.buggyal.chaos.chaos;

import me.buggyal.chaos.ChaosEvent;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

public class RandomEffect implements ChaosEvent {

    @Override
    public void run(Player player) {
        int randEffect = random.nextInt(PotionEffectType.values().length);
        int randDuration = random.nextInt(90) + 30;
        int randAmplifier = random.nextInt(10);
        player.addPotionEffect(PotionEffectType.values()[randEffect].createEffect(20 * randDuration, randAmplifier));
    }

}
