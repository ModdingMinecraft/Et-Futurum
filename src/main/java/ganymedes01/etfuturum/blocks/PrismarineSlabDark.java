package ganymedes01.etfuturum.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ganymedes01.etfuturum.EtFuturum;
import ganymedes01.etfuturum.ModBlocks;
import ganymedes01.etfuturum.configuration.ConfigurationHandler;
import ganymedes01.etfuturum.core.utils.Utils;
import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;

public class PrismarineSlabDark extends GenericSlab {

	public PrismarineSlabDark() {
		super(Material.rock, ModBlocks.prismarine);
		setHardness(1.5F);
		setResistance(10.0F);
		setBlockName(Utils.getUnlocalisedName("prismarine_slab_dark"));
		setCreativeTab(ConfigurationHandler.enablePrismarine ? EtFuturum.creativeTab : null);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return base.getIcon(side, 2);
	}

	@Override
	public boolean isEnabled() {
		return ConfigurationHandler.enablePrismarine;
	}
}