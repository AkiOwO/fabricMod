package net.aki.fabricmod.item.custom;

import net.aki.fabricmod.item.ModItems;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.message.MessageSignatureData;
import net.minecraft.network.packet.c2s.play.ChatMessageC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerInteractBlockC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.minecraft.network.packet.s2c.play.DisconnectS2CPacket;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.Rarity;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;


import java.time.Instant;

public class CoinflipItem extends Item {
    public static final Rarity RARITY = Rarity.EPIC;

    public CoinflipItem(Settings settings) {
        super(settings);
    }

    private static boolean throwItems()
    {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        player.refreshPositionAndAngles(player.getX(), player.getY(), player.getZ(), 0, 90);
        MinecraftClient.getInstance().getNetworkHandler().sendPacket(new PlayerMoveC2SPacket.LookAndOnGround(0, 90, true)); // point to correct location
        return true;
    }

    private static boolean kekTest(){
        ClientPlayerEntity player = MinecraftClient.getInstance().player;

        //MinecraftClient.getInstance().getNetworkHandler().sendChatMessage("KackW alla xD");

        //MinecraftClient.getInstance().getNetworkHandler().sendPacket(new DisconnectS2CPacket(Text.literal("Raus biste du Mongo!")));

        MinecraftClient.getInstance().wireFrame = true;

        MinecraftClient.getInstance().getNetworkHandler().sendPacket(new PlayerMoveC2SPacket.PositionAndOnGround(player.getX() + 1, player.getY(), player.getZ(), true));


        player.sendMessage(Text.literal(player.getX() + " " + player.getY() + " " + player.getZ() + " " + player.isOnGround()));

        return true;
    }



    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if (!world.isClient && hand == Hand.MAIN_HAND) {
            var message = "The number is " + getRandomNumer();

            //output message
            //outputMessage(player, message);
        kekTest();
            //player.getInventory().dropAll();

            //throwItems();

            //cooldown for item
            //user.getItemCooldownManager().set(this, 20);
        }
        return super.use(world, player, hand);
    }

    private void outputMessage(PlayerEntity player, String message) {
        player.sendMessage(Text.literal(message));
    }

    private int getRandomNumer() {
        return Random.createLocal().nextInt(2);
    }
}
