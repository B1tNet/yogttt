package dev.bitnet.yogttt.item;

import dev.bitnet.yogttt.YogTTT;
import dev.bitnet.yogttt.setup.ModSetup;
import net.minecraft.item.Item;

public class ExplosiveCellItem extends Item {
    public ExplosiveCellItem() {
        super(new Properties()
                .group(ModSetup.itemGroup)
        );
    }
}
