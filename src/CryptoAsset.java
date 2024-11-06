public class CryptoAsset {
    private String name;
    private double amount;

    public CryptoAsset(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Asset: " + name + ", Amount: " + amount;
    }
}
