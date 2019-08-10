import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;

public class LoginGUI extends JFrame {
    private JLabel title;
    private JLabel userN;
    private JLabel pass;
    private JTextField userName;
    private JPasswordField password;
    private JButton connect;

    private String un;
    private String pw;

    public LoginGUI(){
        title = new JLabel("Login");
        JLabel dv = new JLabel("-----------------------------------------------------------------");
        userN = new JLabel("Username           ");
        pass = new JLabel("Password           ");
        userName = new JTextField(10);
        password = new JPasswordField(10);
        JLabel spacer = new JLabel("                                                             \n                                                             ");
        connect = new JButton("Connect");

        setSize(280,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new FlowLayout());
        setTitle("Login");
        setLocationRelativeTo(null);

        add(title);
        add(dv);
        add(userN);
        add(userName);
        add(pass);
        add(password);
        add(spacer);
        add(connect);

        event e = new event();
        connect.addActionListener(e);
    }

    public class event implements ActionListener{
        public void actionPerformed(ActionEvent e){
            un = userName.getText();
            pw = password.getText();

            //create un and pw validationi.

            if(!un.equals("")) {
                try {
                    Connection connection = null;
                    connection = ConnectionConfig.getConnection(un, pw);

                    if(connection != null){
                        dispose();
                        EDIT edit = new EDIT(connection);
                        edit.setVisible(true);
                    }

                } catch (Exception ex) {
                    JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(
                            frame,
                            "Something Went Wrong.",
                            "ERROR",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }else{
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(
                        frame,
                        "Username field is required..",
                        "WARNING",
                        JOptionPane.WARNING_MESSAGE
                );
            }
        }
    }
}
