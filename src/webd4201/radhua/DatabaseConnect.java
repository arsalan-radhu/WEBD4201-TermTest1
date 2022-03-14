package webd4201.radhua;
import java.sql.*;

/*
 * This class represents the database connection
 * @author Arsalan Arif Radhu
 * @version 1.0
 * @since 1.0
 */


public class DatabaseConnect
{
    /**
     * Database location
     */
    static String url = "jdbc:postgresql://127.0.0.1:5432/webd4201_db";
    /**
     * Connection object to open port to db
     */
    static Connection aConnection;
    /**
     * database user
     */
    static String user = "webd4201_admin";
    /**
     * database user password
     */
    static String password = "webd4201_password";

    /**
     * establishes the database connection
     * @return Connection to the webd4201_db database
     */
    public static Connection initialize()
    {
        try
        {
            Class.forName("org.postgresql.Driver"); // loads the JDBC Driver for PostGreSQL
            aConnection = DriverManager.getConnection(url, user, password); // creates the database connection instance

        }
        catch (ClassNotFoundException e)  //will occur if you did not import the PostGreSQL *.jar file with drivers
        {
            System.out.println(e.getMessage());
        }
        catch (SQLException e)	//any other database exception (misnamed db, misnamed user, wrong password, etc)
        { System.out.println(e.getMessage()); }
        return aConnection;
    }

    /**
     * closes the database connection
     */
    public static void terminate()
    {
        try
        {
            aConnection.close();
        }
        catch (SQLException e)
        { System.out.println(e.getMessage());	}
    }
}
