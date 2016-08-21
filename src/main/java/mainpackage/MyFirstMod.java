package mainpackage;

import blocks.BasicBlock;
import blocks.BlockAtomTNT;
import items.ItemReddiamond;
import items.ItemSuperCake;
import blocks.BlockBombOre;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBlock;
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
    public static BlockAtomTNT atomTNT = new BlockAtomTNT();

    @SidedProxy(clientSide = "proxy.ClientProxy", serverSide = "proxy.ServerProxy")
    public static ServerProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        GameRegistry.register(reddiamond);
        GameRegistry.register(superCake);
    	
    	registerBlock(bombOre);
        registerBlock(atomTNT);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        GameRegistry.addRecipe(new ItemStack(Blocks.TNT,32), "xxx", " r ", "xxx", 'x', bombOre, 'r', Items.REDSTONE);

        GameRegistry.addShapedRecipe(new ItemStack(Blocks.TNT,6), "xx", "xx", 'x', bombOre);

        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.GOLD_BLOCK, 4), Blocks.STONE, reddiamond);


        GameRegistry.addSmelting(new ItemStack(bombOre), new ItemStack(reddiamond, 2), 200);

        proxy.registerClient();
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

    }

    public static void registerBlock(BasicBlock block){
        GameRegistry.register(block);
        GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
    }

}
