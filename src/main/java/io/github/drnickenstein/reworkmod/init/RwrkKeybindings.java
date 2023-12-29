package io.github.drnickenstein.reworkmod.init;

import com.mojang.blaze3d.platform.InputConstants;
import io.github.drnickenstein.reworkmod.ReworkMod;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;

public final class RwrkKeybindings {

    public static final RwrkKeybindings INSTANCE = new RwrkKeybindings();

    private RwrkKeybindings() {



    }

    public final KeyMapping activateArmourEffect = new KeyMapping("key." + ReworkMod.MODID + ".armour_effect_activation",
            KeyConflictContext.IN_GAME,
            InputConstants.getKey(InputConstants.KEY_T, -1),
            KeyMapping.CATEGORY_GAMEPLAY);


}
