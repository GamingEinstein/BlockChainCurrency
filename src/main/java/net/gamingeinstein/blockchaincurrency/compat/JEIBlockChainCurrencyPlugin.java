package net.gamingeinstein.blockchaincurrency.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.gamingeinstein.blockchaincurrency.BlockChainCurrency;
import net.gamingeinstein.blockchaincurrency.recipe.BitsFabricationRecipe;
import net.gamingeinstein.blockchaincurrency.screen.BitsFabricatorScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;

@JeiPlugin
public class JEIBlockChainCurrencyPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(BlockChainCurrency.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new BitsFabricationCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

        List<BitsFabricationRecipe> fabricationRecipes = recipeManager.getAllRecipesFor(BitsFabricationRecipe.Type.INSTANCE);
        registration.addRecipes(BitsFabricationCategory.BITS_FABRICATION_TYPE, fabricationRecipes);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(BitsFabricatorScreen.class, 60, 30, 20, 30,
                BitsFabricationCategory.BITS_FABRICATION_TYPE);
    }
}
