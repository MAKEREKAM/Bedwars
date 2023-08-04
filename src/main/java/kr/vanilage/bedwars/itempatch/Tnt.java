package kr.vanilage.bedwars.itempatch;

import kr.vanilage.bedwars.Bedwars;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class Tnt implements Listener {
    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        if (e.getBlock().getType().equals(Material.TNT)) {
            e.getPlayer().getInventory().getItemInMainHand().setAmount(e.getPlayer().getInventory().getItemInMainHand().getAmount() - 1);
            e.getBlock().getWorld().spawn(e.getBlock().getLocation().add(new Location(e.getBlock().getWorld(), 0.5, 0, 0.5)), TNTPrimed.class);
            Bukkit.getScheduler().scheduleSyncDelayedTask(Bedwars.getPlugin(Bedwars.class), new Runnable() {
                @Override
                public void run() {
                    e.getBlock().setType(Material.AIR);
                }
            }, 1);
        }
    }
}
