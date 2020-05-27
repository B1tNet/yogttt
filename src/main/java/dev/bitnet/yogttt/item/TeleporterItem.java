package dev.bitnet.yogttt.item;

import dev.bitnet.yogttt.YogTTT;
import dev.bitnet.yogttt.setup.ModSetup;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponent;
import net.minecraft.world.World;

import java.util.Random;

public class TeleporterItem extends Item {
    protected final Random rand = new Random();

    public TeleporterItem() {
        super(new Properties()
                .group(ModSetup.itemGroup)
                .maxStackSize(1)
                .maxDamage(16)
                .defaultMaxDamage(16)
        );
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getHeldItem(hand);
        if (player.isCrouching()) {
            CompoundNBT nbt = stack.getOrCreateTag();
            nbt.putInt("yogttt_dim", player.dimension.getId());
            nbt.putDouble("yogttt_posX", player.getPosX());
            nbt.putDouble("yogttt_posY", player.getPosY());
            nbt.putDouble("yogttt_posZ", player.getPosZ());
            stack.setTag(nbt);
        } else {
            if (stack.getTag().contains("yogttt_posX") && stack.getTag().contains("yogttt_posY") && stack.getTag().contains("yogttt_posZ") && stack.getTag().contains("yogttt_dim")) {
                if(player.dimension.getId() != stack.getTag().getInt("yogttt_dim")) {
                    player.sendStatusMessage(new TextComponent() {
                        @Override
                        public String getUnformattedComponentText() {
                            return "Teleporter is unable to traverse between dimensions";
                        }

                        @Override
                        public ITextComponent shallowCopy() {
                            return null;
                        }
                    }, true);
                }
                else {
                    spawnParticles(world, player);
                    player.playSound(SoundEvents.ENTITY_ENDERMAN_TELEPORT, 0.5F, 1.0F);
                    player.setLocationAndAngles(stack.getTag().getDouble("yogttt_posX"), stack.getTag().getDouble("yogttt_posY"), stack.getTag().getDouble("yogttt_posZ"), player.prevRotationYaw, player.prevRotationPitch);
                    stack.damageItem(1, player, LivingEntity -> {LivingEntity.sendBreakAnimation(hand);});
                    spawnParticles(world, player);
                }
            }
        }

        return super.onItemRightClick(world, player, hand);
    }

    private void spawnParticles(World world, PlayerEntity player) {
        for(int i = 0; i < 32; ++i) {
            world.addParticle(ParticleTypes.PORTAL, player.getPosX(), player.getPosY() + this.rand.nextDouble() * 2.0D, player.getPosZ(), this.rand.nextGaussian(), 0.0D, this.rand.nextGaussian());
        }
    }
}
