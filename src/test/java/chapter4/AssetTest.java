package chapter4;

import chapter4.separatingconcerns.Asset;
import org.junit.Test;

import static org.junit.Assert.*;

public class AssetTest {
	@Test
	public void testCreation() {
		Asset a = new Asset(Asset.AssetType.BOND, 1);
		assertEquals(Asset.AssetType.BOND, a.getType());
		assertEquals(1, a.getValue());
		assertEquals(Asset.AssetType.BOND, a.type);
		assertEquals(1, a.value);

		a = new Asset(Asset.AssetType.STOCK, 2);
		assertEquals(Asset.AssetType.STOCK, a.getType());
		assertEquals(2, a.getValue());
		assertEquals(Asset.AssetType.STOCK, a.type);
		assertEquals(2, a.value);

	}

}