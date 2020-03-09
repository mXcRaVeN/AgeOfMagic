package com.mxcraven.ageofmagic;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("AgeOfMagic")
public class AgeOfMagic
{
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "ageofmagic";

    public AgeOfMagic() { 
    	
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        
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
//    	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, MOD_ID);
//    	public static final RegistryObject<Item> amethyst = ITEMS.register("amethyst", () -> new Item(new Item.Properties().group(ItemGroup.MISC)));
    	
    	/*
    	 * * * * * * * * * * * * * * * * * * * * * * * * * * * *
    	 *						ARMOUR						   *
    	 * * * * * * * * * * * * * * * * * * * * * * * * * * * *
    	 */	
//    	final RegistryObject<Item> amethyst_boots = ITEMS.register("amethyst_boots", () -> new ArmorItem(ModArmorMaterial.AMETHYST, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)));
//    	final RegistryObject<Item> amethyst_legs = ITEMS.register("amethyst_legs", () -> new ArmorItem(ModArmorMaterial.AMETHYST, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)));
//    	final RegistryObject<Item> amethyst_chestplate = ITEMS.register("amethyst_chestplate", () -> new ArmorItem(ModArmorMaterial.AMETHYST, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)));
//    	final RegistryObject<Item> amethyst_helmet = ITEMS.register("amethyst_helmet", () -> new ArmorItem(ModArmorMaterial.AMETHYST, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)));

    	/*
    	 * * * * * * * * * * * * * * * * * * * * * * * * * * * *
    	 *						ITEMS						   *
    	 * * * * * * * * * * * * * * * * * * * * * * * * * * * *
    	 */	
//    	final RegistryObject<Item> long_tool_rod = ITEMS.register("long_tool_rod", () -> new Item(new Item.Properties().group(ModItemGroup.ITEMS)));
//    	final RegistryObject<Item> pile_of_dirt = ITEMS.register("pile_of_dirt", () -> new Item(new Item.Properties().group(ItemGroup.MISC)));
//    	final RegistryObject<Item> pile_of_gravel = ITEMS.register("pile_of_gravel", () -> new Item(new Item.Properties().group(ItemGroup.MISC)));
//    	final RegistryObject<Item> pile_of_sand = ITEMS.register("pile_of_sand", () -> new Item(new Item.Properties().group(ItemGroup.MISC)));
//    	final RegistryObject<Item> plant_fiber = ITEMS.register("plant_fiber", () -> new Item(new Item.Properties().group(ItemGroup.MISC)));
//    	final RegistryObject<Item> rock = ITEMS.register("rock", () -> new Item(new Item.Properties().group(ItemGroup.MISC)));
//    	final RegistryObject<Item> sharp_rock = ITEMS.register("sharp_rock", () -> new Item(new Item.Properties().group(ItemGroup.MISC)));
//    	final RegistryObject<Item> twine = ITEMS.register("twine", () -> new Item(new Item.Properties().group(ItemGroup.MISC)));

    	/*
    	 * * * * * * * * * * * * * * * * * * * * * * * * * * * *
    	 *					AMETHYST TOOLS					   *
    	 * * * * * * * * * * * * * * * * * * * * * * * * * * * *
    	 */	
    	//(TIER, ATTACK DAMAGE, ATTACK SPEED, ITEM GROUP
//    	final RegistryObject<Item> amethyst_sword = ITEMS.register("amethyst_sword", () -> new SwordItem(ModToolTier.AMETHYST, 3, -2.4F, new Item.Properties().group(ItemGroup.MISC)));
//    	final RegistryObject<Item> amethyst_pickaxe = ITEMS.register("amethyst_pickaxe", () -> new PickaxeItem(ModToolTier.AMETHYST, 1, -2.8F, new Item.Properties().group(ItemGroup.MISC)));
//    	final RegistryObject<Item> amethyst_axe = ITEMS.register("amethyst_axe", () -> new AxeItem(ModToolTier.AMETHYST, 5.0f, -3.0F, new Item.Properties().group(ItemGroup.MISC)));
//    	final RegistryObject<Item> amethyst_shovel = ITEMS.register("amethyst_shovel", () -> new ShovelItem(ModToolTier.AMETHYST, 1.5f, 1.0F, new Item.Properties().group(ItemGroup.MISC)));
//    	final RegistryObject<Item> amethyst_hoe = ITEMS.register("amethyst_hoe", () -> new HoeItem(ModToolTier.AMETHYST, 0.0F, new Item.Properties().group(ItemGroup.MISC)));

    	/*
    	 * * * * * * * * * * * * * * * * * * * * * * * * * * * *
    	 *						STONE TOOLS					   *
    	 * * * * * * * * * * * * * * * * * * * * * * * * * * * *
    	 */
//    	final RegistryObject<Item> stone_spear = ITEMS.register("stone_spear", () -> new TridentItem(new Item.Properties().maxDamage(100).group(ItemGroup.COMBAT)));
    	//final RegistryObject<Item> stone_knife = ITEMS.register("stone_knife", () -> new KnifeItem(new Item.Properties().maxDamage(35).group(ItemGroup.COMBAT)));	
//    	@SubscribeEvent
//        public static void onItemsRegistry(final RegistryEvent.Register<Item> itemRegistryEvent) {
//        	
//
//        }
//        @SubscribeEvent
//        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
//            
//        }

    }
}
