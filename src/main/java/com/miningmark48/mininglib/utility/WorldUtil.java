package com.miningmark48.mininglib.utility;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

public class WorldUtil {

    /**
     * Finds an empty spot ('Y' value) in the world to place a generated structure.
     * @param world
     *  World to check in
     * @param x
     *  'X' value to start checking at.
     * @param z
     *  'Z' value to start checking at.
     * @return
     *  Returns a 'Y' value that was found to be empty.
     */
    @SuppressWarnings("deprecation")
    public static int findEmptySpot(World world, int x, int z) {
        int y = world.getTopSolidOrLiquidBlock(new BlockPos(x, 0, z)).getY();
        if (y == -1) {
            return -1;
        }
        y--;
        if (y > world.getHeight() - 5) {
            y = world.getHeight() / 2;
        }


        Block block = world.getBlockState(new BlockPos(x, y + 1, z)).getBlock();
        while (block.getMaterial(block.getDefaultState()).isLiquid() || world.isAirBlock(new BlockPos(x, y - 1, z))) {
            y++;
            if (y > world.getHeight() - 10) {
                return -1;
            }
            block = world.getBlockState(new BlockPos(x, y + 1, z)).getBlock();
        }

        return y;
    }

    /**
     * Checks to see if a given block coordinate is in a slime chunk.
     * @param world
     *  World to check in.
     * @param x
     *  'X' value to start checking at.
     * @param z
     *  'Z' value to start checking at.
     * @return
     *  Returns a true if given block coordinate is found in a slime chunk.
     */
    public static boolean isSlimeChunk(World world, int x, int z){
        Chunk chunk = world.getChunkFromBlockCoords(new BlockPos(x, 0, z));
        return chunk.getRandomWithSeed(987234911L).nextInt(10) == 0;
    }

}
