package dev.bitnet.yogttt.tile_entity;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants;

import static dev.bitnet.yogttt.setup.Registration.CFOUR_TILE;

public class C4Tile extends TileEntity implements ITickableTileEntity {
    private int count = 0;
    private boolean fused = false;

    public C4Tile() {
        super(CFOUR_TILE.get());
    }

    @Override
    public void tick() {

    }

    @Override
    public void read(CompoundNBT compound) {
        super.read(compound);
        if (compound.contains("yogttt_count", Constants.NBT.TAG_INT)) {
            this.count = compound.getInt("yogttt_count");
        }
        if (compound.contains("yogttt_fused", Constants.NBT.TAG_BYTE)) {
            this.fused = compound.getBoolean("yogttt_fused");
        }
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        return super.write(compound);
    }
}
