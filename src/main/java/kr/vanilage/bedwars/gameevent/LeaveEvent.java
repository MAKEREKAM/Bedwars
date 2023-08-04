package kr.vanilage.bedwars.gameevent;

import kr.vanilage.bedwars.Bedwars;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveEvent implements Listener {
    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        if (Bedwars.gaming) {
            Bedwars.teamStatus.remove(Bedwars.teamUUID.get(e.getPlayer().getUniqueId()));
            Bedwars.teamStatus.remove(Bedwars.teamUUID.get(e.getPlayer().getUniqueId()), false);
        }
    }
}
