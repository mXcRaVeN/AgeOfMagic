package com.mxcraven.ageofmagic.client.renderer.entity;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mxcraven.ageofmagic.client.renderer.entity.model.StoneSpearModel;
import com.mxcraven.ageofmagic.entity.spear.StoneSpearEntity;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

public class StoneSpearRenderer extends EntityRenderer<StoneSpearEntity>{
	   public static final ResourceLocation stone_spear = new ResourceLocation("textures/entity/stone_spear.png");
	   private final StoneSpearModel stoneSpearModel = new StoneSpearModel();

	   public StoneSpearRenderer(EntityRendererManager renderManagerIn) {
	      super(renderManagerIn);
	   }

	   public void func_225623_a_(StoneSpearEntity p_225623_1_, float p_225623_2_, float p_225623_3_, MatrixStack p_225623_4_, IRenderTypeBuffer p_225623_5_, int p_225623_6_) {
	      p_225623_4_.func_227860_a_();
	      p_225623_4_.func_227863_a_(Vector3f.field_229181_d_.func_229187_a_(MathHelper.lerp(p_225623_3_, p_225623_1_.prevRotationYaw, p_225623_1_.rotationYaw) - 90.0F));
	      p_225623_4_.func_227863_a_(Vector3f.field_229183_f_.func_229187_a_(MathHelper.lerp(p_225623_3_, p_225623_1_.prevRotationPitch, p_225623_1_.rotationPitch) + 90.0F));
	      IVertexBuilder ivertexbuilder = net.minecraft.client.renderer.ItemRenderer.func_229113_a_(p_225623_5_, this.stoneSpearModel.func_228282_a_(this.getEntityTexture(p_225623_1_)), false, p_225623_1_.func_226572_w_());
	      this.stoneSpearModel.func_225598_a_(p_225623_4_, ivertexbuilder, p_225623_6_, OverlayTexture.field_229196_a_, 1.0F, 1.0F, 1.0F, 1.0F);
	      p_225623_4_.func_227865_b_();
	      super.func_225623_a_(p_225623_1_, p_225623_2_, p_225623_3_, p_225623_4_, p_225623_5_, p_225623_6_);
	   }

		@Override
		public ResourceLocation getEntityTexture(StoneSpearEntity entity) {
			return stone_spear;
		}
}
