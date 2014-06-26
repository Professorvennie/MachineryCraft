package com.professorvennie.core.block;

import java.util.Random;

import com.professorvennie.core.lib.BlockNames;
import com.professorvennie.core.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.professorvennie.core.block.tileEntity.TileEntityIronOxideFurnace;
import com.professorvennie.core.lib.LibGuiIds;
import com.professorvennie.core.main.MainRegistry;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockIronoxideFurnace extends BlockContainer  {
	@SideOnly(Side.CLIENT)
	private IIcon iconFront;

	private static boolean keepInventory;
	
	private final boolean isActive;

	public BlockIronoxideFurnace(boolean isActive) {
		super(Material.rock);
		
		if(!isActive){
			this.setBlockName(BlockNames.ironOxideFurnaceIdle);
			this.setCreativeTab(MainRegistry.tabMachineryCraft);
		}
		if(isActive){
			this.setLightLevel(0.9F);
			this.setBlockName(BlockNames.ironOxideFurnaceActive);
		}
		this.setHardness(3.5F);
		this.isActive = isActive;
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityIronOxideFurnace();
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister iiconRegister) {
		this.blockIcon = iiconRegister.registerIcon(Reference.MOD_ID + ":ores/" + "metal_6");
		this.iconFront = iiconRegister.registerIcon(Reference.MOD_ID + ":" + (this.isActive ? "ironoxide_furnace_Active" : "ironoxide_furnace_idle"));
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata) {
		return metadata == 0 && side == 3 ? this.iconFront : (side == metadata ? this.iconFront : this.blockIcon);
	}

	public Item getItemDropped(int par1, Random random, int par2) {
		return Item.getItemFromBlock(ModBlocks.ironOxideFurnaceIdle);
	}

	public Item getItem(World world, int x, int y, int z) {
		return Item.getItemFromBlock(ModBlocks.ironOxideFurnaceIdle);
	}

	public void onBlockAdded(World world, int x, int y, int z) {
		super.onBlockAdded(world, x, y, z);
		this.setDefualtDirection(world, x, y, z);
	}

	private void setDefualtDirection(World world, int x, int y, int z) {
		if (!world.isRemote) {
			Block l = world.getBlock(x, y, z - 1);
			Block il = world.getBlock(x, y, z + 1);
			Block jl = world.getBlock(x - 1, y, z);
			Block kl = world.getBlock(x + 1, y, z - 1);
			byte b0 = 3;

			if (l.isNormalCube() && !il.isNormalCube()) {
				b0 = 3;
			}

			if (il.isNormalCube() && !l.isNormalCube()) {
				b0 = 2;
			}

			if (kl.isNormalCube() && !jl.isNormalCube()) {
				b0 = 5;
			}

			if (jl.isNormalCube() && !kl.isNormalCube()) {
				b0 = 4;
			}
			world.setBlockMetadataWithNotify(x, y, z, b0, 2);

		}
	}

	public boolean onBlockActivated(World world, int x, int y, int z,
			EntityPlayer player, int side, float hitx, float hity, float hitz) {
		if (!world.isRemote) {
			FMLNetworkHandler.openGui(player, MainRegistry.instance, LibGuiIds.GUIID_IRONOXIDE_FURNACE, world, x, y, z);
		}
		return true;
	}

	public static void updateGrinderBlockState(boolean active, World worldObj,
			int xCoord, int yCoord, int zCoord) {
		int i = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
		TileEntity tileentity = worldObj.getTileEntity(xCoord, yCoord, zCoord);
			keepInventory = true;

		if (active) {
			worldObj.setBlock(xCoord, yCoord, zCoord, ModBlocks.ironOxideFurnaceActive);
		} else {
			worldObj.setBlock(xCoord, yCoord, zCoord, ModBlocks.ironOxideFurnaceIdle);
		}

			keepInventory = false;

		worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, i, 2);

		if (tileentity != null) {
			tileentity.validate();
			worldObj.setTileEntity(xCoord, yCoord, zCoord, tileentity);
		}
	}


	public void onBlockPlacedBy(World world, int x, int y, int z,
			EntityLivingBase entityLivingBase, ItemStack itemstack) {
		int l = MathHelper.floor_double((double) (entityLivingBase.rotationYaw * 4.0f / 360.0f) + 0.5D) & 3;

		if (l == 0) {
			world.setBlockMetadataWithNotify(x, y, z, 2, 2);
		}

		if (l == 1) {
			world.setBlockMetadataWithNotify(x, y, z, 5, 2);
		}

		if (l == 2) {
			world.setBlockMetadataWithNotify(x, y, z, 3, 2);
		}

		if (l == 3) {
			world.setBlockMetadataWithNotify(x, y, z, 4, 2);
		}

		if (itemstack.hasDisplayName()) {
			((TileEntityIronOxideFurnace) world.getTileEntity(x, y, z)) .setGuiDisplayName(itemstack.getDisplayName());
		}
	}

}


