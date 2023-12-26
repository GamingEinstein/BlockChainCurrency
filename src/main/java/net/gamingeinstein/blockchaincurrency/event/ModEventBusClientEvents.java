package net.gamingeinstein.blockchaincurrency.event;

import net.gamingeinstein.blockchaincurrency.BlockChainCurrency;
import net.gamingeinstein.blockchaincurrency.block.entity.ModBlockEntities;
import net.gamingeinstein.blockchaincurrency.block.entity.renderer.BitsFabricatorBlockEntityRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BlockChainCurrency.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModBlockEntities.BITS_FABRICATOR_BLOCK_ENTITY.get(), BitsFabricatorBlockEntityRenderer::new);
    }
}