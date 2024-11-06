import java.io.*;
import java.util.Scanner;

public class User {
    private String username;
    private String password;
    // Assuming the data folder is in the root project directory, outside of src.
    private static final String USER_DATA_FILE = "data" + File.separator + "users.csv";

    public String getUsername() {
        return username;
    }

    public boolean authenticate() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        username = scanner.nextLine();
        System.out.print("Enter password: ");
        password = scanner.nextLine();

        return verifyCredentials();
    }

    public static void registerUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a new username: ");
        String username = scanner.nextLine();
        System.out.print("Enter a new password: ");
        String password = scanner.nextLine();

        // Ensure the directory exists (adjusted for the root directory)
        File directory = new File("data");
        if (!directory.exists()) {
            if (directory.mkdir()) {
                System.out.println("Created directory: data");
            } else {
                System.out.println("Error: Could not create directory 'data'");
                return;
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USER_DATA_FILE, true))) {
            writer.write(username + "," + password);
            writer.newLine();
            System.out.println("User registered successfully!");
        } catch (IOException e) {
            System.out.println("Error saving user data: " + e.getMessage());
        }
    }

    private boolean verifyCredentials() {
        try (BufferedReader reader = new BufferedReader(new FileReader(USER_DATA_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] credentials = line.split(",");
                if (credentials.length == 2 && credentials[0].equals(username) && credentials[1].equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading user data: " + e.getMessage());
        }
        return false;
    }
}
