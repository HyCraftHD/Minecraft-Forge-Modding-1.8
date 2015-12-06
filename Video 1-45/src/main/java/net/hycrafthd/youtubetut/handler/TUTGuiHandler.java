package net.hycrafthd.youtubetut.handler;

import net.hycrafthd.youtubetut.TUTMain;
import net.hycrafthd.youtubetut.container.TUTContainerDefaultCraftingTable;
import net.hycrafthd.youtubetut.gui.TUTGuiDefaultCraftingTable;
import net.hycrafthd.youtubetut.gui.TUTGuiScreen;
import net.minecraft.client.gui.inventory.GuiCrafting;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class TUTGuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,	int x, int y, int z) {
		if(ID == TUTMain.tutguidefaultcraftingtable) {
			return new TUTContainerDefaultCraftingTable(player.inventory, player.worldObj, new BlockPos(x, y , z));
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,	int x, int y, int z) {
		if(ID == TUTMain.tutguiid) {
			return new TUTGuiScreen();
		} else if(ID == TUTMain.tutguidefaultcraftingtable) {
			return new TUTGuiDefaultCraftingTable(player.inventory, player.worldObj, new BlockPos(x, y , z));
		}
		return null;
	}

}
