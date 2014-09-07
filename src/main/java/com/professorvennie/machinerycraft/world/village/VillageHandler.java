package com.professorvennie.machinerycraft.world.village;

import com.professorvennie.machinerycraft.lib.Reference;
import cpw.mods.fml.common.registry.VillagerRegistry;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.structure.MapGenStructureIO;

/**
 * Created by ProfessorVennie on 8/16/2014 at 2:33 PM.
 */
public class VillageHandler {

    private VillageHandler(){}

    public static void init(){
        VillagerRegistry.instance().registerVillagerId(78906);
        VillagerRegistry.instance().registerVillagerSkin(78906, new ResourceLocation(Reference.MOD_ID, "textures/entitys/machinerycraft_Villager.png"));
        VillagerRegistry.instance().registerVillageTradeHandler(78906, new VillageTrades());
        VillagerRegistry.instance().registerVillageCreationHandler(new VillageWorkShopHandler());
        MapGenStructureIO.func_143031_a(ComponentWorkShop.class, Reference.MOD_ID + ":WorkshopStructure");
    }
}
