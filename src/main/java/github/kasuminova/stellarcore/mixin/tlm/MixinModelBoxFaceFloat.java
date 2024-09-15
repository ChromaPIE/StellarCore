package github.kasuminova.stellarcore.mixin.tlm;

import com.github.tartaricacid.touhoulittlemaid.client.model.ModelBoxFaceFloat;
import com.github.tartaricacid.touhoulittlemaid.client.model.pojo.FaceUVsItem;
import github.kasuminova.stellarcore.client.pool.TLMPositionTextureVertexPool;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.PositionTextureVertex;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ModelBoxFaceFloat.class)
public class MixinModelBoxFaceFloat {

    @Inject(method = "<init>", at = @At("RETURN"))
    private void injectInitBeforeGetTexturedQuad(final ModelRenderer renderer, final float x, final float y, final float z, final float dx, final float dy, final float dz, final float delta, final FaceUVsItem faces, final CallbackInfo ci) {
        PositionTextureVertex[] vertexPositions = ObfuscationReflectionHelper.getPrivateValue(ModelBox.class, (ModelBox) (Object) this, "vertexPositions");
        for (int i = 0; i < vertexPositions.length; i++) {
            vertexPositions[i] = TLMPositionTextureVertexPool.canonicalize(vertexPositions[i]);
        }
    }

}