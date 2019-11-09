package net.pearx.jebc.jei.category.distiller;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DistillerRecipeWrapper implements IRecipeWrapper {
    private final ItemStack in;
    private final ItemStack[] out;

    public DistillerRecipeWrapper(ItemStack in, ItemStack[] out) {
        this.in = in;
        this.out = out;
    }

    @Override
    public void getIngredients(IIngredients ingredients) {
        ItemStack bottle = new ItemStack(Items.GLASS_BOTTLE);
        ingredients.setInputs(VanillaTypes.ITEM, Arrays.asList(in, bottle, bottle));
        List<ItemStack> outputs = new ArrayList<>();
        for (ItemStack st : out) {
            if (st != null)
                outputs.add(st);
        }
        ingredients.setOutputs(VanillaTypes.ITEM, outputs);
    }
}
