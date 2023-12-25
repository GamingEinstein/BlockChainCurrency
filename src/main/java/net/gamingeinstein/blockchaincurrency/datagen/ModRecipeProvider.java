package net.gamingeinstein.blockchaincurrency.datagen;

import net.gamingeinstein.blockchaincurrency.block.ModBlocks;
import net.gamingeinstein.blockchaincurrency.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.DOUBLE_BIT.get(), 9)
                .requires(ModItems.TRIPLE_BIT.get())
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SINGLE_BIT.get(), 9)
                .requires(ModItems.DOUBLE_BIT.get())
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BITS_FABRICATOR.get())
                .pattern("PPP")
                .pattern("#I#")
                .pattern("###")
                .define('P', Items.PAPER)
                .define('#', ItemTags.PLANKS)
                .define('I', Items.IRON_INGOT)
                .unlockedBy(getHasName(Items.PAPER), has(Items.PAPER))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BITS_WALLET.get())
                .pattern("#I#")
                .pattern("###")
                .define('#', Items.LEATHER)
                .define('I', Items.IRON_INGOT)
                .unlockedBy(getHasName(Items.LEATHER), has(Items.LEATHER))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DOUBLE_BIT.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.SINGLE_BIT.get())
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TRIPLE_BIT.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.DOUBLE_BIT.get())
                .save(pWriter);
    }
}
