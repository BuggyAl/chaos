package me.buggyal.chaos.chaos;

import me.buggyal.chaos.ChaosEvent;
import me.buggyal.chaos.util.Chat;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class MLG implements ChaosEvent {

    @Override
    public void run(Player player) {
        player.getInventory().setItemInOffHand(new ItemStack(Material.WATER_BUCKET));
        Location loc = player.getLocation();
        loc.setY(500);
        player.teleport(loc);
    }

}
