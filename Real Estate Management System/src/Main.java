import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/realestate";
        String username = "root";
        String password = "shreyas@123_g";

        try (Scanner scanner = new Scanner(System.in)) {
            Connection connection = DriverManager.getConnection(url, username, password);
            PropertyService propertyService = new PropertyService(connection);
            UserService userService = new UserService(connection);
            TransactionService transactionService = new TransactionService(connection);

            // Adding sample property
            System.out.println("Enter property details:");
            System.out.print("Address: ");
            String address = scanner.nextLine();
            System.out.print("Type: ");
            String type = scanner.nextLine();
            System.out.print("Price: ");
            double price = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            System.out.print("Status: ");
            String status = scanner.nextLine();
            Property property = new Property(0, address, type, price, status);
            propertyService.addProperty(property);

            // Adding sample user
            System.out.println("Enter user details:");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Password: ");
            String userPassword = scanner.nextLine();
            System.out.print("Role: ");
            String role = scanner.nextLine();
            User user = new User(0, name, email, userPassword, role);
            userService.addUser(user);

            // Adding sample transaction
            System.out.println("Enter transaction details:");
            System.out.print("User ID: ");
            int userId = scanner.nextInt();
            System.out.print("Property ID: ");
            int propertyId = scanner.nextInt();
            System.out.print("Agent ID: ");
            int agentId = scanner.nextInt();
            System.out.print("Amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            System.out.print("Date (YYYY-MM-DD): ");
            String date = scanner.nextLine();
            Transaction transaction = new Transaction(0, userId, propertyId, agentId, amount, date);
            transactionService.addTransaction(transaction);

            // Searching properties
            System.out.println("Enter search criteria:");
            System.out.print("Type: ");
            String searchType = scanner.nextLine();
            System.out.print("Min Price: ");
            double minPrice = scanner.nextDouble();
            System.out.print("Max Price: ");
            double maxPrice = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            List<Property> properties = propertyService.searchProperties(searchType, minPrice, maxPrice);
            for (Property p : properties) {
                System.out.println("Found property: " + p.getAddress());
            }

            // Getting transactions
            System.out.println("Transactions:");
            List<Transaction> transactions = transactionService.getTransactions();
            for (Transaction t : transactions) {
                System.out.println("Transaction amount: " + t.getAmount());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
