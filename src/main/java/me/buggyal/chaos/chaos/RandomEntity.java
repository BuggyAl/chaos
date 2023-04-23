package me.buggyal.chaos.chaos;

import me.buggyal.chaos.ChaosEvent;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class RandomEntity implements ChaosEvent {

    @Override
    public void run(Player player) {
        EntityType entity = EntityType.values()[random.nextInt(EntityType.values().length)];
        int amount = random.nextInt(10) + 1;
        for (int i = 0; i < amount; i++) {
            player.getWorld().spawnEntity(player.getLocation(), entity);
        }
    }

}
