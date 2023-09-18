import java.sql.*;
public class ConnectionTosql {

    Connection c;
    Statement s;
    public ConnectionTosql(){
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
            c= DriverManager.getConnection("jdbc:mysql:///bankManagementSystem", "Your_UserName", "Your_Pasword");
            s= c.createStatement();
        }catch (Exception e){
            System.out.println(e);
        }
    }

}
