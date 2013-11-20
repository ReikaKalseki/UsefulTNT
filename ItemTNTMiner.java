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

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import Reika.DragonAPI.Instantiable.MiningExplosion;

public class ItemTNTMiner extends Item {

	public ItemTNTMiner(int ID) {
		super(ID);
		this.setMaxStackSize(1);
		this.setMaxDamage(0);
		this.setCreativeTab(CreativeTabs.tabTools);
	}

	@Override
	public boolean onItemUse(ItemStack is, EntityPlayer ep, World world, int x, int y, int z, int s, float a, float b, float c) {
		int id = world.getBlockId(x, y, z);
		if (id == Block.tnt.blockID) {
			world.setBlock(x, y, z, 0);
			MiningExplosion exp = new MiningExplosion(world, null, x+0.5, y+0.5, z+0.5, 4, !ep.isSneaking());
			exp.doExplosionA();
			exp.doExplosionB(true);
			return true;
		}
		return false;
	}

	@Override
	public void registerIcons(IconRegister ico) {
		itemIcon = ico.registerIcon("UsefulTNT:tool");
	}

	@Override
	public Icon getIconFromDamage(int dmg) {
		return itemIcon;
	}

}
