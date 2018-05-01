package changeToYourPackageName;

import java.sql.*;
import javax.swing.JOptionPane;

public class DBConnection {
    private Connection con;
    
    public Connection getConnection(){
        return con;
    }
    
    public void connectDatabase(){
        try{
            //load the driver class  
            Class.forName("oracle.jdbc.driver.OracleDriver");
            try{
                String url,username,password;
                url = "jdbc:oracle:thin:@localhost:1521:XE";
                username = "yourusername";
                password = "yourpassword";
                koneksi = DriverManager.getConnection(url,username,password);
                //Confirmation that Java has been successfully connected with oracl xe
                System.out.println("Connected!");
            }catch(SQLException sqle){
                JOptionPane.showMessageDialog(null, "Connection Failed! " + sqle.getMessage());
                System.exit(0);
            }
        }catch(ClassNotFoundException cnfe){
            JOptionPane.showMessageDialog(null, "Driver Not Found! \n" + cnfe.getMessage());
            System.exit(0);
        }
    }
    
    public static void main(String[] kon) {  
        new DBConnection().connectDatabase();
    } 
}
