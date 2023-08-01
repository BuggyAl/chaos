package me.buggyal.chaos;

import me.buggyal.chaos.util.Chat;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;

public final class Chaos extends JavaPlugin {

    public static final boolean DEV_MODE = true;

    private static Chaos instance;

    public static Chaos getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        registerListeners();
        Chat.sendConsoleMessage("&6[Chaos] &cLet the chaos begin!");
    }

    @Override
    public void onDisable() {
        Chat.sendConsoleMessage("&6[Chaos] &cThe chaos is over... for now...");
    }

    public void registerListeners() {
        Reflections reflections = new Reflections(this.getClass().getPackage().getName());
        for (Class<?> clazz : reflections.getSubTypesOf(Listener.class)) {
            try {
                Bukkit.getPluginManager().registerEvents((Listener) clazz.getDeclaredConstructor().newInstance(), this);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        Chat.sendConsoleMessage("&6[Chaos] &aAll listeners registered!");
    }

}
