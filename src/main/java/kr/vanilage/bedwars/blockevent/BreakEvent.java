package kr.vanilage.bedwars.blockevent;

import kr.vanilage.bedwars.Bedwars;
import kr.vanilage.bedwars.Messages;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityExplodeEvent;

public class BreakEvent implements Listener {
    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        if (e.getBlock().getType().equals(Material.MAGENTA_WOOL) || e.getBlock().getType().equals(Material.CHERRY_PLANKS) || e.getBlock().getType().equals(Material.END_STONE) || e.getBlock().getType().name().endsWith("_BED") || e.getPlayer().isOp()) {
            return;
        }

        e.setCancelled(true);
        e.getPlayer().sendMessage(Messages.BLOCK_UNBREAKABLE);
    }

    @EventHandler
    public void onExplosion(EntityExplodeEvent e) {
        for (Block b : e.blockList()) {
            if (!(b.getType().equals(Material.MAGENTA_WOOL) || b.getType().equals(Material.CHERRY_PLANKS) || b.getType().equals(Material.END_STONE))) {
                final BlockState state = b.getState();

                b.setType(Material.AIR);

                int delay = 0;

                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bedwars.getPlugin(Bedwars.class), new Runnable() {
                    public void run() {
                        state.update(true, false);
                    }
                }, delay);
            }
        }
    }
}
