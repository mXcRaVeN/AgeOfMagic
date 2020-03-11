package com.mxcraven.ageofmagic.item;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class SpearItem extends Item {

	public SpearItem(Properties properties) {
		super(properties);
		// TODO Auto-generated constructor stub
	}

	public UseAction getUseAction(ItemStack stack) {
		return UseAction.SPEAR;
	}

	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		if (itemstack.getDamage() >= itemstack.getMaxDamage() - 1) {
			return ActionResult.func_226251_d_(itemstack);
		} else if (EnchantmentHelper.getRiptideModifier(itemstack) > 0 && !playerIn.isWet()) {
			return ActionResult.func_226251_d_(itemstack);
		} else {
			playerIn.setActiveHand(handIn);
			return ActionResult.func_226249_b_(itemstack);
		}
	}

	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		stack.damageItem(1, attacker, (p_220048_0_) -> {
			p_220048_0_.sendBreakAnimation(EquipmentSlotType.MAINHAND);
		});
		return true;
	}
}
