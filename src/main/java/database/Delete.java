package database;

import knight.Knight;

import java.sql.*;

public class Delete
{
    public void DeleteUsers()
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            System.out.println("Connection to MSSQLSERVER02 for DeleteUsers established");
            String SqlQuery = "DELETE FROM dbo.Users";
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
    public void DeleteHelmets()
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            //System.out.println("Connection to MSSQLSERVER02 for DeleteHelmetList established");
            String SqlQuery = "DELETE FROM dbo.HelmetList";
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
    public void DeleteBreastplate()
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            //System.out.println("Connection to MSSQLSERVER02 for DeleteHelmetList established");
            String SqlQuery = "DELETE FROM dbo.BreastplateList";
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
    public void DeleteBootsList()
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            //System.out.println("Connection to MSSQLSERVER02 for DeleteHelmetList established");
            String SqlQuery = "DELETE FROM dbo.BootsList";
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
    public void DeleteShieldList()
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            //System.out.println("Connection to MSSQLSERVER02 for DeleteHelmetList established");
            String SqlQuery = "DELETE FROM dbo.ShieldList";
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
    public void DeleteBowList()
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            //System.out.println("Connection to MSSQLSERVER02 for DeleteHelmetList established");
            String SqlQuery = "DELETE FROM dbo.BowList";
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
    public void DeleteHeavyWeaponList()
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            //System.out.println("Connection to MSSQLSERVER02 for DeleteHelmetList established");
            String SqlQuery = "DELETE FROM dbo.HeavyWeaponList";
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
    public void DeleteSpearList()
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            //System.out.println("Connection to MSSQLSERVER02 for DeleteHelmetList established");
            String SqlQuery = "DELETE FROM dbo.SpearList";
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
    public void DeleteSwordList()
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            //System.out.println("Connection to MSSQLSERVER02 for DeleteHelmetList established");
            String SqlQuery = "DELETE FROM dbo.SwordList";
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
    public void DeleteKnight()
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            //System.out.println("Connection to MSSQLSERVER02 for DeleteHelmetList established");
            String SqlQuery = "DELETE FROM dbo.Knight";
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
    public void DeleteknightHelmet()
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            //System.out.println("Connection to MSSQLSERVER02 for DeleteHelmetList established");
            String SqlQuery = "DELETE FROM dbo.KnightHelmets";
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
    public void DeleteKnightBreastplate()
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            //System.out.println("Connection to MSSQLSERVER02 for DeleteHelmetList established");
            String SqlQuery = "DELETE FROM dbo.KnightBreastplate";
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
    public void DeleteKnightBoots()
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            //System.out.println("Connection to MSSQLSERVER02 for DeleteHelmetList established");
            String SqlQuery = "DELETE FROM dbo.KnightBoots";
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
    public void DeleteKnightShield()
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            //System.out.println("Connection to MSSQLSERVER02 for DeleteHelmetList established");
            String SqlQuery = "DELETE FROM dbo.KnightShield";
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
    public void DeleteKnightBow()
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            //System.out.println("Connection to MSSQLSERVER02 for DeleteHelmetList established");
            String SqlQuery = "DELETE FROM dbo.KnightBow";
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
    public void DeleteKnightHeavyWeapon()
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            //System.out.println("Connection to MSSQLSERVER02 for DeleteHelmetList established");
            String SqlQuery = "DELETE FROM dbo.KnightHeavyWeapon";
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
    public void DeleteKnightSpear()
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            //System.out.println("Connection to MSSQLSERVER02 for DeleteHelmetList established");
            String SqlQuery = "DELETE FROM dbo.KnightSpear";
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
    public void DeleteKnightSword()
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            //System.out.println("Connection to MSSQLSERVER02 for DeleteHelmetList established");
            String SqlQuery = "DELETE FROM dbo.KnightSword";
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
    public void DeleteKnightEquipment(int index,double cost)
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            //System.out.println("Connection to MSSQLSERVER02 for DeleteHelmetList established");
            String SqlQuery = null;
            if(index >= 0 && index < 250)
            {
                SqlQuery = "DELETE FROM dbo.KnightHelmets WHERE Cost = " + "'" + cost + "'";
            }
            if(index >= 250 && index < 500)
            {
                SqlQuery = "DELETE FROM dbo.KnightBreastplate WHERE Cost = " + "'" + cost + "'";
            }
            if(index >= 500 && index < 750)
            {
                SqlQuery = "DELETE FROM dbo.KnightBoots WHERE Cost = " + "'" + cost + "'";
            }
            if(index >= 750 && index < 1000)
            {
                SqlQuery = "DELETE FROM dbo.KnightShield WHERE Cost = " + "'" + cost + "'";
            }
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
    public void DeleteKnightWeapon(int index,double cost)
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            //System.out.println("Connection to MSSQLSERVER02 for DeleteHelmetList established");
            String SqlQuery = null;
            if(index >= 0 && index < 250)
            {
                SqlQuery = "DELETE FROM dbo.KnightBow WHERE Cost = " + "'" + cost + "'";
            }
            if(index >= 250 && index < 500)
            {
                SqlQuery = "DELETE FROM dbo.KnightHeavyWeapon WHERE Cost = " + "'" + cost + "'";
            }
            if(index >= 500 && index < 750)
            {
                SqlQuery = "DELETE FROM dbo.KnightSpear WHERE Cost = " + "'" + cost + "'";
            }
            if(index >= 750 && index < 1000)
            {
                SqlQuery = "DELETE FROM dbo.KnightSword WHERE Cost = " + "'" + cost + "'";
            }
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
    public void deleteActUser()
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            //System.out.println("Connection to MSSQLSERVER02 for DeleteHelmetList established");
            String SqlQuery = "DELETE FROM dbo.ActiveUser";
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
    public void KnightHelmet(int KnightId,String login)
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            //System.out.println("Connection to MSSQLSERVER02 for DeleteHelmetList established");
            String SqlQuery = "DELETE FROM dbo.KnightHelmetList WHERE Login = '" + login + "' and KnightId = " + KnightId;
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
    public void KnightBreastplate(int KnightId,String login)
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            //System.out.println("Connection to MSSQLSERVER02 for DeleteHelmetList established");
            String SqlQuery = "DELETE FROM dbo.KnightBreastplateList WHERE Login = '" + login + "' and KnightId = " + KnightId;
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
    public void KnightBoots(int KnightId,String login)
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            //System.out.println("Connection to MSSQLSERVER02 for DeleteHelmetList established");
            String SqlQuery = "DELETE FROM dbo.KnightBootsList WHERE Login = '" + login + "' and KnightId = " + KnightId;
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
    public void KnightShield(int KnightId,String login)
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            //System.out.println("Connection to MSSQLSERVER02 for DeleteHelmetList established");
            String SqlQuery = "DELETE FROM dbo.KnightShieldList WHERE Login = '" + login + "' and KnightId = " + KnightId;
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
    public void KnightBow(int KnightId,String login)
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            //System.out.println("Connection to MSSQLSERVER02 for DeleteHelmetList established");
            String SqlQuery = "DELETE FROM dbo.KnightBowList WHERE Login = '" + login + "' and KnightId = " + KnightId;
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
    public void KnightHeavyWeapon(int KnightId,String login)
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            //System.out.println("Connection to MSSQLSERVER02 for DeleteHelmetList established");
            String SqlQuery = "DELETE FROM dbo.KnightHeavyWeaponList WHERE Login = '" + login + "' and KnightId = " + KnightId;
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
    public void KnightSpear(int KnightId,String login)
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            //System.out.println("Connection to MSSQLSERVER02 for DeleteHelmetList established");
            String SqlQuery = "DELETE FROM dbo.KnightSpearList WHERE Login = '" + login + "' and KnightId = " + KnightId;
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
    public void KnightSword(int KnightId,String login)
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=KnightEquip;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Maks","1111");
            //System.out.println("Connection to MSSQLSERVER02 for DeleteHelmetList established");
            String SqlQuery = "DELETE FROM dbo.KnightSwordList WHERE Login = '" + login + "' and KnightId = " + KnightId;
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
