import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class connect {
    //String sqlQuery;
    public static void insertDB(String sqlQuery) {
        try{
            //Loading Driver
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1/ScheduleSoftdb",
                    "root",
                    "");
            System.out.println("Connected Successfully");

            //Using SQL SELECT Query
            PreparedStatement stmt = con.prepareStatement(sqlQuery);

            System.out.println(sqlQuery);
            int n = stmt.executeUpdate(sqlQuery);
            if(n==1){
                System.out.println("INSERT Successful!!!");
            }else
            {
                System.out.println("INSERT FAILED ********");
            }
            //Closing DataBase
            stmt.close();

        }catch(SQLException ei){
            System.out.println(ei);
        }
    }

    public static void updateDB(String sqlQuery) {
        try{
            //Loading Driver
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1/ScheduleSoftdb",
                    "root",
                    "");
            System.out.println("Connected Successfully");

            //Using SQL SELECT Query
            PreparedStatement stmt = con.prepareStatement(sqlQuery);

            System.out.println(sqlQuery);
            int n = stmt.executeUpdate(sqlQuery);
            if(n==1){
                System.out.println("UPDATE Successful!!!");
            }else
            {
                System.out.println("UPDATE FAILED********");
            }
            //Closing DataBase
            stmt.close();

        }catch(SQLException eu){
            System.out.println(eu);
        }
    }

    public static void deleteDB(String sqlQuery) {
        try{
            //Loading Driver
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1/ScheduleSoftdb",
                    "root",
                    "");
            System.out.println("Connected Successfully");

            //Using SQL SELECT Query
            PreparedStatement stmt = con.prepareStatement(sqlQuery);

            int n = stmt.executeUpdate(sqlQuery);
            if(n==1){
                System.out.println("DELETE Successful!!!");
                System.out.println(sqlQuery);
            }else
            {
                System.out.println("DELETE FAILED********");
            }
            //Closing DataBase
            stmt.close();

        }catch(SQLException ed){
            System.out.println(ed);
        }
    }
}
