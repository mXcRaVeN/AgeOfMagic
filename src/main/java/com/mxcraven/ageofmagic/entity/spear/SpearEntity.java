package com.mxcraven.ageofmagic.entity.spear;

import com.mxcraven.ageofmagic.AgeOfMagic;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.world.World;

public class SpearEntity extends TridentEntity {
	private ItemStack thrownStack = new ItemStack(AgeOfMagic.OnItemsRegisty.stone_spear.get());
	private boolean dealtDamage;

	public SpearEntity(EntityType<? extends SpearEntity> type, World worldIn) {
		super(type, worldIn);
	}

	protected void onEntityHit(EntityRayTraceResult p_213868_1_) {
		Entity entity = p_213868_1_.getEntity();
		float f = 8.0F;
		if (entity instanceof LivingEntity) {
			LivingEntity livingentity = (LivingEntity) entity;
			f += EnchantmentHelper.getModifierForCreature(this.thrownStack, livingentity.getCreatureAttribute());
		}

		Entity entity1 = this.getShooter();
		DamageSource damagesource = DamageSource.causeTridentDamage(this, (Entity) (entity1 == null ? this : entity1));
		this.dealtDamage = true;
		SoundEvent soundevent = SoundEvents.ITEM_TRIDENT_HIT;
		if (entity.attackEntityFrom(damagesource, f)) {
			if (entity.getType() == EntityType.ENDERMAN) {
				return;
			}

			if (entity instanceof LivingEntity) {
				LivingEntity livingentity1 = (LivingEntity) entity;
				if (entity1 instanceof LivingEntity) {
					EnchantmentHelper.applyThornEnchantments(livingentity1, entity1);
					EnchantmentHelper.applyArthropodEnchantments((LivingEntity) entity1, livingentity1);
				}

				this.arrowHit(livingentity1);
			}
		}

		this.setMotion(this.getMotion().mul(-0.01D, -0.1D, -0.01D));
		float f1 = 1.0F;
		this.playSound(soundevent, f1, 1.0F);
	}
}
