import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PropertyService {
    private PropertyDAO propertyDAO;

    public PropertyService(Connection connection) {
        this.propertyDAO = new PropertyDAO(connection);
    }

    public void addProperty(Property property) {
        try {
            propertyDAO.addProperty(property);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Property> searchProperties(String type, double minPrice, double maxPrice) {
        try {
            return propertyDAO.searchProperties(type, minPrice, maxPrice);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
