package net.hycrafthd.youtubetut.proxy;

import net.hycrafthd.youtubetut.TUTMain;
import net.hycrafthd.youtubetut.entity.TUTGrenadeEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class TUTClientProxy extends TUTServerProxy {
	
	public void registerRenderThings() {
		RenderingRegistry.registerEntityRenderingHandler(TUTGrenadeEntity.class, new RenderSnowball(Minecraft.getMinecraft().getRenderManager(), TUTMain.tutgrenade, Minecraft.getMinecraft().getRenderItem()));
	}
	
	public void registerModels() {
		//Items
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(TUTMain.tutitem, 0, new ModelResourceLocation(TUTMain.MODID + ":tutitem", "inventory"));
		
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(TUTMain.tutfood, 0, new ModelResourceLocation(TUTMain.MODID + ":tutfood", "inventory"));
		
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(TUTMain.tutaxe, 0, new ModelResourceLocation(TUTMain.MODID + ":tutaxe", "inventory"));
		
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(TUTMain.tutpickaxe, 0, new ModelResourceLocation(TUTMain.MODID + ":tutpickaxe", "inventory"));
		
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(TUTMain.tutsword, 0, new ModelResourceLocation(TUTMain.MODID + ":tutsword", "inventory"));
		
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(TUTMain.tutspade, 0, new ModelResourceLocation(TUTMain.MODID + ":tutspade", "inventory"));
    	
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(TUTMain.tuthoe, 0, new ModelResourceLocation(TUTMain.MODID + ":tuthoe", "inventory"));
    	
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(TUTMain.tuthelmet, 0, new ModelResourceLocation(TUTMain.MODID + ":tuthelmet", "inventory"));
    	
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(TUTMain.tutchestplate, 0, new ModelResourceLocation(TUTMain.MODID + ":tutchestplate", "inventory"));
    	
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(TUTMain.tutleggings, 0, new ModelResourceLocation(TUTMain.MODID + ":tutleggings", "inventory"));
    	
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(TUTMain.tutboots, 0, new ModelResourceLocation(TUTMain.MODID + ":tutboots", "inventory"));
    	
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(TUTMain.tuthammer, 0, new ModelResourceLocation(TUTMain.MODID + ":tuthammer", "inventory"));
    	
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(TUTMain.tutexcavator, 0, new ModelResourceLocation(TUTMain.MODID + ":tutexcavator", "inventory"));
    	
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(TUTMain.tutgrenade, 0, new ModelResourceLocation(TUTMain.MODID + ":tutgrenade", "inventory"));
    	
		ModelBakery.addVariantName(TUTMain.tutbow, TUTMain.MODID + ":tutbow", TUTMain.MODID + ":tutbow_0", TUTMain.MODID + ":tutbow_1", TUTMain.MODID + ":tutbow_2");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(TUTMain.tutbow, 0, new ModelResourceLocation(TUTMain.MODID + ":tutbow", "inventory"));
    	
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(TUTMain.tuteffectfood, 0, new ModelResourceLocation(TUTMain.MODID + ":tuteffectfood", "inventory"));
	
		//Blocks
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(TUTMain.tutblock), 0, new ModelResourceLocation(TUTMain.MODID + ":tutblock", "inventory"));
	
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(TUTMain.tutblock2), 0, new ModelResourceLocation(TUTMain.MODID + ":tutblock2", "inventory"));
		
	}

}
