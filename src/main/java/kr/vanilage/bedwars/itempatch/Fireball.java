package kr.vanilage.bedwars.itempatch;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class Fireball implements Listener {
    @EventHandler
    public void onRightClick(PlayerInteractEvent e) {
        if (e.getAction().isRightClick() && e.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.FIRE_CHARGE)) {
            e.setCancelled(true);
            e.getPlayer().getInventory().getItemInMainHand().setAmount(e.getPlayer().getInventory().getItemInMainHand().getAmount() - 1);
            org.bukkit.entity.Fireball fireball = e.getPlayer().launchProjectile(org.bukkit.entity.Fireball.class);
            fireball.setVelocity(e.getPlayer().getLocation().getDirection().multiply(2));
        }
    }
}
