/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.core.world.village;

import com.professorvennie.core.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureVillagePieces;
import net.minecraft.world.gen.structure.StructureVillagePieces.*;

import java.util.List;
import java.util.Random;

public class ComponentWorkShop extends StructureVillagePieces.House1{

    private int averageGroundLevel = -1;

    public ComponentWorkShop(){

    }

    public ComponentWorkShop(Start villagePiece, int par2, Random random, StructureBoundingBox structureBoundingBox, int par5){
        super();
        this.coordBaseMode = par5;
        this.boundingBox = structureBoundingBox;
    }

    public static ComponentWorkShop buildComponet(Start villagePiece, List pieces, Random random,int p1, int p2, int p3, int p4, int p5){
        StructureBoundingBox structureBoundingBox = StructureBoundingBox.getComponentToAddBoundingBox(p1, p2, p3, 0, 0, 0, 7, 6, 7, p4);
        return canVillageGoDeeper(structureBoundingBox) && StructureComponent.findIntersecting(pieces, structureBoundingBox) == null ? new ComponentWorkShop(villagePiece, p5, random, structureBoundingBox, p4) : null;
    }
    private StructureBoundingBox sbb;
    private World w;


    public boolean addComponentParts(World world, Random random, StructureBoundingBox sbb){
        this.sbb = sbb;
        this.w = world;
        if(this.averageGroundLevel < 0){
            this.averageGroundLevel = this.getAverageGroundLevel(world, sbb);
            if(this.averageGroundLevel < 0){
                return true;
            }
            this.boundingBox.offset(0, this.averageGroundLevel - this.boundingBox.maxY + 4, 0);
        }

        this.fill(0, 0, 0, 8, 1, 6, Blocks.cobblestone);//Base
        this.fill(1, 0, 1, 8, 1, 8, Blocks.cobblestone);
        this.fill(0, 0, 2, 8, 1, 9, Blocks.cobblestone);

        for(int w = 0; w < 9; w++){
            for(int w1 = 0; w1 < 10; w1++){
                this.placeBlockAtCurrentPosition(world, ModBlocks.plasticPlanks, 0, w, 3, w1, sbb);//Roof
                this.placeBlockAtCurrentPosition(world, ModBlocks.plasticLog, 0, w, 4, w1, sbb);
                this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, w, 5, 0, sbb);
                this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, w, 5, 9, sbb);
                this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 0, 5, w1, sbb);
                this.placeBlockAtCurrentPosition(world, Blocks.fence, 0, 8, 5, w1, sbb);
            }
        }
        this.placeBlockAtCurrentPosition(world, ModBlocks.windmillground, 0, 3, 5, 4, sbb);
        this.placeBlockAtCurrentPosition(world, ModBlocks.windmillground, 0, 3, 5, 5, sbb);
        this.placeBlockAtCurrentPosition(world, ModBlocks.windmillground, 0, 3, 5, 6, sbb);
        this.placeBlockAtCurrentPosition(world, ModBlocks.windmillground, 0, 4, 5, 4, sbb);
        this.placeBlockAtCurrentPosition(world, ModBlocks.windmillground, 0, 4, 5, 5, sbb);
        this.placeBlockAtCurrentPosition(world, ModBlocks.windmillground, 0, 4, 5, 6, sbb);
        this.placeBlockAtCurrentPosition(world, ModBlocks.windmillground, 0, 5, 5, 4, sbb);
        this.placeBlockAtCurrentPosition(world, ModBlocks.windmillground, 0, 5, 5, 5, sbb);
        this.placeBlockAtCurrentPosition(world, ModBlocks.windmillground, 0, 5, 5, 6, sbb);

        for(int y1 = 0; y1 < 7; y1++) {
            this.placeBlockAtCurrentPosition(world, ModBlocks.windmill, (y1+1) == 7?(y1+1+8):(y1+1), 4, 5+y1+1, 5, sbb);
        }

        for(int a = 0; a < 8; a++){
            for(int a1 = 0; a1 < 7; a1++){
                for(int a3 = 0; a3 < 3; a3++){
                    this.placeBlockAtCurrentPosition(world, Blocks.air, 0, a1 + 1, a3, a + 1, sbb);
                    this.placeBlockAtCurrentPosition(world, Blocks.air, 0, a1 + 1, a3 + 1, a + 1, sbb);
                    this.placeBlockAtCurrentPosition(world, ModBlocks.plasticPlanks, 0, a1 + 1, a3 + 2, a + 1, sbb);
                }
            }
        }



        this.fill(0, 0, 0, 8, 0, 8, ModBlocks.plasticPlanks);
        this.placeBlockAtCurrentPosition(world, ModBlocks.plasticLog, 0, 0, 1, 0, sbb);
        this.placeBlockAtCurrentPosition(world, ModBlocks.plasticLog, 0, 0, 2, 0, sbb);
        this.placeBlockAtCurrentPosition(world, ModBlocks.plasticLog, 0, 0, 3, 0, sbb);

        this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 1, 2, 0, sbb);//Front
        this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 2, 2, 0, sbb);
        this.placeBlockAtCurrentPosition(world, ModBlocks.plasticLog, 0, 3, 2, 0, sbb);
        this.placeBlockAtCurrentPosition(world, ModBlocks.plasticLog, 0, 3, 3, 0, sbb);
        this.placeBlockAtCurrentPosition(world, ModBlocks.plasticLog, 0, 4, 3, 0, sbb);
        this.placeDoorAtCurrentPosition(world, sbb, random, 4, 1, 0, this.getMetadataWithOffset(Blocks.wooden_door, 1));
        this.placeBlockAtCurrentPosition(world, ModBlocks.plasticLog, 0, 5, 2, 0, sbb);
        this.placeBlockAtCurrentPosition(world, ModBlocks.plasticLog, 0, 5, 3, 0, sbb);
        this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 6, 2, 0, sbb);
        this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 7, 2, 0, sbb);

        this.placeBlockAtCurrentPosition(world, ModBlocks.plasticLog, 0, 8, 1, 0, sbb);//Left
        this.placeBlockAtCurrentPosition(world, ModBlocks.plasticLog, 0, 8, 2, 0, sbb);
        this.placeBlockAtCurrentPosition(world, ModBlocks.plasticLog, 0, 8, 3, 0, sbb);

        for(int l = 0; l < 8; l++)
            this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 8, 2, l + 1, sbb);

        for(int k = 0; k < 8; k++)
            this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 0, 2, k + 1, sbb);//Right

        for(int b = 0; b < 8; b++)
            this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, b, 2, 9, sbb);//Back

        this.placeBlockAtCurrentPosition(world, ModBlocks.plasticLog, 0, 0, 1, 9, sbb);//Right back
        this.placeBlockAtCurrentPosition(world, ModBlocks.plasticLog, 0, 0, 2, 9, sbb);
        this.placeBlockAtCurrentPosition(world, ModBlocks.plasticLog, 0, 0, 3, 9, sbb);

        this.placeBlockAtCurrentPosition(world, ModBlocks.plasticLog, 0, 8, 1, 9, sbb);//Left back
        this.placeBlockAtCurrentPosition(world, ModBlocks.plasticLog, 0, 8, 2, 9, sbb);
        this.placeBlockAtCurrentPosition(world, ModBlocks.plasticLog, 0, 8, 3, 9, sbb);

        this.placeBlockAtCurrentPosition(world, Blocks.lit_redstone_lamp, 0, 2, 0, 2, sbb);
        this.placeBlockAtCurrentPosition(world, Blocks.redstone_torch, 0, 2, -1, 2, sbb);


        this.placeBlockAtCurrentPosition(world, Blocks.crafting_table, 0, 7, 1, 1, sbb);
        this.placeBlockAtCurrentPosition(world, ModBlocks.plasticChest, 0, 1, 1, 1, sbb);

        this.placeBlockAtCurrentPosition(world, Blocks.lit_redstone_lamp, 0, 4, 0, 4, sbb);
        this.placeBlockAtCurrentPosition(world, Blocks.lit_redstone_lamp, 0, 4, 0, 5, sbb);
        this.placeBlockAtCurrentPosition(world, Blocks.redstone_torch, 0, 4, -1, 5, sbb);
        this.placeBlockAtCurrentPosition(world, Blocks.redstone_torch, 0, 4, -1, 5, sbb);


        this.placeBlockAtCurrentPosition(world, Blocks.lit_redstone_lamp, 0, 6, 0, 7, sbb);
        this.placeBlockAtCurrentPosition(world, Blocks.redstone_torch, 0, 6, -1, 7, sbb);

        this.placeBlockAtCurrentPosition(world, Blocks.lit_redstone_lamp, 0, 2, 0, 7, sbb);
        this.placeBlockAtCurrentPosition(world, Blocks.redstone_torch, 0, 2, -1, 7, sbb);

        this.placeBlockAtCurrentPosition(world, Blocks.lit_redstone_lamp, 0, 6, 0, 2, sbb);
        this.placeBlockAtCurrentPosition(world, Blocks.redstone_torch, 0, 6, -1, 2, sbb);

        this.placeBlockAtCurrentPosition(world, ModBlocks.plasticLog, 0, 7, 1, 8, sbb);
        this.placeBlockAtCurrentPosition(world, ModBlocks.plasticLeaf, 0, 7, 2, 8, sbb);

        this.placeBlockAtCurrentPosition(world, ModBlocks.plasticPlanks, 0, 4 ,2, 9, sbb);

        this.placeBlockAtCurrentPosition(world, ModBlocks.copperFurnaceIdle, 0, 3 ,1, 8, sbb);
        this.placeBlockAtCurrentPosition(world, ModBlocks.copperGrinderIdle, 0, 5 ,1, 8, sbb);

        int i = this.getMetadataWithOffset(Blocks.ladder, 3);
        this.placeBlockAtCurrentPosition(world, Blocks.ladder, i, 4 ,1, 8, sbb);
        this.placeBlockAtCurrentPosition(world, Blocks.ladder, i, 4 ,2, 8, sbb);
        this.placeBlockAtCurrentPosition(world, Blocks.ladder, i, 4 ,3, 8, sbb);
        this.placeBlockAtCurrentPosition(world, Blocks.ladder, i, 4 ,4, 8, sbb);

        this.spawnVillagers(world, sbb, 3, 1, 3,1);
        return true;
    }

    @Override
    protected int getVillagerType(int p_74888_1_) {
        return 78906;
    }
    private void fill(int x, int y, int z, int x1, int y1, int z1, Block b){
        this.fillWithBlocks(w, sbb, x, y, z, x1, y1, z1, b, b, false);
    }
}
