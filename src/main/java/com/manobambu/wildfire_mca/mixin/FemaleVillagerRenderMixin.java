package com.manobambu.wildfire_mca.mixin;

import com.wildfire.render.GenderLayer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererFactory;
import net.minecraft.client.render.entity.VillagerEntityRenderer;
import net.minecraft.client.render.entity.model.VillagerEntityModel;
import net.minecraft.entity.passive.VillagerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(VillagerEntityRenderer.class)
public class FemaleVillagerRenderMixin {
    @Inject(method = "<init>", at = @At("TAIL"))
    private void onInit(EntityRendererFactory.Context ctx, CallbackInfo ci) {
        ((VillagerEntityRenderer)(Object)this).addFeature(
            new GenderLayer<VillagerEntity, VillagerEntityModel<VillagerEntity>>(
                (VillagerEntityRenderer)(Object)this, ctx
            )
        );
    }
}