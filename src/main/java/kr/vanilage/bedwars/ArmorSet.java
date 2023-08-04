package kr.vanilage.bedwars;

import kr.vanilage.bedwars.shop.ItemStackGenerator;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class ArmorSet {
    public static void armorSet(Player p) {
        ItemStack helmet = ItemStackGenerator.generate(Material.LEATHER_HELMET);
        ItemStack chestPlate = ItemStackGenerator.generate(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta helmetMeta = (LeatherArmorMeta) helmet.getItemMeta();
        LeatherArmorMeta chestPlateMeta = (LeatherArmorMeta) chestPlate.getItemMeta();

        Color color = null;
        if (Bedwars.teamUUID.get(p.getUniqueId()).equals(Teams.RED)) color = Color.RED;
        if (Bedwars.teamUUID.get(p.getUniqueId()).equals(Teams.BLUE)) color = Color.BLUE;
        if (Bedwars.teamUUID.get(p.getUniqueId()).equals(Teams.GREEN)) color = Color.GREEN;
        if (Bedwars.teamUUID.get(p.getUniqueId()).equals(Teams.YELLOW)) color = Color.YELLOW;
        if (Bedwars.teamUUID.get(p.getUniqueId()).equals(Teams.AQUA)) color = Color.AQUA;
        if (Bedwars.teamUUID.get(p.getUniqueId()).equals(Teams.WHITE)) color = Color.WHITE;
        if (Bedwars.teamUUID.get(p.getUniqueId()).equals(Teams.PINK)) color = Color.PURPLE;
        if (Bedwars.teamUUID.get(p.getUniqueId()).equals(Teams.GRAY)) color = Color.GRAY;

        helmetMeta.setColor(color);
        chestPlateMeta.setColor(color);
        helmet.setItemMeta(helmetMeta);
        chestPlate.setItemMeta(chestPlateMeta);

        ItemStack leggings = null;
        ItemStack boots = null;

        if (Bedwars.ironArmor.contains(p.getUniqueId())) {
            leggings = ItemStackGenerator.generate(Material.IRON_LEGGINGS);
            boots = ItemStackGenerator.generate(Material.IRON_BOOTS);
        }

        else {
            leggings = ItemStackGenerator.generate(Material.LEATHER_LEGGINGS);
            boots = ItemStackGenerator.generate(Material.LEATHER_BOOTS);
            LeatherArmorMeta leggingsMeta = (LeatherArmorMeta) leggings.getItemMeta();
            LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
            leggingsMeta.setColor(color);
            bootsMeta.setColor(color);
            leggings.setItemMeta(leggingsMeta);
            boots.setItemMeta(bootsMeta);
        }

        if (Bedwars.protect.containsKey(p.getUniqueId())) {
            helmet.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, Bedwars.protect.get(p.getUniqueId()));
            chestPlate.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, Bedwars.protect.get(p.getUniqueId()));
            leggings.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, Bedwars.protect.get(p.getUniqueId()));
            boots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, Bedwars.protect.get(p.getUniqueId()));
        }

        ItemStack sword = ItemStackGenerator.generate(Material.WOODEN_SWORD);

        if (Bedwars.sharpness.contains(p.getUniqueId())) {
            sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
        }

        p.getInventory().setItem(EquipmentSlot.HEAD, helmet);
        p.getInventory().setItem(EquipmentSlot.CHEST, chestPlate);
        p.getInventory().setItem(EquipmentSlot.LEGS, leggings);
        p.getInventory().setItem(EquipmentSlot.FEET, boots);
        p.getInventory().addItem(sword);
    }
}
