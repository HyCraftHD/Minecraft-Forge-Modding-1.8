package net.hycrafthd.youtubetut.item;

import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

import com.google.common.collect.Sets;

public class TUTExcavator extends TUTTools {
	
	private static final Set EFFECTIVE_ON = Sets.newHashSet(new Block[] {Blocks.clay, Blocks.dirt, Blocks.farmland, Blocks.grass, Blocks.gravel, Blocks.mycelium, Blocks.sand, Blocks.snow, Blocks.snow_layer, Blocks.soul_sand});
	
	public TUTExcavator(ToolMaterial material) {
		super(1, 0, 1.0F, material, EFFECTIVE_ON);
		this.setHarvestLevel("spade", 4);
	}
}
