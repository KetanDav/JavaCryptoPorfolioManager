import java.util.Scanner;

public class CryptoPortfolioManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User user = new User();

        // Prompt for user registration if authentication fails
        if (!user.authenticate()) {
            System.out.println("Authentication failed. Would you like to register? (yes/no)");
            String response = scanner.next();
            if (response.equalsIgnoreCase("yes")) {
                User.registerUser();
                System.out.println("Please restart the application to log in.");
                return;
            } else {
                System.out.println("Exiting...");
                return;
            }
        }

        String username = user.getUsername();
        Portfolio portfolio = FileHandler.loadPortfolio(username);

        while (true) {
            System.out.println("\nWelcome to Crypto Portfolio Manager!");
            System.out.println("1. Add Asset");
            System.out.println("2. View Portfolio");
            System.out.println("3. Save Portfolio");
            System.out.println("4. Load Portfolio");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    portfolio.addAsset();
                    break;
                case 2:
                    portfolio.viewPortfolio();
                    break;
                case 3:
                    FileHandler.savePortfolio(portfolio, username);
                    break;
                case 4:
                    portfolio = FileHandler.loadPortfolio(username);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
