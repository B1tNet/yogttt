package dev.bitnet.yogttt.setup;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModSetup {
    public static ItemGroup itemGroup = new ItemGroup("yogttt") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(Registration.ICON.get());
        }
    };

    public void init() {

    }
}
