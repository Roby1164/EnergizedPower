package me.jddev0.ep.block;

import me.jddev0.ep.EnergizedPowerMod;
import me.jddev0.ep.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModBlocks {
    private ModBlocks() {}

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, EnergizedPowerMod.MODID);

    private static RegistryObject<Item> createBlockItem(String name, RegistryObject<Block> blockRegistryObject, Item.Properties props) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(blockRegistryObject.get(), props));
    }
    private static RegistryObject<Item> createBlockItem(String name, RegistryObject<Block> blockRegistryObject) {
        return createBlockItem(name, blockRegistryObject, new Item.Properties());
    }

    public static final RegistryObject<Block> SILICON_BLOCK = BLOCKS.register("silicon_block",
            () -> new Block(BlockBehaviour.Properties.of().
                    requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL)));
    public static final RegistryObject<Item> SILICON_BLOCK_ITEM = createBlockItem("silicon_block", SILICON_BLOCK);

    public static final RegistryObject<Block> SAWDUST_BLOCK = BLOCKS.register("sawdust_block",
            () -> new SimpleFlammableBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).
                    strength(2.0f, 3.0f).sound(SoundType.WOOD), 5, 20));
    public static final RegistryObject<Item> SAWDUST_BLOCK_ITEM = createBlockItem("sawdust_block", SAWDUST_BLOCK);

    public static final RegistryObject<Block> ITEM_CONVEYOR_BELT = BLOCKS.register("item_conveyor_belt",
            () -> new ItemConveyorBeltBlock(BlockBehaviour.Properties.of().noCollission().
                    strength(2.5f, 3.0f).sound(SoundType.METAL)));
    public static final RegistryObject<Item> ITEM_CONVEYOR_BELT_ITEM = ModItems.ITEMS.register("item_conveyor_belt",
            () -> new ItemConveyorBeltBlock.Item(ITEM_CONVEYOR_BELT.get(), new Item.Properties()));

    public static final RegistryObject<Block> ITEM_CONVEYOR_BELT_LOADER = BLOCKS.register("item_conveyor_belt_loader",
            () -> new ItemConveyorBeltLoaderBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).
                    instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.5f).sound(SoundType.STONE)));
    public static final RegistryObject<Item> ITEM_CONVEYOR_BELT_LOADER_ITEM = createBlockItem("item_conveyor_belt_loader", ITEM_CONVEYOR_BELT_LOADER);

    public static final RegistryObject<Block> ITEM_CONVEYOR_BELT_SORTER = BLOCKS.register("item_conveyor_belt_sorter",
            () -> new ItemConveyorBeltSorterBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).
                    instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.5f).sound(SoundType.STONE)));
    public static final RegistryObject<Item> ITEM_CONVEYOR_BELT_SORTER_ITEM = createBlockItem("item_conveyor_belt_sorter", ITEM_CONVEYOR_BELT_SORTER);

    public static final RegistryObject<Block> ITEM_CONVEYOR_BELT_SWITCH = BLOCKS.register("item_conveyor_belt_switch",
            () -> new ItemConveyorBeltSwitchBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).
                    instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.5f).sound(SoundType.STONE)));
    public static final RegistryObject<Item> ITEM_CONVEYOR_BELT_SWITCH_ITEM = createBlockItem("item_conveyor_belt_switch", ITEM_CONVEYOR_BELT_SWITCH);

    public static final RegistryObject<Block> ITEM_CONVEYOR_BELT_SPLITTER = BLOCKS.register("item_conveyor_belt_splitter",
            () -> new ItemConveyorBeltSplitterBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).
                    instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.5f).sound(SoundType.STONE)));
    public static final RegistryObject<Item> ITEM_CONVEYOR_BELT_SPLITTER_ITEM = createBlockItem("item_conveyor_belt_splitter", ITEM_CONVEYOR_BELT_SPLITTER);

    public static final RegistryObject<Block> ITEM_CONVEYOR_BELT_MERGER = BLOCKS.register("item_conveyor_belt_merger",
            () -> new ItemConveyorBeltMergerBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).
                    instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.5f).sound(SoundType.STONE)));
    public static final RegistryObject<Item> ITEM_CONVEYOR_BELT_MERGER_ITEM = createBlockItem("item_conveyor_belt_merger", ITEM_CONVEYOR_BELT_MERGER);

    public static final RegistryObject<FluidPipeBlock> FLUID_PIPE = BLOCKS.register("fluid_pipe",
            () -> new FluidPipeBlock(BlockBehaviour.Properties.of().
                    requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL)));
    public static final RegistryObject<Item> FLUID_PIPE_ITEM = ModItems.ITEMS.register("fluid_pipe",
            () -> new FluidPipeBlock.Item(FLUID_PIPE.get(), new Item.Properties()));

    public static final RegistryObject<CableBlock> COPPER_CABLE = BLOCKS.register("copper_cable",
            () -> new CableBlock(CableBlock.Tier.TIER_COPPER));
    public static final RegistryObject<Item> COPPER_CABLE_ITEM = ModItems.ITEMS.register("copper_cable",
            () -> new CableBlock.Item(COPPER_CABLE.get(), new Item.Properties(), CableBlock.Tier.TIER_COPPER));

    public static final RegistryObject<CableBlock> GOLD_CABLE = BLOCKS.register("gold_cable",
            () -> new CableBlock(CableBlock.Tier.TIER_GOLD));
    public static final RegistryObject<Item> GOLD_CABLE_ITEM = ModItems.ITEMS.register("gold_cable",
            () -> new CableBlock.Item(GOLD_CABLE.get(), new Item.Properties(), CableBlock.Tier.TIER_GOLD));

    public static final RegistryObject<CableBlock> ENERGIZED_COPPER_CABLE = BLOCKS.register("energized_copper_cable",
            () -> new CableBlock(CableBlock.Tier.TIER_ENERGIZED_COPPER));
    public static final RegistryObject<Item> ENERGIZED_COPPER_CABLE_ITEM = ModItems.ITEMS.register("energized_copper_cable",
            () -> new CableBlock.Item(ENERGIZED_COPPER_CABLE.get(), new Item.Properties(), CableBlock.Tier.TIER_ENERGIZED_COPPER));

    public static final RegistryObject<CableBlock> ENERGIZED_GOLD_CABLE = BLOCKS.register("energized_gold_cable",
            () -> new CableBlock(CableBlock.Tier.TIER_ENERGIZED_GOLD));
    public static final RegistryObject<Item> ENERGIZED_GOLD_CABLE_ITEM = ModItems.ITEMS.register("energized_gold_cable",
            () -> new CableBlock.Item(ENERGIZED_GOLD_CABLE.get(), new Item.Properties(), CableBlock.Tier.TIER_ENERGIZED_GOLD));

    public static final RegistryObject<CableBlock> ENERGIZED_CRYSTAL_MATRIX_CABLE = BLOCKS.register("energized_crystal_matrix_cable",
            () -> new CableBlock(CableBlock.Tier.TIER_ENERGIZED_CRYSTAL_MATRIX));
    public static final RegistryObject<Item> ENERGIZED_CRYSTAL_MATRIX_CABLE_ITEM = ModItems.ITEMS.register("energized_crystal_matrix_cable",
            () -> new CableBlock.Item(ENERGIZED_CRYSTAL_MATRIX_CABLE.get(), new Item.Properties(), CableBlock.Tier.TIER_ENERGIZED_CRYSTAL_MATRIX));

    public static final RegistryObject<TransformerBlock> MV_TRANSFORMER_1_TO_N = BLOCKS.register("transformer_1_to_n",
            () -> new TransformerBlock(BlockBehaviour.Properties.of().
                    requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL),
                    TransformerBlock.Tier.TIER_MV, TransformerBlock.Type.TYPE_1_TO_N));
    public static final RegistryObject<Item> MV_TRANSFORMER_1_TO_N_ITEM = ModItems.ITEMS.register("transformer_1_to_n",
            () -> new TransformerBlock.Item(MV_TRANSFORMER_1_TO_N.get(), new Item.Properties(),
                    TransformerBlock.Tier.TIER_MV, TransformerBlock.Type.TYPE_1_TO_N));

    public static final RegistryObject<TransformerBlock> MV_TRANSFORMER_3_TO_3 = BLOCKS.register("transformer_3_to_3",
            () -> new TransformerBlock(BlockBehaviour.Properties.of().
                    requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL),
                    TransformerBlock.Tier.TIER_MV, TransformerBlock.Type.TYPE_3_TO_3));
    public static final RegistryObject<Item> MV_TRANSFORMER_3_TO_3_ITEM = ModItems.ITEMS.register("transformer_3_to_3",
            () -> new TransformerBlock.Item(MV_TRANSFORMER_3_TO_3.get(), new Item.Properties(),
                    TransformerBlock.Tier.TIER_MV, TransformerBlock.Type.TYPE_3_TO_3));

    public static final RegistryObject<TransformerBlock> MV_TRANSFORMER_N_TO_1 = BLOCKS.register("transformer_n_to_1",
            () -> new TransformerBlock(BlockBehaviour.Properties.of().
                    requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL),
                    TransformerBlock.Tier.TIER_MV, TransformerBlock.Type.TYPE_N_TO_1));
    public static final RegistryObject<Item> MV_TRANSFORMER_N_TO_1_ITEM = ModItems.ITEMS.register("transformer_n_to_1",
            () -> new TransformerBlock.Item(MV_TRANSFORMER_N_TO_1.get(), new Item.Properties(),
                    TransformerBlock.Tier.TIER_MV, TransformerBlock.Type.TYPE_N_TO_1));

    public static final RegistryObject<TransformerBlock> HV_TRANSFORMER_1_TO_N = BLOCKS.register("hv_transformer_1_to_n",
            () -> new TransformerBlock(BlockBehaviour.Properties.of().
                    requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL),
                    TransformerBlock.Tier.TIER_HV, TransformerBlock.Type.TYPE_1_TO_N));
    public static final RegistryObject<Item> HV_TRANSFORMER_1_TO_N_ITEM = ModItems.ITEMS.register("hv_transformer_1_to_n",
            () -> new TransformerBlock.Item(HV_TRANSFORMER_1_TO_N.get(), new Item.Properties(),
                    TransformerBlock.Tier.TIER_HV, TransformerBlock.Type.TYPE_1_TO_N));

    public static final RegistryObject<TransformerBlock> HV_TRANSFORMER_3_TO_3 = BLOCKS.register("hv_transformer_3_to_3",
            () -> new TransformerBlock(BlockBehaviour.Properties.of().
                    requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL),
                    TransformerBlock.Tier.TIER_HV, TransformerBlock.Type.TYPE_3_TO_3));
    public static final RegistryObject<Item> HV_TRANSFORMER_3_TO_3_ITEM = ModItems.ITEMS.register("hv_transformer_3_to_3",
            () -> new TransformerBlock.Item(HV_TRANSFORMER_3_TO_3.get(), new Item.Properties(),
                    TransformerBlock.Tier.TIER_HV, TransformerBlock.Type.TYPE_3_TO_3));

    public static final RegistryObject<TransformerBlock> HV_TRANSFORMER_N_TO_1 = BLOCKS.register("hv_transformer_n_to_1",
            () -> new TransformerBlock(BlockBehaviour.Properties.of().
                    requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL),
                    TransformerBlock.Tier.TIER_HV, TransformerBlock.Type.TYPE_N_TO_1));
    public static final RegistryObject<Item> HV_TRANSFORMER_N_TO_1_ITEM = ModItems.ITEMS.register("hv_transformer_n_to_1",
            () -> new TransformerBlock.Item(HV_TRANSFORMER_N_TO_1.get(), new Item.Properties(),
                    TransformerBlock.Tier.TIER_HV, TransformerBlock.Type.TYPE_N_TO_1));

    public static final RegistryObject<TransformerBlock> EHV_TRANSFORMER_1_TO_N = BLOCKS.register("ehv_transformer_1_to_n",
            () -> new TransformerBlock(BlockBehaviour.Properties.of().
                    requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL),
                    TransformerBlock.Tier.TIER_EHV, TransformerBlock.Type.TYPE_1_TO_N));
    public static final RegistryObject<Item> EHV_TRANSFORMER_1_TO_N_ITEM = ModItems.ITEMS.register("ehv_transformer_1_to_n",
            () -> new TransformerBlock.Item(EHV_TRANSFORMER_1_TO_N.get(), new Item.Properties(),
                    TransformerBlock.Tier.TIER_EHV, TransformerBlock.Type.TYPE_1_TO_N));

    public static final RegistryObject<TransformerBlock> EHV_TRANSFORMER_3_TO_3 = BLOCKS.register("ehv_transformer_3_to_3",
            () -> new TransformerBlock(BlockBehaviour.Properties.of().
                    requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL),
                    TransformerBlock.Tier.TIER_EHV, TransformerBlock.Type.TYPE_3_TO_3));
    public static final RegistryObject<Item> EHV_TRANSFORMER_3_TO_3_ITEM = ModItems.ITEMS.register("ehv_transformer_3_to_3",
            () -> new TransformerBlock.Item(EHV_TRANSFORMER_3_TO_3.get(), new Item.Properties(),
                    TransformerBlock.Tier.TIER_EHV, TransformerBlock.Type.TYPE_3_TO_3));

    public static final RegistryObject<TransformerBlock> EHV_TRANSFORMER_N_TO_1 = BLOCKS.register("ehv_transformer_n_to_1",
            () -> new TransformerBlock(BlockBehaviour.Properties.of().
                    requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL),
                    TransformerBlock.Tier.TIER_EHV, TransformerBlock.Type.TYPE_N_TO_1));
    public static final RegistryObject<Item> EHV_TRANSFORMER_N_TO_1_ITEM = ModItems.ITEMS.register("ehv_transformer_n_to_1",
            () -> new TransformerBlock.Item(EHV_TRANSFORMER_N_TO_1.get(), new Item.Properties(),
                    TransformerBlock.Tier.TIER_EHV, TransformerBlock.Type.TYPE_N_TO_1));

    public static final RegistryObject<Block> BATTERY_BOX = BLOCKS.register("battery_box",
            () -> new BatteryBoxBlock(BlockBehaviour.Properties.of().
                    requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL)));
    public static final RegistryObject<Item> BATTERY_BOX_ITEM = ModItems.ITEMS.register("battery_box",
            () -> new BatteryBoxBlock.Item(BATTERY_BOX.get(), new Item.Properties()));

    public static final RegistryObject<Block> ADVANCED_BATTERY_BOX = BLOCKS.register("advanced_battery_box",
            () -> new AdvancedBatteryBoxBlock(BlockBehaviour.Properties.of().
                    requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL)));
    public static final RegistryObject<Item> ADVANCED_BATTERY_BOX_ITEM = ModItems.ITEMS.register("advanced_battery_box",
            () -> new AdvancedBatteryBoxBlock.Item(ADVANCED_BATTERY_BOX.get(), new Item.Properties()));

    public static final RegistryObject<Block> CREATIVE_BATTERY_BOX = BLOCKS.register("creative_battery_box",
            () -> new CreativeBatteryBoxBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).
                    requiresCorrectToolForDrops().strength(-1.f, 3600000.f).noLootTable()));
    public static final RegistryObject<Item> CREATIVE_BATTERY_BOX_ITEM = ModItems.ITEMS.register("creative_battery_box",
            () -> new CreativeBatteryBoxBlock.Item(CREATIVE_BATTERY_BOX.get(), new Item.Properties()));

    public static final RegistryObject<Block> AUTO_CRAFTER = BLOCKS.register("auto_crafter",
            () -> new AutoCrafterBlock(BlockBehaviour.Properties.of().
                    requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL)));
    public static final RegistryObject<Item> AUTO_CRAFTER_ITEM = ModItems.ITEMS.register("auto_crafter",
            () -> new AutoCrafterBlock.Item(AUTO_CRAFTER.get(), new Item.Properties()));

    public static final RegistryObject<Block> CRUSHER = BLOCKS.register("crusher",
            () -> new CrusherBlock(BlockBehaviour.Properties.of().
                    requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL)));
    public static final RegistryObject<Item> CRUSHER_ITEM = createBlockItem("crusher", CRUSHER);

    public static final RegistryObject<Block> PULVERIZER = BLOCKS.register("pulverizer",
            () -> new PulverizerBlock(BlockBehaviour.Properties.of().
                    requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL)));
    public static final RegistryObject<Item> PULVERIZER_ITEM = createBlockItem("pulverizer", PULVERIZER);

    public static final RegistryObject<Block> SAWMILL = BLOCKS.register("sawmill",
            () -> new SawmillBlock(BlockBehaviour.Properties.of().
                    requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL)));
    public static final RegistryObject<Item> SAWMILL_ITEM = createBlockItem("sawmill", SAWMILL);

    public static final RegistryObject<Block> COMPRESSOR = BLOCKS.register("compressor",
            () -> new CompressorBlock(BlockBehaviour.Properties.of().
                    requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL)));
    public static final RegistryObject<Item> COMPRESSOR_ITEM = createBlockItem("compressor", COMPRESSOR);

    public static final RegistryObject<Block> PLANT_GROWTH_CHAMBER = BLOCKS.register("plant_growth_chamber",
            () -> new PlantGrowthChamberBlock(BlockBehaviour.Properties.of().
                    requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL)));
    public static final RegistryObject<Item> PLANT_GROWTH_CHAMBER_ITEM = createBlockItem("plant_growth_chamber", PLANT_GROWTH_CHAMBER);

    public static final RegistryObject<Block> BLOCK_PLACER = BLOCKS.register("block_placer",
            () -> new BlockPlacerBlock(BlockBehaviour.Properties.of().
                    requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL)));
    public static final RegistryObject<Item> BLOCK_PLACER_ITEM = createBlockItem("block_placer", BLOCK_PLACER);

    public static final RegistryObject<Block> FLUID_FILLER = BLOCKS.register("fluid_filler",
            () -> new FluidFillerBlock(BlockBehaviour.Properties.of().
                    requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL)));
    public static final RegistryObject<Item> FLUID_FILLER_ITEM = createBlockItem("fluid_filler", FLUID_FILLER);

    public static final RegistryObject<Block> FLUID_DRAINER = BLOCKS.register("fluid_drainer",
            () -> new FluidDrainerBlock(BlockBehaviour.Properties.of().
                    requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL)));
    public static final RegistryObject<Item> FLUID_DRAINER_ITEM = createBlockItem("fluid_drainer", FLUID_DRAINER);

    public static final RegistryObject<Block> CHARGER = BLOCKS.register("charger",
            () -> new ChargerBlock(BlockBehaviour.Properties.of().
                    requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL)));
    public static final RegistryObject<Item> CHARGER_ITEM = ModItems.ITEMS.register("charger",
            () -> new ChargerBlock.Item(CHARGER.get(), new Item.Properties()));

    public static final RegistryObject<Block> ADVANCED_CHARGER = BLOCKS.register("advanced_charger",
            () -> new AdvancedChargerBlock(BlockBehaviour.Properties.of().
                    requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL)));
    public static final RegistryObject<Item> ADVANCED_CHARGER_ITEM = ModItems.ITEMS.register("advanced_charger",
            () -> new AdvancedChargerBlock.Item(ADVANCED_CHARGER.get(), new Item.Properties()));

    public static final RegistryObject<Block> UNCHARGER = BLOCKS.register("uncharger",
            () -> new UnchargerBlock(BlockBehaviour.Properties.of().
                    requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL)));
    public static final RegistryObject<Item> UNCHARGER_ITEM = createBlockItem("uncharger", UNCHARGER);

    public static final RegistryObject<Block> ADVANCED_UNCHARGER = BLOCKS.register("advanced_uncharger",
            () -> new AdvancedUnchargerBlock(BlockBehaviour.Properties.of().
                    requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL)));
    public static final RegistryObject<Item> ADVANCED_UNCHARGER_ITEM = createBlockItem("advanced_uncharger", ADVANCED_UNCHARGER);

    public static final RegistryObject<Block> MINECART_CHARGER = BLOCKS.register("minecart_charger",
            () -> new MinecartChargerBlock(BlockBehaviour.Properties.of().
                    requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL)));
    public static final RegistryObject<Item> MINECART_CHARGER_ITEM = ModItems.ITEMS.register("minecart_charger",
            () -> new MinecartChargerBlock.Item(MINECART_CHARGER.get(), new Item.Properties()));

    public static final RegistryObject<Block> ADVANCED_MINECART_CHARGER = BLOCKS.register("advanced_minecart_charger",
            () -> new AdvancedMinecartChargerBlock(BlockBehaviour.Properties.of().
                    requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL)));
    public static final RegistryObject<Item> ADVANCED_MINECART_CHARGER_ITEM = ModItems.ITEMS.register("advanced_minecart_charger",
            () -> new AdvancedMinecartChargerBlock.Item(ADVANCED_MINECART_CHARGER.get(), new Item.Properties()));

    public static final RegistryObject<Block> MINECART_UNCHARGER = BLOCKS.register("minecart_uncharger",
            () -> new MinecartUnchargerBlock(BlockBehaviour.Properties.of().
                    requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL)));
    public static final RegistryObject<Item> MINECART_UNCHARGER_ITEM = ModItems.ITEMS.register("minecart_uncharger",
            () -> new MinecartUnchargerBlock.Item(MINECART_UNCHARGER.get(), new Item.Properties()));

    public static final RegistryObject<Block> ADVANCED_MINECART_UNCHARGER = BLOCKS.register("advanced_minecart_uncharger",
            () -> new AdvancedMinecartUnchargerBlock(BlockBehaviour.Properties.of().
                    requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL)));
    public static final RegistryObject<Item> ADVANCED_MINECART_UNCHARGER_ITEM = ModItems.ITEMS.register("advanced_minecart_uncharger",
            () -> new AdvancedMinecartUnchargerBlock.Item(ADVANCED_MINECART_UNCHARGER.get(), new Item.Properties()));


    private static RegistryObject<Item> createSolarPanelBlockItem(String name, RegistryObject<SolarPanelBlock> blockRegistryObject) {
        return ModItems.ITEMS.register(name, () -> new SolarPanelBlock.Item(blockRegistryObject.get(), new Item.Properties(),
                blockRegistryObject.get().getTier()));
    }
    public static final RegistryObject<SolarPanelBlock> SOLAR_PANEL_1 = BLOCKS.register("solar_panel_1",
            () -> new SolarPanelBlock(SolarPanelBlock.Tier.TIER_1));
    public static final RegistryObject<Item> SOLAR_PANEL_ITEM_1 = createSolarPanelBlockItem("solar_panel_1", SOLAR_PANEL_1);

    public static final RegistryObject<SolarPanelBlock> SOLAR_PANEL_2 = BLOCKS.register("solar_panel_2",
            () -> new SolarPanelBlock(SolarPanelBlock.Tier.TIER_2));
    public static final RegistryObject<Item> SOLAR_PANEL_ITEM_2 = createSolarPanelBlockItem("solar_panel_2", SOLAR_PANEL_2);

    public static final RegistryObject<SolarPanelBlock> SOLAR_PANEL_3 = BLOCKS.register("solar_panel_3",
            () -> new SolarPanelBlock(SolarPanelBlock.Tier.TIER_3));
    public static final RegistryObject<Item> SOLAR_PANEL_ITEM_3 = createSolarPanelBlockItem("solar_panel_3", SOLAR_PANEL_3);

    public static final RegistryObject<SolarPanelBlock> SOLAR_PANEL_4 = BLOCKS.register("solar_panel_4",
            () -> new SolarPanelBlock(SolarPanelBlock.Tier.TIER_4));
    public static final RegistryObject<Item> SOLAR_PANEL_ITEM_4 = createSolarPanelBlockItem("solar_panel_4", SOLAR_PANEL_4);

    public static final RegistryObject<SolarPanelBlock> SOLAR_PANEL_5 = BLOCKS.register("solar_panel_5",
            () -> new SolarPanelBlock(SolarPanelBlock.Tier.TIER_5));
    public static final RegistryObject<Item> SOLAR_PANEL_ITEM_5 = createSolarPanelBlockItem("solar_panel_5", SOLAR_PANEL_5);

    public static final RegistryObject<Block> COAL_ENGINE = BLOCKS.register("coal_engine",
            () -> new CoalEngineBlock(BlockBehaviour.Properties.of().
                    requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL).
                    lightLevel(CoalEngineBlock.LIGHT_EMISSION)));
    public static final RegistryObject<Item> COAL_ENGINE_ITEM = createBlockItem("coal_engine", COAL_ENGINE);

    public static final RegistryObject<Block> HEAT_GENERATOR = BLOCKS.register("heat_generator",
            () -> new HeatGeneratorBlock(BlockBehaviour.Properties.of().
                    requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL)));
    public static final RegistryObject<Item> HEAT_GENERATOR_ITEM = createBlockItem("heat_generator", HEAT_GENERATOR);

    public static final RegistryObject<Block> THERMAL_GENERATOR = BLOCKS.register("thermal_generator",
            () -> new ThermalGeneratorBlock(BlockBehaviour.Properties.of().
                    requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL)));
    public static final RegistryObject<Item> THERMAL_GENERATOR_ITEM = createBlockItem("thermal_generator", THERMAL_GENERATOR);

    public static final RegistryObject<Block> POWERED_LAMP = BLOCKS.register("powered_lamp",
            () -> new PoweredLampBlock(BlockBehaviour.Properties.of().
                    strength(.3f).sound(SoundType.GLASS).
                    lightLevel(PoweredLampBlock.LIGHT_EMISSION)));
    public static final RegistryObject<Item> POWERED_LAMP_ITEM = createBlockItem("powered_lamp", POWERED_LAMP);

    public static final RegistryObject<Block> POWERED_FURNACE = BLOCKS.register("powered_furnace",
            () -> new PoweredFurnaceBlock(BlockBehaviour.Properties.of().
                    requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL).
                    lightLevel(PoweredFurnaceBlock.LIGHT_EMISSION)));
    public static final RegistryObject<Item> POWERED_FURNACE_ITEM = createBlockItem("powered_furnace", POWERED_FURNACE);

    public static final RegistryObject<Block> ADVANCED_POWERED_FURNACE = BLOCKS.register("advanced_powered_furnace",
            () -> new AdvancedPoweredFurnaceBlock(BlockBehaviour.Properties.of().
                    requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL).
                    lightLevel(AdvancedPoweredFurnaceBlock.LIGHT_EMISSION)));
    public static final RegistryObject<Item> ADVANCED_POWERED_FURNACE_ITEM = createBlockItem("advanced_powered_furnace", ADVANCED_POWERED_FURNACE);

    public static final RegistryObject<Block> LIGHTNING_GENERATOR = BLOCKS.register("lightning_generator",
            () -> new LightningGeneratorBlock(BlockBehaviour.Properties.of().
                    requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL).
                    lightLevel(LightningGeneratorBlock.LIGHT_EMISSION)));
    public static final RegistryObject<Item> LIGHTNING_GENERATOR_ITEM = ModItems.ITEMS.register("lightning_generator",
            () -> new LightningGeneratorBlock.Item(LIGHTNING_GENERATOR.get(), new Item.Properties()));

    public static final RegistryObject<Block> ENERGIZER = BLOCKS.register("energizer",
            () -> new EnergizerBlock(BlockBehaviour.Properties.of().
                    requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL).
                    lightLevel(EnergizerBlock.LIGHT_EMISSION)));
    public static final RegistryObject<Item> ENERGIZER_ITEM = createBlockItem("energizer", ENERGIZER);

    public static final RegistryObject<Block> CHARGING_STATION = BLOCKS.register("charging_station",
            () -> new ChargingStationBlock(BlockBehaviour.Properties.of().
                    requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL).
                    lightLevel(ChargingStationBlock.LIGHT_EMISSION)));
    public static final RegistryObject<Item> CHARGING_STATION_ITEM = ModItems.ITEMS.register("charging_station",
            () -> new ChargingStationBlock.Item(CHARGING_STATION.get(), new Item.Properties()));

    public static final RegistryObject<Block> WEATHER_CONTROLLER = BLOCKS.register("weather_controller",
            () -> new WeatherControllerBlock(BlockBehaviour.Properties.of().
                    requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL)));
    public static final RegistryObject<Item> WEATHER_CONTROLLER_ITEM = createBlockItem("weather_controller", WEATHER_CONTROLLER);

    public static final RegistryObject<Block> TIME_CONTROLLER = BLOCKS.register("time_controller",
            () -> new TimeControllerBlock(BlockBehaviour.Properties.of().
                    requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL)));
    public static final RegistryObject<Item> TIME_CONTROLLER_ITEM = createBlockItem("time_controller", TIME_CONTROLLER);

    public static final RegistryObject<Block> BASIC_MACHINE_FRAME = BLOCKS.register("basic_machine_frame",
            () -> new Block(BlockBehaviour.Properties.of().
                    requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL)));
    public static final RegistryObject<Item> BASIC_MACHINE_FRAME_ITEM = createBlockItem("basic_machine_frame", BASIC_MACHINE_FRAME);

    public static final RegistryObject<Block> ADVANCED_MACHINE_FRAME = BLOCKS.register("advanced_machine_frame",
            () -> new Block(BlockBehaviour.Properties.of().
                    requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL)));
    public static final RegistryObject<Item> ADVANCED_MACHINE_FRAME_ITEM = createBlockItem("advanced_machine_frame", ADVANCED_MACHINE_FRAME);

    public static final RegistryObject<Block> REINFORCED_ADVANCED_MACHINE_FRAME = BLOCKS.register("reinforced_advanced_machine_frame",
            () -> new Block(BlockBehaviour.Properties.of().
                    requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL)));
    public static final RegistryObject<Item> REINFORCED_ADVANCED_MACHINE_FRAME_ITEM = createBlockItem("reinforced_advanced_machine_frame", REINFORCED_ADVANCED_MACHINE_FRAME);

    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
    }
}
