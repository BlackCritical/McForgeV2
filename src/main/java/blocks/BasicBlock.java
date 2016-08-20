package blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Created by Kriller on 20.08.2016.
 */
public class BasicBlock extends Block {

    public BasicBlock(String name, Material materialIn) {
        super(materialIn);
        setUnlocalizedName(name);
        setRegistryName(name);
    }
}
