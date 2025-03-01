package me.jddev0.ep.screen;

import me.jddev0.ep.EnergizedPowerMod;
import me.jddev0.ep.networking.ModMessages;
import me.jddev0.ep.networking.packet.SetAutoCrafterCheckboxC2SPacket;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@OnlyIn(Dist.CLIENT)
public class AutoCrafterScreen extends AbstractGenericEnergyStorageContainerScreen<AutoCrafterMenu> {
    public AutoCrafterScreen(AutoCrafterMenu menu, Inventory inventory, Component component) {
        super(menu, inventory, component,
                "tooltip.energizedpower.recipe.energy_required_to_finish.txt",
                new ResourceLocation(EnergizedPowerMod.MODID, "textures/gui/container/auto_crafter.png"),
                8, 17);

        imageHeight = 206;
        inventoryLabelY = imageHeight - 94;
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int mouseButton) {
        if(mouseButton == 0) {
            boolean clicked = false;
            if(isHovering(158, 16, 11, 11, mouseX, mouseY)) {
                //Ignore NBT checkbox

                ModMessages.sendToServer(new SetAutoCrafterCheckboxC2SPacket(menu.getBlockEntity().getBlockPos(), 0, !menu.isIgnoreNBT()));
                clicked = true;
            }else if(isHovering(158, 38, 11, 11, mouseX, mouseY)) {
                //Extract mode checkbox

                ModMessages.sendToServer(new SetAutoCrafterCheckboxC2SPacket(menu.getBlockEntity().getBlockPos(), 1, !menu.isSecondaryExtractMode()));
                clicked = true;
            }

            if(clicked)
                minecraft.getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.UI_BUTTON_CLICK, 1.f));
        }

        return super.mouseClicked(mouseX, mouseY, mouseButton);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        super.renderBg(guiGraphics, partialTick, mouseX, mouseY);

        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        renderProgressArrow(guiGraphics, x, y);
        renderCheckboxes(guiGraphics, x, y, mouseX, mouseY);
    }

    private void renderProgressArrow(GuiGraphics guiGraphics, int x, int y) {
        if(menu.isCraftingActive())
            guiGraphics.blit(TEXTURE, x + 89, y + 34, 176, 53, menu.getScaledProgressArrowSize(), 17);
    }

    private void renderCheckboxes(GuiGraphics guiGraphics, int x, int y, int mouseX, int mouseY) {
        if(menu.isIgnoreNBT()) {
            //Ignore NBT checkbox

            guiGraphics.blit(TEXTURE, x + 158, y + 16, 176, 70, 11, 11);
        }

        if(menu.isSecondaryExtractMode()) {
            //Extract mode checkbox [2]

            guiGraphics.blit(TEXTURE, x + 158, y + 38, 187, 81, 11, 11);
        }else {
            //Extract mode checkbox [1]

            guiGraphics.blit(TEXTURE, x + 158, y + 38, 176, 81, 11, 11);
        }
    }

    @Override
    protected void renderTooltip(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        super.renderTooltip(guiGraphics, mouseX, mouseY);

        if(isHovering(158, 16, 11, 11, mouseX, mouseY)) {
            //Ignore NBT checkbox

            List<Component> components = new ArrayList<>(2);
            components.add(Component.translatable("tooltip.energizedpower.auto_crafter.cbx.ignore_nbt"));

            guiGraphics.renderTooltip(font, components, Optional.empty(), mouseX, mouseY);
        }else if(isHovering(158, 38, 11, 11, mouseX, mouseY)) {
            //Extract mode

            List<Component> components = new ArrayList<>(2);
            components.add(Component.translatable("tooltip.energizedpower.auto_crafter.cbx.extract_mode." + (menu.isSecondaryExtractMode()?"2":"1")));

            guiGraphics.renderTooltip(font, components, Optional.empty(), mouseX, mouseY);
        }
    }
}
