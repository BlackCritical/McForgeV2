package blocks;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

/**
 * Created by Kriller on 20.08.2016.
 */
public class BlockBombOre extends BasicBlock{

    public BlockBombOre() {
        super("bomb_ore", Material.ROCK);
        setHardness(2);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
}
