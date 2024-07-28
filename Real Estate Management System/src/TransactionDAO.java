import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAO {
    private Connection connection;

    public TransactionDAO(Connection connection) {
        this.connection = connection;
    }

    public void addTransaction(Transaction transaction) throws SQLException {
        String query = "INSERT INTO transactions (property_id, buyer_id, seller_id, amount, date) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, transaction.getPropertyId());
        statement.setInt(2, transaction.getBuyerId());
        statement.setInt(3, transaction.getSellerId());
        statement.setDouble(4, transaction.getAmount());
        statement.setString(5, transaction.getDate());
        statement.executeUpdate();
    }

    public List<Transaction> getTransactions() throws SQLException {
        String query = "SELECT * FROM transactions";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        List<Transaction> transactions = new ArrayList<>();
        while (resultSet.next()) {
            Transaction transaction = new Transaction(
                    resultSet.getInt("id"),
                    resultSet.getInt("property_id"),
                    resultSet.getInt("buyer_id"),
                    resultSet.getInt("seller_id"),
                    resultSet.getDouble("amount"),
                    resultSet.getString("date"));
            transactions.add(transaction);
        }
        return transactions;
    }
}
