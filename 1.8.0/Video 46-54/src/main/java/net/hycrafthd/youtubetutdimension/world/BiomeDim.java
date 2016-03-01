package net.hycrafthd.youtubetutdimension.world;

import net.hycrafthd.youtubetutdimension.DimMain;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeDim extends BiomeGenBase {

	public BiomeDim(int id) {
		super(id);
		this.setBiomeName("Dimension Biome");
		this.fillerBlock = Blocks.obsidian.getDefaultState();
		this.topBlock = DimMain.stone.getDefaultState();
	}

	@Override
	public int getSkyColorByTemp(float temp) {
		return 13109810;
	}

	@Override
	public int getWaterColorMultiplier() {
		return 13109810;
	}

}
