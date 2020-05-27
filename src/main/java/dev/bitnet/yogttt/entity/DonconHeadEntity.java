package dev.bitnet.yogttt.entity;

import dev.bitnet.yogttt.setup.ModSounds;
import dev.bitnet.yogttt.setup.Registration;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.DamagingProjectileEntity;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class DonconHeadEntity extends DamagingProjectileEntity {

    public DonconHeadEntity(EntityType<? extends DonconHeadEntity> p_i50147_1_, World p_i50147_2_) {
        super(p_i50147_1_, p_i50147_2_);
    }

    public DonconHeadEntity(World worldIn, LivingEntity shooter, double accelX, double accelY, double accelZ) {
        super(Registration.DONCON_HEAD.get(), shooter, accelX, accelY, accelZ, worldIn);
    }

    @OnlyIn(Dist.CLIENT)
    public DonconHeadEntity(World worldIn, double x, double y, double z, double accelX, double accelY, double accelZ) {
        super(Registration.DONCON_HEAD.get(), x, y, z, accelX, accelY, accelZ, worldIn);
    }

    @Override
    public boolean isBurning() {
        return false;
    }

    @Override
    public void setNoGravity(boolean noGravity) {
        super.setNoGravity(true);
    }

    @Override
    public void onAddedToWorld() {
        playSound(ModSounds.ENTITY_DONCONHEAD_AMBIENT, 1, 1);
    }

    @Override
    public void onCollideWithPlayer(PlayerEntity entityIn) {
        super.onCollideWithPlayer(entityIn);
        if (!this.world.isRemote) {
            if (entityIn != shootingEntity && this.ticksExisted >= 40) {
                entityIn.setHealth(0);
            }
        }
    }

    @Override
    public void tick() {
        super.tick();
        this.noClip = true;
        if (this.ticksExisted >= 280) {
            world.createExplosion(this, getPosX(), getPosY(), getPosZ(), 4f, Explosion.Mode.NONE);
            this.remove();
        }
    }
}
