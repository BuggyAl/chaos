package me.buggyal.chaos.chaos;

import me.buggyal.chaos.ChaosEvent;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class RandomEnchant implements ChaosEvent {

    @Override
    public void run(Player player) {

        ItemStack item = player.getInventory().getItemInMainHand();
        if (item.getType() == Material.AIR) { return; }

        Enchantment randomEnchant = Enchantment.values()[random.nextInt(Enchantment.values().length)];
        item.addUnsafeEnchantment(randomEnchant, random.nextInt(10) + 1);

    }

}
