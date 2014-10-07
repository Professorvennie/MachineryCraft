package com.professorvennie.machinerycraft.api.recipes;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Created by ProfessorVennie on 10/6/2014 at 6:58 PM.
 */
public class AlloyRecipe {

    private ItemStack[] recipe;
    private ItemStack output;

    public AlloyRecipe(ItemStack[] recipe, ItemStack output) {
        this.recipe = recipe;
        this.output = output;
    }

    public boolean doesRecipeMatch(ItemStack[] items) {
        ItemStack[] recipe = new ItemStack[2];
        if (items.length < 2) {
            return false;
        }

        if (this.recipe.length != 2) {
            ItemStack[] newRecipe = new ItemStack[2];
            for (int i = 0; i < 2; i++) {
                if (i + 1 > this.recipe.length) {
                    newRecipe[i] = null;
                } else {
                    newRecipe[i] = this.recipe[i];
                }
            }
            recipe = newRecipe;
        } else {
            recipe = this.recipe;
        }
        boolean[] checkList = new boolean[2];
        for (int i = 0; i < 2; i++) {
            checkList[i] = false;
        }
        for (int i = 0; i < 2; i++) {
            ItemStack recipeItemStack = recipe[i];
            if (recipeItemStack == null) {
                continue;
            }
            boolean test = false;
            for (int j = 0; j < 2; j++) {
                if (checkList[j]) {
                    continue;
                }
                ItemStack checked = items[j];
                if (checked == null) {
                    continue;
                }
                boolean quickTest = false;
                if (recipeItemStack.getItem() instanceof ItemBlock) {
                    if (checked.getItem() instanceof ItemBlock) {
                        quickTest = true;
                    }
                } else if (!(checked.getItem() instanceof ItemBlock)) {
                    quickTest = true;
                }
                if (!quickTest) {
                    continue;
                }
                if ((checked.getItemDamage() == recipeItemStack.getItemDamage() || OreDictionary.WILDCARD_VALUE == recipeItemStack.getItemDamage()) && checked.getItem() == recipeItemStack.getItem()) {
                    test = true;
                    checkList[j] = true;
                    break;
                }
            }
            if (!test) {
                return false;
            }
        }
        return true;
    }

    public ItemStack getOutput() {
        return output;
    }

    public ItemStack[] getRecipe() {
        return recipe;
    }
}
