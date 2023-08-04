package kr.vanilage.bedwars.gameevent;

import kr.vanilage.bedwars.Bedwars;
import kr.vanilage.bedwars.Locations;
import kr.vanilage.bedwars.Messages;
import kr.vanilage.bedwars.Teams;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BedBreakEvent implements Listener {
    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        if (!Bedwars.gaming) {
            e.setCancelled(true);
        }

        if (e.getBlock().getType().equals(Material.RED_BED)) {
            e.setDropItems(false);
            Location location = e.getBlock().getLocation();
            for (Location i : Locations.BedRed) {
                if (Bedwars.bedStatus.containsKey(Teams.RED)) {
                    if (i.equals(location)) {
                        Bukkit.broadcastMessage(String.format(Messages.BED_BROKEN, "RED"));
                        Bedwars.bedStatus.remove(Teams.RED);
                        Bedwars.bedStatus.put(Teams.RED, false);
                    }
                }
            }

            for (Location i : Locations.BedBlue) {
                if (Bedwars.bedStatus.containsKey(Teams.BLUE)) {
                    if (i.equals(location)) {
                        Bukkit.broadcastMessage(String.format(Messages.BED_BROKEN, "BLUE"));
                        Bedwars.bedStatus.remove(Teams.BLUE);
                        Bedwars.bedStatus.put(Teams.BLUE, false);
                    }
                }
            }

            for (Location i : Locations.BedGreen) {
                if (Bedwars.bedStatus.containsKey(Teams.GREEN)) {
                    if (i.equals(location)) {
                        Bukkit.broadcastMessage(String.format(Messages.BED_BROKEN, "GREEN"));
                        Bedwars.bedStatus.remove(Teams.GREEN);
                        Bedwars.bedStatus.put(Teams.GREEN, false);
                    }
                }
            }

            for (Location i : Locations.BedYellow) {
                if (Bedwars.bedStatus.containsKey(Teams.YELLOW)) {
                    if (i.equals(location)) {
                        Bukkit.broadcastMessage(String.format(Messages.BED_BROKEN, "YELLOW"));
                        Bedwars.bedStatus.remove(Teams.YELLOW);
                        Bedwars.bedStatus.put(Teams.YELLOW, false);
                    }
                }
            }

            for (Location i : Locations.BedAqua) {
                if (Bedwars.bedStatus.containsKey(Teams.AQUA)) {
                    if (i.equals(location)) {
                        Bukkit.broadcastMessage(String.format(Messages.BED_BROKEN, "AQUA"));
                        Bedwars.bedStatus.remove(Teams.AQUA);
                        Bedwars.bedStatus.put(Teams.AQUA, false);
                    }
                }
            }

            for (Location i : Locations.BedWhite) {
                if (Bedwars.bedStatus.containsKey(Teams.WHITE)) {
                    if (i.equals(location)) {
                        Bukkit.broadcastMessage(String.format(Messages.BED_BROKEN, "WHITE"));
                        Bedwars.bedStatus.remove(Teams.WHITE);
                        Bedwars.bedStatus.put(Teams.WHITE, false);
                    }
                }
            }

            for (Location i : Locations.BedPink) {
                if (Bedwars.bedStatus.containsKey(Teams.PINK)) {
                    if (i.equals(location)) {
                        Bukkit.broadcastMessage(String.format(Messages.BED_BROKEN, "PINK"));
                        Bedwars.bedStatus.remove(Teams.PINK);
                        Bedwars.bedStatus.put(Teams.PINK, false);
                    }
                }
            }

            for (Location i : Locations.BedGray) {
                if (Bedwars.bedStatus.containsKey(Teams.GRAY)) {
                    if (i.equals(location)) {
                        Bukkit.broadcastMessage(String.format(Messages.BED_BROKEN, "GRAY"));
                        Bedwars.bedStatus.remove(Teams.GRAY);
                        Bedwars.bedStatus.put(Teams.GRAY, false);
                    }
                }
            }
        }
    }
}
