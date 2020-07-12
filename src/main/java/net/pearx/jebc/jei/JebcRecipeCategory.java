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

package net.pearx.jebc.jei;

import com.pam.brewcraft.Reference;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;

public abstract class JebcRecipeCategory<T extends IRecipeWrapper> implements IRecipeCategory<T> {
    private String uid;
    private IDrawable background;
    private ItemStack catalyst;

    public JebcRecipeCategory(String uid, ItemStack catalyst, IDrawable background) {
        this.uid = uid;
        this.catalyst = catalyst;
        this.background = background;
    }

    public final void setup(IModRegistry reg) {
        reg.addRecipeCatalyst(catalyst, getUid());
        setupRecipes(reg);
    }

    public abstract void setupRecipes(IModRegistry reg);

    @Override
    public String getUid() {
        return uid;
    }

    @Override
    public String getTitle() {
        return I18n.format(catalyst.getTranslationKey() + ".name");
    }

    @Override
    public String getModName() {
        return Reference.NAME;
    }

    @Override
    public IDrawable getBackground() {
        return background;
    }
}
