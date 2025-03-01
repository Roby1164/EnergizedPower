package me.jddev0.ep.networking.packet;

import me.jddev0.ep.block.WeatherControllerBlock;
import me.jddev0.ep.block.entity.AutoCrafterBlockEntity;
import me.jddev0.ep.block.entity.WeatherControllerBlockEntity;
import me.jddev0.ep.screen.AutoCrafterMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class SetWeatherFromWeatherControllerC2SPacket {
    private final BlockPos pos;
    private final int weatherType;

    public SetWeatherFromWeatherControllerC2SPacket(BlockPos pos, int weatherType) {
        this.pos = pos;
        this.weatherType = weatherType;
    }

    public SetWeatherFromWeatherControllerC2SPacket(FriendlyByteBuf buffer) {
        pos = buffer.readBlockPos();
        weatherType = buffer.readInt();
    }

    public void toBytes(FriendlyByteBuf buffer) {
        buffer.writeBlockPos(pos);
        buffer.writeInt(weatherType);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            BlockEntity blockEntity = context.getSender().level().getBlockEntity(pos);
            if(!(blockEntity instanceof WeatherControllerBlockEntity weatherControllerBlockEntity))
                return;

            LazyOptional<IEnergyStorage> energyStorageLazyOptional = weatherControllerBlockEntity.getCapability(ForgeCapabilities.ENERGY, null);
            if(!energyStorageLazyOptional.isPresent())
                return;

            IEnergyStorage energyStorage = energyStorageLazyOptional.orElse(null);
            if(energyStorage.getEnergyStored() < WeatherControllerBlockEntity.CAPACITY)
                return;

            weatherControllerBlockEntity.clearEnergy();

            switch(weatherType) {
                //Clear
                case 0 -> context.getSender().serverLevel().setWeatherParameters(WeatherControllerBlock.WEATHER_CHANGED_TICKS, 0, false, false);
                //Rain
                case 1 -> context.getSender().serverLevel().setWeatherParameters(0, WeatherControllerBlock.WEATHER_CHANGED_TICKS, true, false);
                //Thunder
                case 2 -> context.getSender().serverLevel().setWeatherParameters(0, WeatherControllerBlock.WEATHER_CHANGED_TICKS, true, true);
            }
        });

        return true;
    }
}
