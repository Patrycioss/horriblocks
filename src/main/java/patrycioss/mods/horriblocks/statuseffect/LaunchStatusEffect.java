package patrycioss.mods.horriblocks.statuseffect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.math.Vec3d;
import patrycioss.mods.horriblocks.Horriblocks;

import java.awt.*;

public class LaunchStatusEffect extends StatusEffect {

	public LaunchStatusEffect() {
		super(
				StatusEffectCategory.NEUTRAL,
				Color.CYAN.getRGB()
		);
	}

	@Override
	public boolean canApplyUpdateEffect(int duration, int amplifier) {
		Horriblocks.LOGGER.info(String.valueOf((duration)));



		return true;
	}

	@Override
	public void applyUpdateEffect(LivingEntity entity, int amplifier) {
		entity.addVelocity(new Vec3d(0, amplifier, 0));
	}
}
