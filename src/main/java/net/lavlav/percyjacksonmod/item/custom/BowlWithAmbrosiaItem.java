package net.lavlav.percyjacksonmod.item.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class BowlWithAmbrosiaItem extends Item {
    public BowlWithAmbrosiaItem(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity entity) {
        super.finishUsingItem(stack, world, entity);

        if (!world.isClientSide && entity instanceof Player player) {
            if (!player.getAbilities().instabuild) {
                stack.shrink(1);
                ItemStack bowl = new ItemStack(Items.BOWL);
                if (!player.getInventory().add(bowl)) {
                    player.drop(bowl, false);
                }
            }
        }

        return stack.isEmpty() ? new ItemStack(Items.BOWL) : stack;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 32;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        player.startUsingItem(hand);
        return InteractionResultHolder.consume(player.getItemInHand(hand));
    }
}
