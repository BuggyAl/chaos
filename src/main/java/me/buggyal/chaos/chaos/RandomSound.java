package me.buggyal.chaos.chaos;

import me.buggyal.chaos.ChaosEvent;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;

public class RandomSound implements ChaosEvent {

    @Override
    public void run(Player player) {
        Sound sound = Sound.values()[random.nextInt(Sound.values().length)];
        float pitch = random.nextFloat() * 2;
        float volume = random.nextFloat() * 10;
        player.playSound(player.getLocation(), sound, SoundCategory.MASTER, volume, pitch);
    }

}
