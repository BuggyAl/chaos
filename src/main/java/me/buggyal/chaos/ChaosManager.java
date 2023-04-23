package me.buggyal.chaos;

import me.buggyal.chaos.util.Chat;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class ChaosManager implements Listener {

    static boolean started = false;
    static Player gamePlayer;
    static Random random = new Random();

    public static List<UUID> startTNT = new ArrayList<>();

    public static Player getGamePlayer() {
        return gamePlayer;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent joinEvent) {
        if (joinEvent.getPlayer().getName().equals("BuggyAl")) {
            gamePlayer = joinEvent.getPlayer();
        }
    }

    public static boolean isStarted() {
        return started;
    }

    @EventHandler
    public void onBegin(AsyncPlayerChatEvent chatEvent) {
        if (gamePlayer != null && chatEvent.getMessage().equalsIgnoreCase("subscribe to wheateneye") && !started) {
            started = true;
            chatEvent.setMessage("subscribe to BuggyAl");
            new BukkitRunnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        TNTPrimed tnt = (TNTPrimed) gamePlayer.getWorld().spawnEntity(gamePlayer.getLocation(), EntityType.PRIMED_TNT);
                        tnt.setFuseTicks(5);
                        startTNT.add(tnt.getUniqueId());
                    }
                    beginChaos();
                }
            }.runTaskLater(Chaos.getInstance(), 20L * 10L);
        } else if (gamePlayer == null) {
            chatEvent.getPlayer().sendMessage(Chat.format("&4WheatenEye &chas not joined the game! &7(or the code is broken)"));
        }
    }

    public static void beginChaos() {
        List<ChaosEvent> chaosEvents = new ArrayList<>();
        Reflections reflections = new Reflections(Chaos.getInstance().getClass().getPackage().getName());
        for (Class<?> clazz : reflections.getSubTypesOf(ChaosEvent.class)) {
            try {
                chaosEvents.add((ChaosEvent) clazz.getDeclaredConstructor().newInstance());
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                e.printStackTrace();
            }
        }

        Chaos.getInstance().getServer().getScheduler().scheduleSyncRepeatingTask(Chaos.getInstance(), () -> {
            ChaosEvent event = chaosEvents.get(random.nextInt(chaosEvents.size()));
            Chat.sendConsoleMessage("&6[Chaos] &cRunning event: " + event.getClass().getSimpleName());
            event.run(gamePlayer);
        },  20L * 60L, 20L * 60L);

    }

}
