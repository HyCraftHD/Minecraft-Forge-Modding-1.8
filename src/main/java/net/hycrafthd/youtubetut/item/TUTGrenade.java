package net.hycrafthd.youtubetut.item;

import net.hycrafthd.youtubetut.entity.TUTGrenadeEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class TUTGrenade extends Item {

	public TUTGrenade() {
		super();
	}
	
	 public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		 if(!player.capabilities.isCreativeMode) {
			 --itemStack.stackSize;
		 }
		 world.playSoundAtEntity(player, "random.fizz", 0.7F, 0.8F);
		 
		 if(!world.isRemote) {
			 world.spawnEntityInWorld(new TUTGrenadeEntity(world, player));
		 }
		 return itemStack;
	 }
	
}
