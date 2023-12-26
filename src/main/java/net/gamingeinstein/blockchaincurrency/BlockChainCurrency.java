package net.gamingeinstein.blockchaincurrency;

import com.mojang.logging.LogUtils;
import net.gamingeinstein.blockchaincurrency.block.ModBlocks;
import net.gamingeinstein.blockchaincurrency.block.entity.ModBlockEntities;
import net.gamingeinstein.blockchaincurrency.item.ModCreativeModeTabs;
import net.gamingeinstein.blockchaincurrency.item.ModItems;
import net.gamingeinstein.blockchaincurrency.recipe.ModRecipes;
import net.gamingeinstein.blockchaincurrency.screen.BitsFabricatorScreen;
import net.gamingeinstein.blockchaincurrency.screen.ModMenuTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(BlockChainCurrency.MOD_ID)
public class BlockChainCurrency {

    public static final String MOD_ID = "blockchain_currency";
    private static final Logger LOGGER = LogUtils.getLogger();

    public BlockChainCurrency() {

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModBlockEntities.register(modEventBus);
        ModCreativeModeTabs.register(modEventBus);

        ModMenuTypes.register(modEventBus);
        ModRecipes.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            MenuScreens.register(ModMenuTypes.BITS_FABRICATOR_MENU.get(), BitsFabricatorScreen::new);
        }
    }
}
