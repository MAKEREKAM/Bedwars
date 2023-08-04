package kr.vanilage.bedwars;

import kr.vanilage.bedwars.blockevent.BreakEvent;
import kr.vanilage.bedwars.blockevent.ClickBed;
import kr.vanilage.bedwars.blockevent.MakeEvent;
import kr.vanilage.bedwars.gameevent.BedBreakEvent;
import kr.vanilage.bedwars.gameevent.KillEvent;
import kr.vanilage.bedwars.gameevent.LeaveEvent;
import kr.vanilage.bedwars.itempatch.Fireball;
import kr.vanilage.bedwars.itempatch.Tnt;
import kr.vanilage.bedwars.shop.ItemStackGenerator;
import kr.vanilage.bedwars.shop.OpenInventory;
import kr.vanilage.bedwars.shop.UsingShop;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public final class Bedwars extends JavaPlugin {
    public static HashMap<Teams, Boolean> bedStatus = null;
    public static HashMap<Teams, UUID> team = null;
    public static HashMap<UUID, Teams> teamUUID = null;
    public static HashMap<Teams, Boolean> teamStatus = null;
    public static ArrayList<UUID> sharpness = null;
    public static HashMap<UUID, Integer> protect = null;
    public static ArrayList<UUID> ironArmor = null;
    public static HashMap<Teams, Location> spawnLocation = null;
    public static boolean gaming = false;


    @Override
    public void onEnable() {
        bedStatus = new HashMap<>();
        team = new HashMap<>();
        teamStatus = new HashMap<>();
        teamUUID = new HashMap<>();
        sharpness = new ArrayList<>();
        protect = new HashMap<>();
        ironArmor = new ArrayList<>();
        spawnLocation = new HashMap<>();
        gaming = false;

        Bukkit.getPluginManager().registerEvents(new MakeEvent(), this);
        Bukkit.getPluginManager().registerEvents(new BreakEvent(), this);
        Bukkit.getPluginManager().registerEvents(new Fireball(), this);
        Bukkit.getPluginManager().registerEvents(new Tnt(), this);
        Bukkit.getPluginManager().registerEvents(new ClickBed(), this);
        Bukkit.getPluginManager().registerEvents(new OpenInventory(), this);
        Bukkit.getPluginManager().registerEvents(new UsingShop(), this);
        Bukkit.getPluginManager().registerEvents(new BedBreakEvent(), this);
        Bukkit.getPluginManager().registerEvents(new KillEvent(), this);
        Bukkit.getPluginManager().registerEvents(new LeaveEvent(), this);

        Bukkit.getPluginCommand("mapset").setExecutor(new MapSet());
        Bukkit.getPluginCommand("start").setExecutor(new Start());

        // 철
        Bukkit.getScheduler().runTaskTimer(this, new Runnable() {
            @Override
            public void run() {
                if (gaming) {
                    for (Location i : Locations.BasicGenerator) {
                        i.getWorld().dropItemNaturally(i, ItemStackGenerator.generate(Material.IRON_INGOT));
                    }
                }
            }
        }, 0, 40);

        // 금
        Bukkit.getScheduler().runTaskTimer(this, new Runnable() {
            @Override
            public void run() {
                if (gaming) {
                    for (Location i : Locations.BasicGenerator) {
                        i.getWorld().dropItemNaturally(i, ItemStackGenerator.generate(Material.GOLD_INGOT));
                    }
                }
            }
        }, 0, 160);

        // 다이아몬드
        Bukkit.getScheduler().runTaskTimer(this, new Runnable() {
            @Override
            public void run() {
                if (gaming) {
                    for (Location i : Locations.DiamondGenerator) {
                        i.getWorld().dropItemNaturally(i, ItemStackGenerator.generate(Material.DIAMOND));
                    }
                }
            }
        }, 0, 600);

        // 에메랄드
        Bukkit.getScheduler().runTaskTimer(this, new Runnable() {
            @Override
            public void run() {
                if (gaming) {
                    for (Location i : Locations.EmeraldGenerator) {
                        i.getWorld().dropItemNaturally(i, ItemStackGenerator.generate(Material.EMERALD));
                    }
                }
            }
        }, 0, 600);
    }
}