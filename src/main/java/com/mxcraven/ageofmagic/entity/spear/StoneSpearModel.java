package com.mxcraven.ageofmagic.entity.spear;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

// Made with Blockbench
// Paste this code into your mod.
// Make sure to generate all required imports

public class StoneSpearModel extends Model {
	   public static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation("textures/entity/stone_spear.png");
	   private final ModelRenderer modelRenderer = new ModelRenderer(32, 32, 0, 6);

	public StoneSpearModel() {
		super(RenderType::func_228634_a_);
		bone = new ModelRenderer(this);
		bone.cubeList.add(new Model(bone, 7, 8, -1.0F, -28.0F, 2.0F, 1, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 8, 5, -1.0F, -28.0F, -2.0F, 1, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 4, 4, -1.0F, -30.0F, 1.0F, 1, 4, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 7, 0, -1.0F, -30.0F, -1.0F, 1, 4, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -1.0F, -32.0F, 0.0F, 1, 32, 1, 0.0F, false));
	}

	@Override
	public void func_225598_a_(MatrixStack p_225598_1_, IVertexBuilder p_225598_2_, int p_225598_3_, int p_225598_4_,
			float p_225598_5_, float p_225598_6_, float p_225598_7_, float p_225598_8_) {
	      this.modelRenderer.func_228309_a_(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
		
	}
}