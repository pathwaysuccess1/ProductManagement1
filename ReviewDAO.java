package dao;

import model.Review;
import utils.ConnectDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAO {
    private ConnectDB db;

    public ReviewDAO() {
        this.db = new ConnectDB();
    }

    public void addReview(Review review) {
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                 "INSERT INTO customer_reviews (account, productId, rating, comment) VALUES (?, ?, ?, ?)")) {
            stmt.setString(1, review.getAccount());
            stmt.setString(2, review.getProductId());
            stmt.setInt(3, review.getRating());
            stmt.setString(4, review.getComment());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Review> getReviewsByProduct(String productId) {
        List<Review> reviews = new ArrayList<>();
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                 "SELECT * FROM customer_reviews WHERE productId = ?")) {
            stmt.setString(1, productId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                reviews.add(new Review(
                    rs.getInt("id"),
                    rs.getString("account"),
                    rs.getString("productId"),
                    rs.getInt("rating"),
                    rs.getString("comment"),
                    rs.getString("review_date")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reviews;
    }
}