package dev.bitnet.yogttt.setup;

import dev.bitnet.yogttt.YogTTT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = YogTTT.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModSounds {

    public static final SoundEvent ENTITY_DONCONHEAD_AMBIENT = register("entity.doncon_head.ambient");
    public static final SoundEvent ITEM_JIHADBOMB_USE = register("item.jihad_bomb.use");
    public static final SoundEvent ITEM_JIHADBOMB_EXPLOSION = register("item.jihad_bomb.explosion");

    private static SoundEvent register(String name) {
        ResourceLocation location = new ResourceLocation(YogTTT.MODID, name);
        SoundEvent event = new SoundEvent(location);
        event.setRegistryName(name);
        ForgeRegistries.SOUND_EVENTS.register(event);
        return event;
    }
}
