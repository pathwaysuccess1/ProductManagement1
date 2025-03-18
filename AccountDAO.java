package dao;

import model.Account;
import utils.ConnectDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO implements Accessible<Account> {
    private ConnectDB db;

    public AccountDAO() {
        this.db = new ConnectDB();
    }

    @Override
    public int insertRec(Account obj) {
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                 "INSERT INTO accounts (account, pass, lastName, firstName, birthday, gender, phone, isUse, roleInSystem) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
            stmt.setString(1, obj.getAccount());
            stmt.setString(2, obj.getPass());
            stmt.setString(3, obj.getLastName());
            stmt.setString(4, obj.getFirstName());
            stmt.setString(5, obj.getBirthday());
            stmt.setBoolean(6, obj.isGender());
            stmt.setString(7, obj.getPhone());
            stmt.setBoolean(8, obj.isUse());
            stmt.setString(9, obj.getRoleInSystem());
            return stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int updateRec(Account obj) {
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                 "UPDATE accounts SET pass = ?, lastName = ?, firstName = ?, birthday = ?, gender = ?, phone = ?, isUse = ?, roleInSystem = ?, sessionId = ? WHERE account = ?")) {
            stmt.setString(1, obj.getPass());
            stmt.setString(2, obj.getLastName());
            stmt.setString(3, obj.getFirstName());
            stmt.setString(4, obj.getBirthday());
            stmt.setBoolean(5, obj.isGender());
            stmt.setString(6, obj.getPhone());
            stmt.setBoolean(7, obj.isUse());
            stmt.setString(8, obj.getRoleInSystem());
            stmt.setString(9, obj.getSessionId());
            stmt.setString(10, obj.getAccount());
            return stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int deleteRec(Account obj) {
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM accounts WHERE account = ?")) {
            stmt.setString(1, obj.getAccount());
            return stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public Account getObjectById(String id) {
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM accounts WHERE account = ?")) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Account acc = new Account(
                    rs.getString("account"),
                    rs.getString("pass"),
                    rs.getString("lastName"),
                    rs.getString("firstName"),
                    rs.getString("birthday"),
                    rs.getBoolean("gender"),
                    rs.getString("phone"),
                    rs.getBoolean("isUse"),
                    rs.getString("roleInSystem")
                );
                acc.setSessionId(rs.getString("sessionId"));
                return acc;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Account> listAll() {
        List<Account> accounts = new ArrayList<>();
        try (Connection conn = db.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM accounts")) {
            while (rs.next()) {
                Account acc = new Account(
                    rs.getString("account"),
                    rs.getString("pass"),
                    rs.getString("lastName"),
                    rs.getString("firstName"),
                    rs.getString("birthday"),
                    rs.getBoolean("gender"),
                    rs.getString("phone"),
                    rs.getBoolean("isUse"),
                    rs.getString("roleInSystem")
                );
                acc.setSessionId(rs.getString("sessionId"));
                accounts.add(acc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accounts;
    }

    public List<Account> searchByName(String name) {
        List<Account> accounts = new ArrayList<>();
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                 "SELECT * FROM accounts WHERE firstName LIKE ? OR lastName LIKE ?")) {
            stmt.setString(1, "%" + name + "%");
            stmt.setString(2, "%" + name + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Account acc = new Account(
                    rs.getString("account"),
                    rs.getString("pass"),
                    rs.getString("lastName"),
                    rs.getString("firstName"),
                    rs.getString("birthday"),
                    rs.getBoolean("gender"),
                    rs.getString("phone"),
                    rs.getBoolean("isUse"),
                    rs.getString("roleInSystem")
                );
                acc.setSessionId(rs.getString("sessionId"));
                accounts.add(acc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accounts;
    }

    public Account loginAccount(String account, String pass) {
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM accounts WHERE account = ? AND pass = ?")) {
            stmt.setString(1, account);
            stmt.setString(2, pass);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Account acc = new Account(
                    rs.getString("account"),
                    rs.getString("pass"),
                    rs.getString("lastName"),
                    rs.getString("firstName"),
                    rs.getString("birthday"),
                    rs.getBoolean("gender"),
                    rs.getString("phone"),
                    rs.getBoolean("isUse"),
                    rs.getString("roleInSystem")
                );
                acc.setSessionId(rs.getString("sessionId"));
                return acc;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}