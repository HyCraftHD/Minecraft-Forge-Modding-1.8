package net.hycrafthd.youtubetut.world;

import java.util.Random;

import net.hycrafthd.youtubetut.TUTMain;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.Height;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class TUTBiome extends BiomeGenBase {

	public TUTBiome(int id) {
		super(id);
		this.setBiomeName("Tutorial Biome");
		this.setHeight(new Height(0, 5));
		this.topBlock = TUTMain.tutblock.getDefaultState();
		this.fillerBlock = Blocks.quartz_block.getDefaultState();
	}
	
	 public void decorate(World worldIn, Random p_180624_2_, BlockPos p_180624_3_) {
	        super.decorate(worldIn, p_180624_2_, p_180624_3_);
	        int i = 1000 + p_180624_2_.nextInt(6);
	        int j;
	        int k;
	        int l;

	        for (j = 0; j < i; ++j)
	        {
	            k = p_180624_2_.nextInt(16);
	            l = p_180624_2_.nextInt(28) + 4;
	            int i1 = p_180624_2_.nextInt(16);
	            BlockPos blockpos1 = p_180624_3_.add(k, l, i1);

	            if (worldIn.getBlockState(blockpos1).getBlock().isReplaceableOreGen(worldIn, blockpos1, net.minecraft.block.state.pattern.BlockHelper.forBlock(Blocks.stone)))
	            {
	                worldIn.setBlockState(blockpos1, TUTMain.tutblock2.getDefaultState(), 1);
	            }
	            //new WorldGenMinable(TUTMain.tutblock.getDefaultState(), 10).generate(worldIn, p_180624_2_, blockpos1);
	        }

	    }
}
