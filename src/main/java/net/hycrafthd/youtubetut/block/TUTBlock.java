package net.hycrafthd.youtubetut.block;

import java.util.Random;

import net.hycrafthd.youtubetut.TUTMain;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class TUTBlock extends Block {

	public TUTBlock() {
		super(Material.rock);
		this.setHardness(1.0F);
		this.setLightLevel(0.6F);
		this.setHarvestLevel("pickaxe", 2);
	}
	
	public int quantityDropped(Random random) {
        return 2;
    }

    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return TUTMain.tutitem;
    }

}
