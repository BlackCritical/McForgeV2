package proxy;

import blocks.BasicBlock;
import items.BasicItem;
import mainpackage.MyFirstMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

/**
 * Created by Kriller on 20.08.2016.
 */
public class ClientProxy extends ServerProxy {

    @Override
    public void registerClient(){
        registerItemModel(MyFirstMod.reddiamond);
        registerItemModel(MyFirstMod.superCake);

        registerBlockModel(MyFirstMod.bombOre);
    }

    public static void registerItemModel(BasicItem item){
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(MyFirstMod.MODID + ":" + item.getSimpleName(), "inventory"));
    }

    public static void registerBlockModel(BasicBlock block){
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(MyFirstMod.MODID + ":" + block.name, "inventory"));
    }

}
