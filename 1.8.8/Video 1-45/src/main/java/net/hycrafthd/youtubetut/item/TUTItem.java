package net.hycrafthd.youtubetut.item;

import net.hycrafthd.youtubetut.TUTMain;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class TUTItem extends Item {
	
	public TUTItem() {
		super();
		this.setMaxDamage(128);
		this.setMaxStackSize(1);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		player.jump();
		player.fallDistance = 0F;
		itemStack.damageItem(1, player);
		player.addStat(TUTMain.tutonitemtutuse, 1);
        return itemStack;
    }

}
