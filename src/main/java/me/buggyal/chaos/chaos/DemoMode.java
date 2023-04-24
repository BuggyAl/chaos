package me.buggyal.chaos.chaos;

import me.buggyal.chaos.ChaosEvent;
import org.bukkit.entity.Player;

public class DemoMode implements ChaosEvent {

    @Override
    public void run(Player player) {
        player.showDemoScreen();
    }

}
