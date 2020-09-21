package com.mxcraven.ageofmagic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mxcraven.ageofmagic.entity.rock.RockEntity;
import com.mxcraven.ageofmagic.item.KnifeItem;
import com.mxcraven.ageofmagic.item.RockItem;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.util.ResourceLocation;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("ageofmagic")
public class AgeOfMagic
{
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "ageofmagic";
    public static AgeOfMagic instance;

    public AgeOfMagic() { 
    	
    	final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        // Register the setup method for modloading
    	modEventBus.addListener(this::setup);
        // Register the doClientStuff method for modloading
    	modEventBus.addListener(this::doClientStuff);
        OnItemsRegisty.ITEMS.register(modEventBus);
        OnBlocksRegisty.BLOCKS.register(modEventBus);
        OnEntityTypesRegisty.ENTITIES.register(modEventBus);
        
        instance = this;
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class OnItemsRegisty {
    	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, MOD_ID);
    	
    	/*
    	 * * * * * * * * * * * * * * * * * * * * * * * * * * * *
    	 *						ARMOUR						   *
    	 * * * * * * * * * * * * * * * * * * * * * * * * * * * *
    	 */	
    	public static final RegistryObject<Item> amethyst_boots = ITEMS.register("amethyst_boots", () -> new ArmorItem(ModArmorMaterial.AMETHYST, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)));
    	public static final RegistryObject<Item> amethyst_leggings = ITEMS.register("amethyst_leggings", () -> new ArmorItem(ModArmorMaterial.AMETHYST, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)));
    	public static final RegistryObject<Item> amethyst_chestplate = ITEMS.register("amethyst_chestplate", () -> new ArmorItem(ModArmorMaterial.AMETHYST, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)));
    	public static final RegistryObject<Item> amethyst_helmet = ITEMS.register("amethyst_helmet", () -> new ArmorItem(ModArmorMaterial.AMETHYST, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)));

    	/*
    	 * * * * * * * * * * * * * * * * * * * * * * * * * * * *
    	 *						ITEMS						   *
    	 * * * * * * * * * * * * * * * * * * * * * * * * * * * *
    	 */	
    	public static final RegistryObject<Item> amethyst = ITEMS.register("amethyst", () -> new Item(new Item.Properties().group(ModItemGroup.ITEMS)));
    	public static final RegistryObject<Item> long_tool_rod = ITEMS.register("long_tool_rod", () -> new Item(new Item.Properties().group(ModItemGroup.ITEMS)));
    	public static final RegistryObject<Item> pile_of_dirt = ITEMS.register("pile_of_dirt", () -> new Item(new Item.Properties().group(ModItemGroup.ITEMS)));
    	public static final RegistryObject<Item> pile_of_gravel = ITEMS.register("pile_of_gravel", () -> new Item(new Item.Properties().group(ModItemGroup.ITEMS)));
    	public static final RegistryObject<Item> pile_of_sand = ITEMS.register("pile_of_sand", () -> new Item(new Item.Properties().group(ModItemGroup.ITEMS)));
    	public static final RegistryObject<Item> plant_fiber = ITEMS.register("plant_fiber", () -> new Item(new Item.Properties().group(ModItemGroup.ITEMS)));
    	public static final RegistryObject<Item> rock = ITEMS.register("rock", () -> new RockItem(new Item.Properties().group(ModItemGroup.ITEMS)));
    	public static final RegistryObject<Item> sharp_rock = ITEMS.register("sharp_rock", () -> new Item(new Item.Properties().group(ModItemGroup.ITEMS)));
    	public static final RegistryObject<Item> twine = ITEMS.register("twine", () -> new Item(new Item.Properties().group(ModItemGroup.ITEMS)));
    	public static final RegistryObject<Item> oak_wood = ITEMS.register("oak_wood", () -> new Item(new Item.Properties().group(ModItemGroup.ITEMS)));

    	/*
    	 * * * * * * * * * * * * * * * * * * * * * * * * * * * *
    	 *							ORE						   *
    	 * * * * * * * * * * * * * * * * * * * * * * * * * * * *
    	 */	
    	public static final RegistryObject<Item> amethyst_ore = ITEMS.register("amethyst_ore", () -> new Item(new Item.Properties().group(ModItemGroup.ORES)));
    	
    	/*
    	 * * * * * * * * * * * * * * * * * * * * * * * * * * * *
    	 *					AMETHYST TOOLS					   *
    	 * * * * * * * * * * * * * * * * * * * * * * * * * * * *
    	 */	
    	//(TIER, ATTACK DAMAGE, ATTACK SPEED, ITEM GROUP
    	public static final RegistryObject<Item> amethyst_sword = ITEMS.register("amethyst_sword", () -> new SwordItem(ModToolTier.AMETHYST, 3, -2.4F, new Item.Properties().group(ItemGroup.COMBAT)));
    	public static final RegistryObject<Item> amethyst_pickaxe = ITEMS.register("amethyst_pickaxe", () -> new PickaxeItem(ModToolTier.AMETHYST, 1, -2.8F, new Item.Properties().group(ItemGroup.TOOLS)));
    	public static final RegistryObject<Item> amethyst_axe = ITEMS.register("amethyst_axe", () -> new AxeItem(ModToolTier.AMETHYST, 5.0f, -3.0F, new Item.Properties().group(ItemGroup.COMBAT)));
    	public static final RegistryObject<Item> amethyst_shovel = ITEMS.register("amethyst_shovel", () -> new ShovelItem(ModToolTier.AMETHYST, 1.5f, 1.0F, new Item.Properties().group(ItemGroup.TOOLS)));
    	public static final RegistryObject<Item> amethyst_hoe = ITEMS.register("amethyst_hoe", () -> new HoeItem(ModToolTier.AMETHYST, 0.0F, new Item.Properties().group(ItemGroup.TOOLS)));

    	/*
    	 * * * * * * * * * * * * * * * * * * * * * * * * * * * *
    	 *						STONE TOOLS					   *
    	 * * * * * * * * * * * * * * * * * * * * * * * * * * * *
    	 */
    	public static final RegistryObject<Item> stone_knife = ITEMS.register("stone_knife", () -> new KnifeItem(new Item.Properties().maxDamage(35).group(ItemGroup.COMBAT)));	
    }
    
    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class OnBlocksRegisty{
    	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, MOD_ID);
    	
    	/*
    	 * * * * * * * * * * * * * * * * * * * * * * * * * * * *
    	 *							ORE						   *
    	 * * * * * * * * * * * * * * * * * * * * * * * * * * * *
    	 */	
    	final RegistryObject<Block> amethyst_ore = BLOCKS.register("amethyst_ore", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).harvestLevel(3).harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));
    }
    
    public static class OnEntityTypesRegisty{
    	public static final DeferredRegister<EntityType<?>> ENTITIES = new DeferredRegister<>(ForgeRegistries.ENTITIES, MOD_ID);
    	
    	public static final RegistryObject<EntityType<RockEntity>> rock = ENTITIES.register("rock", () -> EntityType.Builder.<RockEntity>create(RockEntity::new, EntityClassification.MISC).size(0.25F, 0.25F).build(new ResourceLocation(MOD_ID, "rock").toString()));
    }
}
