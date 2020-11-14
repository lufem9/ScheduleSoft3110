import java.sql.*;

public class entity
{

    //============== Properties===============
    private String Id;
    private String Name;
    private String Email;
    private int phone;
    private String Address;

    public String getId() {
        return Id;
    }
    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }

    public int getPhone() {
        return phone;
    }
    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return Address;
    }
    public void setAddress(String address) {
        Address = address;
    }

    public entity() {
        this.Id = "";
        this.Name = "";
        this.Email = "";
        this.phone = 0;
        this.Address = "";
    }


    public entity(String id, String name, String email, int phone, String address) {
        this.Id = id;
        this.Name = name;
        this.Email = email;
        this.phone = phone;
        this.Address = address;
    }

    //=============InsertDB method=================
    public void insertDB( String id, String na, String em, int ph, String add)
    {
        setId(id);
        setName(na);
        setEmail(em);
        setPhone(ph);
        setAddress(add);

        String sqlQuery = "INSERT into entity values('" + getId() +"',"
                + "'" + getName() +"',"
                + "'" + getEmail() +"',"
                + "" + getPhone() +","
                + "'" + getAddress() +"')";

        connect.insertDB(sqlQuery);
    }//end of InsertDB

    //=============UpdateDB method=================
    public void updateDB()
    {

        String sqlQuery =  "update entity  set Entity_Name = "
                + "'" + getName() +"', "
                + "Email = '" + getEmail() +"',"
                + "Phone = " + getPhone() +", "
                + "Address = '" + getAddress() +"' " +
                "WHERE EId = '" + Id +"' ";

        connect.updateDB(sqlQuery);
    }//end of UpdateDB

    public void SelectDB(String SID){
        Id = SID;
        String sqlQuery = "SELECT * FROM entity WHERE EId = " + "'" + getId()+"'";

        try
        {
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
                setId(rs.getString(1));
                setName(rs.getString(2));
                setEmail(rs.getString(3));
                setPhone(rs.getInt(4));
                setAddress(rs.getString(5));
            }
            // a1.SelectDB(Id);

            //Closing DataBase
            stmt.close();

        }catch(SQLException es)
        {
            System.out.println(es);
        }
    } //End of SelectDB

    //=============DeleteDB method=================
    public void deleteDB( ){

        String sqlQuery = "DELETE FROM entity WHERE EId = "
                + "'" + getId() +"'";
        connect.deleteDB(sqlQuery);
    }//end of DeleteDB

    //=============display method=================
    public void display(){
        System.out.println(" Entity ID = " + getId()
                + "\n Entity Name  = " + getName()
                + "\n Entity Email = " + getEmail()
                + "\n Entity phone = " + getPhone()
                + "\n Entity Address = " + getAddress());
    }//End of display method
}
