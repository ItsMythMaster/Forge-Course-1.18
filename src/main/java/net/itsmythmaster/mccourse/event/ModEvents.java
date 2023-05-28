package net.itsmythmaster.mccourse.event;

import net.itsmythmaster.mccourse.MCCourseMod;
import net.itsmythmaster.mccourse.command.ReturnHomeCommand;
import net.itsmythmaster.mccourse.command.SetHomeCommand;
import net.itsmythmaster.mccourse.util.KaupenTitleScreen;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ScreenOpenEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.ConfigCommand;

@Mod.EventBusSubscriber(modid = MCCourseMod.MOD_ID)
public class ModEvents {
    @SubscribeEvent
    public static void onCommandsRegister(RegisterCommandsEvent event) {
        new SetHomeCommand(event.getDispatcher());
        new ReturnHomeCommand(event.getDispatcher());

        ConfigCommand.register(event.getDispatcher());
    }

    @SubscribeEvent
    public static void onPlayerCloneEvent(PlayerEvent.Clone event) {
        if(!event.getOriginal().getLevel().isClientSide()) {
            event.getPlayer().getPersistentData().putIntArray(MCCourseMod.MOD_ID + "homepos",
                    event.getOriginal().getPersistentData().getIntArray(MCCourseMod.MOD_ID + "homepos"));
        }
    }
    @SubscribeEvent
    public static void setEntityOnFireWhenHit(LivingDamageEvent event) {
        if(!event.getEntity().level.isClientSide()) {
            if(event.getSource().getDirectEntity() instanceof Player) {
                Player player = (Player)event.getSource().getDirectEntity();
                if(player.getMainHandItem().getItem() == Items.BLAZE_ROD) {
                    player.getMainHandItem().shrink(1);
                    event.getEntityLiving().setSecondsOnFire(8);
                }
            }
        }
    }

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void openGui(ScreenOpenEvent event) {
        if (event.getScreen() instanceof TitleScreen && !(event.getScreen() instanceof KaupenTitleScreen)) {
            event.setScreen(new KaupenTitleScreen());
        }
    }

}