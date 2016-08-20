package com.example.examplemod.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

/**
 * Created by Kriller on 20.08.2016.
 */
public class ItemSuperCake extends Item {

    public ItemSuperCake(){
        this.setUnlocalizedName("SuperCake");
        this.setCreativeTab(CreativeTabs.FOOD);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
        playerIn.addPotionEffect(new PotionEffect(MobEffects.SPEED, 20*20, 20));
        return super.onItemRightClick(itemStackIn, worldIn, playerIn, hand);
    }

}
