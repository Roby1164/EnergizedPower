package me.jddev0.ep.networking.packet;

import me.jddev0.ep.block.WeatherControllerBlock;
import me.jddev0.ep.block.entity.WeatherControllerBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.SectionPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.common.capabilities.Capabilities;
import net.neoforged.neoforge.common.util.LazyOptional;
import net.neoforged.neoforge.energy.IEnergyStorage;
import net.neoforged.neoforge.network.NetworkEvent;

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

    public boolean handle(NetworkEvent.Context context) {
        context.enqueueWork(() -> {
            Level level = context.getSender().level();
            if(!level.hasChunk(SectionPos.blockToSectionCoord(pos.getX()), SectionPos.blockToSectionCoord(pos.getZ())))
                return;

            BlockEntity blockEntity = level.getBlockEntity(pos);
            if(!(blockEntity instanceof WeatherControllerBlockEntity weatherControllerBlockEntity))
                return;

            LazyOptional<IEnergyStorage> energyStorageLazyOptional = weatherControllerBlockEntity.getCapability(Capabilities.ENERGY, null);
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
