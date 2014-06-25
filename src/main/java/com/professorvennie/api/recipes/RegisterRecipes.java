package com.professorvennie.api.recipes;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
public class RegisterRecipes {
	
	public static void addGrinding(Item input, ItemStack output, float xp){
		GrinderRecipes.grinding().addRecipe(input, output, xp);
    }

}
