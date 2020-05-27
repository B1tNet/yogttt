package dev.bitnet.yogttt.item;

import dev.bitnet.yogttt.YogTTT;
import dev.bitnet.yogttt.setup.ModSetup;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class MedKitItem extends Item {
    public MedKitItem() {
        super(new Properties()
                .group(ModSetup.itemGroup)
                .maxStackSize(1)
        );
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        player.addPotionEffect(new EffectInstance(Effects.INSTANT_HEALTH, 1, 0));
        player.playSound(SoundEvents.BLOCK_NOTE_BLOCK_PLING, 0.5F, 1.0F);
        return super.onItemRightClick(world, player, hand);
    }
}
