package net.aki.fabricmod;

import net.aki.fabricmod.event.KeyInputHandler;
import net.fabricmc.api.ClientModInitializer;

public class Client implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        KeyInputHandler.register();
    }
}
