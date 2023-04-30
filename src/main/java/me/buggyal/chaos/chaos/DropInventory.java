package me.buggyal.chaos.chaos;

import me.buggyal.chaos.ChaosEvent;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class DropInventory implements ChaosEvent {

    @Override
    public void run(Player player) {
        List<ItemStack> inventory = new ArrayList<>();
        for (ItemStack item : player.getInventory().getContents()) {
            if (item != null) {
                inventory.add(item);
            }
        }
        player.getInventory().clear();
        for (ItemStack item : inventory) {
            player.getWorld().dropItem(player.getLocation(), item);
        }
    }

}
