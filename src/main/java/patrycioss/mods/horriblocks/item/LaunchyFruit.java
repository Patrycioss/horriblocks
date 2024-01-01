package patrycioss.mods.horriblocks.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.UseAction;
import org.jetbrains.annotations.Nullable;
import patrycioss.mods.horriblocks.Horriblocks;

public class LaunchyFruit extends CustomItem {
    public LaunchyFruit() {
        super();
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.EAT;
    }

    @Override
    public boolean isFood() {
        return true;
    }

    @Nullable
    @Override
    public FoodComponent getFoodComponent() {
        FoodComponent.Builder builder = new FoodComponent.Builder();

        builder.hunger(100);
        builder.meat();
        builder.snack();
        builder.alwaysEdible();

//        StatusEffectInstance absorption = new StatusEffectInstance(StatusEffects.ABSORPTION, 100000, 100000);
//        builder.statusEffect(absorption, 1);

        StatusEffectInstance launch = new StatusEffectInstance(Horriblocks.LAUNCH_STATUS_EFFECT, 1, 10000);
        builder.statusEffect(launch, 1);


        return builder.build();
    }

    @Override
    public Text getName() {
        return Text.literal("Launchy Fruit");
    }

}
