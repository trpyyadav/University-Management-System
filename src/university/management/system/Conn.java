
package university.management.system;

import java.sql.*;

public class Conn {

    Connection c;
    Statement s;

    Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/UNIVERSITYMANAGEMENTSYSTEM","root","PRIYANSHU");
            s = c.createStatement();


        }catch(Exception e){
            e.printStackTrace();

        }

    }
    
}
