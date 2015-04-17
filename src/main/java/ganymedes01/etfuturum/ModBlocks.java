package ganymedes01.etfuturum;

import ganymedes01.etfuturum.blocks.BlockBanner;
import ganymedes01.etfuturum.blocks.BlockBeetroot;
import ganymedes01.etfuturum.blocks.BlockSilkedMushroom;
import ganymedes01.etfuturum.blocks.BlockWoodDoor;
import ganymedes01.etfuturum.blocks.BlockWoodFence;
import ganymedes01.etfuturum.blocks.BlockWoodFenceGate;
import ganymedes01.etfuturum.blocks.CoarseDirt;
import ganymedes01.etfuturum.blocks.InvertedDaylightDetector;
import ganymedes01.etfuturum.blocks.IronTrapdoor;
import ganymedes01.etfuturum.blocks.PrismarineBlocks;
import ganymedes01.etfuturum.blocks.RedSandstone;
import ganymedes01.etfuturum.blocks.RedSandstoneSlab;
import ganymedes01.etfuturum.blocks.RedSandstoneStairs;
import ganymedes01.etfuturum.blocks.SeaLantern;
import ganymedes01.etfuturum.blocks.SlimeBlock;
import ganymedes01.etfuturum.blocks.Stones18;

import java.lang.reflect.Field;

import net.minecraft.block.Block;
import net.minecraft.block.BlockWood;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks {

	// MC:PE
	public static final Block beetroot = new BlockBeetroot();

	// 1.8 stuff
	public static final Block newStones = new Stones18();
	public static final Block ironTrapdoor = new IronTrapdoor();
	public static final Block prismarineBlocks = new PrismarineBlocks();
	public static final Block seaLantern = new SeaLantern();
	public static final Block[] doors = new Block[BlockWood.field_150096_a.length - 1];
	public static final Block invertedDaylightDetector = new InvertedDaylightDetector();
	public static final Block redSandstone = new RedSandstone();
	public static final Block redSandstoneSlab = new RedSandstoneSlab();
	public static final Block redSandstoneStairs = new RedSandstoneStairs();
	public static final Block[] fences = new Block[BlockWood.field_150096_a.length];
	public static final Block[] gates = new Block[BlockWood.field_150096_a.length - 1];
	public static final Block brown_mushroom_block = new BlockSilkedMushroom(Blocks.brown_mushroom_block, "brown");
	public static final Block red_mushroom_block = new BlockSilkedMushroom(Blocks.red_mushroom_block, "red");
	public static final Block coarseDirt = new CoarseDirt();
	public static final Block banner = new BlockBanner();
	public static final Block slimeBlock = new SlimeBlock();

	static {
		for (int i = 0; i < doors.length; i++)
			doors[i] = new BlockWoodDoor(i + 1);

		for (int i = 0; i < fences.length; i++)
			fences[i] = new BlockWoodFence(i);

		for (int i = 0; i < gates.length; i++)
			gates[i] = new BlockWoodFenceGate(i + 1);
	}

	public static void init() {
		try {
			for (Field f : ModBlocks.class.getDeclaredFields()) {
				Object obj = f.get(null);
				if (obj instanceof Block)
					registerBlock((Block) obj);
				else if (obj instanceof Block[])
					for (Block block : (Block[]) obj)
						if (block != null)
							registerBlock(block);
			}
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

	private static void registerBlock(Block block) {
		String name = block.getUnlocalizedName();
		String[] strings = name.split("\\.");

		if (block instanceof ISubBlocksBlock)
			GameRegistry.registerBlock(block, ((ISubBlocksBlock) block).getItemBlockClass(), strings[strings.length - 1]);
		else
			GameRegistry.registerBlock(block, strings[strings.length - 1]);

		if (block instanceof IBurnableBlock)
			Blocks.fire.setFireInfo(block, 5, 20);
	}

	public static interface ISubBlocksBlock {

		Class<? extends ItemBlock> getItemBlockClass();
	}

	public static interface IBurnableBlock {
	}
}