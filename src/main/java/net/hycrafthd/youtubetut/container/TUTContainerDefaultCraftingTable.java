package net.hycrafthd.youtubetut.container;

import net.hycrafthd.youtubetut.TUTMain;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class TUTContainerDefaultCraftingTable extends ContainerWorkbench {
	
	private World worldObj;
	private BlockPos pos;

	public TUTContainerDefaultCraftingTable(InventoryPlayer playerInventory, World worldIn, BlockPos pos) {
		super(playerInventory, worldIn, pos);
		this.worldObj = worldIn;
		this.pos = pos;
	}
	
	@Override
    public boolean canInteractWith(EntityPlayer playerIn)
    {
        return this.worldObj.getBlockState(this.pos).getBlock() != TUTMain.tutblock ? false : playerIn.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
    }

}
