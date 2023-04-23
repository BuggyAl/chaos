package me.buggyal.chaos.util;

import me.buggyal.chaos.Chaos;
import org.bukkit.ChatColor;

public class Chat {

    public static String format(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static void sendConsoleMessage(String message) {
        Chaos.getInstance().getServer().getConsoleSender().sendMessage(format(message));
    }

    public static void broadcast(String message) {
        Chaos.getInstance().getServer().broadcastMessage(format(message));
    }

}
