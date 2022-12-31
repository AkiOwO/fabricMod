package net.aki.fabricmod.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.DisconnectedScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.gui.screen.option.OptionsScreen;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.minecraft.network.packet.s2c.login.LoginDisconnectS2CPacket;
import net.minecraft.network.packet.s2c.play.DisconnectS2CPacket;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {

    public static final String KEY_CATEGORY = "key.category.fabricmod.open";
    public static final String KEY_SEND_MSG = "key.category.fabricmod.SEND_MSG";

    public static final String KEY_TEST_METHOD = "key.category.fabricmod.TEST_METHOD";

    public static KeyBinding sendMsgKey;

    public static KeyBinding testMethodKey;

    public static void registerKeyInputs(){
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (sendMsgKey.wasPressed()) {
                MinecraftClient.getInstance().getNetworkHandler().sendChatMessage("Was geht?");
                //MinecraftClient.getInstance().getNetworkHandler().sendPacket(new DisconnectS2CPacket(Text.literal("Raus biste du Mongo!")));
            }

            while (testMethodKey.wasPressed()) {
                ClientPlayerEntity player = MinecraftClient.getInstance().player;
                MinecraftClient test = MinecraftClient.getInstance();

                MinecraftClient.getInstance().
                player.closeScreen();
            }
        });
    }

    public static void register(){
        sendMsgKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_SEND_MSG,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_KP_1,
                KEY_CATEGORY
        ));
        testMethodKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_TEST_METHOD,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_KP_2,
                KEY_CATEGORY
        ));

        registerKeyInputs();
    }
}
