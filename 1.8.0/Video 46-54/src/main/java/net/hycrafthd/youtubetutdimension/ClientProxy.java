package net.hycrafthd.youtubetutdimension;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class ClientProxy extends ServerProxy {

	public void registerModels() {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(DimMain.stone), 0, new ModelResourceLocation(DimMain.MODID + ":dimstone", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(DimMain.portal), 0, new ModelResourceLocation(DimMain.MODID + ":dimportal", "inventory"));
	}

}
