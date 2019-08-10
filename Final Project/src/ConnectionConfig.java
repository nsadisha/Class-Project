import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionConfig {
    public static Connection getConnection(){
        Connection connection = null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/grppro","root","");

        }catch(Exception e){
            e.printStackTrace();
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(
                    frame,
                    "Can't Connect To The Databse.",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE
            );
        }
        return connection;
    }
}
