package net.hycrafthd.youtubetut.gui;

import net.minecraft.client.gui.inventory.GuiCrafting;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class TUTGuiDefaultCraftingTable extends GuiCrafting {

	public TUTGuiDefaultCraftingTable(InventoryPlayer playerInv, World worldIn, BlockPos blockPosition) {
		super(playerInv, worldIn, blockPosition);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		this.fontRendererObj.drawString(I18n.format("CraftingTable", new Object[0]), 28, 6, 0xFF0000);
		this.fontRendererObj.drawString(I18n.format("Spieler Inventar", new Object[0]), 8, this.ySize - 96 + 2, 0xFF0000);
	}

}
