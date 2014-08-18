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

import Reika.DragonAPI.Instantiable.MiningExplosion;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ItemTNTMiner extends Item {

	public ItemTNTMiner() {
		super();
		this.setMaxStackSize(1);
		this.setMaxDamage(0);
		this.setCreativeTab(CreativeTabs.tabTools);
	}

	@Override
	public boolean onItemUse(ItemStack is, EntityPlayer ep, World world, int x, int y, int z, int s, float a0, float a1, float a2) {
		Block b = world.getBlock(x, y, z);
		if (b == Blocks.tnt) {
			world.setBlock(x, y, z, Blocks.air);
			MiningExplosion exp = new MiningExplosion(world, null, x+0.5, y+0.5, z+0.5, 4, !ep.isSneaking());
			exp.doExplosionA();
			exp.doExplosionB(true);
			return true;
		}
		return false;
	}

	@Override
	public void registerIcons(IIconRegister ico) {
		itemIcon = ico.registerIcon("UsefulTNT:tool");
	}

	@Override
	public IIcon getIconFromDamage(int dmg) {
		return itemIcon;
	}

}
