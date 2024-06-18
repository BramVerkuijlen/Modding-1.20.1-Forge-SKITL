package net.phantom.SkitlMod.item.custom;

import com.ibm.icu.impl.TextTrieMap;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class IslandFinderItem extends Item {
    public IslandFinderItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if (pContext.getLevel().isClientSide()) {
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundblock = false;


            for (int i = 0; i <= positionClicked.getY() + 64; i++) {
                BlockState state = pContext.getLevel().getBlockState(positionClicked.below(i));

                if (isStone(state)) {
                    OutputIslandCoordinates(positionClicked.below(i), player, state.getBlock());
                    foundblock = true;

                    break;
                }
            }

            if (!foundblock) {
                player.sendSystemMessage(Component.literal("no island found"));
            }
        }

        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
                player -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return InteractionResult.SUCCESS;
    }

    private void OutputIslandCoordinates(BlockPos blockPos, Player player, Block block) {
        player.sendSystemMessage(Component.literal("found island at " + blockPos.getX()));
    }

    private boolean isStone(BlockState state) {
        return state.is(Blocks.STONE);
    }
}
