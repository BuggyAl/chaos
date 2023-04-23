package me.buggyal.chaos;

import org.bukkit.entity.Player;

import java.util.Random;

public interface ChaosEvent {

    Random random = new Random();

    void run(Player player);

}
