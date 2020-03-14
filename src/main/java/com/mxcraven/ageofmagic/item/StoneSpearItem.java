package com.mxcraven.ageofmagic.item;

import com.mxcraven.ageofmagic.entity.spear.StoneSpearEntity;

import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class StoneSpearItem extends Item {

	public StoneSpearItem(Properties properties) {
		super(properties);
		this.addPropertyOverride(new ResourceLocation("throwing"), (p_210315_0_, p_210315_1_, p_210315_2_) -> {
			return p_210315_2_ != null && p_210315_2_.isHandActive() && p_210315_2_.getActiveItemStack() == p_210315_0_
					? 1.0F
					: 0.0F;
		});
	}

	public boolean canPlayerBreakBlockWhileHolding(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
		return !player.isCreative();
	}

	public UseAction getUseAction(ItemStack stack) {
		return UseAction.SPEAR;
	}

	public int getUseDuration(ItemStack stack) {
		return 72000;
	}
	
	   public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		      ItemStack itemstack = playerIn.getHeldItem(handIn);
		      if (itemstack.getDamage() >= itemstack.getMaxDamage() - 1) {
		         return ActionResult.func_226251_d_(itemstack);
		      } else {
		         playerIn.setActiveHand(handIn);
		         return ActionResult.func_226249_b_(itemstack);
		      }
		   }
	
	   public void onPlayerStoppedUsing(ItemStack stack, World worldIn, LivingEntity entityLiving, int timeLeft) {
		      if (entityLiving instanceof PlayerEntity) {
		         PlayerEntity playerentity = (PlayerEntity)entityLiving;
		         int i = this.getUseDuration(stack) - timeLeft;
		         if (i >= 10) {
		               if (!worldIn.isRemote) {
		                  stack.damageItem(1, playerentity, (p_220047_1_) -> {
		                     p_220047_1_.sendBreakAnimation(entityLiving.getActiveHand());
		                  });
		                     StoneSpearEntity stonespearentity = new StoneSpearEntity(worldIn, playerentity, stack);
		                     stonespearentity.shoot(playerentity, playerentity.rotationPitch, playerentity.rotationYaw, 0.0F, 2.5F, 1.0F);
		                     if (playerentity.abilities.isCreativeMode) {
		                    	 stonespearentity.pickupStatus = AbstractArrowEntity.PickupStatus.CREATIVE_ONLY;
		                     }

		                     worldIn.addEntity(stonespearentity);
		                     worldIn.playMovingSound((PlayerEntity)null, stonespearentity, SoundEvents.ITEM_TRIDENT_THROW, SoundCategory.PLAYERS, 1.0F, 1.0F);
		                     if (!playerentity.abilities.isCreativeMode) {
		                        playerentity.inventory.deleteStack(stack);
		                     
		               }

		               playerentity.addStat(Stats.ITEM_USED.get(this));
		         }
		      }
		   }
	   }

//	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
//		ItemStack itemstack = playerIn.getHeldItem(handIn);
//		worldIn.playSound((PlayerEntity) null, playerIn.func_226277_ct_(), playerIn.func_226278_cu_(),
//				playerIn.func_226281_cx_(), SoundEvents.ITEM_TRIDENT_THROW, SoundCategory.PLAYERS, 0.5F,
//				0.4F / (random.nextFloat() * 0.4F + 0.8F));
//		if (!worldIn.isRemote) {
//			StoneSpearEntity stonespearentity = new StoneSpearEntity(worldIn, playerIn);
//			stonespearentity.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
//			worldIn.addEntity(stonespearentity);
//		}
//
//		playerIn.addStat(Stats.ITEM_USED.get(this));
//		if (!playerIn.abilities.isCreativeMode) {
//			itemstack.setCount(0);
//			;
//		}
//
//		return ActionResult.func_226248_a_(itemstack);
//
//	}

}
