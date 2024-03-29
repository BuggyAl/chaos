package me.buggyal.chaos;

import me.buggyal.chaos.chaos.Nuke;
import me.buggyal.chaos.util.Chat;
import org.bukkit.GameMode;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.scheduler.BukkitRunnable;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class ChaosManager implements Listener {

    public static List<UUID> startTNT = new ArrayList<>();
    static boolean started = false;
    static Random random = new Random();

    public static boolean isStarted() {
        return started;
    }

    public static void beginChaos() {
        List<ChaosEvent> chaosEvents = new ArrayList<>();

        // DEBUG SPECIFIC EVENT
//        try {
//            chaosEvents.add(TrollResourcePack.class.getDeclaredConstructor().newInstance());
//        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
//            throw new RuntimeException(e);
//        }

        Reflections reflections = new Reflections(Chaos.getInstance().getClass().getPackage().getName());
        for (Class<?> clazz : reflections.getSubTypesOf(ChaosEvent.class)) {
            try {
                chaosEvents.add((ChaosEvent) clazz.getDeclaredConstructor().newInstance());
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                e.printStackTrace();
            }
        }

        long initialDelaySeconds = 60;
        long delaySeconds = 30;

        if (Chaos.DEV_MODE) {
            initialDelaySeconds = 5;
            delaySeconds = 10;
        }

        Chaos.getInstance().getServer().getScheduler().scheduleSyncRepeatingTask(Chaos.getInstance(), () -> {
            ChaosEvent event = chaosEvents.get(random.nextInt(chaosEvents.size()));
            Chat.sendConsoleMessage("&6[Chaos] &cRunning event: " + event.getClass().getSimpleName());
            for (Player player : Chaos.getInstance().getServer().getOnlinePlayers()) {
                if (player.getGameMode() == GameMode.SURVIVAL && !isVanished(player)) {
                    event.run(player);
                }
            }

            if (event instanceof Nuke) {
                Chat.broadcast("&8<&6!&8> &4&lDANGER &8<&6!&8> &cNuke detected! Take cover!");
            }

        }, 20L * initialDelaySeconds, 20L * delaySeconds);

    }

    private static boolean isVanished(Player player) {
        for (MetadataValue meta : player.getMetadata("vanished")) {
            if (meta.asBoolean()) return true;
        }
        return false;
    }

    @EventHandler
    public void onBegin(AsyncPlayerChatEvent chatEvent) {
        if (chatEvent.getMessage().equalsIgnoreCase("subscribe to wheateneye") && !started) {
            started = true;
            chatEvent.setMessage("subscribe to BuggyAl");

            if (Chaos.DEV_MODE) {
                beginChaos();
                return;
            }

            new BukkitRunnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        for (Player player : Chaos.getInstance().getServer().getOnlinePlayers()) {
                            TNTPrimed tnt = (TNTPrimed) player.getWorld().spawnEntity(player.getLocation(), EntityType.PRIMED_TNT);
                            tnt.setFuseTicks(5);
                            startTNT.add(tnt.getUniqueId());
                        }
                    }
                    beginChaos();
                }
            }.runTaskLater(Chaos.getInstance(), 20L * 5L);
        }
    }

}
