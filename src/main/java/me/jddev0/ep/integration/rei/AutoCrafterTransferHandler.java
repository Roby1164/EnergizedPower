package me.jddev0.ep.integration.rei;

import me.jddev0.ep.networking.ModMessages;
import me.jddev0.ep.networking.packet.SetAutoCrafterPatternInputSlotsC2SPacket;
import me.jddev0.ep.screen.AutoCrafterMenu;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.transfer.TransferHandler;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.entry.EntryStack;
import me.shedaniel.rei.api.common.entry.type.VanillaEntryTypes;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingRecipe;

import java.util.ArrayList;
import java.util.List;

public class AutoCrafterTransferHandler implements TransferHandler {
    @Override
    public Result handle(Context context) {
        if(!(context.getMenu() instanceof AutoCrafterMenu container))
            return Result.createNotApplicable();

        Display display = context.getDisplay();
        Object origin = DisplayRegistry.getInstance().getDisplayOrigin(display);
        if(!(origin instanceof CraftingRecipe recipe))
            return Result.createNotApplicable();

        if(!recipe.canCraftInDimensions(3, 3))
            return Result.createFailed(Component.translatable("recipes.energizedpower.transfer.too_large"));

        if(!context.isActuallyCrafting())
            return Result.createSuccessful().blocksFurtherHandling();

        List<ItemStack> itemStacks = new ArrayList<>(9);

        List<EntryIngredient> inputSlots = display.getInputEntries();
        int len = Math.min(inputSlots.size(), 9);
        for(int i = 0;i < len;i++) {
            EntryStack<?> entryStack = inputSlots.get(i).stream().findAny().orElse(EntryStacks.of(ItemStack.EMPTY));
            if(entryStack.getType() != VanillaEntryTypes.ITEM)
                return Result.createNotApplicable();

            itemStacks.add(entryStack.castValue());

            if((recipe.canCraftInDimensions(1, 2) || recipe.canCraftInDimensions(1, 3))) {
                //1xX recipe: Add 2nd and 3rd column items
                itemStacks.add(ItemStack.EMPTY);
                itemStacks.add(ItemStack.EMPTY);
            }else if((recipe.canCraftInDimensions(2, 2) || recipe.canCraftInDimensions(2, 3)) && i % 2 == 1) {
                //2xX recipe: Add 3rd column item
                itemStacks.add(ItemStack.EMPTY);
            }
        }

        ModMessages.sendToServer(new SetAutoCrafterPatternInputSlotsC2SPacket(container.getBlockEntity().getBlockPos(), itemStacks));

        return Result.createSuccessful().blocksFurtherHandling();
    }
}
