package dao;

import model.Category;
import utils.ConnectDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO implements Accessible<Category> {
    private ConnectDB db;

    public CategoryDAO() {
        this.db = new ConnectDB();
    }

    @Override
    public int insertRec(Category obj) {
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                 "INSERT INTO categories (categoryName, memo) VALUES (?, ?)")) {
            stmt.setString(1, obj.getCategoryName());
            stmt.setString(2, obj.getMemo());
            return stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int updateRec(Category obj) {
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                 "UPDATE categories SET categoryName = ?, memo = ? WHERE typeId = ?")) {
            stmt.setString(1, obj.getCategoryName());
            stmt.setString(2, obj.getMemo());
            stmt.setInt(3, obj.getTypeId());
            return stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int deleteRec(Category obj) {
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM categories WHERE typeId = ?")) {
            stmt.setInt(1, obj.getTypeId());
            return stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public Category getObjectById(String id) {
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM categories WHERE typeId = ?")) {
            stmt.setInt(1, Integer.parseInt(id));
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Category(
                    rs.getInt("typeId"),
                    rs.getString("categoryName"),
                    rs.getString("memo")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Category> listAll() {
        List<Category> categories = new ArrayList<>();
        try (Connection conn = db.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM categories")) {
            while (rs.next()) {
                categories.add(new Category(
                    rs.getInt("typeId"),
                    rs.getString("categoryName"),
                    rs.getString("memo")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categories;
    }

    public List<Category> searchByName(String name) {
        List<Category> categories = new ArrayList<>();
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                 "SELECT * FROM categories WHERE categoryName LIKE ?")) {
            stmt.setString(1, "%" + name + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                categories.add(new Category(
                    rs.getInt("typeId"),
                    rs.getString("categoryName"),
                    rs.getString("memo")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categories;
    }
}