package kr.vanilage.bedwars;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Villager;
import org.jetbrains.annotations.NotNull;

public class MapSet implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender.isOp()) {
            for (Location i : Locations.SHOPS) {
                Villager entity = Locations.world.spawn(i, Villager.class);
                entity.setAI(false);
                entity.setInvulnerable(true);
                entity.setGravity(false);
                entity.setCustomName(ChatColor.GREEN + "상점");
                entity.setSilent(true);
            }
        }
        return false;
    }
}
