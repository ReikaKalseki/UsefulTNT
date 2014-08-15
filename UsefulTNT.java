/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2014
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
package Reika.UsefulTNT;

import Reika.DragonAPI.DragonAPICore;
import Reika.DragonAPI.Auxiliary.CommandableUpdateChecker;
import Reika.DragonAPI.Base.DragonAPIMod;
import Reika.DragonAPI.Instantiable.IO.ModLogger;

import java.net.URL;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod( modid = "UsefulTNT", name="Useful TNT", version="beta", certificateFingerprint = "@GET_FINGERPRINT@", dependencies="required-after:DragonAPI")

public class UsefulTNT extends DragonAPIMod {

	@Instance("UsefulTNT")
	public static UsefulTNT instance = new UsefulTNT();

	public static Item tntItem;

	public static ModLogger logger;

	//public static final SimpleConfig config = new SimpleConfig(instance);

	@Override
	@EventHandler
	public void preload(FMLPreInitializationEvent evt) {
		//config.loadSubfolderedConfigFile(evt);
		//config.loadDataFromFile(evt);
		//int itemID = config.getInteger("Item IDs", "TNT Miner Item", 27600);
		//config.finishReading();

		//if (Items.itemsList[256+itemID] != null)
		//	throw new IDConflictException(UsefulTNT.instance, itemID+" item slot already occupied by "+Items.itemsList[256+itemID]+" while adding "+this);
		tntItem = new ItemTNTMiner().setUnlocalizedName("tntminer");
		logger = new ModLogger(instance, false);
		LanguageRegistry.addName(tntItem, "TNT Mining Item");

		this.basicSetup(evt);
	}

	@Override
	@EventHandler
	public void load(FMLInitializationEvent event) {
		this.addRecipes();
	}

	public static void addRecipes() {
		GameRegistry.addShapedRecipe(new ItemStack(tntItem, 1, 0), "IDI", " E ", " I ", 'I', Items.iron_ingot, 'D', Items.diamond, 'E', Items.ender_pearl);
	}

	@Override
	@EventHandler
	public void postload(FMLPostInitializationEvent evt) {

	}

	@Override
	public String getDisplayName() {
		return "Useful TNT";
	}

	@Override
	public String getModAuthorName() {
		return "Reika";
	}

	@Override
	public URL getDocumentationSite() {
		return DragonAPICore.getReikaForumPage();
	}

	@Override
	public String getWiki() {
		return null;
	}

	@Override
	public String getUpdateCheckURL() {
		return CommandableUpdateChecker.reikaURL;
	}

	@Override
	public ModLogger getModLogger() {
		return logger;
	}

}