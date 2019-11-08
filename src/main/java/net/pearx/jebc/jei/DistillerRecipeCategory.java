package net.pearx.jebc.jei;

import com.pam.brewcraft.blocks.BlockRegistry;
import com.pam.brewcraft.gui.ContainerDistiller;
import com.pam.brewcraft.gui.GuiDistiller;
import com.pam.brewcraft.item.DistillerRecipes;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.IIngredientType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.pearx.jebc.Jebc;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SideOnly(Side.CLIENT)
public class DistillerRecipeCategory extends JebcRecipeCategory<DistillerRecipeWrapper> {
    public DistillerRecipeCategory(IGuiHelper helper) {
        super("jehc.distiller", new ItemStack(BlockRegistry.distillerItemBlock), helper.drawableBuilder(new ResourceLocation("brewcraft", "textures/gui/distiller.png"), 33, 16, 123, 54).build());
    }

    @SuppressWarnings("unchecked")
    @Override
    public void setupRecipes(IModRegistry registry) {
        registry.addRecipeClickArea(GuiDistiller.class, 79, 33, 24, 19, getUid());
        registry.getRecipeTransferRegistry().addRecipeTransferHandler(ContainerDistiller.class, getUid(), 0, 3, 5, 36);
        List<DistillerRecipeWrapper> rec = new ArrayList<>();
        try {
            for (Map.Entry<ItemStack, ItemStack[]> entr : ((Map<ItemStack, ItemStack[]>) FieldUtils.readStaticField(DistillerRecipes.class, "distillingList", true)).entrySet()) {
                rec.add(new DistillerRecipeWrapper(entr.getKey(), entr.getValue()));
            }
        }
        catch (IllegalAccessException e) {
            Jebc.INSTANCE.getLog().error("An IllegalAccessException occurred while setting up the " + DistillerRecipes.class.getSimpleName() + " recipes.", e);
        }
        registry.addRecipes(rec, getUid());
    }

    @Override
    public void setRecipe(IRecipeLayout recipeLayout, DistillerRecipeWrapper recipeWrapper, IIngredients ingredients) {
        List<List<ItemStack>> inputs = ingredients.getInputs(VanillaTypes.ITEM);
        List<List<ItemStack>> outputs = ingredients.getOutputs(VanillaTypes.ITEM);
        recipeLayout.getItemStacks().init(0, true, 22, 0);
        recipeLayout.getItemStacks().set(0, inputs.get(0));
        recipeLayout.getItemStacks().init(1, true, 0, 18);
        recipeLayout.getItemStacks().set(1, inputs.get(1));
        recipeLayout.getItemStacks().init(2, true, 22, 36);
        recipeLayout.getItemStacks().set(2, inputs.get(2));
        recipeLayout.getItemStacks().init(3, false, 83, 19);
        recipeLayout.getItemStacks().set(3, outputs.get(0));
        if (outputs.size() > 1) {
            recipeLayout.getItemStacks().init(4, false, 102, 19);
            recipeLayout.getItemStacks().set(4, outputs.get(1));
        }
    }
}