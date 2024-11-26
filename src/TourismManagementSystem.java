package src;
import java.sql.*;

public class TourismManagementSystem {
    public void addTour(String name, String location, double price, int seats) {
        String query = "INSERT INTO tours (name, location, price, available_seats) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, location);
            stmt.setDouble(3, price);
            stmt.setInt(4, seats);
            stmt.executeUpdate();
            System.out.println("Tour added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error adding tour.");
        }
    }

    public void viewTours() {
        String query = "SELECT * FROM tours";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            if (!rs.isBeforeFirst()) {
                System.out.println("No tours available.");
                return;
            }
            while (rs.next()) {
                System.out.printf("Tour ID: %d, Name: %s, Location: %s, Price: %.2f, Available Seats: %d%n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("location"),
                        rs.getDouble("price"),
                        rs.getInt("available_seats"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error retrieving tours.");
        }
    }

    public void bookTour(int id) {
        String query = "UPDATE tours SET available_seats = available_seats - 1 WHERE id = ? AND available_seats > 0";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Tour booked successfully!");
            } else {
                System.out.println("No seats available or tour not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error booking tour.");
        }
    }
}
