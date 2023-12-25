package net.gamingeinstein.blockchaincurrency.datagen;

import net.gamingeinstein.blockchaincurrency.BlockChainCurrency;
import net.gamingeinstein.blockchaincurrency.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.network.protocol.game.ClientboundBlockChangedAckPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, BlockChainCurrency.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.SINGLE_BIT);
        simpleItem(ModItems.DOUBLE_BIT);
        simpleItem(ModItems.TRIPLE_BIT);
        simpleItem(ModItems.BITS_WALLET);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(BlockChainCurrency.MOD_ID, "item/" + item.getId().getPath()));
    }
}
