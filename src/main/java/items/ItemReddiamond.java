package items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

/**
 * Created by Kriller on 20.08.2016.
 */
public class ItemReddiamond extends Item{

    public ItemReddiamond(){
        this.setUnlocalizedName("reddiamond");
        this.setCreativeTab(CreativeTabs.MATERIALS);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
        playerIn.addExperience(1000);
        return super.onItemRightClick(itemStackIn, worldIn, playerIn, hand);
    }
}
