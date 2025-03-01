package me.jddev0.ep.integration.jei;

import me.jddev0.ep.EnergizedPowerMod;
import me.jddev0.ep.block.ModBlocks;
import me.jddev0.ep.recipe.PlantGrowthChamberFertilizerRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class PlantGrowthChamberFertilizerCategory implements IRecipeCategory<PlantGrowthChamberFertilizerRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(EnergizedPowerMod.MODID, "plant_growth_chamber_fertilizer");
    public static final RecipeType<PlantGrowthChamberFertilizerRecipe> TYPE = new RecipeType<>(UID, PlantGrowthChamberFertilizerRecipe.class);

    private final IDrawable background;
    private final IDrawable fertlizerSlot;
    private final IDrawable icon;

    public PlantGrowthChamberFertilizerCategory(IGuiHelper helper) {
        ResourceLocation texture = new ResourceLocation(EnergizedPowerMod.MODID, "textures/gui/container/plant_growth_chamber.png");
        fertlizerSlot = helper.createDrawable(texture, 34, 34, 18, 18);
        background = helper.createBlankDrawable(144, 30);

        icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.PLANT_GROWTH_CHAMBER_ITEM.get()));
    }

    @Override
    public RecipeType<PlantGrowthChamberFertilizerRecipe> getRecipeType() {
        return TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("recipes.energizedpower.plant_growth_chamber_fertilizer");
    }

    @Override
    public IDrawable getBackground() {
        return background;
    }

    @Override
    public IDrawable getIcon() {
        return icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder iRecipeLayoutBuilder, PlantGrowthChamberFertilizerRecipe recipe, IFocusGroup iFocusGroup) {
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 1, 1).addIngredients(recipe.getInput());
    }

    @Override
    public void draw(PlantGrowthChamberFertilizerRecipe recipe, IRecipeSlotsView iRecipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        fertlizerSlot.draw(guiGraphics, 0, 0);

        Font font = Minecraft.getInstance().font;
        Component component = Component.translatable("recipes.energizedpower.plant_growth_chamber_fertilizer.speed_multiplier", recipe.getSpeedMultiplier());
        int textWidth = font.width(component);

        guiGraphics.drawString(Minecraft.getInstance().font, component, 144 - textWidth, 5, 0xFFFFFFFF, false);

        component = Component.translatable("recipes.energizedpower.plant_growth_chamber_fertilizer.energy_consumption_multiplier", recipe.getEnergyConsumptionMultiplier());
        textWidth = font.width(component);

        guiGraphics.drawString(Minecraft.getInstance().font, component, 144 - textWidth, 22, 0xFFFFFFFF, false);
    }
}
