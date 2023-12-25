package net.gamingeinstein.blockchaincurrency.item;

import net.gamingeinstein.blockchaincurrency.BlockChainCurrency;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BlockChainCurrency.MOD_ID);

    public static final RegistryObject<Item> SINGLE_BIT = ITEMS.register("single_bit",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DOUBLE_BIT = ITEMS.register("double_bit",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {

        ITEMS.register(eventBus);
    }
}