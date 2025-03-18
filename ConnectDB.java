package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.ServletContext;

public class ConnectDB {
    private String hostName;
    private String port;
    private String instance;
    private String dbName;
    private String user;
    private String pass;

    public ConnectDB() {
        this.hostName = "localhost";
        this.port = "1433";
        this.instance = "UYHPAHN\\SQL";
        this.dbName = "ProductIntro";
        this.user = "sa";
        this.pass = "123";
    }

    public ConnectDB(ServletContext sc) {
        this.hostName = sc.getInitParameter("hostAddress");
        this.port = sc.getInitParameter("dbPort");
        this.instance = sc.getInitParameter("instance");
        this.dbName = sc.getInitParameter("dbName");
        this.user = sc.getInitParameter("userName");
        this.pass = sc.getInitParameter("userPass");
    }

    public String getURLString() {
        String fm = "jdbc:sqlserver://%s\\%s:%s;databaseName=%s;user=%s;password=%s";
        return String.format(fm, this.hostName, this.instance.trim(), this.port, this.dbName, this.user, this.pass);
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        String url = getURLString();
        System.out.println("Attempting to connect with URL: " + url);
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url);
    }
}