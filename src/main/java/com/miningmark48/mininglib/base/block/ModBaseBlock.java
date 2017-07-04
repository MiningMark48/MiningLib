package com.miningmark48.mininglib.base.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class ModBaseBlock extends Block{

    public ModBaseBlock() {
        super(Material.ROCK, MapColor.GRAY);
        setHardness(1.5f);
        setResistance(1.0f);
    }

    /**
     * Defaults to Gray map color with 1.5f hardness and 1.0f resistance.
     * @param blockMaterial
     *  Material for the block, uses the Material class.
     **/
    public ModBaseBlock(Material blockMaterial) {
        super(blockMaterial, MapColor.GRAY);
        setHardness(1.5f);
        setResistance(1.0f);
    }

    /**
     * Defaults to 1.5f hardness and 1.0f resistance.
     * @param blockMaterial
     *  Material for the block, uses the Material class.
     * @param blockMapColor
     *  Map color for the block, uses the MapColor class.
     **/
    public ModBaseBlock(Material blockMaterial, MapColor blockMapColor) {
        super(blockMaterial, blockMapColor);
        setHardness(1.5f);
        setResistance(1.0f);
    }

    /**
     * @param blockMaterial
     *  Material for the block, uses the Material class.
     * @param blockMapColor
     *  Map color for the block, uses the MapColor class.
     * @param blockHardness
     *  Hardness for the block.
     * @param blockResistance
     *  Explosion resistance for the block.
     **/
    public ModBaseBlock(Material blockMaterial, MapColor blockMapColor, float blockHardness, float blockResistance) {
        super(blockMaterial, blockMapColor);
        setHardness(1.5f);
        setResistance(1.0f);
    }

}
