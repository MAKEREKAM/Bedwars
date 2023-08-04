package kr.vanilage.bedwars.blockevent;

import kr.vanilage.bedwars.Messages;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;

public class MakeEvent implements Listener {
    @EventHandler
    public void onMake(CraftItemEvent e) {
        e.setCancelled(true);
        e.getWhoClicked().sendMessage(Messages.UNMAKEABLE);
    }
}
