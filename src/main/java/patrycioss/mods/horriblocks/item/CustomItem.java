package patrycioss.mods.horriblocks.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;

public class CustomItem extends Item {

	public String getPath(){
		return getName().getString().toLowerCase().strip().replaceAll("\\s", "_");
	}

	public CustomItem(Settings settings) {
		super(settings);
	}

	public CustomItem() {
		super(new FabricItemSettings());
	}

//	@Override
//	public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
//		playerEntity.playSound(SoundEvents.ENTITY_COW_HURT, 1.0F, 1.0F);
//		return TypedActionResult.success(playerEntity.getStackInHand(hand));
//	}


	//	@Override
//	public ActionResult useOnBlock(ItemUsageContext context) {
//		context.getPlayer().playSound(SoundEvents.ENTITY_PIG_HURT, 1.0f, 1.0f);
//		return super.useOnBlock(context);
//	}
}
