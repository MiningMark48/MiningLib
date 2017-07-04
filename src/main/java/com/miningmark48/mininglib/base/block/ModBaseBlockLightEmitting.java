package com.miningmark48.mininglib.base.block;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class ModBaseBlockLightEmitting extends ModBaseBlock{

    /**
     * @param lightValue
     *  Light value to be emitted from block as float.
     * @param blockMaterial
     *  Material for the block, uses the Material class.
     * @param blockMapColor
     *  Map color for the block, uses the MapColor class.
     * @param blockHardness
     *  Hardness for the block.
     * @param blockResistance
     *  Explosion resistance for the block.
     **/
    public ModBaseBlockLightEmitting(float lightValue, Material blockMaterial, MapColor blockMapColor, float blockHardness, float blockResistance) {
        super(blockMaterial, blockMapColor);
        setHardness(1.5f);
        setResistance(1.0f);
        setLightLevel(lightValue);
    }

}
