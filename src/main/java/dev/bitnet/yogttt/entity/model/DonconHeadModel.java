package dev.bitnet.yogttt.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;

public class DonconHeadModel extends Model {
    protected final ModelRenderer modelRenderer;

    public DonconHeadModel() {
        this(0, 35, 64, 64);
    }

    public DonconHeadModel(int p_i51060_1_, int p_i51060_2_, int p_i51060_3_, int p_i51060_4_) {
        super(RenderType::getEntitySolid);
        textureWidth = 320;
        textureHeight = 160;

        this.modelRenderer = new ModelRenderer(this, p_i51060_1_, p_i51060_2_);
        this.modelRenderer.addBox(-40.0f, 0.0f, 40.0f, 80.0f, 80.0f, 80.0f, 0.0f);
        this.modelRenderer.setRotationPoint(0.0f, 0.0f, 0.0f);
    }

    public void func_225603_a_(float p_225603_1_, float p_225603_2_, float p_225603_3_) {
        this.modelRenderer.rotateAngleY = p_225603_2_ * ((float)Math.PI / 180F);
        this.modelRenderer.rotateAngleX = p_225603_3_ * ((float)Math.PI / 180F);
    }


    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        this.modelRenderer.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}