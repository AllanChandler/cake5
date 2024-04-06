package app.persistence;

import app.entities.Order;
import app.exceptions.DatabaseException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerMapper {
    public static List<Order> getCustomer(ConnectionPool connectionPool) throws DatabaseException {
        List<Order> customerList = new ArrayList<>();
        String sql = "SELECT * FROM public.order;";

        try (
                Connection connection = connectionPool.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {
                int orderId = rs.getInt("order_id");
                int antal = rs.getInt("antal");
                double sum = rs.getDouble("sum");
                int userId = rs.getInt("user_id");

                // Create the Order object with the fetched data
                Order order = new Order(orderId, antal, sum, userId);
                customerList.add(order);
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error retrieving customer orders: " + e.getMessage());
        }
        return customerList;
    }

    public void deleteOrderAndOrderLinesByOrderId(ConnectionPool connectionPool, int orderId) {
        String deleteOrderLinesSql = "DELETE FROM orderline WHERE order_id = ?";
        String deleteOrderSql = "DELETE FROM \"order\" WHERE order_id = ?";

        try (
                Connection connection = connectionPool.getConnection();
                PreparedStatement psOrderLines = connection.prepareStatement(deleteOrderLinesSql);
                PreparedStatement psOrder = connection.prepareStatement(deleteOrderSql)
        ) {
            // First, delete order lines associated with the order
            psOrderLines.setInt(1, orderId);
            psOrderLines.executeUpdate();

            // Then, delete the order itself
            psOrder.setInt(1, orderId);
            psOrder.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

