package net.itsmythmaster.mccourse.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;

public class ChessBlock extends Block {

    public static final BooleanProperty CHESSCLICKED = BooleanProperty.create("chessclicked");

    public ChessBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(CHESSCLICKED, Boolean.valueOf(false)));
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos,
                                 Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {

        if(!pLevel.isClientSide() && pHand == InteractionHand.MAIN_HAND)
        {
            boolean currentState = pState.getValue(CHESSCLICKED);
            pLevel.setBlock(pPos, pState.setValue(CHESSCLICKED, !currentState), 3);
        }

        return InteractionResult.SUCCESS;
    }
    
}
