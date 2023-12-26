package net.gamingeinstein.blockchaincurrency.compat;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.gamingeinstein.blockchaincurrency.BlockChainCurrency;
import net.gamingeinstein.blockchaincurrency.block.ModBlocks;
import net.gamingeinstein.blockchaincurrency.recipe.BitsFabricationRecipe;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class BitsFabricationCategory implements IRecipeCategory<BitsFabricationRecipe> {

    public static final ResourceLocation UID = new ResourceLocation(BlockChainCurrency.MOD_ID, "bits_fabrication");
    public static final ResourceLocation TEXTURE = new ResourceLocation(BlockChainCurrency.MOD_ID,
            "textures/gui/bits_fabricator_gui.png");

    public static final RecipeType<BitsFabricationRecipe> BITS_FABRICATION_TYPE =
            new RecipeType<>(UID, BitsFabricationRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public BitsFabricationCategory(IGuiHelper helper) {

        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.BITS_FABRICATOR.get()));
    }

    @Override
    public RecipeType<BitsFabricationRecipe> getRecipeType() {
        return BITS_FABRICATION_TYPE;
    }

    @Override
    public Component getTitle() {

        return Component.translatable("block.blockchain_currency.bits_fabricator");
    }

    @Override
    public IDrawable getBackground() {

        return this.background;
    }

    @Override
    public IDrawable getIcon() {

        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, BitsFabricationRecipe recipe, IFocusGroup focuses) {

        builder.addSlot(RecipeIngredientRole.INPUT, 80, 11).addIngredients(recipe.getIngredients().get(0));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 80, 59).addItemStack(recipe.getResultItem(null));
    }
}
