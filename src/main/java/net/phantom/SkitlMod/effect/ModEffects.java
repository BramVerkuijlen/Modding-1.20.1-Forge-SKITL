package net.phantom.SkitlMod.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.phantom.SkitlMod.SkitlMod;
import net.phantom.SkitlMod.effect.custom.DungeonCurse;

public class ModEffects {
    public static DeferredRegister<MobEffect> MOB_EFFECTS
            = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, SkitlMod.MOD_ID);

    public static final RegistryObject<MobEffect> DUNGEON_CURSE = MOB_EFFECTS.register("dungeon_curse",
            () -> new DungeonCurse(MobEffectCategory.HARMFUL, 3124687));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
