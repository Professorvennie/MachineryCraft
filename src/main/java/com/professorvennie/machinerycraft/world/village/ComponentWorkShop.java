/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.world.village;

import com.professorvennie.machinerycraft.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureVillagePieces;
import net.minecraft.world.gen.structure.StructureVillagePieces.Start;

import java.util.List;
import java.util.Random;

public class ComponentWorkShop extends StructureVillagePieces.House1 {

    private int averageGroundLevel = -1;
    private StructureBoundingBox sbb;
    private World w;

    public ComponentWorkShop() {

    }

    public ComponentWorkShop(Start villagePiece, int par2, Random random, StructureBoundingBox structureBoundingBox, EnumFacing facing) {
        super();
        this.coordBaseMode = facing;
        this.boundingBox = structureBoundingBox;
    }

    public static ComponentWorkShop buildComponet(Start villagePiece, List pieces, Random random, int p1, int p2, int p3, int p4, int p5) {
        StructureBoundingBox structureBoundingBox = StructureBoundingBox.func_175897_a(p1, p2, p3, 0, 0, 0, 7, 6, 7, EnumFacing.EAST);
        return canVillageGoDeeper(structureBoundingBox) && StructureComponent.findIntersecting(pieces, structureBoundingBox) == null ? new ComponentWorkShop(villagePiece, p5, random, structureBoundingBox, EnumFacing.EAST) : null;
    }

    public boolean addComponentParts(World world, Random random, StructureBoundingBox sbb) {
        this.sbb = sbb;
        this.w = world;
        if (this.averageGroundLevel < 0) {
            this.averageGroundLevel = this.getAverageGroundLevel(world, sbb);
            if (this.averageGroundLevel < 0) {
                return true;
            }
            this.boundingBox.offset(0, this.averageGroundLevel - this.boundingBox.maxY + 4, 0);
        }

        this.fill(0, 0, 0, 8, 1, 6, Blocks.cobblestone);//Base
        this.fill(1, 0, 1, 8, 1, 8, Blocks.cobblestone);
        this.fill(0, 0, 2, 8, 1, 9, Blocks.cobblestone);

        for (int w = 0; w < 9; w++) {
            for (int w1 = 0; w1 < 10; w1++) {
                this.func_175811_a(world, ModBlocks.plasticPlanks.getDefaultState(), w, 3, w1, sbb);//Roof
                this.func_175811_a(world, ModBlocks.plasticLog.getDefaultState(), w, 4, w1, sbb);
                this.func_175811_a(world, ModBlocks.plasticFence.getDefaultState(), w, 5, 0, sbb);
                this.func_175811_a(world, ModBlocks.plasticFence.getDefaultState(), w, 5, 9, sbb);
                this.func_175811_a(world, ModBlocks.plasticFence.getDefaultState(), 0, 5, w1, sbb);
                this.func_175811_a(world, ModBlocks.plasticFence.getDefaultState(), 8, 5, w1, sbb);
            }
        }

        this.func_175811_a(world, ModBlocks.windmillground.getDefaultState(), 3, 5, 4, sbb);
        this.func_175811_a(world, ModBlocks.windmillground.getDefaultState(), 3, 5, 5, sbb);
        this.func_175811_a(world, ModBlocks.windmillground.getDefaultState(), 3, 5, 6, sbb);
        this.func_175811_a(world, ModBlocks.windmillground.getDefaultState(), 4, 5, 4, sbb);
        this.func_175811_a(world, ModBlocks.windmillground.getDefaultState(), 4, 5, 5, sbb);
        this.func_175811_a(world, ModBlocks.windmillground.getDefaultState(), 4, 5, 6, sbb);
        this.func_175811_a(world, ModBlocks.windmillground.getDefaultState(), 5, 5, 4, sbb);
        this.func_175811_a(world, ModBlocks.windmillground.getDefaultState(), 5, 5, 5, sbb);
        this.func_175811_a(world, ModBlocks.windmillground.getDefaultState(), 5, 5, 6, sbb);

        for (int y1 = 0; y1 < 7; y1++) {
            this.func_175804_a(world, sbb, (y1 + 1) == 7 ? (y1 + 1 + 8) : (y1 + 1), 4, 5 + y1 + 1, 5, 0, 0, ModBlocks.windmill.getDefaultState(), ModBlocks.windmill.getDefaultState(), false);
        }

        for (int a = 0; a < 8; a++) {
            for (int a1 = 0; a1 < 7; a1++) {
                for (int a3 = 0; a3 < 3; a3++) {
                    this.func_175811_a(world, Blocks.air.getDefaultState(), a1 + 1, a3, a + 1, sbb);
                    this.func_175811_a(world, Blocks.air.getDefaultState(), a1 + 1, a3 + 1, a + 1, sbb);
                    this.func_175811_a(world, ModBlocks.plasticPlanks.getDefaultState(), a1 + 1, a3 + 2, a + 1, sbb);
                }
            }
        }


        this.fill(0, 0, 0, 8, 0, 8, ModBlocks.plasticPlanks);
        this.func_175811_a(world, ModBlocks.plasticLog.getDefaultState(), 0, 1, 0, sbb);
        this.func_175811_a(world, ModBlocks.plasticLog.getDefaultState(), 0, 2, 0, sbb);
        this.func_175811_a(world, ModBlocks.plasticLog.getDefaultState(), 0, 3, 0, sbb);

        this.func_175811_a(world, Blocks.glass_pane.getDefaultState(), 1, 2, 0, sbb);//Front
        this.func_175811_a(world, Blocks.glass_pane.getDefaultState(), 2, 2, 0, sbb);
        this.func_175811_a(world, ModBlocks.plasticLog.getDefaultState(), 3, 2, 0, sbb);
        this.func_175811_a(world, ModBlocks.plasticLog.getDefaultState(), 3, 3, 0, sbb);
        this.func_175811_a(world, ModBlocks.plasticLog.getDefaultState(), 4, 3, 0, sbb);
        this.func_175810_a(w, sbb, random, 4, 1, 0, EnumFacing.getHorizontal(this.getMetadataWithOffset(Blocks.oak_door, 1)));
        this.func_175811_a(world, ModBlocks.plasticLog.getDefaultState(), 5, 2, 0, sbb);
        this.func_175811_a(world, ModBlocks.plasticLog.getDefaultState(), 5, 3, 0, sbb);
        this.func_175811_a(world, Blocks.glass_pane.getDefaultState(), 6, 2, 0, sbb);
        this.func_175811_a(world, Blocks.glass_pane.getDefaultState(), 7, 2, 0, sbb);

        this.func_175811_a(world, ModBlocks.plasticLog.getDefaultState(), 8, 1, 0, sbb);//Left
        this.func_175811_a(world, ModBlocks.plasticLog.getDefaultState(), 8, 2, 0, sbb);
        this.func_175811_a(world, ModBlocks.plasticLog.getDefaultState(), 8, 3, 0, sbb);

        for (int l = 0; l < 8; l++)
            this.func_175811_a(world, Blocks.glass_pane.getDefaultState(), 8, 2, l + 1, sbb);

        for (int k = 0; k < 8; k++)
            this.func_175811_a(world, Blocks.glass_pane.getDefaultState(), 0, 2, k + 1, sbb);//Right

        for (int b = 0; b < 8; b++)
            this.func_175811_a(world, Blocks.glass_pane.getDefaultState(), b, 2, 9, sbb);//Back

        this.func_175811_a(world, ModBlocks.plasticLog.getDefaultState(), 0, 1, 9, sbb);//Right back
        this.func_175811_a(world, ModBlocks.plasticLog.getDefaultState(), 0, 2, 9, sbb);
        this.func_175811_a(world, ModBlocks.plasticLog.getDefaultState(), 0, 3, 9, sbb);

        this.func_175811_a(world, ModBlocks.plasticLog.getDefaultState(), 8, 1, 9, sbb);//Left back
        this.func_175811_a(world, ModBlocks.plasticLog.getDefaultState(), 8, 2, 9, sbb);
        this.func_175811_a(world, ModBlocks.plasticLog.getDefaultState(), 8, 3, 9, sbb);

        this.func_175811_a(world, Blocks.lit_redstone_lamp.getDefaultState(), 2, 0, 2, sbb);
        this.func_175811_a(world, Blocks.redstone_torch.getDefaultState(), 2, -1, 2, sbb);


        this.func_175811_a(world, Blocks.crafting_table.getDefaultState(), 7, 1, 1, sbb);
        this.func_175811_a(world, ModBlocks.plasticChest.getDefaultState(), 1, 1, 1, sbb);

        this.func_175811_a(world, Blocks.lit_redstone_lamp.getDefaultState(), 4, 0, 4, sbb);
        this.func_175811_a(world, Blocks.lit_redstone_lamp.getDefaultState(), 4, 0, 5, sbb);
        this.func_175811_a(world, Blocks.redstone_torch.getDefaultState(), 4, -1, 5, sbb);
        this.func_175811_a(world, Blocks.redstone_torch.getDefaultState(), 4, -1, 5, sbb);


        this.func_175811_a(world, Blocks.lit_redstone_lamp.getDefaultState(), 6, 0, 7, sbb);
        this.func_175811_a(world, Blocks.redstone_torch.getDefaultState(), 6, -1, 7, sbb);

        this.func_175811_a(world, Blocks.lit_redstone_lamp.getDefaultState(), 2, 0, 7, sbb);
        this.func_175811_a(world, Blocks.redstone_torch.getDefaultState(), 2, -1, 7, sbb);

        this.func_175811_a(world, Blocks.lit_redstone_lamp.getDefaultState(), 6, 0, 2, sbb);
        this.func_175811_a(world, Blocks.redstone_torch.getDefaultState(), 6, -1, 2, sbb);

        this.func_175811_a(world, ModBlocks.plasticLog.getDefaultState(), 7, 1, 8, sbb);
        this.func_175811_a(world, ModBlocks.plasticLeaf.getDefaultState(), 7, 2, 8, sbb);

        this.func_175811_a(world, ModBlocks.plasticPlanks.getDefaultState(), 4, 2, 9, sbb);

        this.func_175811_a(world, ModBlocks.copperFurnaceIdle.getDefaultState(), 3, 1, 8, sbb);
        this.func_175811_a(world, ModBlocks.copperGrinderIdle.getDefaultState(), 5, 1, 8, sbb);

        int i = this.getMetadataWithOffset(Blocks.ladder, 3);
        this.func_175811_a(world, Blocks.ladder.getStateFromMeta(i), 4, 1, 8, sbb);
        this.func_175811_a(world, Blocks.ladder.getStateFromMeta(i), 4, 2, 8, sbb);
        this.func_175811_a(world, Blocks.ladder.getStateFromMeta(i), 4, 3, 8, sbb);
        this.func_175811_a(world, Blocks.ladder.getStateFromMeta(i), 4, 4, 8, sbb);

        this.spawnVillagers(world, sbb, 3, 1, 3, 1);
        return true;
    }

    /*@Override
    protected int getVillagerType(int p_74888_1_) {
        return 78906;
    }*/

    private void fill(int x, int y, int z, int x1, int y1, int z1, Block b) {
        for (int i = 0; i < x; ++i)
        {
            for (int j = 0; j < y; ++j)
            {
                this.clearCurrentPositionBlocksUpwards(w, j, x, i, sbb);
                this.func_175808_b(w, b.getDefaultState(), j, -1, i, sbb);
            }
        }
    }
}
