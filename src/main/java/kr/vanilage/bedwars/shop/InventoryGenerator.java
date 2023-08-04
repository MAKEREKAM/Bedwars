package kr.vanilage.bedwars.shop;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class InventoryGenerator implements InventoryHolder {
    private Inventory inv;

    public InventoryGenerator() {
        inv = Bukkit.createInventory(this, 36, ChatColor.GREEN + "상점");

        inv.setItem(1, ItemStackGenerator.generate(Material.MAGENTA_WOOL, 16, ChatColor.WHITE + "양털 16개 (철 4개)"));
        inv.setItem(2, ItemStackGenerator.generate(Material.CHERRY_PLANKS, 16, ChatColor.WHITE + "나무 16개 (금 4개)"));
        inv.setItem(3, ItemStackGenerator.generate(Material.END_STONE, 12, ChatColor.WHITE + "엔드돌 12개 (철 24개)"));
        inv.setItem(5, ItemStackGenerator.generate(Material.STONE_SWORD, 1, ChatColor.WHITE + "돌 검 (철 10개)"));
        inv.setItem(6, ItemStackGenerator.generate(Material.IRON_SWORD, 1, ChatColor.WHITE + "철 검 (금 7개)"));
        inv.setItem(7, ItemStackGenerator.generate(Material.DIAMOND_SWORD, 1, ChatColor.WHITE + "다이아몬드 검 (에메랄드 12개)"));
        inv.setItem(11, ItemStackGenerator.generate(Material.IRON_CHESTPLATE, 1, ChatColor.WHITE + "철 갑옷 업그레이드 (금 12개)"));
        inv.setItem(14, ItemStackGenerator.generate(Material.SHEARS, 1 ,ChatColor.WHITE + "가위 (철 20개)"));
        inv.setItem(15, ItemStackGenerator.generate(Material.STONE_AXE, 1, ChatColor.WHITE + "돌 도끼 (철 10개)"));
        inv.setItem(16, ItemStackGenerator.generate(Material.STONE_PICKAXE, 1, ChatColor.WHITE + "돌 곡괭이 (철 10개)"));
        inv.setItem(20, ItemStackGenerator.generate(Material.FIRE_CHARGE, 1, ChatColor.WHITE + "화염구 (철 40개)"));
        inv.setItem(22, ItemStackGenerator.generate(Material.GOLDEN_APPLE, 1, ChatColor.WHITE + "황금 사과 (금 3개)"));
        inv.setItem(24, ItemStackGenerator.generate(Material.TNT, 1, ChatColor.WHITE + "TNT (금 4개)"));
        inv.setItem(27, ItemStackGenerator.generate(Material.BOOK, 1, ChatColor.WHITE + "보호 1 강화 (다이아몬드 2개)"));
        inv.setItem(29, ItemStackGenerator.generate(Material.BOOK, 2, ChatColor.WHITE + "보호 2 강화 (다이아몬드 4개)"));
        inv.setItem(31, ItemStackGenerator.generate(Material.NETHERITE_SWORD, 1, ChatColor.WHITE + "날카로움 1 강화 (다이아몬드 4개)"));
        inv.setItem(33, ItemStackGenerator.generate(Material.BOOK, 3, ChatColor.WHITE + "보호 3 강화 (다이아몬드 8개)"));
        inv.setItem(35, ItemStackGenerator.generate(Material.BOOK, 4, ChatColor.WHITE + "보호 4 강화 (다이아몬드 16개)"));
    }

    @Override
    public Inventory getInventory() {
        return inv;
    }
}
