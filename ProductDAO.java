package dao;

import model.Product;
import utils.ConnectDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements Accessible<Product> {
    private ConnectDB db;

    public ProductDAO() {
        this.db = new ConnectDB();
    }

    @Override
    public int insertRec(Product obj) {
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                 "INSERT INTO products (productId, productName, productImage, brief, typeId, account, unit, price, discount) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
            stmt.setString(1, obj.getProductId());
            stmt.setString(2, obj.getProductName());
            stmt.setString(3, obj.getProductImage());
            stmt.setString(4, obj.getBrief());
            stmt.setInt(5, obj.getTypeId());
            stmt.setString(6, obj.getAccount());
            stmt.setString(7, obj.getUnit());
            stmt.setInt(8, obj.getPrice());
            stmt.setInt(9, obj.getDiscount());
            return stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int updateRec(Product obj) {
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                 "UPDATE products SET productName = ?, productImage = ?, brief = ?, typeId = ?, account = ?, unit = ?, price = ?, discount = ? WHERE productId = ?")) {
            stmt.setString(1, obj.getProductName());
            stmt.setString(2, obj.getProductImage());
            stmt.setString(3, obj.getBrief());
            stmt.setInt(4, obj.getTypeId());
            stmt.setString(5, obj.getAccount());
            stmt.setString(6, obj.getUnit());
            stmt.setInt(7, obj.getPrice());
            stmt.setInt(8, obj.getDiscount());
            stmt.setString(9, obj.getProductId());
            return stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int deleteRec(Product obj) {
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM products WHERE productId = ?")) {
            stmt.setString(1, obj.getProductId());
            return stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public Product getObjectById(String id) {
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM products WHERE productId = ?")) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Product(
                    rs.getString("productId"),
                    rs.getString("productName"),
                    rs.getString("productImage"),
                    rs.getString("brief"),
                    rs.getString("postedDate"),
                    rs.getInt("typeId"),
                    rs.getString("account"),
                    rs.getString("unit"),
                    rs.getInt("price"),
                    rs.getInt("discount")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Product> listAll() {
        return getFilteredProducts(null, null, null, null, null);
    }

    public List<Product> getProductsByCategory(int typeId) {
        return getFilteredProducts(null, typeId, null, null, null);
    }

    public List<Product> searchByName(String name) {
        return getFilteredProducts(name, null, null, null, null);
    }

    public List<Product> getFilteredProducts(String name, Integer typeId, Integer minPrice, Integer maxPrice, String sortBy) {
        List<Product> products = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT * FROM products WHERE 1=1");
        if (name != null && !name.isEmpty()) sql.append(" AND productName LIKE ?");
        if (typeId != null) sql.append(" AND typeId = ?");
        if (minPrice != null) sql.append(" AND price >= ?");
        if (maxPrice != null) sql.append(" AND price <= ?");
        if (sortBy != null && !sortBy.isEmpty()) sql.append(" ORDER BY " + sortBy);

        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql.toString())) {
            int paramIndex = 1;
            if (name != null && !name.isEmpty()) stmt.setString(paramIndex++, "%" + name + "%");
            if (typeId != null) stmt.setInt(paramIndex++, typeId);
            if (minPrice != null) stmt.setInt(paramIndex++, minPrice);
            if (maxPrice != null) stmt.setInt(paramIndex++, maxPrice);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                products.add(new Product(
                    rs.getString("productId"),
                    rs.getString("productName"),
                    rs.getString("productImage"),
                    rs.getString("brief"),
                    rs.getString("postedDate"),
                    rs.getInt("typeId"),
                    rs.getString("account"),
                    rs.getString("unit"),
                    rs.getInt("price"),
                    rs.getInt("discount")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    public List<Product> getViewedProducts(String account) {
        List<Product> products = new ArrayList<>();
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                 "SELECT p.* FROM customer_views cv JOIN products p ON cv.productId = p.productId WHERE cv.account = ?")) {
            stmt.setString(1, account);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                products.add(new Product(
                    rs.getString("productId"),
                    rs.getString("productName"),
                    rs.getString("productImage"),
                    rs.getString("brief"),
                    rs.getString("postedDate"),
                    rs.getInt("typeId"),
                    rs.getString("account"),
                    rs.getString("unit"),
                    rs.getInt("price"),
                    rs.getInt("discount")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    public void addView(String account, String productId) {
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                 "INSERT INTO customer_views (account, productId) VALUES (?, ?)")) {
            stmt.setString(1, account);
            stmt.setString(2, productId);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getIncomeSegment(String account) {
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                 "SELECT AVG(p.price) as avgPrice FROM customer_views cv JOIN products p ON cv.productId = p.productId WHERE cv.account = ?")) {
            stmt.setString(1, account);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                double avgPrice = rs.getDouble("avgPrice");
                if (avgPrice < 5000000) return "Thu nhập thấp";
                else if (avgPrice <= 15000000) return "Thu nhập trung bình";
                else return "Thu nhập cao";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Chưa xác định";
    }
}