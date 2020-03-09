package com.mxcraven.ageofmagic;

import java.util.function.Supplier;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

/*
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 *					TIERED TOOLS					   *
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 */	
	//Custom tool level like wood -> stone -> iron -> diamond
	public enum ModToolTier implements IItemTier{
		//(TIER, DURABILITY, EFFICIENCY, ATTCK DAMAGE, ENCHANT-ABILITY
		AMETHYST(4, 500, 4.5F, 4.0F, 30, () -> {
			return Ingredient.fromItems(AgeOfMagic.OnItemsRegisty.amethyst.get());
		});
//	   WOOD(0, 59, 2.0F, 0.0F, 15, () -> {
//	      return Ingredient.fromTag(ItemTags.PLANKS);
//	   }),
//	   STONE(1, 5, 4.0F, 1.0F, 5, () -> {
//	      return Ingredient.fromItems(Blocks.COBBLESTONE);
//	   });
//	   IRON(2, 250, 6.0F, 2.0F, 14, () -> {
//	      return Ingredient.fromItems(Items.IRON_INGOT);
//	   }),
//	   DIAMOND(3, 1561, 8.0F, 3.0F, 10, () -> {
//	      return Ingredient.fromItems(Items.DIAMOND);
//	   }),
//	   GOLD(0, 32, 12.0F, 0.0F, 22, () -> {
//	      return Ingredient.fromItems(Items.GOLD_INGOT);
//	   });		
		private final int harvestlevel;
		private final int maxUses;
		private final float efficiency;
		private final float attackDamage;
		private final int enchantAbility;
		private final LazyValue<Ingredient> repairMaterial;
		
		private ModToolTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantAbility, Supplier<Ingredient> repairMaterial) {
			this.harvestlevel = harvestLevel;
			this.maxUses = maxUses;
			this.efficiency = efficiency;
			this.attackDamage = attackDamage;
			this.enchantAbility = enchantAbility;
			this.repairMaterial = new LazyValue<>(repairMaterial);
		}

		@Override
		public int getMaxUses() {
			return this.maxUses;
		}

		@Override
		public float getEfficiency() {
			return this.efficiency;
		}

		@Override
		public float getAttackDamage() {
			return this.attackDamage;
		}

		@Override
		public int getHarvestLevel() {
			return this.harvestlevel;
		}

		@Override
		public int getEnchantability() {
			return this.enchantAbility;
		}

		@Override
		public Ingredient getRepairMaterial() {
			return this.repairMaterial.getValue();
		}
	}