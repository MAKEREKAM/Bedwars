package kr.vanilage.bedwars;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Random;

public class Start implements CommandExecutor {
    Random rd = new Random();
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender.isOp()) {
            if (Bukkit.getOnlinePlayers().size() >= 2) {
                ArrayList<Teams> list = new ArrayList<>();
                for (Teams i : Teams.values()) {
                    list.add(i);
                }

                for (Player i : Bukkit.getOnlinePlayers()) {
                    Teams team = list.get(rd.nextInt(list.size()));
                    Bedwars.team.put(team, i.getUniqueId());
                    Bedwars.teamUUID.put(i.getUniqueId(), team);
                    Bedwars.bedStatus.put(team, true);
                    Bedwars.teamStatus.put(team, true);
                    list.remove(team);
                    i.setPlayerListName(i.getName() + " " + team.name());
                    if (team.equals(Teams.RED)) Bedwars.spawnLocation.put(team, Locations.SpawnRed);
                    if (team.equals(Teams.BLUE)) Bedwars.spawnLocation.put(team, Locations.SpawnBlue);
                    if (team.equals(Teams.GREEN)) Bedwars.spawnLocation.put(team, Locations.SpawnGreen);
                    if (team.equals(Teams.YELLOW)) Bedwars.spawnLocation.put(team, Locations.SpawnYellow);
                    if (team.equals(Teams.AQUA)) Bedwars.spawnLocation.put(team, Locations.SpawnAqua);
                    if (team.equals(Teams.WHITE)) Bedwars.spawnLocation.put(team, Locations.SpawnWhite);
                    if (team.equals(Teams.PINK)) Bedwars.spawnLocation.put(team, Locations.SpawnPink);
                    if (team.equals(Teams.GRAY)) Bedwars.spawnLocation.put(team, Locations.SpawnGray);
                    i.teleport(Bedwars.spawnLocation.get(team));
                    ArmorSet.armorSet(i);
                }

                Bedwars.gaming = true;
                Bukkit.broadcastMessage(Messages.GAME_STARTED);
            }
        }
        return false;
    }
}
