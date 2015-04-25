package net.hycrafthd.youtubetut;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class TUTEffectFood extends ItemFood {

	public TUTEffectFood() {
		super(2, false);
		this.setAlwaysEdible();
	}
	
	@Override
	public boolean hasEffect(ItemStack stack) {
		return true;
	}
	
	@Override
	public void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
		if(!world.isRemote) {
			player.addPotionEffect(new PotionEffect(Potion.resistance.id, 400, 254));
			player.addExperienceLevel(20);
		}
	}

}
