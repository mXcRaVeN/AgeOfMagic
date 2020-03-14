package com.mxcraven.ageofmagic.renderer;

import java.util.Map;

import com.google.common.collect.Maps;
import com.mxcraven.ageofmagic.AgeOfMagic;
import com.mxcraven.ageofmagic.AgeOfMagic.OnEntityTypesRegisty;

import net.minecraft.client.GameSettings;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.Quaternion;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.PlayerRenderer;
import net.minecraft.client.renderer.entity.TridentRenderer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.resources.IReloadableResourceManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class ModEntityRendererManager extends EntityRendererManager {
	private static final RenderType field_229082_e_ = RenderType
			.func_228650_h_(new ResourceLocation("textures/misc/shadow.png"));
	public final Map<EntityType<?>, EntityRenderer<?>> renderers = Maps.newHashMap();
	private final Map<String, PlayerRenderer> skinMap = Maps.newHashMap();
	private final PlayerRenderer playerRenderer;
	private final FontRenderer textRenderer;
	public final TextureManager textureManager;
	private World world;
	public ActiveRenderInfo info;
	private Quaternion field_229083_k_;
	public Entity pointedEntity;
	public final GameSettings options;
	private boolean renderShadow = true;
	private boolean debugBoundingBox;

	public ModEntityRendererManager(TextureManager p_i226034_1_, ItemRenderer p_i226034_2_,
			IReloadableResourceManager p_i226034_3_, FontRenderer p_i226034_4_, GameSettings p_i226034_5_) {
		super(p_i226034_1_, p_i226034_2_, p_i226034_3_, p_i226034_4_, p_i226034_5_);
		this.textureManager = p_i226034_1_;
		this.textRenderer = p_i226034_4_;
		this.options = p_i226034_5_;
		this.func_229097_a_(p_i226034_2_, p_i226034_3_);
		this.playerRenderer = new PlayerRenderer(this);
		this.skinMap.put("default", this.playerRenderer);
		this.skinMap.put("slim", new PlayerRenderer(this, true));
	}

	public <T extends Entity> void EntitySetup(EntityType<?> entityType, TridentRenderer tridentRenderer) {
		this.renderers.put(entityType, tridentRenderer);
	}

	private void func_229097_a_(net.minecraft.client.renderer.ItemRenderer p_229097_1_,
			IReloadableResourceManager p_229097_2_) {
		this.EntitySetup(AgeOfMagic.OnEntityTypesRegisty.stone_spear.get(), new TridentRenderer(this));
	}

}
