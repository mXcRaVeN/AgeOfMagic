package com.mxcraven.ageofmagic;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.EggEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class RockEntity extends EggEntity {

	public RockEntity(final EntityType<? extends RockEntity> EntityType, World world) {
		super(EntityType, world);
		// TODO Auto-generated constructor stub
	}

	public RockEntity(World worldIn, PlayerEntity playerIn) {
		// TODO Auto-generated constructor stub
		super(worldIn,playerIn);
	}

	protected void onImpact(RayTraceResult result) {
		      if (result.getType() == RayTraceResult.Type.ENTITY) {
		         ((EntityRayTraceResult)result).getEntity().attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 1.5F);
		      }

		      if (!this.world.isRemote) {
		         this.world.setEntityState(this, (byte)3);
		         this.remove();
		      }

		   }
}
