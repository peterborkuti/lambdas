package chapter4.separatingconcerns;

import chapter4.separatingconcerns.Asset;

import java.util.List;
import java.util.function.Predicate;

public class AssetUtil {
	public static int totalAssetValues1(final List<Asset> assets) {
		return assets.stream()
				.mapToInt(Asset::getValue)
				.sum();
	}

	public static int totalBONDAssetValues1(final List<Asset> assets) {
		return assets.stream()
				.filter(asset -> asset.getType() == Asset.AssetType.BOND)
				.mapToInt(Asset::getValue)
				.sum();
	}

	public static int totalBONDAssetValues2(final List<Asset> assets) {
		return assets.stream()
				.filter(asset -> asset.type == Asset.AssetType.BOND)
				.mapToInt(Asset::getValue)
				.sum();
	}

	public static int totalAssetValues2(final List<Asset> assets, Predicate<Asset> predicate) {
		return assets.stream()
				.filter(predicate)
				.mapToInt(Asset::getValue)
				.sum();
	}
}
