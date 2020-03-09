package com.mxcraven.ageofmagic;

import java.util.function.Supplier;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/*
 * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *						ARMOR						   *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 */	
//Custom Armor
public enum ModArmorMaterial implements IArmorMaterial{
	//mod + layer, maxDmgFactor, dmgReductionAmtArray, enchantAbility
	AMETHYST(AgeOfMagic.MOD_ID + ":amethyst", 5 , new int[] {4, 7, 9, 5}, 30, SoundEvents.field_226124_Y_, 6.9f, () -> {
		return Ingredient.fromItems(AgeOfMagic.OnItemsRegisty.amethyst.get());
	});
//	LEATHER("leather", 5, new int[]{1, 2, 3, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F, () -> {
//      return Ingredient.fromItems(Items.LEATHER);
//	}),
//	CHAIN("chainmail", 15, new int[]{1, 4, 5, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0.0F, () -> {
//      return Ingredient.fromItems(Items.IRON_INGOT);
//   }),
//   IRON("iron", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, () -> {
//      return Ingredient.fromItems(Items.IRON_INGOT);
//   }),
//   GOLD("gold", 7, new int[]{1, 3, 5, 2}, 25, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F, () -> {
//      return Ingredient.fromItems(Items.GOLD_INGOT);
//   }),
//   DIAMOND("diamond", 33, new int[]{3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, () -> {
//      return Ingredient.fromItems(Items.DIAMOND);
//   }),
//   TURTLE("turtle", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_TURTLE, 0.0F, () -> {
//      return Ingredient.fromItems(Items.SCUTE);
//   });
	
	private static final int[] MAX_DAMAGE_ARRAY = new int[] { 14,17,18,16};
	private final String name;
	private final int maxDamageFactor;
	private final int[] damageReductionAmountArray;
	private final int enchantAbility;
	private final SoundEvent soundEvent;
	private final float toughness;
	private final LazyValue<Ingredient> repairMaterial;

	ModArmorMaterial(String name, int maxDamageFactor, int[] damageReductionAmountArray, int enchantAbility,
					 SoundEvent soundEvent, float toughness, Supplier<Ingredient> repairMaterial) {
		this.name = name;
		this.maxDamageFactor = maxDamageFactor;
		this.damageReductionAmountArray = damageReductionAmountArray;
		this.enchantAbility = enchantAbility;
		this.soundEvent = soundEvent;
		this.toughness = toughness;
		this.repairMaterial = new LazyValue<>(repairMaterial);
		
	}

	@Override
	public int getDurability(EquipmentSlotType slotIn) {
	      return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
	}

	@Override
	public int getDamageReductionAmount(EquipmentSlotType slotIn) {
	      return this.damageReductionAmountArray[slotIn.getIndex()];
	}

	@Override
	public int getEnchantability() {
	      return this.enchantAbility;
	}

	@Override
	public SoundEvent getSoundEvent() {
	      return this.soundEvent;
	}

	@Override
	public Ingredient getRepairMaterial() {
	      return this.repairMaterial.getValue();
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public String getName() {
	      return this.name;
	}

	@Override
	public float getToughness() {
	      return this.toughness;
	}
	
}