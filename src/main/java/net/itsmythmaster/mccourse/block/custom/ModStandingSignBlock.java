package net.itsmythmaster.mccourse.block.custom;

import net.itsmythmaster.mccourse.block.entity.ModSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModStandingSignBlock extends StandingSignBlock {
    public ModStandingSignBlock(Properties properties, WoodType woodType)
    {
        super(properties, woodType);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState)
    {
        return new ModSignBlockEntity(pPos, pState);
    }

}
