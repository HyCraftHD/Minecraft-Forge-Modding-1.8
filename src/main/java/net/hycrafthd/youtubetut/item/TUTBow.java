package net.hycrafthd.youtubetut.item;

import net.hycrafthd.youtubetut.TUTMain;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;

public class TUTBow extends ItemBow {
	
	public TUTBow() {
		super();
	}
	
	@Override
	public ModelResourceLocation getModel(ItemStack stack, EntityPlayer player, int useRemaining) {
		ModelResourceLocation mrl = new ModelResourceLocation(TUTMain.MODID + ":tutbow", "inventory");
		useRemaining = 72000 - useRemaining;
		if(player.getItemInUse() != null) {
			if(useRemaining >= 18) {
				mrl = new ModelResourceLocation(TUTMain.MODID + ":tutbow_2", "inventory");
			} else if(useRemaining > 13) {
				mrl = new ModelResourceLocation(TUTMain.MODID + ":tutbow_1", "inventory");
			} else if(useRemaining > 0) {
				mrl = new ModelResourceLocation(TUTMain.MODID + ":tutbow_0", "inventory");
			}
		}
		return mrl;
	}

}
