package net.aki.fabricmod;

import net.aki.fabricmod.block.ModBlocks;
import net.aki.fabricmod.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FabricMod implements ModInitializer {

	public static final String MOD_ID = "fabricmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}
