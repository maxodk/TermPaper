package database;

import data.UserData;
import equipment.Boots;
import equipment.Breastplate;
import equipment.Helmet;
import equipment.Shield;
import javafx.collections.ObservableList;
import knight.Knight;
import weapon.Bow;
import weapon.HeavyWeapon;
import weapon.Spear;
import weapon.Sword;

import java.sql.*;

public class Insert
{
    public void InsertUsers(UserData userlist)
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            System.out.println("Connection to MSSQLSERVER02 for InsertUsers established");
            String SqlQuery = "INSERT INTO dbo.Users VALUES ";

            for(int i = 0;i < userlist.getSize();i++)
            {
                SqlQuery += "('" + userlist.getElem(i).getEmail() + "','" + userlist.getElem(i).getLogin() + "','" + userlist.getElem(i).getPassword() + "')";
                if(i < userlist.getSize() - 1)
                {
                    SqlQuery += ",";
                }
            }
            SqlQuery += ";";
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
    public boolean InsertUser(String email,String login,String password)
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            System.out.println("Connection to MSSQLSERVER02 for InsertUsers established");
            Statement statement = conn.createStatement();
            String SqlQueryS = "SELECT * FROM dbo.Users";
            ResultSet resultSet = statement.executeQuery(SqlQueryS);
            while(resultSet.next())
            {
                if(resultSet.getString(1).equals(email) || resultSet.getString(2).equals(login) && resultSet.getString(3).equals(password))
                {
                    return false;
                }
            }
            String SqlQuery = "INSERT INTO dbo.Users VALUES (" + "'" + email + "','" + login + "','" + password + "');";
            PreparedStatement preparedStatement = conn.prepareStatement(SqlQuery);
            preparedStatement.execute();
            return true;
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

    public void InsertHelmets(Helmet helmet)
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            //System.out.println("Connection to MSSQLSERVER02 for InsertHelmets established");

            String SqlQuery = "INSERT INTO dbo.HelmetList VALUES ";

            SqlQuery += "('" + helmet.getCost() + "','" + helmet.getWeight() + "','" + helmet.getMaterial() + "','" + helmet.getStrength() + "','" + helmet.getTypeofarmoring() + "');";
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
    public void InsertBreastplate(Breastplate breastplate)
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            //System.out.println("Connection to MSSQLSERVER02 for InsertBreastplate established");

            String SqlQuery = "INSERT INTO dbo.BreastplateList VALUES ";

            SqlQuery += "('" + breastplate.getCost() + "','" + breastplate.getWeight() + "','" + breastplate.getMaterial() + "','" + breastplate.getStrength() + "','" + breastplate.getArmor() + "');";
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
    public void InsertBoots(Boots boots)
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            //System.out.println("Connection to MSSQLSERVER02 for InsertBoots established");

            String SqlQuery = "INSERT INTO dbo.BootsList VALUES ";

            SqlQuery += "('" + boots.getCost() + "','" + boots.getWeight() + "','" + boots.getMaterial() + "','" + boots.getStrength() + "','" + boots.getIsGaiters() + "');";
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
    public void InsertShield(Shield shield)
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            //System.out.println("Connection to MSSQLSERVER02 for InsertBoots established");

            String SqlQuery = "INSERT INTO dbo.ShieldList VALUES ";

            SqlQuery += "('" + shield.getCost() + "','" + shield.getWeight() + "','" + shield.getMaterial() + "','" + shield.getStrength() + "','" + shield.getIsCrooked() + "','" + shield.getProtection() + "');";
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
    public void InsertBow(Bow bow)
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            //System.out.println("Connection to MSSQLSERVER02 for InsertBoots established");

            String SqlQuery = "INSERT INTO dbo.BowList VALUES ";

            SqlQuery += "('" + bow.getCost() + "','" + bow.getWeight() + "','" + bow.getType() + "','" + bow.getStrength() + "','" + bow.getCountofarrows() + "','" + bow.getIsLong() + "');";
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
    public void InsertHeavyWeapon(HeavyWeapon heavyWeapon)
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            //System.out.println("Connection to MSSQLSERVER02 for InsertBoots established");

            String SqlQuery = "INSERT INTO dbo.HeavyWeaponList VALUES ";

            SqlQuery += "('" + heavyWeapon.getCost() + "','" + heavyWeapon.getWeight() + "','" + heavyWeapon.getType() + "','" + heavyWeapon.getStrength() + "','"  + heavyWeapon.getIsSpiked() + "');";
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
    public void InsertSpear(Spear spear)
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            //System.out.println("Connection to MSSQLSERVER02 for InsertBoots established");

            String SqlQuery = "INSERT INTO dbo.SpearList VALUES ";

            SqlQuery += "('" + spear.getCost() + "','" + spear.getWeight() + "','" + spear.getType() + "','" + spear.getStrength() + "','"  + spear.getLength() + "');";
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
    public void InsertSword(Sword sword)
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            //System.out.println("Connection to MSSQLSERVER02 for InsertBoots established");

            String SqlQuery = "INSERT INTO dbo.SwordList VALUES ";

            SqlQuery += "('" + sword.getCost() + "','" + sword.getWeight() + "','" + sword.getType() + "','" + sword.getStrength() + "','"  + sword.getIsCrooked() + "','"  + sword.getSharpness() + "');";
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
    public void InsertKnight(Knight knight)
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            //System.out.println("Connection to MSSQLSERVER02 for InsertBoots established");

            String SqlQuery = "INSERT INTO dbo.Knight VALUES ";

            SqlQuery += "('" + knight.getName() + "','" + knight.getAge() + "','" + knight.getAvailable_money() + "');";
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
    public void InsertKnightHelmet(Helmet helmet , int number)
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            //System.out.println("Connection to MSSQLSERVER02 for InsertBoots established");

            String SqlQuery = "INSERT INTO dbo.Knighthelmets VALUES ";

            SqlQuery += "('" + helmet.getCost() + "','" + helmet.getWeight() + "','" + helmet.getMaterial() + "','" + helmet.getStrength() + "','"  + helmet.getTypeofarmoring() + "','"  + (number + 1) + "');";
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
    public void InsertKnightBreastplate(Breastplate breastplate , int number)
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            //System.out.println("Connection to MSSQLSERVER02 for InsertBoots established");

            String SqlQuery = "INSERT INTO dbo.KnightBreastplate VALUES ";

            SqlQuery += "('" + breastplate.getCost() + "','" + breastplate.getWeight() + "','" + breastplate.getMaterial() + "','" + breastplate.getStrength() + "','"  + breastplate.getArmor() + "','"  + (number + 1) + "');";
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
    public void InsertKnightBoots(Boots boots , int number)
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            //System.out.println("Connection to MSSQLSERVER02 for InsertBoots established");

            String SqlQuery = "INSERT INTO dbo.KnightBoots VALUES ";

            SqlQuery += "('" + boots.getCost() + "','" + boots.getWeight() + "','" + boots.getMaterial() + "','" + boots.getStrength() + "','"  + boots.getIsGaiters() + "','"  + (number + 1) + "');";
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
    public void InsertKnightShield(Shield shield, int number)
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            //System.out.println("Connection to MSSQLSERVER02 for InsertBoots established");

            String SqlQuery = "INSERT INTO dbo.KnightShield VALUES ";

            SqlQuery += "('" + shield.getCost() + "','" + shield.getWeight() + "','" + shield.getMaterial() + "','" + shield.getStrength() + "','"  + shield.getIsCrooked() + "','" + shield.getProtection() + "','"  + (number + 1) + "');";
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
    public void InsertKnightBow(Bow bow, int number)
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            //System.out.println("Connection to MSSQLSERVER02 for InsertBoots established");

            String SqlQuery = "INSERT INTO dbo.KnightBow VALUES ";

            SqlQuery += "('" + bow.getCost() + "','" + bow.getWeight() + "','" + bow.getType() + "','" + bow.getStrength() + "','"  + bow.getCountofarrows() + "','" + bow.getIsLong() + "','"  + (number + 1) + "');";
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
    public void InsertKnightHeavyWeapon(HeavyWeapon heavyWeapon, int number)
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            //System.out.println("Connection to MSSQLSERVER02 for InsertBoots established");

            String SqlQuery = "INSERT INTO dbo.KnightHeavyWeapon VALUES ";

            SqlQuery += "('" + heavyWeapon.getCost() + "','" + heavyWeapon.getWeight() + "','" + heavyWeapon.getType() + "','" + heavyWeapon.getStrength() + "','" + heavyWeapon.getIsSpiked() + "','"  + (number + 1) + "');";
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
    public void InsertKnightSpear(Spear spear, int number)
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            //System.out.println("Connection to MSSQLSERVER02 for InsertBoots established");

            String SqlQuery = "INSERT INTO dbo.KnightSpear VALUES ";

            SqlQuery += "('" + spear.getCost() + "','" + spear.getWeight() + "','" + spear.getType() + "','" + spear.getStrength() + "','" + spear.getLength() + "','"  + (number + 1) + "');";
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
    public void InsertKnightSword(Sword sword, int number)
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            //System.out.println("Connection to MSSQLSERVER02 for InsertBoots established");

            String SqlQuery = "INSERT INTO dbo.KnightSword VALUES ";

            SqlQuery += "('" + sword.getCost() + "','" + sword.getWeight() + "','" + sword.getType() + "','" + sword.getStrength() + "','" + sword.getIsCrooked() + "','" + sword.getSharpness() + "','"  + (number + 1) + "');";
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
    public void actUser(String email,String login,String password)
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            //System.out.println("Connection to MSSQLSERVER02 for InsertBoots established");

            String SqlQuery = "INSERT INTO dbo.ActiveUser VALUES (" + "'" + email + "','" + login + "','" + password + "');";
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
    public void Knight(ObservableList<Knight> knights,String Login)
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            //System.out.println("Connection to MSSQLSERVER02 for InsertBoots established");
            String SqlQuery = "INSERT INTO dbo.KnightsList VALUES ";
            for(int i = 0;i < knights.size();i++)
            {
                SqlQuery += "('" + knights.get(i).getName() + "','" + knights.get(i).getAge() + "','" + knights.get(i).getAvailable_money() + "','" + Login + "')";
                if(i < knights.size() - 1)
                {
                    SqlQuery += ",";
                }
            }
            SqlQuery += ";";
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
    public void HelmetsList(Helmet helmet,int id)
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            //System.out.println("Connection to MSSQLSERVER02 for InsertHelmets established");

            String SqlQuery = "INSERT INTO dbo.HelmetsList VALUES ";

            SqlQuery += "('" + id + "','"  + helmet.getCost() + "','" + helmet.getWeight() + "','" + helmet.getMaterial() + "','" + helmet.getStrength() + "','" + helmet.getTypeofarmoring() + "');";
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
    /*public void InsertKnightEquipment(ArrayList<Integer> IdList,String login,int knightid)
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            //System.out.println("Connection to MSSQLSERVER02 for InsertHelmets established");
            String SqlQuery = "INSERT INTO dbo.KnightEquipment VALUES(";
            SqlQuery += "'" + knightid + "','" + login + "',";
            String Id1 = "NULL";
            String Id2 = "NULL";
            String Id3 = "NULL";
            String Id4 = "NULL";
            switch (IdList.size())
            {
                case 1:
                    if(IdList.get(0) >0 && IdList.get(0) <=250 )
                    {
                        Id1 = IdList.get(0).toString();
                    }
                    if(IdList.get(0) > 250 && IdList.get(0) <= 500)
                    {
                        Id2 = IdList.get(0).toString();
                    }
                    if(IdList.get(0) > 500 && IdList.get(0) <= 750)
                    {
                        Id3 = IdList.get(0).toString();
                    }
                    if(IdList.get(0) > 750 && IdList.get(0) <= 1000)
                    {
                        Id4 = IdList.get(0).toString();
                    }
                    break;
                case 2:
                    if(IdList.get(0) >0 && IdList.get(0) <=250 )
                    {
                        Id1 = IdList.get(0).toString();
                    }
                    if(IdList.get(0) > 250 && IdList.get(0) <= 500)
                    {
                        Id2 = IdList.get(0).toString();
                    }
                    if(IdList.get(0) > 500 && IdList.get(0) <= 750)
                    {
                        Id3 = IdList.get(0).toString();
                    }
                    if(IdList.get(0) > 750 && IdList.get(0) <= 1000)
                    {
                        Id4 = IdList.get(0).toString();
                    }
                    if(IdList.get(1) > 250 && IdList.get(1) <= 500)
                    {
                        Id2 = IdList.get(1).toString();
                    }
                    if(IdList.get(1) > 500 && IdList.get(1) <= 750)
                    {
                        Id3 = IdList.get(1).toString();
                    }
                    if(IdList.get(1) > 750 && IdList.get(1) <= 1000)
                    {
                        Id4 = IdList.get(1).toString();
                    }
                    break;
                case 3:
                    if(IdList.get(0) >0 && IdList.get(0) <=250 )
                    {
                        Id1 = IdList.get(0).toString();
                    }
                    if(IdList.get(0) > 250 && IdList.get(0) <= 500)
                    {
                        Id2 = IdList.get(0).toString();
                    }
                    if(IdList.get(0) > 500 && IdList.get(0) <= 750)
                    {
                        Id3 = IdList.get(0).toString();
                    }
                    if(IdList.get(0) > 750 && IdList.get(0) <= 1000)
                    {
                        Id4 = IdList.get(0).toString();
                    }
                    if(IdList.get(1) > 250 && IdList.get(1) <= 500)
                    {
                        Id2 = IdList.get(1).toString();
                    }
                    if(IdList.get(1) > 500 && IdList.get(1) <= 750)
                    {
                        Id3 = IdList.get(1).toString();
                    }
                    if(IdList.get(1) > 750 && IdList.get(1) <= 1000)
                    {
                        Id4 = IdList.get(1).toString();
                    }
                    if(IdList.get(2) > 500 && IdList.get(2) <= 750)
                    {
                        Id3 = IdList.get(2).toString();
                    }
                    if(IdList.get(2) > 750 && IdList.get(2) <= 1000)
                    {
                        Id4 = IdList.get(2).toString();
                    }
                    break;
                case 4:
                    Id1 = IdList.get(0).toString();
                    Id2 = IdList.get(1).toString();
                    Id3 = IdList.get(2).toString();
                    Id4 = IdList.get(3).toString();
                    break;
                default:
                    break;
            }
            SqlQuery += Id1 + "," + Id2 + "," + Id3 + "," + Id4 + ");";
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
    }*/
    public void KnightHelmetList(int Id,int knightId,String Login)
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            //System.out.println("Connection to MSSQLSERVER02 for InsertHelmets established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.HelmetList ";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            int ch = 0;
            double cost;
            double weight;
            String mat;
            double strength;
            String type;
            Helmet helmet = null;
            while (resultSet.next())
            {
                if(ch == Id - 1)
                {
                    cost = resultSet.getDouble("Cost");
                    weight = resultSet.getDouble("Weightt");
                    mat = resultSet.getString("Material");
                    strength = resultSet.getDouble("Streingth");
                    type = resultSet.getString("Typeofarmoring");
                    helmet = new Helmet(cost,weight,mat,strength,type);
                }
                ch++;
            }

            SqlQuery = "INSERT INTO dbo.KnightHelmetList VALUES ";
            SqlQuery += "('" + knightId + "','" + Login + "','" + helmet.getCost() + "','" + helmet.getWeight() + "','" + helmet.getMaterial() + "','" + helmet.getStrength() + "','" + helmet.getTypeofarmoring() + "');";
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
    public void KnightBreastplateList(int Id,int knightId,String Login)
    {
        Id -= 250;
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            //System.out.println("Connection to MSSQLSERVER02 for InsertHelmets established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.BreastplateList ";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            int ch = 0;
            double cost;
            double weight;
            String mat;
            double strength;
            String armor;
            Breastplate breastplate = null;
            while (resultSet.next())
            {
                if(ch == Id - 1)
                {
                    cost = resultSet.getDouble("Cost");
                    weight = resultSet.getDouble("Weightt");
                    mat = resultSet.getString("Material");
                    strength = resultSet.getDouble("Streingth");
                    armor = resultSet.getString("Armor");
                    breastplate = new Breastplate(cost,weight,mat,strength,armor);
                }
                ch++;
            }

            SqlQuery = "INSERT INTO dbo.KnightBreastplateList VALUES ";
            SqlQuery += "('" + knightId + "','" + Login + "','" + breastplate.getCost() + "','" + breastplate.getWeight() + "','" + breastplate.getMaterial() + "','" + breastplate.getStrength() + "','" + breastplate.getArmor() + "');";
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
    public void KnightBootsList(int Id,int knightId,String Login)
    {
        Id -= 500;
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            //System.out.println("Connection to MSSQLSERVER02 for InsertHelmets established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.BootsList ";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            int ch = 0;
            double cost;
            double weight;
            String mat;
            double strength;
            boolean isGaiters;
            Boots boots = null;
            while (resultSet.next())
            {
                if(ch == Id - 1)
                {
                    cost = resultSet.getDouble("Cost");
                    weight = resultSet.getDouble("Weightt");
                    mat = resultSet.getString("Material");
                    strength = resultSet.getDouble("Streingth");
                    isGaiters = resultSet.getBoolean("IsGaiters");
                    boots = new Boots(cost,weight,mat,strength,isGaiters);
                }
                ch++;
            }

            SqlQuery = "INSERT INTO dbo.KnightBootsList VALUES ";
            SqlQuery += "('" + knightId + "','" + Login + "','" + boots.getCost() + "','" + boots.getWeight() + "','" + boots.getMaterial() + "','" + boots.getStrength() + "','" + boots.getIsGaiters() + "');";
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
    public void KnightShieldList(int Id,int knightId,String Login)
    {
        Id -= 750;
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            //System.out.println("Connection to MSSQLSERVER02 for InsertHelmets established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.ShieldList ";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            int ch = 0;
            double cost;
            double weight;
            String mat;
            double strength;
            boolean isCrooked;
            double sharpness;
            Shield shield = null;
            while (resultSet.next())
            {
                if(ch == Id - 1)
                {
                    cost = resultSet.getDouble("Cost");
                    weight = resultSet.getDouble("Weightt");
                    mat = resultSet.getString("Material");
                    strength = resultSet.getDouble("Streingth");
                    isCrooked = resultSet.getBoolean("IsCrooked");
                    sharpness = resultSet.getDouble("Sharpness");
                    shield = new Shield(cost,weight,mat,strength,isCrooked,sharpness);
                }
                ch++;
            }
            SqlQuery = "INSERT INTO dbo.KnightShieldList VALUES ";
            SqlQuery += "('" + knightId + "','" + Login + "','" + shield.getCost() + "','" + shield.getWeight() + "','" + shield.getMaterial() + "','" + shield.getStrength() + "','" + shield.getIsCrooked() + "','" + shield.getProtection() + "');";
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
    public void KnightBowList(int Id,int knightId,String Login)
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            //System.out.println("Connection to MSSQLSERVER02 for InsertHelmets established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.BowList ";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            int ch = 0;
            double cost;
            double weight;
            String type;
            double strength;
            int count;
            boolean isLong;
            Bow bow = null;
            while (resultSet.next())
            {
                if(ch == Id - 1)
                {
                    cost = resultSet.getDouble("Cost");
                    weight = resultSet.getDouble("Weightt");
                    type = resultSet.getString("Type");
                    strength = resultSet.getDouble("Strength");
                    count = resultSet.getInt("CountOfArrows");
                    isLong = resultSet.getBoolean("IsLong");
                    bow = new Bow(cost,weight,type,strength,count,isLong);
                    break;
                }
                ch++;
            }
            SqlQuery = "INSERT INTO dbo.KnightBowList VALUES ";
            SqlQuery += "('" + knightId + "','" + Login + "','" + bow.getCost() + "','" + bow.getWeight() + "','" + bow.getType() + "','" + bow.getStrength() + "','" + bow.getCountofarrows() + "','" + bow.getIsLong() + "');";
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
    public void KnightHeavyWeaponList(int Id,int knightId,String Login)
    {
        Id -= 250;
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            //System.out.println("Connection to MSSQLSERVER02 for InsertHelmets established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.HeavyWeaponList ";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            int ch = 0;
            double cost;
            double weight;
            String type;
            double strength;
            boolean isSpiked;
            HeavyWeapon heavyWeapon = null;
            while (resultSet.next())
            {
                if(ch == Id - 1)
                {
                    cost = resultSet.getDouble("Cost");
                    weight = resultSet.getDouble("Weightt");
                    type = resultSet.getString("Type");
                    strength = resultSet.getDouble("Strength");
                    isSpiked = resultSet.getBoolean("IsSpiked");
                    heavyWeapon = new HeavyWeapon(cost,weight,type,strength,isSpiked);
                    break;
                }
                ch++;
            }

            SqlQuery = "INSERT INTO dbo.KnightHeavyWeaponList VALUES ";
            SqlQuery += "('" + knightId + "','" + Login + "','" + heavyWeapon.getCost() + "','" + heavyWeapon.getWeight() + "','" + heavyWeapon.getType() + "','" + heavyWeapon.getStrength() + "','" + heavyWeapon.getIsSpiked() + "');";
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
    public void KnightSpearList(int Id,int knightId,String Login)
    {
        Id -= 500;
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            //System.out.println("Connection to MSSQLSERVER02 for InsertHelmets established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.SpearList ";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            int ch = 0;
            double cost;
            double weight;
            String type;
            double strength;
            double length;
            Spear spear = null;
            while (resultSet.next())
            {
                if(ch == Id - 1)
                {
                    cost = resultSet.getDouble("Cost");
                    weight = resultSet.getDouble("Weightt");
                    type = resultSet.getString("Type");
                    strength = resultSet.getDouble("Strength");
                    length = resultSet.getDouble("Length");
                    spear = new Spear(cost,weight,type,strength,length);
                    break;
                }
                ch++;
            }

            SqlQuery = "INSERT INTO dbo.KnightSpearList VALUES ";
            SqlQuery += "('" + knightId + "','" + Login + "','" + spear.getCost() + "','" + spear.getWeight() + "','" + spear.getType() + "','" + spear.getStrength() + "','" + spear.getLength() + "');";
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
    public void KnightSwordList(int Id,int knightId,String Login)
    {
        Id -= 750;
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            //System.out.println("Connection to MSSQLSERVER02 for InsertHelmets established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.SwordList ";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            int ch = 0;
            double cost;
            double weight;
            String type;
            double strength;
            boolean isCrooked;
            double sharpness;
            Sword sword = null;
            while (resultSet.next())
            {
                if(ch == Id - 1)
                {
                    cost = resultSet.getDouble("Cost");
                    weight = resultSet.getDouble("Weightt");
                    type = resultSet.getString("Type");
                    strength = resultSet.getDouble("Strength");
                    isCrooked = resultSet.getBoolean("IsCrooked");
                    sharpness = resultSet.getDouble("Sharpness");
                    sword = new Sword(cost,weight,type,strength,isCrooked,sharpness);
                    break;
                }
                ch++;
            }
            SqlQuery = "INSERT INTO dbo.KnightSwordList VALUES ";
            SqlQuery += "('" + knightId + "','" + Login + "','" + sword.getCost() + "','" + sword.getWeight() + "','" + sword.getType() + "','" + sword.getStrength() + "','" + sword.getIsCrooked() + "','" + sword.getSharpness() + "');";
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
