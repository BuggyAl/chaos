package me.buggyal.chaos.chaos;

import com.sun.tools.javac.jvm.Items;
import me.buggyal.chaos.ChaosEvent;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class PumpkinHelmet implements ChaosEvent {

    @Override
    public void run(Player player) {
        player.getInventory().setHelmet(new ItemStack(Material.CARVED_PUMPKIN));
    }

}
