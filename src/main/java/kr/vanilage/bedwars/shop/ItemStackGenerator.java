package kr.vanilage.bedwars.shop;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemStackGenerator {
    public static ItemStack generate(Material material, int amount, String name) {
        ItemStack result = new ItemStack(material, amount);
        ItemMeta meta = result.getItemMeta();
        meta.setDisplayName(name);
        result.setItemMeta(meta);
        return result;
    }

    public static ItemStack generate(Material material, int amount) {
        ItemStack result = new ItemStack(material, amount);
        return result;
    }

    public static ItemStack generate(Material material) {
        ItemStack result = new ItemStack(material, 1);
        return result;
    }
}
