package database;

import knight.Knight;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update
{
    public void UpdateKnight(Knight elem)
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            //System.out.println("Connection to MSSQLSERVER02 for DeleteHelmetList established");
            String SqlQuery = "UPDATE dbo.Knight SET AvailableMoney = " + "'"  + elem.getAvailable_money() + "'" +
                    " WHERE Name LIKE " + "'" + elem.getName() + "'" + " and Age = " + elem.getAge();
            System.out.println(SqlQuery);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            preparedStatement.execute();
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
    public void UpdateKnightMoney(String Login, double money,Knight elem)
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            //System.out.println("Connection to MSSQLSERVER02 for DeleteHelmetList established");
            String SqlQuery = "UPDATE dbo.KnightsList SET AvailableMoney = " + "'"  + money + "'" +
                    " WHERE Name LIKE " + "'" + elem.getName() + "'" + " and Age = " + elem.getAge() + " and Login = '" + Login + "'";
            System.out.println(SqlQuery);
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            preparedStatement.execute();
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
}
