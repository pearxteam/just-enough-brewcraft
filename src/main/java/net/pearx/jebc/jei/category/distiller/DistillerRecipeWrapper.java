/*
 * This file is part of Just Enough BrewCraft.
 *
 * Just Enough BrewCraft is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Just Enough BrewCraft is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Just Enough BrewCraft.  If not, see <https://www.gnu.org/licenses/>.
 */

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
