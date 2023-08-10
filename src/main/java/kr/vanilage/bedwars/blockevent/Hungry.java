package kr.vanilage.bedwars.blockevent;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class Hungry implements Listener {
    @EventHandler
    public void onFoodLevel(FoodLevelChangeEvent e) {e.setCancelled(true);}
}
