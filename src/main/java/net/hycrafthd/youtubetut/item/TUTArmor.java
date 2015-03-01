package net.hycrafthd.youtubetut.item;

import net.hycrafthd.youtubetut.TUTMain;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class TUTArmor extends ItemArmor {

	public TUTArmor(ArmorMaterial material, int armorType) {
		super(material, 0, armorType);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		if(slot == 0 || slot == 1 || slot == 3) {
			return TUTMain.MODID + ":textures/models/armor/tutarmor_1.png";
		} else if(slot == 2) {
			return TUTMain.MODID + ":textures/models/armor/tutarmor_2.png";
		} else {
			return null;
		}
	}

}
