package me.buggyal.chaos.chaos;

import me.buggyal.chaos.ChaosEvent;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class RandomLaunch implements ChaosEvent {

    @Override
    public void run(Player player) {
        Vector velocity = player.getVelocity();
        velocity.setX(random.nextInt(41) - 20);
        velocity.setY(random.nextInt(41) - 20);
        velocity.setZ(random.nextInt(41) - 20);
        player.setVelocity(velocity);
    }

}
