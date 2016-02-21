package net.hycrafthd.youtubetutdimension.world;

import net.hycrafthd.youtubetutdimension.DimMain;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldProviderHell;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.border.WorldBorder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DimWorldProvider extends WorldProvider {

	@Override
	public void registerWorldChunkManager() {
		this.worldChunkMgr = new WorldChunkManagerHell(DimMain.biome, 0.0F);
		this.dimensionId = DimMain.dimensionId;
	}

	public boolean isSurfaceWorld() {
		return false;
	}

	public boolean canRespawnHere() {
		return false;
	}

	@Override
	public String getDimensionName() {
		return "Tutorial Dimension";
	}

	@Override
	public String getInternalNameSuffix() {
		return "tutdim";
	}

	@SideOnly(Side.CLIENT)
	public Vec3 getFogColor(float p_76562_1_, float p_76562_2_) {
		return new Vec3(0.00000000298023224D, 0.059999999329447746D, 0.029999999329447746D);
	}

	@SideOnly(Side.CLIENT)
	public boolean doesXZShowFog(int x, int z) {
		return true;
	}

}
