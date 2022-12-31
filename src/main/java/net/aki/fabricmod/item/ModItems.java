package net.aki.fabricmod.item;

import net.aki.fabricmod.FabricMod;
import net.aki.fabricmod.item.custom.CoinflipItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {


    public static final Item ruby = registerItem(
            "ruby",
            new Item(new Item.Settings()),
            ModItemGroup.ruby
    );

    public static final Item RUBY_NUGGET = registerItem(
            "ruby_nugget",
            new Item(new Item.Settings()),
            ModItemGroup.ruby
    );

    public static final Item OFENKAESE_ITEM = registerItem(
            "ofenkaese_item",
            new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(4).saturationModifier(0.3F).alwaysEdible().build()).rarity(Rarity.EPIC)),
            ModItemGroup.ruby
    );

    public static final Item RUBY_HELMET = registerItem(
            "ruby_helmet",
            new ArmorItem(ArmorMaterials.NETHERITE, EquipmentSlot.HEAD, new Item.Settings()),
            ModItemGroup.ruby
    );

    public static final Item RUBY_CHESTPLATE = registerItem(
            "ruby_chestplate",
            new ArmorItem(ArmorMaterials.NETHERITE, EquipmentSlot.CHEST, new Item.Settings()),
            ModItemGroup.ruby
    );

    public static final Item RUBY_LEGGINGS = registerItem(
            "ruby_leggings",
            new ArmorItem(ArmorMaterials.NETHERITE, EquipmentSlot.LEGS, new Item.Settings()),
            ModItemGroup.ruby
    );

    public static final Item RUBY_BOOTS = registerItem(
            "ruby_boots",
            new ArmorItem(ArmorMaterials.NETHERITE, EquipmentSlot.FEET, new Item.Settings()),
            ModItemGroup.ruby
    );

    public static final Item COINFLIP_ITEM = registerItem(
            "coinflip_item",
            new CoinflipItem(new Item.Settings().maxCount(1).rarity(CoinflipItem.RARITY)),
            ModItemGroup.ruby
    );

    public static final Item SCHLAGSTOCK = registerItem(
            "schlagstock",
            new SwordItem(ToolMaterials.DIAMOND, 10, 5f, new Item.Settings()),
            ModItemGroup.ruby
    );

    private static Item registerItem(String name, Item item, ItemGroup itemGroup) {
        ItemGroupEvents.modifyEntriesEvent(itemGroup).register(entries -> entries.add(item));
        return Registry.register(Registries.ITEM, new Identifier(FabricMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        // Register items here
        FabricMod.LOGGER.info("Registered mod items for " + FabricMod.MOD_ID);
    }
}
