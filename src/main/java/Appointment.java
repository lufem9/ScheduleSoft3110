import java.sql.*;

public class Appointment
{

    //============== Properties===============
    private String appId;
    private String appDy;
    private String appSt;
    private String appEt;
    private String CId;
    private String EId;

    //============== Behaviour===============
    public void setAppId(String app){this.appId = app;}
    public String getAppId(){return appId;}

    public void setAppDy(String ad){this.appDy = ad;}
    public String getAppDy(){return appDy;}

    public void setAppSt(String at){this.appSt = at;}
    public String getAppSt(){return appSt;}

    public String getAppEt() {return appEt; }
    public void setAppEt(String appEt) {this.appEt = appEt;    }

    public String getCId() { return CId; }
    public void setCId(String CId) {this.CId = CId; }

    public String getEId() {return EId; }
    public void setEId(String EId) {this.EId = EId; }

    //=============InsertDB method=================
    public void insertDB( String appid, String appdy, String appst, String appet,String cid, String eid)
    {
        setAppId(appid);
        setAppDy(appdy);
        setAppSt(appst);
        setAppEt(appet);
        setCId(cid);
        setEId(eid);

        String sqlQuery = "INSERT into appointment values('" + getAppId() + "',"
                + "'" + getAppDy() + "',"
                + "'" + getAppSt() + "',"
                + "'" + getAppEt() + "',"
                + "'" + getCId() + "',"
                + " " + getEId() + ")";

        connect.insertDB(sqlQuery);
    }

    public void SelectDB(String appi)
    {
        appId = appi;
        String sqlQuery = "SELECT * FROM appointment WHERE AId = '" + getAppId()+"'" ;
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

            ResultSet rs = stmt.executeQuery(sqlQuery);

            //Processing result set.
            while(rs.next()){
                setAppId(rs.getString(1));
                setAppDy(rs.getString(2));
                setAppSt(rs.getString(3));
                setAppEt(rs.getString(4));
                setCId(rs.getString(5));
                setEId(rs.getString(6));
            }
            //Closing DataBase
            stmt.close();

        }catch( SQLException es)
        {
            System.out.println(es);
        }
    } //End of SelectDB


    public void updateDB(){

        String sqlQuery = "update appointment  set Date = '" + getAppDy() +"',"
                + "Start_Time = '" + getAppSt() +"', "
                + "End_Time = '" + getAppEt() +"',"
                + "CId = '" + getCId() +"',"
                + "EId = '" + getEId() +"'"
                +  "WHERE AId = '" + appId +"'";

        connect.updateDB(sqlQuery);

    }//end of UpdateDB

    public void deleteDB( )
    {
        String sqlQuery = "DELETE FROM appointment WHERE AId = " + getAppId() +"";
        connect.deleteDB(sqlQuery);

    }//end of DeleteDB

//=============display method=================
public void display()
    {
        System.out.println(" Appointment ID = " + getAppId()
                + " \n Date = " + getAppDy()
                + " \n Start Time = " + getAppSt()
                + " \n End time = " + getAppEt()
                + " \n Client ID = " + getCId()
                + " \n Entity ID = " + getEId());
    }//End of Display method

}//End of Class