package employee.management.system;
import java.sql.*;    // this is for connection with JDBC

public class Conn {

    Statement s;
    Connection c;
    public Conn(){
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");   // step 1 of JDBC connectivity which is register a java Driver class, forName() is static method, inside it we provide the jar driver file address.
            c = DriverManager.getConnection("jdbc:mysql:///employeemanagementsystem","root","root");    // this localhost 3306 is default for sql.
            s = c.createStatement();
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
