package com.manobambu.wildfire_mca.mixin;

import com.wildfire.render.GenderLayer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererFactory;
import net.minecraft.client.render.entity.ZombieVillagerEntityRenderer;
import net.minecraft.client.render.entity.model.VillagerEntityModel;
import net.minecraft.entity.mob.ZombieVillagerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ZombieVillagerEntityRenderer.class)
public class FemaleZombieVillagerRenderMixin {
    @Inject(method = "<init>", at = @At("TAIL"))
    private void onInit(EntityRendererFactory.Context ctx, CallbackInfo ci) {
        ((ZombieVillagerEntityRenderer)(Object)this).addFeature(
            new GenderLayer<ZombieVillagerEntity, VillagerEntityModel<ZombieVillagerEntity>>(
                (ZombieVillagerEntityRenderer)(Object)this, ctx
            )
        );
    }
}