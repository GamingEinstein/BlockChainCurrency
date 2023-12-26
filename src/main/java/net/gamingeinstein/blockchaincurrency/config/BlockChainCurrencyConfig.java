package net.gamingeinstein.blockchaincurrency.config;

import net.gamingeinstein.blockchaincurrency.BlockChainCurrency;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

/*
 * Basically copied this from Traveler's Backpack, since it was the most sensible one that works.
 * That, and... there aren't really any updated tutorials on configs... nor are they this simple...
 * This might not work or is broken somewhere, but hey, at least it's something I guess
 * Actually this 100% doesn't work, since I can't figure out how to make it change recipe inputs/outputs in JSON files...
 * I'll ignore that
 */

@Mod.EventBusSubscriber(modid = BlockChainCurrency.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockChainCurrencyConfig {

    //Bit Fabrication Settings
    public static String singleBitBase;
    public static int baseToSingleYield;
    public static int singleToDoubleYield;
    public static int doubleToTripleYield;

    public static class Common {

        private static final String REGISTRY_NAME_MATCHER = "([a-z0-9_.-]+:[a-z0-9_/.-]+)";

        BitFabricationSettings bitFabricationSettings;

        Common(final ForgeConfigSpec.Builder builder) {

            builder.comment("Common config settings")
                    .push("common");

            //Bit Fabrication Settings
            bitFabricationSettings = new BitFabricationSettings(builder, "bitFabricationSettings");

            builder.pop();
        }

        public static class BitFabricationSettings {

            public final ForgeConfigSpec.ConfigValue<? extends String> singleBitBase;
            public final ForgeConfigSpec.IntValue baseToSingleYield;
            public final ForgeConfigSpec.IntValue singleToDoubleYield;
            public final ForgeConfigSpec.IntValue doubleToTripleYield;

            BitFabricationSettings(final ForgeConfigSpec.Builder builder, final String path) {

                builder.push(path);

                //Bit Fabrication Settings
                singleBitBase = builder
                        .define("singleBitBase", String.valueOf(Items.DIAMOND));
                baseToSingleYield = builder
                        .comment("How many Single Bits should yield from Base Item")
                        .defineInRange("basteToSingleYield", 8, 1, 64);
                singleToDoubleYield = builder
                        .comment("How many Double Bits should yield from Single Bits")
                        .defineInRange("singleToDoubleBits", 9, 1, 64);
                doubleToTripleYield = builder
                        .comment("How many Triple Bits should yield from Double Bits")
                        .defineInRange("doubleToTripleBits", 9, 1, 64);

                builder.pop();
            }
        }

        public void loadItemsFromConfig(List<? extends String> configList, List<Item> targetList) {

            for (String registryName : configList) {
                ResourceLocation res  = new ResourceLocation(registryName);

                if (ForgeRegistries.ITEMS.containsKey(res)) {
                    targetList.add(ForgeRegistries.ITEMS.getValue(res));
                }
            }
        }
    }

    //Common
    private static final ForgeConfigSpec commonSpec;
    public static final Common COMMON;

    static {
        final Pair<Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Common::new);
        commonSpec = specPair.getRight();
        COMMON = specPair.getLeft();
    }

    //Registry
    public static void register(final ModLoadingContext context) {

        context.registerConfig(ModConfig.Type.COMMON, commonSpec);
    }

    @SubscribeEvent
    public static void onModConfigEvent(final ModConfigEvent.Loading configEvent) {

        if (configEvent.getConfig().getSpec() == BlockChainCurrencyConfig.commonSpec) {
            bakeCommonConfig();
        }
    }

    public static void bakeCommonConfig() {

        //Bit Fabrication Settings
        singleBitBase = COMMON.bitFabricationSettings.singleBitBase.get();
        baseToSingleYield = COMMON.bitFabricationSettings.baseToSingleYield.get();
        singleToDoubleYield = COMMON.bitFabricationSettings.singleToDoubleYield.get();
        doubleToTripleYield = COMMON.bitFabricationSettings.doubleToTripleYield.get();
    }

    //Gather Data
    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event) {

        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        boolean includeServer = event.includeServer();
    }
}
