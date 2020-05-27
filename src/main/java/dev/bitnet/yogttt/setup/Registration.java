package dev.bitnet.yogttt.setup;

import dev.bitnet.yogttt.block.C4Block;
import dev.bitnet.yogttt.block.ExplosiveBundleBlock;
import dev.bitnet.yogttt.entity.DonconHeadEntity;
import dev.bitnet.yogttt.item.*;
import dev.bitnet.yogttt.tile_entity.C4Tile;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static dev.bitnet.yogttt.YogTTT.MODID;

public class Registration {
    private static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, MODID);
    private static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, MODID);
    private static final DeferredRegister<TileEntityType<?>> TILES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, MODID);
    private static final DeferredRegister<ContainerType<?>> CONTAINERS = new DeferredRegister<>(ForgeRegistries.CONTAINERS, MODID);
    private static final DeferredRegister<EntityType<?>> ENTITIES = new DeferredRegister<>(ForgeRegistries.ENTITIES, MODID);
    private static final DeferredRegister<ModDimension> DIMENSIONS = new DeferredRegister<>(ForgeRegistries.MOD_DIMENSIONS, MODID);

    public static void init() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        TILES.register(FMLJavaModLoadingContext.get().getModEventBus());
        CONTAINERS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
        DIMENSIONS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }


    //Items
    public static final RegistryObject<IconItem> ICON = ITEMS.register("icon", IconItem::new);
    public static final RegistryObject<TeleporterItem> TELEPORTER = ITEMS.register("teleporter", TeleporterItem::new);
    public static final RegistryObject<MedKitItem> MEDKIT = ITEMS.register("medkit", MedKitItem::new);
    public static final RegistryObject<HomerunBatItem> HOMERUN_BAT = ITEMS.register("homerun_bat", HomerunBatItem::new);
    public static final RegistryObject<ExplosiveCellItem> EXPLOSIVE_CELL = ITEMS.register("explosive_cell", ExplosiveCellItem::new);
    public static final RegistryObject<C4TimerItem> CFOUR_TIMER = ITEMS.register("cfour_timer", C4TimerItem::new);
    public static final RegistryObject<DonconnonItem> DONCONNON = ITEMS.register("donconnon", DonconnonItem::new);

    //Blocks
    public static final RegistryObject<C4Block> CFOUR = BLOCKS.register("cfour", C4Block::new);
    public static final RegistryObject<ExplosiveBundleBlock> EXPLOSIVE_BUNDLE = BLOCKS.register("explosive_bundle", ExplosiveBundleBlock::new);

    //BlockItems
    public static final RegistryObject<Item> CFOUR_ITEM = ITEMS.register("cfour", () -> new BlockItem(CFOUR.get(),  new Item.Properties().group(ModSetup.itemGroup)));
    public static final RegistryObject<Item> EXPLOSIVE_BUNDLE_ITEM = ITEMS.register("explosive_bundle", () -> new BlockItem(EXPLOSIVE_BUNDLE.get(), new Item.Properties().group(ModSetup.itemGroup)));

    //Tile Entities
    public static final RegistryObject<TileEntityType<C4Tile>> CFOUR_TILE = TILES.register("cfour", () -> TileEntityType.Builder.create(C4Tile::new, CFOUR.get()).build(null));

    //Entity
    public static final RegistryObject<EntityType<DonconHeadEntity>> DONCON_HEAD = ENTITIES.register("doncon_head", () -> EntityType.Builder.<DonconHeadEntity>create(DonconHeadEntity::new, EntityClassification.MISC)
            .immuneToFire()
            .size(5, 5)
            .build("doncon_head")
    );
}
