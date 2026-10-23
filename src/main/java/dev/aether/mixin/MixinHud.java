package dev.aether.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import dev.aether.bootstrap.AetherBootstrapHooks;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.Hud;
import net.minecraft.world.scores.Objective;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Hud.class)
public class MixinHud {
    @WrapMethod(method = "displayScoreboardSidebar")
    private void aether$extractScoreboardSidebar(GuiGraphicsExtractor graphics,
                                                 Objective objective,
                                                 Operation<Void> original) {
        AetherBootstrapHooks.extractScoreboardSidebar(graphics, target -> original.call(target, objective));
    }
}
