package me.buggyal.chaos.chaos;

import me.buggyal.chaos.ChaosEvent;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class RandomEntity implements ChaosEvent {

    @Override
    public void run(Player player) {
        EntityType entity = EntityType.values()[random.nextInt(EntityType.values().length)];
        while (!isRealMob(entity)) { entity = EntityType.values()[random.nextInt(EntityType.values().length)]; }
        int amount = random.nextInt(10) + 1;
        for (int i = 0; i < amount; i++) {
            player.getWorld().spawnEntity(player.getLocation(), entity);
        }
    }

    public boolean isRealMob(EntityType e) {
        return e != EntityType.AREA_EFFECT_CLOUD && e != EntityType.ARMOR_STAND && e != EntityType.ARROW &&
                e != EntityType.BLOCK_DISPLAY && e != EntityType.DROPPED_ITEM && e != EntityType.EGG &&
                e != EntityType.ENDER_CRYSTAL && e != EntityType.ENDER_DRAGON && e != EntityType.ENDER_PEARL &&
                e != EntityType.ENDER_SIGNAL && e != EntityType.FISHING_HOOK && e != EntityType.GLOW_ITEM_FRAME &&
                e != EntityType.INTERACTION && e != EntityType.ITEM_DISPLAY && e != EntityType.ITEM_FRAME &&
                e != EntityType.LEASH_HITCH && e != EntityType.MARKER && e != EntityType.PAINTING &&
                e != EntityType.PLAYER && e != EntityType.SPECTRAL_ARROW && e != EntityType.SPLASH_POTION &&
                e != EntityType.TEXT_DISPLAY && e != EntityType.PRIMED_TNT && e != EntityType.UNKNOWN;
    }

}
