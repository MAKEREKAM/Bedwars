package kr.vanilage.bedwars.gameevent;

import kr.vanilage.bedwars.ArmorSet;
import kr.vanilage.bedwars.Bedwars;
import kr.vanilage.bedwars.Messages;
import kr.vanilage.bedwars.Teams;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class KillEvent implements Listener {
    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        e.getDrops().clear();

        if (Bedwars.gaming) {
            if (!Bedwars.bedStatus.get(Bedwars.teamUUID.get(e.getPlayer().getUniqueId()))) {
                Bukkit.broadcastMessage(String.format(Messages.TEAM_ELIMINATED, Bedwars.teamUUID.get(e.getPlayer()).name()));
                Bedwars.teamStatus.remove(Bedwars.teamUUID.get(e.getPlayer()));
                Bedwars.teamStatus.put(Bedwars.teamUUID.get(e.getPlayer()), false);

                for (Teams i : Bedwars.teamStatus.keySet()) {
                    if (Bedwars.teamStatus.get(i)) {
                        return;
                    }
                }

                Bedwars.gaming = false;
                Bukkit.broadcastMessage(Messages.GAME_ENDED);
            }
        }
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent e) {
        if (Bedwars.gaming) {
            e.getPlayer().setGameMode(GameMode.SPECTATOR);
            if (Bedwars.teamStatus.get(Bedwars.teamUUID.get(e.getPlayer().getUniqueId()))) {
                Bukkit.getScheduler().runTaskLater(Bedwars.getPlugin(Bedwars.class), new Runnable() {
                    @Override
                    public void run() {
                        e.getPlayer().teleport(Bedwars.spawnLocation.get(Bedwars.teamUUID.get(e.getPlayer().getUniqueId())));
                        e.getPlayer().setGameMode(GameMode.SURVIVAL);
                        ArmorSet.armorSet(e.getPlayer());
                    }
                }, 100);
            }
        }
    }
}
