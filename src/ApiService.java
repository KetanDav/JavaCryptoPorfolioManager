import java.util.Random;

public class ApiService {
    private static final String[] mockAssets = {"Bitcoin", "Ethereum", "Ripple", "Litecoin", "Cardano"};
    private static Random random = new Random();

    public static CryptoAsset generateMockData() {
        String assetName = mockAssets[random.nextInt(mockAssets.length)];
        double amount = random.nextDouble() * 10; // Random amount between 0 and 10
        return new CryptoAsset(assetName, amount);
    }
}
