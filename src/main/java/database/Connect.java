package database;

import java.sql.*;

public class Connect {
    public static void connect() {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            System.out.println("Connection to MSSQLSERVER02 has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    public static void method()
    {
        connect();
    }
}


