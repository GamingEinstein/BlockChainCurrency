package net.gamingeinstein.blockchaincurrency.recipe;

import net.gamingeinstein.blockchaincurrency.BlockChainCurrency;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    private static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, BlockChainCurrency.MOD_ID);

    public static final RegistryObject<RecipeSerializer<BitsFabricationRecipe>> BITS_FABRICATION_SERIALIZER =
            SERIALIZERS.register("bits_fabrication", () -> BitsFabricationRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
