package me.buggyal.chaos.chaos;

import me.buggyal.chaos.ChaosEvent;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class RandomItem implements ChaosEvent {

    @Override
    public void run(Player player) {
        int randItem = random.nextInt(Material.values().length);
        int randAmount = random.nextInt(64) + 1;
        ItemStack item = new ItemStack(Material.values()[randItem], randAmount);
        player.getInventory().addItem(item);
    }

}

