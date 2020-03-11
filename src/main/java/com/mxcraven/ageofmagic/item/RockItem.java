package com.mxcraven.ageofmagic.item;

import com.mxcraven.ageofmagic.RockEntity;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class RockItem extends Item {

	public RockItem(Properties properties) {
		super(properties);
		// TODO Auto-generated constructor stub
	}

	   public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		      ItemStack itemstack = playerIn.getHeldItem(handIn);
		      worldIn.playSound((PlayerEntity)null, playerIn.func_226277_ct_(), playerIn.func_226278_cu_(), playerIn.func_226281_cx_(), SoundEvents.ENTITY_EGG_THROW, SoundCategory.PLAYERS, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
		      if (!worldIn.isRemote) {
		         RockEntity rockentity = new RockEntity(worldIn, playerIn);
		         rockentity.setItem(itemstack);
		         rockentity.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
		         worldIn.addEntity(rockentity);
		      }

		      playerIn.addStat(Stats.ITEM_USED.get(this));
		      if (!playerIn.abilities.isCreativeMode) {
		         itemstack.shrink(1);
		      }

		      return ActionResult.func_226248_a_(itemstack);
	   }
}
