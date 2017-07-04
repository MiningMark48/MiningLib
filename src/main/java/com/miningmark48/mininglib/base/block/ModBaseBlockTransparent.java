package com.miningmark48.mininglib.base.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBaseBlockTransparent extends ModBaseBlock{

    /**
     * Used for transparent blocks such as glass.
     * @param blockMaterial
     *  Material for the block, uses the Material class.
     * @param blockMapColor
     *  Map color for the block, uses the MapColor class.
     * @param blockHardness
     *  Hardness for the block.
     * @param blockResistance
     *  Explosion resistance for the block.
     **/
    public ModBaseBlockTransparent(Material blockMaterial, MapColor blockMapColor, float blockHardness, float blockResistance) {
        super(blockMaterial, blockMapColor);
        setHardness(1.5f);
        setResistance(1.0f);
        setLightLevel(lightValue);
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }

    @Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
    {
        IBlockState iblockstate = blockAccess.getBlockState(pos.offset(side));
        Block block = iblockstate.getBlock();

        if (blockState != iblockstate)
        {
            return true;
        }

        if (block == this)
        {
            return false;
        }

        return !true && block == this ? false : super.shouldSideBeRendered(blockState, blockAccess, pos, side);
    }

}
