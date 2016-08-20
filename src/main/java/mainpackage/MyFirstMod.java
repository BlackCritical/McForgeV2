package mainpackage;

import mainpackage.blocks.BlockBombOre;
import items.ItemReddiamond;
import mainpackage.items.ItemSuperCake;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import proxy.ServerProxy;

@Mod(modid = MyFirstMod.MODID, version = MyFirstMod.VERSION)
public class MyFirstMod
{
    public static final String MODID = "myfirstmod";
    public static final String VERSION = "1.0";

    private static Item superCake = new ItemSuperCake();
    private static Item reddiamond = new ItemReddiamond();

    private static Block bombOre = new BlockBombOre();

    @SidedProxy(clientSide = "proxy.ClientProxy", serverSide = "proxy.ServerProxy")
    public static ServerProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	ItemStack woolStack = new ItemStack(Blocks.WOOL, 4);
    	ItemStack stoneStack = new ItemStack(Blocks.STONE);
    	
    	GameRegistry.addShapelessRecipe(woolStack, stoneStack);
    }
    //test
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.registerClient();

        GameRegistry.registerItem(superCake, "SuperCake");
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(superCake,0, new ModelResourceLocation(MODID + ":SuperCake", "inventory"));
        GameRegistry.registerItem(reddiamond, "reddiamond");
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(reddiamond,0, new ModelResourceLocation(MODID + ":reddiamond", "inventory"));

        GameRegistry.registerBlock(bombOre, "bomb_ore");
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(bombOre), 0, new ModelResourceLocation(MODID + ":bomb_ore", "inventory"));
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

    }
}
