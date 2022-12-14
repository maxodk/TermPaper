package database;

import equipment.*;
import javafx.collections.*;
import knight.Knight;
import weapon.*;

import java.sql.*;

public class Select
{
    public void SelectUsers()
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.Users";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            System.out.println(String.format("%30s %30s %30s","Email","Login","Password"));
            while(resultSet.next())
            {
                System.out.println(String.format("%30s %30s %30s",resultSet.getString(1),resultSet.getString(2),resultSet.getString(3)));
            }
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
    public void SelectKnights()
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.Knight";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            System.out.println(String.format("%30s %30s %30s","Name","Age","AvailableMoney"));
            while(resultSet.next())
            {
                System.out.println(String.format("%30s %30s %30s",resultSet.getString(1),resultSet.getString(2),resultSet.getString(3)));
            }
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
    public void SelectKnightEquip(int index)
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.KnightHelmets WHERE KnightId = " + index;
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            while(resultSet.next())
            {
                System.out.println(String.format("%30s %30s %30s",resultSet.getString(1),resultSet.getString(2),resultSet.getString(3)));
            }
            statement = conn.createStatement();
            SqlQuery = "SELECT * FROM dbo.KnightBreastplate WHERE KnightId = " + index;
            resultSet = statement.executeQuery(SqlQuery);
            while(resultSet.next())
            {
                System.out.println(String.format("%30s %30s %30s",resultSet.getString(1),resultSet.getString(2),resultSet.getString(3)));
            }
            statement = conn.createStatement();
            SqlQuery = "SELECT * FROM dbo.KnightBoots WHERE KnightId = " + index;
            resultSet = statement.executeQuery(SqlQuery);
            while(resultSet.next())
            {
                System.out.println(String.format("%30s %30s %30s",resultSet.getString(1),resultSet.getString(2),resultSet.getString(3)));
            }
            statement = conn.createStatement();
            SqlQuery = "SELECT * FROM dbo.KnightShield WHERE KnightId = " + index;
            resultSet = statement.executeQuery(SqlQuery);
            while(resultSet.next())
            {
                System.out.println(String.format("%30s %30s %30s",resultSet.getString(1),resultSet.getString(2),resultSet.getString(3)));
            }

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
    public boolean SelectUser(String email,String login,String password)
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.Users WHERE Email = " + "'" + email + "'" + " and Login = " + "'" + login + "'" + " and Password = " + "'" + password + "'";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            if(resultSet.next())
            {
                return true;
            }
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
        return false;
    }
    public String SelectLogin()
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.ActiveUser ";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            String login = null;
            while (resultSet.next())
            {
                login = resultSet.getString("Login");
            }
            System.out.println(login);
            return  login;
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
        return "";
    }
    public ObservableList<Helmet> HelmetList() {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        ObservableList<Helmet> list = FXCollections.observableArrayList();
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url, "Maks", "1111");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.HelmetList ";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            double cost;
            double weight;
            String material;
            double strength;
            String type;
            while (resultSet.next()) {
                cost = resultSet.getDouble("Cost");
                weight = resultSet.getDouble("Weightt");
                material = resultSet.getString("Material");
                strength = resultSet.getDouble("Streingth");
                type = resultSet.getString("Typeofarmoring");
                Helmet helmet = new Helmet(cost,weight,material,strength,type);
                list.add(helmet);
            }
            return list;
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
        return list;
    }
    public ObservableList<Breastplate> BreastplateList() {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        ObservableList<Breastplate> list = FXCollections.observableArrayList();
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url, "Maks", "1111");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.BreastplateList ";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            double cost;
            double weight;
            String material;
            double strength;
            String armor;
            while (resultSet.next()) {
                cost = resultSet.getDouble("Cost");
                weight = resultSet.getDouble("Weightt");
                material = resultSet.getString("Material");
                strength = resultSet.getDouble("Streingth");
                armor = resultSet.getString("Armor");
                Breastplate breastplate = new Breastplate(cost,weight,material,strength,armor);
                list.add(breastplate);
            }
            return list;
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
        return list;
    }
    public ObservableList<Boots> BootsList() {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        ObservableList<Boots> list = FXCollections.observableArrayList();
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url, "Maks", "1111");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.BootsList ";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            double cost;
            double weight;
            String material;
            double strength;
            boolean isGaiters;
            while (resultSet.next()) {
                cost = resultSet.getDouble("Cost");
                weight = resultSet.getDouble("Weightt");
                material = resultSet.getString("Material");
                strength = resultSet.getDouble("Streingth");
                isGaiters = resultSet.getBoolean("IsGaiters");
                Boots boots = new Boots(cost,weight,material,strength,isGaiters);
                list.add(boots);
            }
            return list;
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
        return list;
    }
    public ObservableList<Shield> ShieldList() {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        ObservableList<Shield> list = FXCollections.observableArrayList();
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url, "Maks", "1111");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.ShieldList ";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            double cost;
            double weight;
            String material;
            double strength;
            boolean isCrooked;
            double protection;
            while (resultSet.next()) {
                cost = resultSet.getDouble("Cost");
                weight = resultSet.getDouble("Weightt");
                material = resultSet.getString("Material");
                strength = resultSet.getDouble("Streingth");
                isCrooked = resultSet.getBoolean("IsCrooked");
                protection = resultSet.getDouble("Sharpness");
                Shield shield = new Shield(cost,weight,material,strength,isCrooked,protection);
                list.add(shield);
            }
            return list;
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
        return list;
    }
    public boolean isKnightId(int knightid)
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.KnightEquipment WHERE KnightId = " + knightid;
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            if(resultSet.next())
            {
                return false;
            }
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
        return true;
    }
    public ObservableList<Knight> SelectKnights(String login)
    {
        ObservableList<Knight> list = FXCollections.observableArrayList();
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.KnightsList WHERE Login = " + "'" + login + "'";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            String name;
            int age;
            double money;
            while (resultSet.next())
            {
                name = resultSet.getString("Name");
                age = resultSet.getInt("Age");
                money = resultSet.getDouble("AvailableMoney");
                list.add(new Knight(name,age,money));
            }
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
        return list;
    }
    public boolean isEquip(int knightid,String Login)
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.KnightHelmetList WHERE KnightId = " + knightid + " and Login = '" + Login + "'";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            if(resultSet.next())
            {
                return false;
            }
            SqlQuery = "SELECT * FROM dbo.KnightBreastplateList WHERE KnightId = " + knightid + " and Login = '" + Login + "'";
            resultSet = statement.executeQuery(SqlQuery);
            if(resultSet.next())
            {
                return false;
            }
            SqlQuery = "SELECT * FROM dbo.KnightBootsList WHERE KnightId = " + knightid + " and Login = '" + Login + "'";
            resultSet = statement.executeQuery(SqlQuery);
            if(resultSet.next())
            {
                return false;
            }
            SqlQuery = "SELECT * FROM dbo.KnightShieldList WHERE KnightId = " + knightid + " and Login = '" + Login + "'";
            resultSet = statement.executeQuery(SqlQuery);
            if(resultSet.next())
            {
                return false;
            }
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
        return true;
    }
    public double GetKnightMoney(int knightId ,String login)
    {
        double money = 0;
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.KnightsList WHERE Login = '"  + login + "'";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            int ch = 0;
            while (resultSet.next())
            {
                if(ch == knightId - 1)
                {
                    money = resultSet.getDouble("AvailableMoney");
                    break;
                }
                ch++;
            }
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
        return money;
    }
    public Knight GetKnight(int knightId,String login)
    {
        Knight knight = null;
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.KnightsList WHERE Login = '"  + login + "'";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            int ch = 0;
            String name;
            int age;
            double money;
            while (resultSet.next())
            {
                if(ch == knightId - 1)
                {
                    name = resultSet.getString("Name");
                    age = resultSet.getInt("Age");
                    money = resultSet.getDouble("AvailableMoney");
                    knight = new Knight(name,age,money);
                    break;
                }
                ch++;
            }
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
        return knight;
    }
    public double GetHelmetMoney(int Id)
    {
        double money = 0;
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.HelmetList";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            int ch = 0;
            while (resultSet.next())
            {
                if(ch == Id - 1)
                {
                    money = resultSet.getDouble("Cost");
                    break;
                }
                ch++;
            }
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
        return money;
    }
    public double GetBreastplateMoney(int Id)
    {
        double money = 0;
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.BreastplateList";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            int ch = 250;
            while (resultSet.next())
            {
                if(ch == Id - 1)
                {
                    money = resultSet.getDouble("Cost");
                    break;
                }
                ch++;
            }
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
        return money;
    }
    public double GetBootsMoney(int Id)
    {
        double money = 0;
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.BootsList";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            int ch = 500;
            while (resultSet.next())
            {
                if(ch == Id - 1)
                {
                    money = resultSet.getDouble("Cost");
                    break;
                }
                ch++;
            }
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
        return money;
    }
    public double GetShieldMoney(int Id)
    {
        double money = 0;
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.ShieldList";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            int ch = 750;
            while (resultSet.next())
            {
                if(ch == Id - 1)
                {
                    money = resultSet.getDouble("Cost");
                    break;
                }
                ch++;
            }
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
        return money;
    }
    public ObservableList<Bow> BowList() {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        ObservableList<Bow> list = FXCollections.observableArrayList();
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url, "Maks", "1111");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.BowList ";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            double cost;
            double weight;
            String type;
            double strength;
            int count;
            boolean islong;
            while (resultSet.next()) {
                cost = resultSet.getDouble("Cost");
                weight = resultSet.getDouble("Weightt");
                type = resultSet.getString("Type");
                strength = resultSet.getDouble("Strength");
                count = resultSet.getInt("CountOfArrows");
                islong = resultSet.getBoolean("IsLong");
                Bow bow = new Bow(cost,weight,type,strength,count,islong);
                list.add(bow);
            }
            return list;
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
        return list;
    }
    public ObservableList<HeavyWeapon> HeavyWeaponList() {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        ObservableList<HeavyWeapon> list = FXCollections.observableArrayList();
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url, "Maks", "1111");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.HeavyWeaponList ";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            double cost;
            double weight;
            String type;
            double strength;
            boolean isSpiked;
            while (resultSet.next()) {
                cost = resultSet.getDouble("Cost");
                weight = resultSet.getDouble("Weightt");
                type = resultSet.getString("Type");
                strength = resultSet.getDouble("Strength");
                isSpiked = resultSet.getBoolean("IsSpiked");
                HeavyWeapon heavyWeapon = new HeavyWeapon(cost,weight,type,strength,isSpiked);
                list.add(heavyWeapon);
            }
            return list;
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
        return list;
    }
    public ObservableList<Spear> SpearList() {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        ObservableList<Spear> list = FXCollections.observableArrayList();
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url, "Maks", "1111");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.SpearList ";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            double cost;
            double weight;
            String type;
            double strength;
            double length;
            while (resultSet.next()) {
                cost = resultSet.getDouble("Cost");
                weight = resultSet.getDouble("Weightt");
                type = resultSet.getString("Type");
                strength = resultSet.getDouble("Strength");
                length = resultSet.getDouble("Length");
                Spear spear = new Spear(cost,weight,type,strength,length);
                list.add(spear);
            }
            return list;
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
        return list;
    }
    public ObservableList<Sword> SwordList() {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        ObservableList<Sword> list = FXCollections.observableArrayList();
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url, "Maks", "1111");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.SwordList ";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            double cost;
            double weight;
            String type;
            double strength;
            boolean isCrooked;
            double sharpness;
            while (resultSet.next())
            {
                cost = resultSet.getDouble("Cost");
                weight = resultSet.getDouble("Weightt");
                type = resultSet.getString("Type");
                strength = resultSet.getDouble("Strength");
                isCrooked = resultSet.getBoolean("IsCrooked");
                sharpness = resultSet.getDouble("Sharpness");
                Sword sword = new Sword(cost,weight,type,strength,isCrooked,sharpness);
                list.add(sword);
            }
            return list;
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
        return list;
    }
    public boolean isWeapon(int knightid,String Login)
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.KnightBowList WHERE KnightId = " + knightid + " and Login = '" + Login + "'";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            if(resultSet.next())
            {
                return false;
            }
            SqlQuery = "SELECT * FROM dbo.KnightHeavyWeaponList WHERE KnightId = " + knightid + " and Login = '" + Login + "'";
            resultSet = statement.executeQuery(SqlQuery);
            if(resultSet.next())
            {
                return false;
            }
            SqlQuery = "SELECT * FROM dbo.KnightSpearList WHERE KnightId = " + knightid + " and Login = '" + Login + "'";
            resultSet = statement.executeQuery(SqlQuery);
            if(resultSet.next())
            {
                return false;
            }
            SqlQuery = "SELECT * FROM dbo.KnightSwordList WHERE KnightId = " + knightid + " and Login = '" + Login + "'";
            resultSet = statement.executeQuery(SqlQuery);
            if(resultSet.next())
            {
                return false;
            }
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
        return true;
    }
    public double GetBowMoney(int Id)
    {
        double money = 0;
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.BowList";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            int ch = 0;
            while (resultSet.next())
            {
                if(ch == Id - 1)
                {
                    money = resultSet.getDouble("Cost");
                    break;
                }
                ch++;
            }
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
        return money;
    }
    public double GetHeavyWeaponMoney(int Id)
    {
        double money = 0;
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.HeavyWeaponList";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            int ch = 250;
            while (resultSet.next())
            {
                if(ch == Id - 1)
                {
                    money = resultSet.getDouble("Cost");
                    break;
                }
                ch++;
            }
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
        return money;
    }
    public double GetSpearMoney(int Id)
    {
        double money = 0;
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.SpearList";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            int ch = 500;
            while (resultSet.next())
            {
                if(ch == Id - 1)
                {
                    money = resultSet.getDouble("Cost");
                    break;
                }
                ch++;
            }
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
        return money;
    }
    public double GetSwordMoney(int Id)
    {
        double money = 0;
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.SwordList";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            int ch = 750;
            while (resultSet.next())
            {
                if(ch == Id - 1)
                {
                    money = resultSet.getDouble("Cost");
                    break;
                }
                ch++;
            }
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
        return money;
    }
    public boolean isHelmet(int knightid,String Login)
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.KnightHelmetList WHERE KnightId = " + knightid + " and Login = '" + Login + "'";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            if(resultSet.next())
            {
                return false;
            }
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
        return true;
    }
    public boolean isBreastplate(int knightid,String Login)
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.KnightBreastplateList WHERE KnightId = " + knightid + " and Login = '" + Login + "'";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            if(resultSet.next())
            {
                return false;
            }
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
        return true;
    }
    public boolean isBoots(int knightid,String Login)
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.KnightBootsList WHERE KnightId = " + knightid + " and Login = '" + Login + "'";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            if(resultSet.next())
            {
                return false;
            }
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
        return true;
    }
    public boolean isShield(int knightid,String Login)
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.KnightShieldList WHERE KnightId = " + knightid + " and Login = '" + Login + "'";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            if(resultSet.next())
            {
                return false;
            }
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
        return true;
    }
    public boolean isBow(int knightid,String Login)
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.KnightBowList WHERE KnightId = " + knightid + " and Login = '" + Login + "'";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            if(resultSet.next())
            {
                return false;
            }
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
        return true;
    }
    public boolean isHeavyWeapon(int knightid,String Login)
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.KnightHeavyWeaponList WHERE KnightId = " + knightid + " and Login = '" + Login + "'";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            if(resultSet.next())
            {
                return false;
            }
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
        return true;
    }
    public boolean isSpear(int knightid,String Login)
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.KnightSpearList WHERE KnightId = " + knightid + " and Login = '" + Login + "'";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            if(resultSet.next())
            {
                return false;
            }
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
        return true;
    }
    public boolean isSword(int knightid,String Login)
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.KnightSwordList WHERE KnightId = " + knightid + " and Login = '" + Login + "'";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            if(resultSet.next())
            {
                return false;
            }
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
        return true;
    }
    public ObservableList<Helmet> KnightHelmetList(int knightId)
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        ObservableList<Helmet> list = FXCollections.observableArrayList();
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url, "Maks", "1111");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.KnightHelmetList WHERE KnightId = " + knightId;
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            double cost;
            double weight;
            String material;
            double strength;
            String type;
            while (resultSet.next()) {
                cost = resultSet.getDouble("Cost");
                weight = resultSet.getDouble("Weightt");
                material = resultSet.getString("Material");
                strength = resultSet.getDouble("Strength");
                type = resultSet.getString("Typeofarmoring");
                Helmet helmet = new Helmet(cost,weight,material,strength,type);
                list.add(helmet);
            }
            return list;
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
        return list;
    }
    public ObservableList<Breastplate> KnightBreastplateList(int knightId) {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        ObservableList<Breastplate> list = FXCollections.observableArrayList();
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url, "Maks", "1111");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.KnightBreastplateList WHERE KnightId = " + knightId;
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            double cost;
            double weight;
            String material;
            double strength;
            String armor;
            while (resultSet.next()) {
                cost = resultSet.getDouble("Cost");
                weight = resultSet.getDouble("Weightt");
                material = resultSet.getString("Material");
                strength = resultSet.getDouble("Streingth");
                armor = resultSet.getString("Armor");
                Breastplate breastplate = new Breastplate(cost,weight,material,strength,armor);
                list.add(breastplate);
            }
            return list;
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
        return list;
    }
    public ObservableList<Boots> KnightBootsList(int knightId) {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        ObservableList<Boots> list = FXCollections.observableArrayList();
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url, "Maks", "1111");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.KnightBootsList WHERE KnightId = " + knightId;
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            double cost;
            double weight;
            String material;
            double strength;
            boolean isGaiters;
            while (resultSet.next()) {
                cost = resultSet.getDouble("Cost");
                weight = resultSet.getDouble("Weightt");
                material = resultSet.getString("Material");
                strength = resultSet.getDouble("Streingth");
                isGaiters = resultSet.getBoolean("IsGaiters");
                Boots boots = new Boots(cost,weight,material,strength,isGaiters);
                list.add(boots);
            }
            return list;
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
        return list;
    }
    public ObservableList<Shield> KnightShieldList(int knightId) {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        ObservableList<Shield> list = FXCollections.observableArrayList();
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url, "Maks", "1111");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.KnightShieldList WHERE KnightId = " + knightId;
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            double cost;
            double weight;
            String material;
            double strength;
            boolean isCrooked;
            double protection;
            while (resultSet.next()) {
                cost = resultSet.getDouble("Cost");
                weight = resultSet.getDouble("Weightt");
                material = resultSet.getString("Material");
                strength = resultSet.getDouble("Streingth");
                isCrooked = resultSet.getBoolean("IsCrooked");
                protection = resultSet.getDouble("Sharpness");
                Shield shield = new Shield(cost,weight,material,strength,isCrooked,protection);
                list.add(shield);
            }
            return list;
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
        return list;
    }
    public double GetKnightHelmetMoney(int knightId,String login)
    {
        double money = 0;
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.KnightHelmetList WHERE KnightId = " + knightId + " and Login = '" + login + "'";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            while (resultSet.next())
            {
                money = resultSet.getDouble("cost");
            }
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
        return money;
    }
    public double GetKnightBreastplateMoney(int knightId, String login)
    {
        double money = 0;
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.KnightBreastplateList WHERE KnightId = " + knightId + " and Login = '" + login + "'";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            while (resultSet.next())
            {
                money = resultSet.getDouble("cost");
            }
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
        return money;
    }
    public double GetKnightBootsMoney(int knightId, String login)
    {
        double money = 0;
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.KnightBootsList WHERE KnightId = " + knightId + " and Login = '" + login + "'";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            while (resultSet.next())
            {
                money = resultSet.getDouble("cost");
            }
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
        return money;
    }
    public double GetKnightShieldMoney(int knightId, String login)
    {
        double money = 0;
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.KnightShieldList WHERE KnightId = " + knightId + " and Login = '" + login + "'";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            while (resultSet.next())
            {
                money = resultSet.getDouble("cost");
            }
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
        return money;
    }
    public ObservableList<Bow> KnightBowList(int knightId) {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        ObservableList<Bow> list = FXCollections.observableArrayList();
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url, "Maks", "1111");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.KnightBowList WHERE KnightId = " + knightId;
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            double cost;
            double weight;
            String type;
            double strength;
            int count;
            boolean islong;
            while (resultSet.next()) {
                cost = resultSet.getDouble("Cost");
                weight = resultSet.getDouble("Weightt");
                type = resultSet.getString("Type");
                strength = resultSet.getDouble("Strength");
                count = resultSet.getInt("CountOfArrows");
                islong = resultSet.getBoolean("IsLong");
                Bow bow = new Bow(cost,weight,type,strength,count,islong);
                list.add(bow);
            }
            return list;
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
        return list;
    }
    public ObservableList<HeavyWeapon> KnightHeavyWeaponList(int knightId) {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        ObservableList<HeavyWeapon> list = FXCollections.observableArrayList();
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url, "Maks", "1111");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.KnightHeavyWeaponList WHERE KnightId = " + knightId;
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            double cost;
            double weight;
            String type;
            double strength;
            boolean isSpiked;
            while (resultSet.next()) {
                cost = resultSet.getDouble("Cost");
                weight = resultSet.getDouble("Weightt");
                type = resultSet.getString("Type");
                strength = resultSet.getDouble("Strength");
                isSpiked = resultSet.getBoolean("IsSpiked");
                HeavyWeapon heavyWeapon = new HeavyWeapon(cost,weight,type,strength,isSpiked);
                list.add(heavyWeapon);
            }
            return list;
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
        return list;
    }
    public ObservableList<Spear> KnightSpearList(int knightId) {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        ObservableList<Spear> list = FXCollections.observableArrayList();
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url, "Maks", "1111");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.KnightSpearList WHERE KnightId = " + knightId;
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            double cost;
            double weight;
            String type;
            double strength;
            double length;
            while (resultSet.next()) {
                cost = resultSet.getDouble("Cost");
                weight = resultSet.getDouble("Weightt");
                type = resultSet.getString("Type");
                strength = resultSet.getDouble("Strength");
                length = resultSet.getDouble("Length");
                Spear spear = new Spear(cost,weight,type,strength,length);
                list.add(spear);
            }
            return list;
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
        return list;
    }
    public ObservableList<Sword> KnightSwordList(int knightId) {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        ObservableList<Sword> list = FXCollections.observableArrayList();
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url, "Maks", "1111");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.KnightSwordList WHERE KnightId = " + knightId;
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            double cost;
            double weight;
            String type;
            double strength;
            boolean isCrooked;
            double sharpness;
            while (resultSet.next())
            {
                cost = resultSet.getDouble("Cost");
                weight = resultSet.getDouble("Weightt");
                type = resultSet.getString("Type");
                strength = resultSet.getDouble("Strength");
                isCrooked = resultSet.getBoolean("IsCrooked");
                sharpness = resultSet.getDouble("Sharpness");
                Sword sword = new Sword(cost,weight,type,strength,isCrooked,sharpness);
                list.add(sword);
            }
            return list;
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
        return list;
    }
    public double GetKnightBowMoney(int knightId,String login)
    {
        double money = 0;
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.KnightBowList WHERE KnightId = " + knightId + " and Login = '" + login + "'";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            while (resultSet.next())
            {
                money = resultSet.getDouble("cost");
            }
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
        return money;
    }
    public double GetKnightHeavyWeaponMoney(int knightId,String login)
    {
        double money = 0;
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.KnightHeavyWeaponList WHERE KnightId = " + knightId + " and Login = '" + login + "'";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            while (resultSet.next())
            {
                money = resultSet.getDouble("cost");
            }
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
        return money;
    }
    public double GetKnightSpearMoney(int knightId,String login)
    {
        double money = 0;
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.KnightSpearList WHERE KnightId = " + knightId + " and Login = '" + login + "'";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            while (resultSet.next())
            {
                money = resultSet.getDouble("cost");
            }
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
        return money;
    }
    public double GetKnightSwordMoney(int knightId,String login)
    {
        double money = 0;
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.KnightSwordList WHERE KnightId = " + knightId + " and Login = '" + login + "'";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            while (resultSet.next())
            {
                money = resultSet.getDouble("cost");
            }
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
        return money;
    }
    public ObservableList<Equipment> KnightEquip(int knightId,String login)
    {
        Connection conn = null;
        ObservableList<Equipment> list = FXCollections.observableArrayList();
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.KnightHelmetList WHERE KnightId = " + knightId + " and Login = '" + login + "'";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            double cost;
            double weight;
            String material;
            double strength;
            if (resultSet.next())
            {
                cost = resultSet.getDouble("Cost");
                weight = resultSet.getDouble("Weightt");
                material = resultSet.getString("Material");
                strength = resultSet.getDouble("Strength");
                list.add(new Equipment(cost,weight,material,strength));
            }
            else
            {
                list.add(new Equipment(0,0,"",0));
            }
            SqlQuery = "SELECT * FROM dbo.KnightBreastplateList WHERE KnightId = " + knightId + " and Login = '" + login + "'";
            resultSet = statement.executeQuery(SqlQuery);
            if (resultSet.next())
            {
                cost = resultSet.getDouble("Cost");
                weight = resultSet.getDouble("Weightt");
                material = resultSet.getString("Material");
                strength = resultSet.getDouble("Streingth");
                list.add(new Equipment(cost,weight,material,strength));
            }
            else
            {
                list.add(new Equipment(0,0,"",0));
            }
            SqlQuery = "SELECT * FROM dbo.KnightBootsList WHERE KnightId = " + knightId + " and Login = '" + login + "'";
            resultSet = statement.executeQuery(SqlQuery);
            if (resultSet.next())
            {
                cost = resultSet.getDouble("Cost");
                weight = resultSet.getDouble("Weightt");
                material = resultSet.getString("Material");
                strength = resultSet.getDouble("Streingth");
                list.add(new Equipment(cost,weight,material,strength));
            }
            else
            {
                list.add(new Equipment(0,0,"",0));
            }
            SqlQuery = "SELECT * FROM dbo.KnightShieldList WHERE KnightId = " + knightId + " and Login = '" + login + "'";
            resultSet = statement.executeQuery(SqlQuery);
            if (resultSet.next())
            {
                cost = resultSet.getDouble("Cost");
                weight = resultSet.getDouble("Weightt");
                material = resultSet.getString("Material");
                strength = resultSet.getDouble("Streingth");
                list.add(new Equipment(cost,weight,material,strength));
            }
            else
            {
                list.add(new Equipment(0,0,"",0));
            }
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
        return list;
    }
    public ObservableList<Weapon> WeaponEquip(int knightId, String login)
    {
        Connection conn = null;
        ObservableList<Weapon> list = FXCollections.observableArrayList();
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.KnightBowList WHERE KnightId = " + knightId + " and Login = '" + login + "'";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            double cost;
            double weight;
            String material;
            double strength;
            if (resultSet.next())
            {
                cost = resultSet.getDouble("Cost");
                weight = resultSet.getDouble("Weightt");
                material = resultSet.getString("Type");
                strength = resultSet.getDouble("Strength");
                list.add(new Weapon(cost,weight,material,strength));
            }
            else
            {
                list.add(new Weapon(0,0,"",0));
            }
            SqlQuery = "SELECT * FROM dbo.KnightHeavyWeaponList WHERE KnightId = " + knightId + " and Login = '" + login + "'";
            resultSet = statement.executeQuery(SqlQuery);
            if (resultSet.next())
            {
                cost = resultSet.getDouble("Cost");
                weight = resultSet.getDouble("Weightt");
                material = resultSet.getString("Type");
                strength = resultSet.getDouble("Strength");
                list.add(new Weapon(cost,weight,material,strength));
            }
            else
            {
                list.add(new Weapon(0,0,"",0));
            }
            SqlQuery = "SELECT * FROM dbo.KnightSpearList WHERE KnightId = " + knightId + " and Login = '" + login + "'";
            resultSet = statement.executeQuery(SqlQuery);
            if (resultSet.next())
            {
                cost = resultSet.getDouble("Cost");
                weight = resultSet.getDouble("Weightt");
                material = resultSet.getString("Type");
                strength = resultSet.getDouble("Strength");
                list.add(new Weapon(cost,weight,material,strength));
            }
            else
            {
                list.add(new Weapon(0,0,"",0));
            }
            SqlQuery = "SELECT * FROM dbo.KnightSwordList WHERE KnightId = " + knightId + " and Login = '" + login + "'";
            resultSet = statement.executeQuery(SqlQuery);
            if (resultSet.next())
            {
                cost = resultSet.getDouble("Cost");
                weight = resultSet.getDouble("Weightt");
                material = resultSet.getString("Type");
                strength = resultSet.getDouble("Strength");
                list.add(new Weapon(cost,weight,material,strength));
            }
            else
            {
                list.add(new Weapon(0,0,"",0));
            }
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
        return list;
    }
    public boolean SelectActiveUser(String email,String login,String password)
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.ActiveUser WHERE Email = " + "'" + email + "'" + " and Login = " + "'" + login + "'" + " and Password = " + "'" + password + "'";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            System.out.println(String.format("%30s %30s %30s","Email","Login","Password"));
            if(resultSet.next())
            {
                System.out.println(String.format("%30s %30s %30s",resultSet.getString(1),resultSet.getString(2),resultSet.getString(3)));
            }
            if(resultSet.getString(1).equals(email) && resultSet.getString(2).equals(login) && resultSet.getString(3).equals(password))
            {
                return true;
            }
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
        return false;
    }
}
