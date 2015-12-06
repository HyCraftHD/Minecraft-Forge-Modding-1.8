package net.hycrafthd.youtubetutdimension;

import net.hycrafthd.youtubetutdimension.block.BlockDimPortal;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = DimMain.MODID, version = DimMain.VERSION)
public class DimMain {
	
	public static final String MODID = "tutyoutubedim";
	public static final String VERSION = "1.0";
	
	public static Block creator, portal, stone;

	@Instance(MODID)
	public static DimMain INSTANCE;

	@SidedProxy(clientSide = "net.hycrafthd.youtubetutdimension.ClientProxy", serverSide = "net.hycrafthd.youtubetutdimension.ServerProxy")
	public static ServerProxy PROXY;

	public static CreativeTabs tab;

	@EventHandler
	public void preinit(FMLPreInitializationEvent event) {

		tab = new CreativeTabs("tuttabdim") {
			@Override
			public Item getTabIconItem() {
				return Item.getItemFromBlock(Blocks.anvil);
			}
		};
		
		portal = new BlockDimPortal().setUnlocalizedName("dimportal").setCreativeTab(tab);
		stone = new BlockDimStone().setUnlocalizedName("dimstone").setCreativeTab(tab);
		creator = new BlockDimCreator().setUnlocalizedName("dimcreator").setCreativeTab(tab);

	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		GameRegistry.registerBlock(portal, "dimportal");
		GameRegistry.registerBlock(stone, "dimstone");
		GameRegistry.registerBlock(creator, "dimcreator");
	}

	@EventHandler
	public void postinit(FMLPostInitializationEvent event) {
		PROXY.registerModels();
	}

}
