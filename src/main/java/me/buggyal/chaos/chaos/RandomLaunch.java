package me.buggyal.chaos.chaos;

import me.buggyal.chaos.ChaosEvent;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class RandomLaunch implements ChaosEvent {

    @Override
    public void run(Player player) {
        Vector velocity = player.getVelocity();
        velocity.setX(random.nextInt(5) - 2.5);
        velocity.setY(random.nextInt(5));
        velocity.setZ(random.nextInt(5) - 2.5);
        player.setVelocity(velocity);
    }

}
