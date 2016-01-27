package net.hycrafthd.youtubetutdimension.world;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldProviderHell;

public class DimWorldProvider extends WorldProvider {

	@Override
	public String getDimensionName() {
		return "Tutorial Dimension";
	}

	@Override
	public String getInternalNameSuffix() {
		return "tutdim";
	}

}
