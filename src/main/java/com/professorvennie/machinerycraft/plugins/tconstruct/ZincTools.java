package com.professorvennie.machinerycraft.plugins.tconstruct;

import com.professorvennie.lib.utils.RegistryUtils;
import net.minecraft.item.Item;

public class ZincTools {

    public static final int SALT_ID = 250;
    public static ZincPart arrowhead;
    public static ZincPart axe_Head;
    public static ZincPart battle_Sign_Head;
    public static ZincPart binding;
    public static ZincPart broad_axe_head;
    public static ZincPart chisel_head;
    public static ZincPart chunk;
    public static ZincPart crossbar;
    public static ZincPart excavator_head;
    public static ZincPart frypan_head;
    public static ZincPart full_gaurd;
    public static ZincPart hammer_head;
    public static ZincPart hand_guard;
    public static ZincPart knife_blade;
    public static ZincPart large_guard;
    public static ZincPart large_sword_blade;
    public static ZincPart large_plate;
    public static ZincPart pickaxe_head;
    public static ZincPart scthe_head;
    public static ZincPart shovel_head;
    public static ZincPart sword_blade;
    public static ZincPart tool_rod;
    public static ZincPart tough_binding;
    public static ZincPart tough_rod;

    public static void preInit() {
//        arrowhead = (SaltPart) new SaltPart().setUnlocalizedName("zinc.arrow.head");
//        axe_Head = (SaltPart) new SaltPart().setUnlocalizedName("zinc.arrow.head");
//        battle_Sign_Head = (SaltPart) new SaltPart().setUnlocalizedName("zinc.arrow.head");
//        binding = (SaltPart) new SaltPart().setUnlocalizedName("zinc.arrow.head");
//        broad_axe_head = (SaltPart) new SaltPart().setUnlocalizedName("zinc.arrow.head");
//        chisel_head = (SaltPart) new SaltPart().setUnlocalizedName("zinc.arrow.head");
//        chunk = (SaltPart) new SaltPart().setUnlocalizedName("zinc.arrow.head");
//        excavator_head = (SaltPart) new SaltPart().setUnlocalizedName("zinc.arrow.head");
//        frypan_head = (SaltPart) new SaltPart().setUnlocalizedName("zinc.arrow.head");
//        full_gaurd = (SaltPart) new SaltPart().setUnlocalizedName("zinc.arrow.head");
//        hammer_head = (SaltPart) new SaltPart().setUnlocalizedName("zinc.arrow.head");
//        hand_guard = (SaltPart) new SaltPart().setUnlocalizedName("zinc.arrow.head");
//        knife_blade = (SaltPart) new SaltPart().setUnlocalizedName("zinc.arrow.head");
//        large_guard = (SaltPart) new SaltPart().setUnlocalizedName("zinc.arrow.head");
//        large_sword_blade = (SaltPart) new SaltPart().setUnlocalizedName("zinc.arrow.head");
//        large_plate = (SaltPart) new SaltPart().setUnlocalizedName("zinc.arrow.head");
//        pickaxe_head = (SaltPart) new SaltPart().setUnlocalizedName("zinc.arrow.head");
//        scthe_head = (SaltPart) new SaltPart().setUnlocalizedName("zinc.arrow.head");
//        shovel_head = (SaltPart) new SaltPart().setUnlocalizedName("zinc.arrow.head");
//        sword_blade = (SaltPart) new SaltPart().setUnlocalizedName("zinc.arrow.head");
//        tool_rod = (SaltPart) new SaltPart().setUnlocalizedName("zinc.arrow.head");
//        tough_binding = (SaltPart) new SaltPart().setUnlocalizedName("zinc.arrow.head");
//        tough_rod = (SaltPart) new SaltPart().setUnlocalizedName("zinc.arrow.head");
//        registerItems(new Item[] {arrowhead, axe_Head, battle_Sign_Head, binding, broad_axe_head, chisel_head, chunk, excavator_head, frypan_head, full_gaurd, hammer_head, hand_guard, knife_blade, large_guard, large_sword_blade, large_plate, pickaxe_head, scthe_head, shovel_head, sword_blade, tool_rod, tough_binding, tough_rod});
    }

    public static void registerItems(Item[] items) {
        for (Item item : items) {
            RegistryUtils.registerItem(item);
        }
    }

    public static void postInit() {
        //addCastings(SALT_ID, new FluidStack(ModFuilds.saltFluid, 100), 80);

        //addTools();

//        TConstructRegistry.addToolMaterial(SALT_ID, "Salt", 2, 450, 500, 1,.5F, 1, 0.1F, "", "");
//        TConstructClientRegistry.addMaterialRenderMapping(SALT_ID, Reference.MOD_ID, "zinc", true);
//        TConstructRegistry.addBowMaterial(SALT_ID, 450, 25, 0.55F);
//        TConstructRegistry.addArrowMaterial(SALT_ID, 2.3F, 1.0F, 80.0F);
    }

    public static void addCastings(int id, /*FluidStack fluid,*/ int delay) {
//        PluginTConstruct.addPartCasting(new ItemStack(tool_rod, 1, id), TConstructRegistry.getItemStack("toolRodCast"), fluid, delay);
//        PluginTConstruct.addPartCasting(new ItemStack(pickaxe_head, 1, id), TConstructRegistry.getItemStack("pickaxeHeadCast"), fluid, delay);
//        PluginTConstruct.addPartCasting(new ItemStack(shovel_head, 1, id), TConstructRegistry.getItemStack("shovelHeadCast"), fluid, delay);
//        PluginTConstruct.addPartCasting(new ItemStack(axe_Head, 1, id), TConstructRegistry.getItemStack("hatchetHeadCast"), fluid, delay);
//        PluginTConstruct.addPartCasting(new ItemStack(sword_blade, 1, id), TConstructRegistry.getItemStack("swordBladeCast"), fluid, delay);
//        PluginTConstruct.addPartCasting(new ItemStack(large_guard, 1, id), TConstructRegistry.getItemStack("wideGuardCast"), fluid, delay);
//        PluginTConstruct.addPartCasting(new ItemStack(hand_guard, 1, id), TConstructRegistry.getItemStack("handGuardCast"), fluid, delay);
//        PluginTConstruct.addPartCasting(new ItemStack(crossbar, 1, id), TConstructRegistry.getItemStack("crossBarCast"), fluid, delay);
//        PluginTConstruct.addPartCasting(new ItemStack(binding, 1, id), TConstructRegistry.getItemStack("bindingCast"), fluid, delay);
//        PluginTConstruct.addPartCasting(new ItemStack(frypan_head, 1, id), TConstructRegistry.getItemStack("frypanHeadCast"), fluid, delay);
//        PluginTConstruct.addPartCasting(new ItemStack(battle_Sign_Head, 1, id), TConstructRegistry.getItemStack("signHeadCast"), fluid, delay);
//        PluginTConstruct.addPartCasting(new ItemStack(knife_blade, 1, id), TConstructRegistry.getItemStack("knifeBladeCast"), fluid, delay);
//        PluginTConstruct.addPartCasting(new ItemStack(chisel_head, 1, id), TConstructRegistry.getItemStack("chiselHeadCast"), fluid, delay);
//        PluginTConstruct.addPartCasting(new ItemStack(tough_rod, 1, id), TConstructRegistry.getItemStack("toughRodCast"), fluid, delay);
//        PluginTConstruct.addPartCasting(new ItemStack(tough_binding, 1, id), TConstructRegistry.getItemStack("toughBindingCast"), fluid, delay);
//        PluginTConstruct.addPartCasting(new ItemStack(large_plate, 1, id), TConstructRegistry.getItemStack("largePlateCast"), fluid, delay);
//        PluginTConstruct.addPartCasting(new ItemStack(broad_axe_head, 1, id), TConstructRegistry.getItemStack("broadAxeHeadCast"), fluid, delay);
//        PluginTConstruct.addPartCasting(new ItemStack(scthe_head, 1, id), TConstructRegistry.getItemStack("scytheHeadCast"), fluid, delay);
//        PluginTConstruct.addPartCasting(new ItemStack(excavator_head, 1, id), TConstructRegistry.getItemStack("excavatorHeadCast"), fluid, delay);
//        PluginTConstruct.addPartCasting(new ItemStack(large_sword_blade, 1, id), TConstructRegistry.getItemStack("largeBladeCast"), fluid, delay);
//        PluginTConstruct.addPartCasting(new ItemStack(hammer_head, 1, id), TConstructRegistry.getItemStack("hammerHeadCast"), fluid, delay);
//        PluginTConstruct.addPartCasting(new ItemStack(full_gaurd, 1, id), TConstructRegistry.getItemStack("fullGuardCast"), fluid, delay);
//        PluginTConstruct.addPartCasting(new ItemStack(arrowhead, 1, id), new ItemStack(TConstructRegistry.getItem("metalPattern"), 1, 25), fluid, delay);
    }

    public static void addTools() {
//        TConstructRegistry.addToolRecipe((ToolCore) TConstructRegistry.getItem("arrow"), new Item[] { arrowhead, tool_rod, TConstructRegistry.getItem("fletching") });
//        TConstructRegistry.addToolRecipe((ToolCore) TConstructRegistry.getItem("battleaxe"), new Item[] { broad_axe_head, tough_rod, broad_axe_head, tough_binding });
//        TConstructRegistry.addToolRecipe((ToolCore) TConstructRegistry.getItem("battlesign"), new Item[] { battle_Sign_Head, tool_rod });
//        TConstructRegistry.addToolRecipe((ToolCore) TConstructRegistry.getItem("broadsword"), new Item[] { sword_blade, tool_rod, large_guard });
//        TConstructRegistry.addToolRecipe((ToolCore) TConstructRegistry.getItem("chisel"), new Item[] { chisel_head, tool_rod });
//        TConstructRegistry.addToolRecipe((ToolCore) TConstructRegistry.getItem("cleaver"), new Item[] { large_sword_blade, tough_rod, large_plate, tough_rod });
//        TConstructRegistry.addToolRecipe((ToolCore) TConstructRegistry.getItem("cutlass"), new Item[] { sword_blade, tool_rod, full_gaurd });
//        TConstructRegistry.addToolRecipe((ToolCore) TConstructRegistry.getItem("dagger"), new Item[] { knife_blade, tool_rod, crossbar });
//        TConstructRegistry.addToolRecipe((ToolCore) TConstructRegistry.getItem("excavator"), new Item[] { excavator_head, tough_rod, large_plate, tough_binding });
//        TConstructRegistry.addToolRecipe((ToolCore) TConstructRegistry.getItem("frypan"), new Item[] { frypan_head, tool_rod });
//        TConstructRegistry.addToolRecipe((ToolCore) TConstructRegistry.getItem("hammer"), new Item[] { hammer_head, tough_rod, large_plate, large_plate });
//        TConstructRegistry.addToolRecipe((ToolCore) TConstructRegistry.getItem("hatchet"), new Item[] { axe_Head, tool_rod });
//        TConstructRegistry.addToolRecipe((ToolCore) TConstructRegistry.getItem("longsword"), new Item[] { sword_blade, tool_rod, hand_guard });
//        TConstructRegistry.addToolRecipe((ToolCore) TConstructRegistry.getItem("lumberaxe"), new Item[] { broad_axe_head, tough_rod, large_plate, tough_binding });
//        TConstructRegistry.addToolRecipe((ToolCore) TConstructRegistry.getItem("mattock"), new Item[] { axe_Head, tool_rod, shovel_head });
//        TConstructRegistry.addToolRecipe((ToolCore) TConstructRegistry.getItem("pickaxe"), new Item[] { pickaxe_head, tool_rod, binding });
//        TConstructRegistry.addToolRecipe((ToolCore) TConstructRegistry.getItem("rapier"), new Item[] { sword_blade, tool_rod, crossbar });
//        TConstructRegistry.addToolRecipe((ToolCore) TConstructRegistry.getItem("scythe"), new Item[] { scthe_head, tough_rod, tough_binding, tough_rod });
//        TConstructRegistry.addToolRecipe((ToolCore) TConstructRegistry.getItem("shortbow"), new Item[] { tool_rod, TConstructRegistry.getItem("bowstring"), tool_rod });
//        TConstructRegistry.addToolRecipe((ToolCore) TConstructRegistry.getItem("shortbow"), new Item[] { TConstructRegistry.getItem("toolRod"), TConstructRegistry.getItem("bowstring"), tool_rod });
//        TConstructRegistry.addToolRecipe((ToolCore) TConstructRegistry.getItem("shortbow"), new Item[] { tool_rod, TConstructRegistry.getItem("bowstring"), TConstructRegistry.getItem("toolRod") });
//        TConstructRegistry.addToolRecipe((ToolCore) TConstructRegistry.getItem("shovel"), new Item[] { shovel_head, tool_rod });
    }
}

