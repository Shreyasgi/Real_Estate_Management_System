import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TransactionService {
    private TransactionDAO transactionDAO;

    public TransactionService(Connection connection) {
        this.transactionDAO = new TransactionDAO(connection);
    }

    public void addTransaction(Transaction transaction) {
        try {
            transactionDAO.addTransaction(transaction);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Transaction> getTransactions() {
        try {
            return transactionDAO.getTransactions();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
