package com.example.examplemod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

/**
 * Created by Kriller on 20.08.2016.
 */
public class BlockBombOre extends Block{

    public BlockBombOre() {
        super(Material.ROCK);
        this.setUnlocalizedName("bomb_ore");
        this.setHardness(1);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
}
