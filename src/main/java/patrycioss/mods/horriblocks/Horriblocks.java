package patrycioss.mods.horriblocks;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import patrycioss.mods.horriblocks.item.CustomItem;
import patrycioss.mods.horriblocks.item.LaunchyFruit;
import patrycioss.mods.horriblocks.statuseffect.LaunchStatusEffect;

import java.util.ArrayList;
import java.util.List;

public class Horriblocks implements ModInitializer {

    public static final String MOD_ID = "horriblocks";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final StatusEffect LAUNCH_STATUS_EFFECT = new LaunchStatusEffect();

    public static List<CustomItem> CustomItems = new ArrayList<>();
    @Override
    public void onInitialize() {
        CustomItems.add(new LaunchyFruit());

        RegisterItems();

        Registry.register(Registries.ITEM_GROUP, new Identifier(MOD_ID, MOD_ID), ITEM_GROUP);

        Registry.register(Registries.STATUS_EFFECT, new Identifier(MOD_ID, "launch_effect"), LAUNCH_STATUS_EFFECT);

        LOGGER.info("Hello Fabric world!");
    }

    private static void RegisterItems(){
        for (CustomItem customItem : CustomItems){
            Registry.register(Registries.ITEM, new Identifier(MOD_ID, customItem.getPath()), customItem);
        }
    }

    private static final ItemGroup ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(CustomItems.get(0)))
            .displayName(Text.translatable(MOD_ID))
            .entries((context, entries) -> {
                for (Item item : CustomItems){
                    entries.add(item);
                }
            })
            .build();
}
