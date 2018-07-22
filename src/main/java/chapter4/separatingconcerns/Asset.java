package chapter4.separatingconcerns;

public class Asset {
	public enum AssetType { BOND, STOCK };
	public final AssetType type;
	public final int value;
	public Asset(final AssetType assetType, final int assetValue) {
		type = assetType;
		value = assetValue;
	}
	public AssetType getType() { return type; }
	public int getValue() { return value; }
	public boolean isBond() { return type == AssetType.BOND; }
	public boolean isStock() { return type == AssetType.STOCK; }
	public boolean anyType() { return true; }
}

