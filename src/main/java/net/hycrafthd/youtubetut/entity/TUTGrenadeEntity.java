package net.hycrafthd.youtubetut.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class TUTGrenadeEntity extends EntityThrowable {

	public TUTGrenadeEntity(World world) {
		super(world);
	}
	
	public TUTGrenadeEntity(World world, EntityLivingBase entity) {
		super(world, entity);
	}

	@Override
	protected void onImpact(MovingObjectPosition mop) {
		if(!this.worldObj.isRemote) {
			this.setDead();
			this.worldObj.createExplosion((Entity)null, this.posX, this.posY, this.posZ, 4.5F, true);
		}
	}

}
