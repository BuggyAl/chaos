package me.buggyal.chaos.chaos;

import me.buggyal.chaos.ChaosEvent;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.Collections;

public class InventoryFlip implements ChaosEvent {

    @Override
    public void run(Player player) {
        // randomly switch items in the player's inventory
        Inventory inventory = player.getInventory();
        ItemStack[] contents = inventory.getContents();
        Collections.shuffle(Arrays.asList(contents));
        inventory.setContents(contents);
    }

}
