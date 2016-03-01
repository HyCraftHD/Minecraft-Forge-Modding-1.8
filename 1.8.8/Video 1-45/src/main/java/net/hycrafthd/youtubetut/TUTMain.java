package net.hycrafthd.youtubetut;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.hycrafthd.youtubetut.block.TUTBlock;
import net.hycrafthd.youtubetut.block.TUTBlock2;
import net.hycrafthd.youtubetut.entity.TUTGrenadeEntity;
import net.hycrafthd.youtubetut.handler.TUTEventHandler;
import net.hycrafthd.youtubetut.handler.TUTFuelHandler;
import net.hycrafthd.youtubetut.handler.TUTGuiHandler;
import net.hycrafthd.youtubetut.item.TUTArmor;
import net.hycrafthd.youtubetut.item.TUTAxe;
import net.hycrafthd.youtubetut.item.TUTBow;
import net.hycrafthd.youtubetut.item.TUTEffectFood;
import net.hycrafthd.youtubetut.item.TUTExcavator;
import net.hycrafthd.youtubetut.item.TUTFood;
import net.hycrafthd.youtubetut.item.TUTGrenade;
import net.hycrafthd.youtubetut.item.TUTHammer;
import net.hycrafthd.youtubetut.item.TUTHoe;
import net.hycrafthd.youtubetut.item.TUTItem;
import net.hycrafthd.youtubetut.item.TUTPickaxe;
import net.hycrafthd.youtubetut.item.TUTSpade;
import net.hycrafthd.youtubetut.item.TUTSword;
import net.hycrafthd.youtubetut.proxy.TUTServerProxy;
import net.hycrafthd.youtubetut.world.TUTBiome;
import net.hycrafthd.youtubetut.world.TUTWorldgenerator;
import net.minecraft.block.Block;
import net.minecraft.client.audio.SoundCategory;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.stats.Achievement;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = TUTMain.MODID, version = TUTMain.VERSION)
public class TUTMain {
	public static final String MODID = "tutyoutube";
	public static final String VERSION = "1.0";

	@Instance(MODID)
	public static TUTMain INSTANCE;

	@SidedProxy(clientSide = "net.hycrafthd.youtubetut.proxy.TUTClientProxy", serverSide = "net.hycrafthd.youtubetut.proxy.TUTServerProxy")
	public static TUTServerProxy PROXY;

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

	public static Item tutgrenade;

	public static Item tutbow;

	public static Item tuteffectfood;

	public static int tutguiid;
	public static int tutguidefaultcraftingtable;

	@EventHandler
	public void preinit(FMLPreInitializationEvent event) {

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
		tutarmormaterial = EnumHelper.addArmorMaterial("TUTARMOR", "", 11, new int[] { 1, 10, 6, 3 }, 60);

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

		tutgrenade = new TUTGrenade().setUnlocalizedName("tutgrenade").setCreativeTab(tuttab);

		tutbow = new TUTBow().setUnlocalizedName("tutbow").setCreativeTab(tuttab);

		tuteffectfood = new TUTEffectFood().setUnlocalizedName("tuteffectfood").setCreativeTab(tuttab);

		tutguiid = 1;
		tutguidefaultcraftingtable = 2;

	}

	@EventHandler
	public void init(FMLInitializationEvent event) {

		registerItems();
		registerBlocks();
		registerEntitys();
		removerecipes();
		crafting();
		furnancerecipes();
		registerHandlers();
		registerAchievements();
		registerWorldgenerator();
		registerBiome();

	}

	@EventHandler
	public void postinit(FMLPostInitializationEvent event) {
		PROXY.registerModels();
		PROXY.registerRenderThings();
	}

	// Craftingrezepte
	private void crafting() {
		GameRegistry.addRecipe(new ItemStack(Blocks.diamond_block, 64), new Object[] { "ggg", "gbg", "ggg", Character.valueOf('g'), Blocks.gold_block, Character.valueOf('b'), Items.diamond });

		GameRegistry.addShapelessRecipe(new ItemStack(Items.diamond, 2), new ItemStack(Blocks.dirt), new ItemStack(Items.compass));

		ItemStack testitemstack = new ItemStack(Items.iron_sword, 1);

		testitemstack.addEnchantment(Enchantment.sharpness, 11);
		testitemstack.setItemDamage(241);
		testitemstack.setStackDisplayName("§6§lMASTER SWORD§r");

		GameRegistry.addShapelessRecipe(testitemstack, new ItemStack(Blocks.dirt));

	}

	// Furnancerecipes
	public void furnancerecipes() {
		GameRegistry.addSmelting(tutblock, new ItemStack(tutfood, 5), 1.0F);
	}

	// RegisterItem
	private void registerItems() {

		GameRegistry.registerItem(tutitem, "tutitem");

		GameRegistry.registerItem(tutfood, "tutfood");

		GameRegistry.registerItem(tutaxe, "tutaxe");

		GameRegistry.registerItem(tutpickaxe, "tutpickaxe");

		GameRegistry.registerItem(tutsword, "tutsword");

		GameRegistry.registerItem(tutspade, "tutspade");

		GameRegistry.registerItem(tuthoe, "tuthoe");

		GameRegistry.registerItem(tuthelmet, "tuthelmet");

		GameRegistry.registerItem(tutchestplate, "tutchestplate");

		GameRegistry.registerItem(tutleggings, "tutleggings");

		GameRegistry.registerItem(tutboots, "tutboots");

		GameRegistry.registerItem(tuthammer, "tuthammer");

		GameRegistry.registerItem(tutexcavator, "tutexcavator");

		GameRegistry.registerItem(tutgrenade, "tutgrenade");

		GameRegistry.registerItem(tutbow, "tutbow");

		GameRegistry.registerItem(tuteffectfood, "tuteffectfood");

	}

	// RegisterBlock
	private void registerBlocks() {

		GameRegistry.registerBlock(tutblock, "tutblock");

		GameRegistry.registerBlock(tutblock2, "tutblock2");

	}

	// Remove Vanilla Recipes
	private void removerecipes() {

		List<IRecipe> craftingrecipes = CraftingManager.getInstance().getRecipeList();
		Iterator<IRecipe> craftingremover = craftingrecipes.iterator();
		while (craftingremover.hasNext()) {
			ItemStack craftingitemstack = craftingremover.next().getRecipeOutput();

			if (craftingitemstack != null && craftingitemstack.getItem() == Item.getItemFromBlock(Blocks.iron_block)) {
				craftingremover.remove();
			}

		}

		Map furnacerecipes = FurnaceRecipes.instance().getSmeltingList();
		Iterator furnanceremover = furnacerecipes.entrySet().iterator();
		while (furnanceremover.hasNext()) {
			Entry furnanceentry = (Entry) furnanceremover.next();
			ItemStack furnanceitemstack = (ItemStack) furnanceentry.getValue();

			if (furnanceitemstack != null && furnanceitemstack.getItem() == Items.iron_ingot) {
				furnanceremover.remove();
			}
		}
	}

	// RegisterHandlers
	private void registerHandlers() {

		GameRegistry.registerFuelHandler(new TUTFuelHandler());

		FMLCommonHandler.instance().bus().register(new TUTEventHandler());

		NetworkRegistry.INSTANCE.registerGuiHandler(INSTANCE, new TUTGuiHandler());

	}

	// RegisterAchievements
	private void registerAchievements() {

		tutjoin = (new Achievement("achievement.tutjoin", "tutjoin", 0, 0, new ItemStack(tutblock), (Achievement) null)).initIndependentStat().setSpecial().registerStat();
		tutonitemtutuse = (new Achievement("achievement.tutonitemtutuse", "tutonitemtutuse", 1, 3, new ItemStack(tutitem), tutjoin)).registerStat();
		AchievementPage.registerAchievementPage(new AchievementPage("Tutorial Achievements", new Achievement[] { tutjoin, tutonitemtutuse }));

	}

	// RegisterWorldgenerator
	private void registerWorldgenerator() {

		GameRegistry.registerWorldGenerator(new TUTWorldgenerator(), 0);

	}

	// RegisterBiome
	private void registerBiome() {

		BiomeManager.addBiome(BiomeType.COOL, new BiomeEntry(tutbiome, 1));

	}

	// RegisterEntities
	private void registerEntitys() {
		registerEntity(TUTGrenadeEntity.class, "tutgrenade", 128, 10, true);
	}

	// RegisterEntityes...
	private void registerEntity(Class<? extends Entity> entityClass, String name, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates) {
		int id = EntityRegistry.findGlobalUniqueEntityId();

		EntityRegistry.registerGlobalEntityID(entityClass, name, id);
		EntityRegistry.registerModEntity(entityClass, name, id, INSTANCE, trackingRange, updateFrequency, sendsVelocityUpdates);
	}

}
