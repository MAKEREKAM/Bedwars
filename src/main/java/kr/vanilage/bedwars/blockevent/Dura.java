package kr.vanilage.bedwars.blockevent;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemDamageEvent;

public class Dura implements Listener {
    @EventHandler
    public void onDura(PlayerItemDamageEvent e) {e.setCancelled(true);}
}
