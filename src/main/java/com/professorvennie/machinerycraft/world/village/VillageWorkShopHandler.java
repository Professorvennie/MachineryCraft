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

import cpw.mods.fml.common.registry.VillagerRegistry;
import net.minecraft.world.gen.structure.StructureVillagePieces;

import java.util.List;
import java.util.Random;

public class VillageWorkShopHandler  implements VillagerRegistry.IVillageCreationHandler{
    @Override
    public StructureVillagePieces.PieceWeight getVillagePieceWeight(Random random, int i) {
             return new StructureVillagePieces.PieceWeight(ComponentWorkShop.class, 30, i + random.nextInt(4));
    }

    @Override
    public Class<?> getComponentClass() {
        return ComponentWorkShop.class;
    }

    @Override
    public Object buildComponent(StructureVillagePieces.PieceWeight villagePiece, StructureVillagePieces.Start startPiece, List pieces, Random random, int p1, int p2, int p3, int p4, int p5) {
        return ComponentWorkShop.buildComponet(startPiece, pieces, random, p1, p2, p3, p4, p5);
    }
}
