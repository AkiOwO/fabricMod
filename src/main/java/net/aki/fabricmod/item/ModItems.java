package net.aki.fabricmod.item;

import net.aki.fabricmod.FabricMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItems {


    public static final Item ruby = registerItem(
            "ruby",
            new Item(new Item.Settings()),
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
