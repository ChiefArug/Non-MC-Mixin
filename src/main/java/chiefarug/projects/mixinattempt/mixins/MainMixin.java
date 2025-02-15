package chiefarug.projects.mixinattempt.mixins;

import chiefarug.projects.mixinattempt.Main;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Main.class)
public class MainMixin {
    @Inject(method = "main", at = @At("RETURN"))
    private static void injectAfter(String[] args, CallbackInfo ci) {
        System.out.println("!dlrow olleH");
    }
}
