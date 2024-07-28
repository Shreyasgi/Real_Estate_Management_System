import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PropertyDAO {
    private Connection connection;

    public PropertyDAO(Connection connection) {
        this.connection = connection;
    }

    public void addProperty(Property property) throws SQLException {
        String query = "INSERT INTO properties (address, type, price, status) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, property.getAddress());
        statement.setString(2, property.getType());
        statement.setDouble(3, property.getPrice());
        statement.setString(4, property.getStatus());
        statement.executeUpdate();
    }

    public List<Property> searchProperties(String type, double minPrice, double maxPrice) throws SQLException {
        String query = "SELECT * FROM properties WHERE type = ? AND price BETWEEN ? AND ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, type);
        statement.setDouble(2, minPrice);
        statement.setDouble(3, maxPrice);
        ResultSet resultSet = statement.executeQuery();

        List<Property> properties = new ArrayList<>();
        while (resultSet.next()) {
            Property property = new Property(
                    resultSet.getInt("id"),
                    resultSet.getString("address"),
                    resultSet.getString("type"),
                    resultSet.getDouble("price"),
                    resultSet.getString("status"));
            properties.add(property);
        }
        return properties;
    }
}
