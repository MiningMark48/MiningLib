package com.miningmark48.mininglib.base.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ModItemBlock extends ItemBlock{

    public ModItemBlock(Block block) {
        super(block);

        setRegistryName(block.getRegistryName());
    }
}
