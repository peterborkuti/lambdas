package chapter4;

import chapter4.separatingconcerns.Asset;
import chapter4.separatingconcerns.AssetUtil;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static chapter4.separatingconcerns.Asset.AssetType.BOND;
import static chapter4.separatingconcerns.Asset.AssetType.STOCK;
import static org.junit.Assert.*;

public class AssetUtilTest {
	final List<Asset> assets = Arrays.asList(
			new Asset(BOND, 1000),
			new Asset(BOND, 2000),
			new Asset(STOCK, 3000),
			new Asset(STOCK, 4000)
	);

	@Test
	public void totalAssetValues1() {
		assertEquals(10000, AssetUtil.totalAssetValues1(assets));
	}

	@Test
	public void totalBONDAssetValues1() {
		assertEquals(3000, AssetUtil.totalBONDAssetValues1(assets));
	}

	@Test
	public void totalBONDAssetValues2() {
		assertEquals(3000, AssetUtil.totalBONDAssetValues2(assets));
	}

	@Test
	public void totalAssetValues2() {
		assertEquals(3000, AssetUtil.totalAssetValues2(assets, a -> a.type == BOND));
		assertEquals(7000, AssetUtil.totalAssetValues2(assets, a -> a.type == STOCK));
		assertEquals(10000, AssetUtil.totalAssetValues2(assets, a -> true));
		assertEquals(10000, AssetUtil.totalAssetValues2(assets, Asset::anyType));
		assertEquals(3000, AssetUtil.totalAssetValues2(assets, Asset::isBond));
		assertEquals(7000, AssetUtil.totalAssetValues2(assets, Asset::isStock));
	}
}