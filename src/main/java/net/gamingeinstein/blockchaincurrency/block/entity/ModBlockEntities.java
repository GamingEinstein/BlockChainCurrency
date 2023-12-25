package net.gamingeinstein.blockchaincurrency.block.entity;

import net.gamingeinstein.blockchaincurrency.BlockChainCurrency;
import net.gamingeinstein.blockchaincurrency.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, BlockChainCurrency.MOD_ID);

    public static final RegistryObject<BlockEntityType<BitsFabricatorBlockEntity>> BITS_FABRICATOR_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("bits_fabricator_block_entity", () ->
                    BlockEntityType.Builder.of(BitsFabricatorBlockEntity::new,
                            ModBlocks.BITS_FABRICATOR.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
