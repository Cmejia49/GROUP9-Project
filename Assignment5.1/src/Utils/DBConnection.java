package Utils;
import java.sql.*;
public class DBConnection{
    private static final String DB_NAME 
       = "jdbc:mysql://localhost/restourantReviewDB?serverTimezone=UTC";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "1234";
    private static Connection conn = null;
    private static void connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException ex){
            return;
        }

        try{
            conn = DriverManager.getConnection(DB_NAME, DB_USERNAME, DB_PASSWORD);
        }
        catch(SQLException ex){
            return;
        }
    }
    public static ResultSet executeQuery(String query){
        if(conn==null){
            connect();
        }
        try{
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(query);
        }
        catch(NullPointerException ex){
            return null;
        }
        catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }
    public static void executeUpdate(String query){
        if(conn==null){
            connect();
        }
        try{
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
        }
        catch(NullPointerException ex){
            return;
        }
        catch(SQLException ex){
            ex.printStackTrace();
            return;
        }
    }
}