package kr.vanilage.bedwars.shop;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

public class OpenInventory implements Listener {
    @EventHandler
    public void onInteract(PlayerInteractAtEntityEvent e) {
        if (e.getRightClicked().getCustomName() != null && e.getRightClicked().getCustomName().equals(ChatColor.GREEN + "상점")) {
            e.setCancelled(true);
            e.getPlayer().openInventory(new InventoryGenerator().getInventory());
        }
    }

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        if (e.getEntity().getCustomName() != null && e.getEntity().getCustomName().equals(ChatColor.GREEN + "상점")) {
            e.setCancelled(true);
        }
    }
}
