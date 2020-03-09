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
	public static final ModItemGroup instance = new ModItemGroup(ItemGroup.GROUPS.length, "items");

	public ModItemGroup(int index, String label) {
		super(index, label);
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(null);
	}

}
