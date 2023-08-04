package kr.vanilage.bedwars.shop;

import kr.vanilage.bedwars.Bedwars;
import kr.vanilage.bedwars.Messages;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

public class UsingShop implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (e.getView().getTitle().contains(ChatColor.GREEN + "상점")) {
            e.setCancelled(true);
            if (e.getRawSlot() <= 35) {
                if (e.getCurrentItem() != null) {
                    if (e.getCurrentItem().getType().equals(Material.MAGENTA_WOOL)) {
                        for (ItemStack i : e.getWhoClicked().getInventory().getContents()) {
                            if (i != null) {
                                if (i.getType().equals(Material.IRON_INGOT) && i.getAmount() >= 4) {
                                    i.setAmount(i.getAmount() - 4);
                                    e.getWhoClicked().getInventory().addItem(ItemStackGenerator.generate(Material.MAGENTA_WOOL, 16));
                                    return;
                                }
                            }
                        }

                        e.getWhoClicked().sendMessage(Messages.RESOURCE_REQUIRED);
                    }

                    if (e.getCurrentItem().getType().equals(Material.CHERRY_PLANKS)) {
                        for (ItemStack i : e.getWhoClicked().getInventory().getContents()) {
                            if (i != null) {
                                if (i.getType().equals(Material.GOLD_INGOT) && i.getAmount() >= 4) {
                                    i.setAmount(i.getAmount() - 4);
                                    e.getWhoClicked().getInventory().addItem(ItemStackGenerator.generate(Material.CHERRY_PLANKS, 16));
                                    return;
                                }
                            }
                        }

                        e.getWhoClicked().sendMessage(Messages.RESOURCE_REQUIRED);
                    }

                    if (e.getCurrentItem().getType().equals(Material.END_STONE)) {
                        for (ItemStack i : e.getWhoClicked().getInventory().getContents()) {
                            if (i != null) {
                                if (i.getType().equals(Material.IRON_INGOT) && i.getAmount() >= 24) {
                                    i.setAmount(i.getAmount() - 24);
                                    e.getWhoClicked().getInventory().addItem(ItemStackGenerator.generate(Material.END_STONE, 12));
                                    return;
                                }
                            }
                        }

                        e.getWhoClicked().sendMessage(Messages.RESOURCE_REQUIRED);
                    }

                    if (e.getCurrentItem().getType().equals(Material.STONE_SWORD)) {
                        for (ItemStack i : e.getWhoClicked().getInventory().getContents()) {
                            if (i != null) {
                                if (i.getType().equals(Material.IRON_INGOT) && i.getAmount() >= 10) {
                                    i.setAmount(i.getAmount() - 10);
                                    ItemStack item = ItemStackGenerator.generate(Material.STONE_SWORD);

                                    if (Bedwars.sharpness.contains(e.getWhoClicked().getUniqueId())) {
                                        item.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
                                    }

                                    e.getWhoClicked().getInventory().addItem(item);
                                    return;
                                }
                            }
                        }

                        e.getWhoClicked().sendMessage(Messages.RESOURCE_REQUIRED);
                    }

                    if (e.getCurrentItem().getType().equals(Material.IRON_SWORD)) {
                        for (ItemStack i : e.getWhoClicked().getInventory().getContents()) {
                            if (i != null) {
                                if (i.getType().equals(Material.GOLD_INGOT) && i.getAmount() >= 7) {
                                    i.setAmount(i.getAmount() - 7);
                                    ItemStack item = ItemStackGenerator.generate(Material.IRON_SWORD);

                                    if (Bedwars.sharpness.contains(e.getWhoClicked().getUniqueId())) {
                                        item.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
                                    }

                                    e.getWhoClicked().getInventory().addItem(item);
                                    return;
                                }
                            }
                        }

                        e.getWhoClicked().sendMessage(Messages.RESOURCE_REQUIRED);
                    }

                    if (e.getCurrentItem().getType().equals(Material.DIAMOND_SWORD)) {
                        for (ItemStack i : e.getWhoClicked().getInventory().getContents()) {
                            if (i != null) {
                                if (i.getType().equals(Material.EMERALD) && i.getAmount() >= 12) {
                                    i.setAmount(i.getAmount() - 12);
                                    ItemStack item = ItemStackGenerator.generate(Material.DIAMOND_SWORD);

                                    if (Bedwars.sharpness.contains(e.getWhoClicked().getUniqueId())) {
                                        item.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
                                    }

                                    e.getWhoClicked().getInventory().addItem(item);
                                    return;
                                }
                            }
                        }

                        e.getWhoClicked().sendMessage(Messages.RESOURCE_REQUIRED);
                    }

                    if (e.getCurrentItem().getType().equals(Material.IRON_CHESTPLATE)) {
                        if (!Bedwars.ironArmor.contains(e.getWhoClicked().getUniqueId())) {
                            for (ItemStack i : e.getWhoClicked().getInventory().getContents()) {
                                if (i != null) {
                                    if (i.getType().equals(Material.GOLD_INGOT) && i.getAmount() >= 12) {
                                        i.setAmount(i.getAmount() - 12);
                                        Bedwars.ironArmor.add(e.getWhoClicked().getUniqueId());
                                        if (Bedwars.protect.containsKey(e.getWhoClicked().getUniqueId())) {
                                            ItemStack leg = ItemStackGenerator.generate(Material.IRON_LEGGINGS);
                                            ItemStack foot = ItemStackGenerator.generate(Material.IRON_BOOTS);
                                            leg.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, Bedwars.protect.get(e.getWhoClicked().getUniqueId()));
                                            foot.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, Bedwars.protect.get(e.getWhoClicked().getUniqueId()));
                                            e.getWhoClicked().getInventory().setItem(EquipmentSlot.LEGS, leg);
                                            e.getWhoClicked().getInventory().setItem(EquipmentSlot.FEET, foot);
                                        }

                                        else {
                                            e.getWhoClicked().getInventory().setItem(EquipmentSlot.LEGS, ItemStackGenerator.generate(Material.IRON_LEGGINGS));
                                            e.getWhoClicked().getInventory().setItem(EquipmentSlot.FEET, ItemStackGenerator.generate(Material.IRON_BOOTS));
                                        }
                                        return;
                                    }
                                }
                            }

                            e.getWhoClicked().sendMessage(Messages.RESOURCE_REQUIRED);
                        }
                    }

                    if (e.getCurrentItem().getType().equals(Material.SHEARS)) {
                        for (ItemStack i : e.getWhoClicked().getInventory().getContents()) {
                            if (i != null) {
                                if (i.getType().equals(Material.IRON_INGOT) && i.getAmount() >= 20) {
                                    i.setAmount(i.getAmount() - 20);
                                    e.getWhoClicked().getInventory().addItem(ItemStackGenerator.generate(Material.SHEARS));
                                    return;
                                }
                            }
                        }

                        e.getWhoClicked().sendMessage(Messages.RESOURCE_REQUIRED);
                    }

                    if (e.getCurrentItem().getType().equals(Material.STONE_AXE)) {
                        for (ItemStack i : e.getWhoClicked().getInventory().getContents()) {
                            if (i != null) {
                                if (i.getType().equals(Material.IRON_INGOT) && i.getAmount() >= 10) {
                                    i.setAmount(i.getAmount() - 10);
                                    e.getWhoClicked().getInventory().addItem(ItemStackGenerator.generate(Material.STONE_AXE));
                                    return;
                                }
                            }
                        }

                        e.getWhoClicked().sendMessage(Messages.RESOURCE_REQUIRED);
                    }

                    if (e.getCurrentItem().getType().equals(Material.STONE_PICKAXE)) {
                        for (ItemStack i : e.getWhoClicked().getInventory().getContents()) {
                            if (i != null) {
                                if (i.getType().equals(Material.IRON_INGOT) && i.getAmount() >= 10) {
                                    i.setAmount(i.getAmount() - 10);
                                    e.getWhoClicked().getInventory().addItem(ItemStackGenerator.generate(Material.STONE_PICKAXE));
                                    return;
                                }
                            }
                        }

                        e.getWhoClicked().sendMessage(Messages.RESOURCE_REQUIRED);
                    }

                    if (e.getCurrentItem().getType().equals(Material.FIRE_CHARGE)) {
                        for (ItemStack i : e.getWhoClicked().getInventory().getContents()) {
                            if (i != null) {
                                if (i.getType().equals(Material.IRON_INGOT) && i.getAmount() >= 40) {
                                    i.setAmount(i.getAmount() - 40);
                                    e.getWhoClicked().getInventory().addItem(ItemStackGenerator.generate(Material.FIRE_CHARGE));
                                    return;
                                }
                            }
                        }

                        e.getWhoClicked().sendMessage(Messages.RESOURCE_REQUIRED);
                    }

                    if (e.getCurrentItem().getType().equals(Material.GOLDEN_APPLE)) {
                        for (ItemStack i : e.getWhoClicked().getInventory().getContents()) {
                            if (i != null) {
                                if (i.getType().equals(Material.GOLD_INGOT) && i.getAmount() >= 3) {
                                    i.setAmount(i.getAmount() - 3);
                                    e.getWhoClicked().getInventory().addItem(ItemStackGenerator.generate(Material.GOLDEN_APPLE));
                                    return;
                                }
                            }
                        }

                        e.getWhoClicked().sendMessage(Messages.RESOURCE_REQUIRED);
                    }

                    if (e.getCurrentItem().getType().equals(Material.TNT)) {
                        for (ItemStack i : e.getWhoClicked().getInventory().getContents()) {
                            if (i != null) {
                                if (i.getType().equals(Material.GOLD_INGOT) && i.getAmount() >= 4) {
                                    i.setAmount(i.getAmount() - 4);
                                    e.getWhoClicked().getInventory().addItem(ItemStackGenerator.generate(Material.TNT));
                                    return;
                                }
                            }
                        }

                        e.getWhoClicked().sendMessage(Messages.RESOURCE_REQUIRED);
                    }

                    if (e.getCurrentItem().getType().equals(Material.BOOK) && e.getCurrentItem().getItemMeta().getDisplayName().contains("보호 1 강화")) {
                        if (!Bedwars.protect.containsKey(e.getWhoClicked().getUniqueId())) {
                            for (ItemStack i : e.getWhoClicked().getInventory().getContents()) {
                                if (i != null) {
                                    if (i.getType().equals(Material.DIAMOND) && i.getAmount() >= 2) {
                                        i.setAmount(i.getAmount() - 2);
                                        Bedwars.protect.put(e.getWhoClicked().getUniqueId(), 1);
                                        e.getWhoClicked().getInventory().getItem(EquipmentSlot.HEAD).addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
                                        e.getWhoClicked().getInventory().getItem(EquipmentSlot.CHEST).addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
                                        e.getWhoClicked().getInventory().getItem(EquipmentSlot.LEGS).addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
                                        e.getWhoClicked().getInventory().getItem(EquipmentSlot.FEET).addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
                                        return;
                                    }
                                }
                            }

                            e.getWhoClicked().sendMessage(Messages.RESOURCE_REQUIRED);
                        }
                    }

                    if (e.getCurrentItem().getType().equals(Material.BOOK) && e.getCurrentItem().getItemMeta().getDisplayName().contains("보호 2 강화")) {
                        if (Bedwars.protect.containsKey(e.getWhoClicked().getUniqueId()) && Bedwars.protect.get(e.getWhoClicked().getUniqueId()) == 1) {
                            for (ItemStack i : e.getWhoClicked().getInventory().getContents()) {
                                if (i != null) {
                                    if (i.getType().equals(Material.DIAMOND) && i.getAmount() >= 4) {
                                        i.setAmount(i.getAmount() - 4);
                                        Bedwars.protect.put(e.getWhoClicked().getUniqueId(), 2);
                                        e.getWhoClicked().getInventory().getItem(EquipmentSlot.HEAD).addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
                                        e.getWhoClicked().getInventory().getItem(EquipmentSlot.CHEST).addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
                                        e.getWhoClicked().getInventory().getItem(EquipmentSlot.LEGS).addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
                                        e.getWhoClicked().getInventory().getItem(EquipmentSlot.FEET).addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
                                        return;
                                    }
                                }
                            }

                            e.getWhoClicked().sendMessage(Messages.RESOURCE_REQUIRED);
                        }
                    }

                    if (e.getCurrentItem().getType().equals(Material.BOOK) && e.getCurrentItem().getItemMeta().getDisplayName().contains("보호 3 강화")) {
                        if (Bedwars.protect.containsKey(e.getWhoClicked().getUniqueId()) && Bedwars.protect.get(e.getWhoClicked().getUniqueId()) == 2) {
                            for (ItemStack i : e.getWhoClicked().getInventory().getContents()) {
                                if (i != null) {
                                    if (i.getType().equals(Material.DIAMOND) && i.getAmount() >= 8) {
                                        i.setAmount(i.getAmount() - 8);
                                        Bedwars.protect.put(e.getWhoClicked().getUniqueId(), 3);
                                        e.getWhoClicked().getInventory().getItem(EquipmentSlot.HEAD).addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
                                        e.getWhoClicked().getInventory().getItem(EquipmentSlot.CHEST).addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
                                        e.getWhoClicked().getInventory().getItem(EquipmentSlot.LEGS).addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
                                        e.getWhoClicked().getInventory().getItem(EquipmentSlot.FEET).addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
                                        return;
                                    }
                                }
                            }

                            e.getWhoClicked().sendMessage(Messages.RESOURCE_REQUIRED);
                        }
                    }

                    if (e.getCurrentItem().getType().equals(Material.BOOK) && e.getCurrentItem().getItemMeta().getDisplayName().contains("보호 4 강화")) {
                        if (Bedwars.protect.containsKey(e.getWhoClicked().getUniqueId()) && Bedwars.protect.get(e.getWhoClicked().getUniqueId()) == 3) {
                            for (ItemStack i : e.getWhoClicked().getInventory().getContents()) {
                                if (i != null) {
                                    if (i.getType().equals(Material.DIAMOND) && i.getAmount() >= 16) {
                                        i.setAmount(i.getAmount() - 16);
                                        Bedwars.protect.put(e.getWhoClicked().getUniqueId(), 4);
                                        e.getWhoClicked().getInventory().getItem(EquipmentSlot.HEAD).addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
                                        e.getWhoClicked().getInventory().getItem(EquipmentSlot.CHEST).addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
                                        e.getWhoClicked().getInventory().getItem(EquipmentSlot.LEGS).addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
                                        e.getWhoClicked().getInventory().getItem(EquipmentSlot.FEET).addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
                                        return;
                                    }
                                }
                            }

                            e.getWhoClicked().sendMessage(Messages.RESOURCE_REQUIRED);
                        }
                    }

                    if (e.getCurrentItem().getType().equals(Material.NETHERITE_SWORD)) {
                        if (!Bedwars.sharpness.contains(e.getWhoClicked().getUniqueId())) {
                            for (ItemStack i : e.getWhoClicked().getInventory().getContents()) {
                                if (i != null) {
                                    if (i.getType().equals(Material.DIAMOND) && i.getAmount() >= 4) {
                                        i.setAmount(i.getAmount() - 4);
                                        Bedwars.sharpness.add(e.getWhoClicked().getUniqueId());

                                        for (ItemStack j : e.getWhoClicked().getInventory().getContents()) {
                                            if (j != null) {
                                                if (j.getType().name().endsWith("_SWORD")) {
                                                    j.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
                                                }
                                            }
                                        }
                                        return;
                                    }
                                }
                            }

                            e.getWhoClicked().sendMessage(Messages.RESOURCE_REQUIRED);
                        }
                    }
                }
            }
        }
    }
}