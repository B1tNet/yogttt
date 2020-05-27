package dev.bitnet.yogttt.item;

import dev.bitnet.yogttt.YogTTT;
import dev.bitnet.yogttt.setup.ModSetup;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;

public class HomerunBatItem extends Item {

    public HomerunBatItem() {
        super(new Properties()
                .group(ModSetup.itemGroup)
                .maxStackSize(1)
                .maxDamage(4)
                .defaultMaxDamage(4)
        );
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        double knockback = 15F;
        Hand hand = attacker.getActiveHand();

        Vec3d looking = attacker.getLookVec().normalize();
        target.addVelocity(looking.x * knockback, looking.y * knockback, looking.z * knockback);
        target.setHealth(target.getHealth() - 10);
        stack.damageItem(1, attacker, LivingEntity -> {LivingEntity.sendBreakAnimation(hand);});
        return true;
    }
}
