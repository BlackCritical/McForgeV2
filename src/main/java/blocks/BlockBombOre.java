package blocks;

import mainpackage.MyFirstMod;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

/**
 * Created by Kriller on 20.08.2016.
 */
public class BlockBombOre extends BasicBlock{

    public BlockBombOre() {
        super("bomb_ore", Material.ROCK);
        setHardness(4);
        setHarvestLevel("pickaxe", 2);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }

    @Nullable
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        if(rand.nextBoolean())
            return Item.getItemFromBlock( MyFirstMod.bombOre);
        else if (rand.nextBoolean())
            return Item.getItemFromBlock( MyFirstMod.bombOre);
        return MyFirstMod.reddiamond;
    }

    @Override
    public int quantityDropped(IBlockState state, int fortune, Random random) {
        if(fortune > 1)
            return 2;
        return 1;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced) {
        tooltip.add("Dieses Ore kann geschmlozen werden,");
        tooltip.add("Oder vercrafted werden.");
    }

    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
        Random rnd = new Random();
        if(rnd.nextBoolean())
            if(rnd.nextBoolean())
                worldIn.newExplosion(player, pos.getX(), pos.getY(), pos.getZ(), 2.5F, false, true);
    }
}
