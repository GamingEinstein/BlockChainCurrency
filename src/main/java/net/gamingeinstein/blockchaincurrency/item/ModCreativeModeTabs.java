package net.gamingeinstein.blockchaincurrency.item;

import net.gamingeinstein.blockchaincurrency.BlockChainCurrency;
import net.gamingeinstein.blockchaincurrency.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BlockChainCurrency.MOD_ID);

    public static final RegistryObject<CreativeModeTab> BLOCKCHAIN_CURRENCY_TAB = CREATIVE_MODE_TABS.register("blockchain_currency_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SINGLE_BIT.get()))
                    .title(Component.translatable("creativetab.blockchain_currency_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.SINGLE_BIT.get());
                        pOutput.accept(ModItems.DOUBLE_BIT.get());
                        pOutput.accept(ModItems.TRIPLE_BIT.get());
                        pOutput.accept(ModItems.BITS_WALLET.get());

                        pOutput.accept(ModBlocks.BITS_FABRICATOR.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
