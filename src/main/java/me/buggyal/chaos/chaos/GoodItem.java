package me.buggyal.chaos.chaos;

import me.buggyal.chaos.ChaosEvent;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class GoodItem implements ChaosEvent {

    private static final List<ItemStack> goodItems = new ArrayList<>();
    private static boolean isInit = false;

    public static void init() {

        ItemStack knockbackStick = new ItemStack(Material.STICK);
        knockbackStick.addUnsafeEnchantment(Enchantment.KNOCKBACK, 10);
        goodItems.add(knockbackStick);

        goodItems.add(new ItemStack(Material.TOTEM_OF_UNDYING));

        goodItems.add(new ItemStack(Material.DIAMOND_HELMET));
        goodItems.add(new ItemStack(Material.DIAMOND_CHESTPLATE));
        goodItems.add(new ItemStack(Material.DIAMOND_LEGGINGS));
        goodItems.add(new ItemStack(Material.DIAMOND_BOOTS));
        goodItems.add(new ItemStack(Material.DIAMOND_SWORD));
        goodItems.add(new ItemStack(Material.DIAMOND_PICKAXE));
        goodItems.add(new ItemStack(Material.DIAMOND_AXE));
        goodItems.add(new ItemStack(Material.DIAMOND_SHOVEL));

        goodItems.add(new ItemStack(Material.GOLDEN_APPLE, 5));

        goodItems.add(new ItemStack(Material.ENDER_PEARL, 5));
        goodItems.add(new ItemStack(Material.BLAZE_ROD, 3));

        goodItems.add(new ItemStack(Material.BOW));
        goodItems.add(new ItemStack(Material.ARROW, 64));

        goodItems.add(new ItemStack(Material.OBSIDIAN, 4));

        goodItems.add(new ItemStack(Material.FLINT_AND_STEEL));

        goodItems.add(new ItemStack(Material.ENCHANTED_GOLDEN_APPLE));

        goodItems.add(new ItemStack(Material.COOKED_BEEF, 16));

        isInit = true;

    }


    @Override
    public void run(Player player) {
        if (!isInit) { init(); }
        if (goodItems.isEmpty()) {
            player.getInventory().addItem(new ItemStack(Material.DEAD_BUSH));
            return;
        }
        ItemStack item = goodItems.get(random.nextInt(goodItems.size()));
        goodItems.remove(item);
        player.getInventory().addItem(item);
    }

}
