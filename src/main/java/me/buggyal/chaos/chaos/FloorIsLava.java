package me.buggyal.chaos.chaos;

import me.buggyal.chaos.ChaosEvent;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class FloorIsLava implements ChaosEvent {

    public static List<Block> getNearbyBlocks(Location location, int radius) {
        List<Block> blocks = new ArrayList<>();
        for (int x = location.getBlockX() - radius; x <= location.getBlockX() + radius; x++) {
            for (int y = location.getBlockY() - radius; y <= location.getBlockY() + radius; y++) {
                for (int z = location.getBlockZ() - 3; z <= location.getBlockZ() + 3; z++) {
                    Block block = location.getWorld().getBlockAt(x, y, z);
                    if (block.getType() != Material.AIR && !block.isPassable()) {
                        blocks.add(block);
                    }
                }
            }
        }
        return blocks;
    }

    @Override
    public void run(Player player) {
        List<Block> blocks = getNearbyBlocks(player.getLocation(), 25);
        for (Block block : blocks) {
            if (random.nextInt(10) == 0) {
                block.setType(org.bukkit.Material.LAVA);
            }
        }
    }

}
