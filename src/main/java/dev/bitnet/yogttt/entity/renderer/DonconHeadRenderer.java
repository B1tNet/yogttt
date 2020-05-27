package dev.bitnet.yogttt.entity.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import dev.bitnet.yogttt.YogTTT;
import dev.bitnet.yogttt.entity.DonconHeadEntity;
import dev.bitnet.yogttt.entity.model.DonconHeadModel;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

public class DonconHeadRenderer extends EntityRenderer<DonconHeadEntity> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(YogTTT.MODID, "textures/entity/doncon_head.png");
    private final DonconHeadModel model = new DonconHeadModel();

    public DonconHeadRenderer(EntityRendererManager renderManager) {
        super(renderManager);
    }

    @Override
    public ResourceLocation getEntityTexture(DonconHeadEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(DonconHeadEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        matrixStackIn.push();
        matrixStackIn.scale(-1.0F, -1.0F, 1.0F);
        float f = MathHelper.rotLerp(entityIn.prevRotationYaw, entityIn.rotationYaw, partialTicks);
        float f1 = MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch);
        IVertexBuilder iVertexBuilder = bufferIn.getBuffer(this.model.getRenderType(this.getEntityTexture(entityIn)));
        this.model.func_225603_a_(0.0f, f, f1);
        this.model.render(matrixStackIn, iVertexBuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
        matrixStackIn.pop();
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }
}
