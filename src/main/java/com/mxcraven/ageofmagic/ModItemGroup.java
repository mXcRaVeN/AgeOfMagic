package com.mxcraven.ageofmagic;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ModItemGroup extends ItemGroup {
	public final static ItemGroup ITEMS = (new ItemGroup(12, "items") {
		@OnlyIn(Dist.CLIENT)
		public ItemStack createIcon() {
			return new ItemStack(AgeOfMagic.OnItemsRegisty.amethyst.get());
		}
	});
	public final static ItemGroup ORES = (new ItemGroup(13, "ores") {
		@OnlyIn(Dist.CLIENT)
		public ItemStack createIcon() {
			return new ItemStack(AgeOfMagic.OnItemsRegisty.amethyst_ore.get());
		}
	});

	public ModItemGroup(int index, String label) {
		super(index, label);
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(null);
	}

}
