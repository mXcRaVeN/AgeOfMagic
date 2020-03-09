package com.mxcraven.ageofmagic;


import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.util.registry.Registry;

public class ModBlocks extends Blocks {
	   public static final Block AMETHYST_ORE = register("amethyst_ore", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F)));

	   private static Block register(String key, Block p_222382_1_) {
		      return Registry.register(Registry.BLOCK, key, p_222382_1_);
		   }
}
