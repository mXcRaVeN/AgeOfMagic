package com.mxcraven.ageofmagic.entity.spear;

import javax.annotation.Nullable;

import com.mxcraven.ageofmagic.AgeOfMagic;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class StoneSpearEntity extends AbstractArrowEntity {
	private static final DataParameter<Boolean> field_226571_aq_ = EntityDataManager.createKey(StoneSpearEntity.class,
			DataSerializers.BOOLEAN);
	private ItemStack thrownStack = new ItemStack(AgeOfMagic.OnItemsRegisty.stone_spear.get());
	private boolean dealtDamage;
	public int returningTicks;

	public StoneSpearEntity(EntityType<? extends StoneSpearEntity> p_i50172_1_, World p_i50172_2_) {
		super(p_i50172_1_, p_i50172_2_);
	}

	public StoneSpearEntity(World worldIn, double x, double y, double z) {
		super(AgeOfMagic.OnEntityTypesRegisty.stone_spear.get(), x, y, z, worldIn);
	}

	public StoneSpearEntity(World worldIn, LivingEntity shooter) {
		super(AgeOfMagic.OnEntityTypesRegisty.stone_spear.get(), shooter, worldIn);
	}

	public StoneSpearEntity(World worldIn, LivingEntity thrower, ItemStack thrownStackIn) {
		super(AgeOfMagic.OnEntityTypesRegisty.stone_spear.get(), thrower, worldIn);
		this.thrownStack = thrownStackIn.copy();
	}

//	protected void registerData() {
//		super.registerData();
//	}

//	private boolean shouldReturnToThrower() {
//		Entity entity = this.getShooter();
//		if (entity != null && entity.isAlive()) {
//			return !(entity instanceof ServerPlayerEntity) || !entity.isSpectator();
//		} else {
//			return false;
//		}
//	}
//
//	public void tick() {
//		if (this.timeInGround > 4) {
//			this.dealtDamage = true;
//		}
//
//		Entity entity = this.getShooter();
//		if ((this.dealtDamage || this.getNoClip()) && entity != null) {
//			int i = 0;
//			if (i > 0 && !this.shouldReturnToThrower()) {
//				if (!this.world.isRemote && this.pickupStatus == AbstractArrowEntity.PickupStatus.ALLOWED) {
//					this.entityDropItem(this.getArrowStack(), 0.1F);
//				}
//
//				this.remove();
//			} else if (i > 0) {
//				this.setNoClip(true);
//				Vec3d vec3d = new Vec3d(entity.func_226277_ct_() - this.func_226277_ct_(),
//						entity.func_226280_cw_() - this.func_226278_cu_(),
//						entity.func_226281_cx_() - this.func_226281_cx_());
//				this.func_226288_n_(this.func_226277_ct_(), this.func_226278_cu_() + vec3d.y * 0.015D * (double) i,
//						this.func_226281_cx_());
//				if (this.world.isRemote) {
//					this.lastTickPosY = this.func_226278_cu_();
//				}
//
//				double d0 = 0.05D * (double) i;
//				this.setMotion(this.getMotion().scale(0.95D).add(vec3d.normalize().scale(d0)));
//				if (this.returningTicks == 0) {
//					this.playSound(SoundEvents.ITEM_TRIDENT_RETURN, 10.0F, 1.0F);
//				}
//
//				++this.returningTicks;
//			}
//		}
//
//		super.tick();
//	}

	protected void onEntityHit(EntityRayTraceResult p_213868_1_) {
		Entity entity = p_213868_1_.getEntity();
		float f = 8.0F;
		if (entity instanceof LivingEntity) {
			LivingEntity livingentity = (LivingEntity) entity;
			f += EnchantmentHelper.getModifierForCreature(this.thrownStack, livingentity.getCreatureAttribute());
		}

		Entity entity1 = this.getShooter();
		DamageSource damagesource = DamageSource.causeTridentDamage(this, (Entity) (entity1 == null ? this : entity1));
		SoundEvent soundevent = SoundEvents.ITEM_TRIDENT_HIT;
		if (entity.attackEntityFrom(damagesource, f)) {
			if (entity instanceof LivingEntity) {
				LivingEntity livingentity1 = (LivingEntity) entity;

				this.arrowHit(livingentity1);
			}
		}
		this.setMotion(this.getMotion().mul(-0.01D, -0.1D, -0.01D));
		float f1 = 1.0F;
		this.playSound(soundevent, f1, 1.0F);
	}

	protected SoundEvent getHitEntitySound() {
		return SoundEvents.ITEM_TRIDENT_HIT_GROUND;
	}

	public void onCollideWithPlayer(PlayerEntity entityIn) {
		Entity entity = this.getShooter();
		if (entity == null || entity.getUniqueID() == entityIn.getUniqueID()) {
			super.onCollideWithPlayer(entityIn);
		}
	}

	protected ItemStack getArrowStack() {
		return this.thrownStack.copy();
	}

	@Nullable
	protected EntityRayTraceResult rayTraceEntities(Vec3d startVec, Vec3d endVec) {
		return this.dealtDamage ? null : super.rayTraceEntities(startVec, endVec);
	}

	public void func_225516_i_() {
		if (this.pickupStatus != AbstractArrowEntity.PickupStatus.ALLOWED) {
			super.func_225516_i_();
		}

	}

	@OnlyIn(Dist.CLIENT)
	public boolean isInRangeToRender3d(double x, double y, double z) {
		return true;
	}

	@OnlyIn(Dist.CLIENT)
	public boolean func_226572_w_() {
		return this.dataManager.get(field_226571_aq_);
	}
}
