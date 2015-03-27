package net.hycrafthd.youtubetut.proxy;

import net.hycrafthd.youtubetut.TUTMain;
import net.hycrafthd.youtubetut.entity.TUTGrenadeEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class TUTClientProxy extends TUTServerProxy {
	
	public void registerRenderThings() {
		RenderingRegistry.registerEntityRenderingHandler(TUTGrenadeEntity.class, new RenderSnowball(Minecraft.getMinecraft().getRenderManager(), TUTMain.tutgrenade, Minecraft.getMinecraft().getRenderItem()));
	}

}
