package net.hycrafthd.youtubetut.block;

import java.util.Random;

import net.hycrafthd.youtubetut.TUTMain;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

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
    
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {
		player.openGui(TUTMain.INSTANCE, TUTMain.tutguidefaultcraftingtable, world, pos.getX(), pos.getY(), pos.getZ());
		return super.onBlockActivated(world, pos, state, player, side, hitX, hitY, hitZ);
	}

}
