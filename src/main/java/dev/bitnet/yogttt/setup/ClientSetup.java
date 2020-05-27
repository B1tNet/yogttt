package dev.bitnet.yogttt.setup;

import dev.bitnet.yogttt.YogTTT;
import dev.bitnet.yogttt.entity.renderer.DonconHeadRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = YogTTT.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup {

    public static void init(final FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(Registration.DONCON_HEAD.get(), DonconHeadRenderer::new);
    }
}
