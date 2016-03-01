package net.hycrafthd.youtubetutdimension.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFire;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class BlockDimCreator extends Block {

	public BlockDimCreator() {
		super(Material.rock);
	}

	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		new BlockDimPortal().func_176548_d(worldIn, pos);
	}

}
