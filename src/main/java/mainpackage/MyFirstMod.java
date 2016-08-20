package mainpackage;

import items.ItemReddiamond;
import items.ItemSuperCake;
import blocks.BlockBombOre;
import net.minecraft.init.Blocks;
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

    public static ItemSuperCake superCake = new ItemSuperCake();
    public static ItemReddiamond reddiamond = new ItemReddiamond();

    public static BlockBombOre bombOre = new BlockBombOre();

    @SidedProxy(clientSide = "proxy.ClientProxy", serverSide = "proxy.ServerProxy")
    public static ServerProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        GameRegistry.registerItem(reddiamond);

    	ItemStack woolStack = new ItemStack(Blocks.WOOL, 4);
    	ItemStack stoneStack = new ItemStack(Blocks.STONE);
    	
    	GameRegistry.addShapelessRecipe(woolStack, stoneStack);
    }
    //test
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.registerClient();

    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

    }

}
