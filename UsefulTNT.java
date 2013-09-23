/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2013
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
package Reika.UsefulTNT;

import java.net.MalformedURLException;
import java.net.URL;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import Reika.DragonAPI.Base.DragonAPIMod;
import Reika.DragonAPI.Exception.IDConflictException;
import Reika.DragonAPI.Exception.RegistrationException;
import Reika.DragonAPI.Instantiable.ModLogger;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod( modid = "UsefulTNT", name="Useful TNT", version="beta", certificateFingerprint = "@GET_FINGERPRINT@", dependencies="after:DragonAPI")
@NetworkMod(clientSideRequired = true, serverSideRequired = true)
public class UsefulTNT extends DragonAPIMod {

	//@Instance
	public static UsefulTNT instance = new UsefulTNT();

	public static final int itemID = 27600;

	public static Item tntItem;

	public static ModLogger logger;

	@Override
	@PreInit
	public void preload(FMLPreInitializationEvent evt) {
		if (Item.itemsList[256+itemID] != null)
			throw new IDConflictException(UsefulTNT.instance, itemID+" item slot already occupied by "+Item.itemsList[256+itemID]+" while adding "+this);
		tntItem = new ItemTNTMiner(itemID).setUnlocalizedName("tntminer");
		logger = new ModLogger(instance, true, false, false);
		LanguageRegistry.addName(tntItem, "TNT Mining Item");
	}

	@Override
	@Init
	public void load(FMLInitializationEvent event) {
		this.addRecipes();
	}

	public static void addRecipes() {
		GameRegistry.addShapedRecipe(new ItemStack(tntItem.itemID, 1, 0), "IDI", " E ", " I ", 'I', Item.ingotIron, 'D', Item.diamond, 'E', Item.enderPearl);
	}

	@Override
	@PostInit
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
		try {
			return new URL("http://www.minecraftforum.net/topic/1969694-");
		}
		catch (MalformedURLException e) {
			throw new RegistrationException(instance, "The mod provided a malformed URL for its documentation site!");
		}
	}

	@Override
	public boolean hasWiki() {
		return false;
	}

	@Override
	public URL getWiki() {
		return null;
	}

	@Override
	public boolean hasVersion() {
		return false;
	}

	@Override
	public String getVersionName() {
		return null;
	}

}
