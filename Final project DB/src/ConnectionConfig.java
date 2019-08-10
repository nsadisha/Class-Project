import com.mysql.cj.jdbc.exceptions.CommunicationsException;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionConfig {
    public static Connection getConnection(String username,String password){
        Connection connection = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/grppro",username,password);
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(
                    frame,
                    "Successfully Connected To The Database.",
                    "Database Connected.",
                    JOptionPane.PLAIN_MESSAGE
            );

        }catch (CommunicationsException any){
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(
                    frame,
                    "Can't Connect To The Database.",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE
            );
        }
        catch(SQLException e){
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(
                    frame,
                    "Invalid Username Or Password.\nTry Again...!.",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE
            );
        }catch(Exception e){
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(
                    frame,
                    "Something Went Wrong.",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE
            );
        }
        return connection;
    }
}
