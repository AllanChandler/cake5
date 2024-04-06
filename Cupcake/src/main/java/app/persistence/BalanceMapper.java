package app.persistence;

import app.exceptions.DatabaseException;
import java.sql.*;
public class BalanceMapper {
    public static void addBalance(String email, int balance, ConnectionPool connectionPool) throws DatabaseException {

        String sql = "UPDATE public.users SET balance = balance + ? WHERE email = ?";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, balance);
            ps.setString(2, email);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected != 1) {
                throw new DatabaseException("An error occurred while updating the user's balance");
            }

        } catch (SQLException e) {
            String msg = "An error occurred while adding credit to the user's account. Please try again.";
            throw new DatabaseException(msg, e.getMessage());
        }

    }
}
