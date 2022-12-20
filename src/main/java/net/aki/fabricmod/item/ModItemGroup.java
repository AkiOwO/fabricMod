package net.aki.fabricmod.item;

import net.aki.fabricmod.FabricMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final net.minecraft.item.ItemGroup ruby = FabricItemGroup.builder(new Identifier(FabricMod.MOD_ID))
            .displayName(Text.literal("OPC Mod"))
            .icon(() -> new ItemStack(ModItems.ruby))
            .build();
}
