import java.util.ArrayList;
import java.util.Scanner;

public class Portfolio {
    ArrayList<CryptoAsset> assets;

    public Portfolio() {
        this.assets = new ArrayList<>();
    }

    public void addAsset() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter asset name: ");
        String name = scanner.nextLine();
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        assets.add(new CryptoAsset(name, amount));
        System.out.println("Asset added successfully!");
    }

    public void viewPortfolio() {
        if (assets.isEmpty()) {
            System.out.println("Portfolio is empty.");
            return;
        }
        System.out.println("\nCurrent Portfolio:");
        for (CryptoAsset asset : assets) {
            System.out.println(asset);
        }
    }
}
