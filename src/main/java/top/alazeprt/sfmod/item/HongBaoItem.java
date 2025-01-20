package top.alazeprt.sfmod.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class HongBaoItem extends Item {
    public HongBaoItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient()) {
            ItemStack stack = user.getStackInHand(hand);
            stack.setCount(stack.getCount() - 1);
            ItemStack reward = new ItemStack(Items.GOLD_INGOT, (int) (Math.random() * 50) + 1);
            user.giveItemStack(reward);
            return TypedActionResult.success(stack);
        } else {
            return super.use(world, user, hand);
        }
    }
}
