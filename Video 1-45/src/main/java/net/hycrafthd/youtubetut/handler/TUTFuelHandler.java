package net.hycrafthd.youtubetut.handler;

import net.hycrafthd.youtubetut.TUTMain;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

public class TUTFuelHandler implements IFuelHandler {

	@Override
	public int getBurnTime(ItemStack fuel) {
		if(fuel.getItem().equals(TUTMain.tutitem)) {
			return 200;
		}
		
		if(fuel.getItem().equals(TUTMain.tutfood)) {
			return 400;
		}
		return 0;
	}

}
