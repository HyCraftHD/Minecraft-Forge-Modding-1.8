package net.hycrafthd.youtubetut;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.hycrafthd.youtubetut.block.*;
import net.hycrafthd.youtubetut.handler.*;
import net.hycrafthd.youtubetut.item.*;
import net.hycrafthd.youtubetut.world.*;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.stats.Achievement;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.Height;
import net.minecraft.world.biome.BiomeGenForest;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = TUTMain.MODID, version = TUTMain.VERSION)
public class TUTMain
{
    public static final String MODID = "tutyoutube";
    public static final String VERSION = "1.0";
    
    public static CreativeTabs tuttab;
    
    public static Item tutitem;
    
    public static Block tutblock;
    public static Block tutblock2;
    
    public static Item tutfood;
    
    public static ToolMaterial tuttoolmaterial;
    public static ArmorMaterial tutarmormaterial;
    
    public static Item tutaxe;
    public static Item tutpickaxe;
    public static Item tutsword;
    public static Item tutspade;
    public static Item tuthoe;
    
    public static Item tuthelmet;
    public static Item tutchestplate;
    public static Item tutleggings;
    public static Item tutboots;
    
    public static String tutgreeting;
    
    public static Achievement tutjoin;
    public static Achievement tutonitemtutuse;
    
    public static BiomeGenBase tutbiome;
    public static int tutbiomeid;
    
    public static Item tuthammer;
    public static Item tutexcavator;
    
    @EventHandler
    public void preinit(FMLPreInitializationEvent event)
    {
    	
    	Configuration config = new Configuration(event.getSuggestedConfigurationFile());
    	config.load();
    	
    	tutgreeting = config.getString("greeting", "String", "Hi!!!!!!!", "Setup a Greetingmessage!");
    	tutbiomeid = config.getInt("biomeid", "Biomes", 80, 60, 110, "Biome ID");
    	
    	config.save();
    	
    	tuttab = new CreativeTabs("tuttab") {
			@Override
			public Item getTabIconItem() {
				return Item.getItemFromBlock(Blocks.diamond_ore);
			}
		};
    	
    	tutitem = new TUTItem().setUnlocalizedName("tutitem").setCreativeTab(tuttab);
    	
    	tutblock = new TUTBlock().setUnlocalizedName("tutblock").setCreativeTab(tuttab);
    	tutblock2 = new TUTBlock2().setUnlocalizedName("tutblock2").setCreativeTab(tuttab);
    	
    	tutfood = new TUTFood().setUnlocalizedName("tutfood").setCreativeTab(tuttab);

    	tuttoolmaterial = EnumHelper.addToolMaterial("TUTTOOL", 3, 19, 64F, 10F, 64).setRepairItem(new ItemStack(tutitem, 1));
    	tutarmormaterial = EnumHelper.addArmorMaterial("TUTARMOR", "", 11, new int[]{1, 10, 6, 3}, 60);
    	
    	tutaxe = new TUTAxe(tuttoolmaterial).setUnlocalizedName("tutaxe").setCreativeTab(tuttab);
    	tutpickaxe = new TUTPickaxe(tuttoolmaterial).setUnlocalizedName("tutpickaxe").setCreativeTab(tuttab);
    	tutsword = new TUTSword(tuttoolmaterial).setUnlocalizedName("tutsword").setCreativeTab(tuttab);
    	tutspade = new TUTSpade(tuttoolmaterial).setUnlocalizedName("tutspade").setCreativeTab(tuttab);
    	tuthoe = new TUTHoe(tuttoolmaterial).setUnlocalizedName("tuthoe").setCreativeTab(tuttab);
    	
    	tuthelmet = new TUTArmor(tutarmormaterial, 0).setUnlocalizedName("tuthelmet").setCreativeTab(tuttab);
    	tutchestplate = new TUTArmor(tutarmormaterial, 1).setUnlocalizedName("tutchestplate").setCreativeTab(tuttab);
    	tutleggings = new TUTArmor(tutarmormaterial, 2).setUnlocalizedName("tutleggings").setCreativeTab(tuttab);
    	tutboots = new TUTArmor(tutarmormaterial, 3).setUnlocalizedName("tutboots").setCreativeTab(tuttab);
    	
    	tutbiome = new TUTBiome(tutbiomeid);
    	tuthammer = new TUTHammer(tuttoolmaterial).setUnlocalizedName("tuthammer").setCreativeTab(tuttab);
    	tutexcavator = new TUTExcavator(tuttoolmaterial).setUnlocalizedName("tutexcavator").setCreativeTab(tuttab);
    	
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	
    	registerItems();
    	registerBlocks();
    	removerecipes();
    	crafting();
    	furnancerecipes();
    	registerHandlers();
    	registerAchievements();
    	registerWorldgenerator();
    	registerBiome();
    	
    }
    
    @EventHandler
    public void postinit(FMLPostInitializationEvent event)
    {
    	
    }
    
    //Craftingrezepte
    private void crafting() {
    	GameRegistry.addRecipe(new ItemStack(Blocks.diamond_block, 64), new Object[]{
    		"ggg",
    		"gbg",
    		"ggg",
    		Character.valueOf('g'), Blocks.gold_block,
    		Character.valueOf('b'), Items.diamond
    	});
    	
    	GameRegistry.addShapelessRecipe(new ItemStack(Items.diamond, 2), new ItemStack(Blocks.dirt), new ItemStack(Items.compass));
    	
    	ItemStack testitemstack = new ItemStack(Items.iron_sword, 1);
    	
    	testitemstack.addEnchantment(Enchantment.sharpness, 11);
    	testitemstack.setItemDamage(241);
    	testitemstack.setStackDisplayName("§6§lMASTER SWORD§r");
    	
    	GameRegistry.addShapelessRecipe(testitemstack, new ItemStack(Blocks.dirt));
    	
    }
    
    //Furnancerecipes
    public void furnancerecipes() {
    	GameRegistry.addSmelting(tutblock, new ItemStack(tutfood, 5), 1.0F);
    }
    
    //RegisterItem
    private void registerItems() {
    	
    	GameRegistry.registerItem(tutitem, "tutitem");
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(tutitem, 0, new ModelResourceLocation(MODID + ":tutitem", "inventory"));
    	
    	GameRegistry.registerItem(tutfood, "tutfood");
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(tutfood, 0, new ModelResourceLocation(MODID + ":tutfood", "inventory"));
    	
    	GameRegistry.registerItem(tutaxe, "tutaxe");
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(tutaxe, 0, new ModelResourceLocation(MODID + ":tutaxe", "inventory"));
    	GameRegistry.registerItem(tutpickaxe, "tutpickaxe");
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(tutpickaxe, 0, new ModelResourceLocation(MODID + ":tutpickaxe", "inventory"));
    	GameRegistry.registerItem(tutsword, "tutsword");
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(tutsword, 0, new ModelResourceLocation(MODID + ":tutsword", "inventory"));
    	GameRegistry.registerItem(tutspade, "tutspade");
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(tutspade, 0, new ModelResourceLocation(MODID + ":tutspade", "inventory"));
    	GameRegistry.registerItem(tuthoe, "tuthoe");
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(tuthoe, 0, new ModelResourceLocation(MODID + ":tuthoe", "inventory"));
    	
    	GameRegistry.registerItem(tuthelmet, "tuthelmet");
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(tuthelmet, 0, new ModelResourceLocation(MODID + ":tuthelmet", "inventory"));
    	GameRegistry.registerItem(tutchestplate, "tutchestplate");
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(tutchestplate, 0, new ModelResourceLocation(MODID + ":tutchestplate", "inventory"));
    	GameRegistry.registerItem(tutleggings, "tutleggings");
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(tutleggings, 0, new ModelResourceLocation(MODID + ":tutleggings", "inventory"));
    	GameRegistry.registerItem(tutboots, "tutboots");
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(tutboots, 0, new ModelResourceLocation(MODID + ":tutboots", "inventory"));
    	
    	GameRegistry.registerItem(tuthammer, "tuthammer");
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(tuthammer, 0, new ModelResourceLocation(MODID + ":tuthammer", "inventory"));
    	GameRegistry.registerItem(tutexcavator, "tutexcavator");
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(tutexcavator, 0, new ModelResourceLocation(MODID + ":tutexcavator", "inventory"));
    }
    
    //RegisterBlock
    private void registerBlocks() {
    	
    	GameRegistry.registerBlock(tutblock, "tutblock");
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(tutblock), 0, new ModelResourceLocation(MODID + ":tutblock", "inventory"));
    	
    	GameRegistry.registerBlock(tutblock2, "tutblock2");
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(tutblock2), 0, new ModelResourceLocation(MODID + ":tutblock2", "inventory"));
    	
    }
    
    //Remove Vanilla Recipes
    private void removerecipes() {
    	
    	List<IRecipe> craftingrecipes = CraftingManager.getInstance().getRecipeList();
    	Iterator<IRecipe> craftingremover = craftingrecipes.iterator();
    	while(craftingremover.hasNext()) {
    		ItemStack craftingitemstack = craftingremover.next().getRecipeOutput();
    		
    		if(craftingitemstack != null && craftingitemstack.getItem() == Item.getItemFromBlock(Blocks.iron_block)) {
    			craftingremover.remove();
    		}

    	}
    	
    	Map furnacerecipes = FurnaceRecipes.instance().getSmeltingList();
    	Iterator furnanceremover = furnacerecipes.entrySet().iterator();
    	while(furnanceremover.hasNext()) {
    		Entry furnanceentry = (Entry) furnanceremover.next();
    		ItemStack furnanceitemstack = (ItemStack) furnanceentry.getValue();
    		
    		if(furnanceitemstack != null && furnanceitemstack.getItem() == Items.iron_ingot) {
    			furnanceremover.remove();
    		}
    	}
    }
    
    //RegisterHandlers
    private void registerHandlers() {
    	
    	GameRegistry.registerFuelHandler(new TUTFuelHandler());
    	
    	FMLCommonHandler.instance().bus().register(new TUTEventHandler());
    	
    }
    
    //RegisterAchievements
    private void registerAchievements() {
    	
    	tutjoin = (new Achievement("achievement.tutjoin", "tutjoin", 0, 0, new ItemStack(tutblock), (Achievement)null)).setIndependent().setSpecial().func_180788_c();
    	tutonitemtutuse = (new Achievement("achievement.tutonitemtutuse", "tutonitemtutuse", 1, 3, new ItemStack(tutitem), tutjoin)).func_180788_c();
    	AchievementPage.registerAchievementPage(new AchievementPage("Tutorial Achievements", new Achievement[]{tutjoin, tutonitemtutuse}));
    
    }
    
    //RegisterWorldgenerator
    private void registerWorldgenerator() {
    	
    	GameRegistry.registerWorldGenerator(new TUTWorldgenerator(), 0);
    	
    }
    
    //RegisterBiome
    private void registerBiome() {
    	
    	BiomeManager.addBiome(BiomeType.COOL, new BiomeEntry(tutbiome, 1));
    	
    }
    
}
