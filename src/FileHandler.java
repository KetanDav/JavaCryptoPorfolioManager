import java.io.*;
import java.util.ArrayList;

public class FileHandler {
    public static void savePortfolio(Portfolio portfolio, String username) {
        String filePath = "data/portfolio_" + username + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (CryptoAsset asset : portfolio.assets) {
                writer.write(asset.toString());
                writer.newLine();
            }
            System.out.println("Portfolio saved successfully for user: " + username);
        } catch (IOException e) {
            System.out.println("Error saving portfolio: " + e.getMessage());
        }
    }

    public static Portfolio loadPortfolio(String username) {
        Portfolio portfolio = new Portfolio();
        String filePath = "data/portfolio_" + username + ".txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                String name = parts[0].split(": ")[1];
                double amount = Double.parseDouble(parts[1].split(": ")[1]);
                portfolio.assets.add(new CryptoAsset(name, amount));
            }
            System.out.println("Portfolio loaded successfully for user: " + username);
        } catch (IOException e) {
            System.out.println("Error loading portfolio: " + e.getMessage());
        }
        return portfolio;
    }
}
