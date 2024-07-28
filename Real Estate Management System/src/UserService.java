import java.sql.Connection;
import java.sql.SQLException;

public class UserService {
    private UserDAO userDAO;

    public UserService(Connection connection) {
        this.userDAO = new UserDAO(connection);
    }

    public void addUser(User user) {
        try {
            userDAO.addUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUserByEmail(String email) {
        try {
            return userDAO.getUserByEmail(email);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
