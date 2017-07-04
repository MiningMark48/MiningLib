package com.miningmark48.mininglib.base.block;

import net.minecraft.block.BlockFalling;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class ModBaseBlockGravity extends BlockFalling{

    /**
     * Block class for making blocks fall like Gravel or Sand.
     * @param blockMaterial
     *  Material for block using Material class.
     * @param soundType
     *  Sound for block will walked on, broken, etc using SoundType
     * @param hardness
     *  Block hardness as float.
     * @param resistance
     *  Block blast resistance as float.
     */
    public ModBaseBlockGravity(Material blockMaterial, SoundType soundType, float hardness, float resistance){
        super(Material.SAND);
        setSoundType(soundType);
        setHardness(hardness);
        setResistance(resistance);
    }

}
