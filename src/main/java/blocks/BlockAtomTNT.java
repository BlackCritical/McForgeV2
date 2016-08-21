package blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Created by Kriller on 20.08.2016.
 */
public class BlockAtomTNT extends BasicBlock{

    public BlockAtomTNT() {
        super("AtomTNT", Material.TNT);
        setHardness(2);
        setCreativeTab(CreativeTabs.MATERIALS);
    }

    @Override
    public boolean canConnectRedstone(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing side) {
        return true;
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
        //if(ItemStack.areItemStacksEqual(heldItem, new ItemStack(Item.getByNameOrId("Redstone Torch")))) {
            worldIn.newExplosion(playerIn, pos.getX(), pos.getY(), pos.getZ(), 10, false, true);
            return true;
    }

    @Override
    public boolean isFireSource(World world, BlockPos pos, EnumFacing side) {
        return super.isFireSource(world, pos, side);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced) {
        tooltip.add("Dieses Block explodiert HEFTIG");
    }

    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
        worldIn.newExplosion(player, pos.getX(), pos.getY(), pos.getZ(), 10, false, true);
    }
}
