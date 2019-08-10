package Edits;
import org.w3c.dom.events.EventException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update extends JPanel {
    private JLabel lid;
    private JLabel lname;
    private JLabel lnic;
    private JLabel lsub1;
    private JLabel lsub2;
    private JLabel lsub3;

    private JTextField id;
    private JTextField name;
    private JTextField nic;
    private JTextField sub1;
    private JTextField sub2;
    private JTextField sub3;

    private JButton btn;

    Connection connection;
    PreparedStatement ps;

    public Update(Connection connection){
        this.connection = connection;
        setLayout(new FlowLayout());
        setVisible(true);

        lid = new JLabel("Student ID");
        lname = new JLabel("Name      ");
        lnic = new JLabel("NIC       ");
        lsub1 = new JLabel("Subject 1 ");
        lsub2 = new JLabel("Subject 2 ");
        lsub3 = new JLabel("Subject 3 ");

        id = new JTextField(15);
        name = new JTextField(15);
        nic = new JTextField(15);
        sub1 = new JTextField(15);
        sub2 = new JTextField(15);
        sub3 = new JTextField(15);

        btn = new JButton("Update");


        add(lid); add(id);
        add(lname); add(name);
        add(lnic); add(nic);
        add(lsub1); add(sub1);
        add(lsub2); add(sub2);
        add(lsub3); add(sub3);
        add(btn);

        event e = new event();
        btn.addActionListener(e);

    }

    public void ClearAll(){
        id.setText("");
        nic.setText("");
        name.setText("");
        sub1.setText("");
        sub2.setText("");
        sub3.setText("");
    }


    public class event implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                if (!id.getText().equals("")) {
                    int sid = (int) Integer.parseInt(id.getText());

                    boolean isError = false;

                    if(!name.getText().equals("")){
                        try{
                            String uname = name.getText();
                            ps = connection.prepareStatement("UPDATE results SET Name=? WHERE StudentID=?");
                            ps.setString(1,uname);
                            ps.setInt(2,sid);
                            ps.executeUpdate();

                        }catch(Exception any){
                            isError=true;
                            JFrame frame = new JFrame();
                            JOptionPane.showMessageDialog(
                                    frame,
                                    "Somethig Went Wrong.",
                                    "ERROR.",
                                    JOptionPane.ERROR_MESSAGE
                            );
                        }
                    }//update name
                    if(!nic.getText().equals("")) {
                        try {
                            int unic = (int) Integer.parseInt(nic.getText());
                            if(unic>=0){
                                ps = connection.prepareStatement("UPDATE results SET NIC=? WHERE StudentID=?");
                                ps.setInt(1, unic);
                                ps.setInt(2, sid);
                                ps.executeUpdate();
                            }else{
                                isError=true;
                                JFrame frame = new JFrame();
                                JOptionPane.showMessageDialog(
                                        frame,
                                        "Invalid NIC.",
                                        "ERROR.",
                                        JOptionPane.ERROR_MESSAGE
                                );
                            }

                        }catch(NumberFormatException any){
                            isError=true;
                            JFrame frame = new JFrame();
                            JOptionPane.showMessageDialog(
                                    frame,
                                    "Invalid NIC.",
                                    "ERROR.",
                                    JOptionPane.ERROR_MESSAGE
                            );
                        }catch(Exception any){
                            isError=true;
                            JFrame frame = new JFrame();
                            JOptionPane.showMessageDialog(
                                    frame,
                                    "Somethig Went Wrong.",
                                    "ERROR.",
                                    JOptionPane.ERROR_MESSAGE
                            );
                        }
                    }//update nic
                    if(!sub1.getText().equals("")){
                        try {
                            int usub1 = (int) Integer.parseInt(sub1.getText());
                            if(usub1>=0 & usub1<=100){
                                ps = connection.prepareStatement("UPDATE results SET Subject1=? WHERE StudentID=?");
                                ps.setInt(1, usub1);
                                ps.setInt(2, sid);
                                ps.executeUpdate();
                            }else{
                                isError=true;
                                JFrame frame = new JFrame();
                                JOptionPane.showMessageDialog(
                                        frame,
                                        "Invalid Marks On Subject 1.",
                                        "ERROR.",
                                        JOptionPane.ERROR_MESSAGE
                                );
                            }

                        }catch(NumberFormatException any){
                            isError=true;
                            JFrame frame = new JFrame();
                            JOptionPane.showMessageDialog(
                                    frame,
                                    "Invalid Marks On Subject 1.",
                                    "ERROR.",
                                    JOptionPane.ERROR_MESSAGE
                            );
                        }catch(Exception any){
                            isError=true;
                            JFrame frame = new JFrame();
                            JOptionPane.showMessageDialog(
                                    frame,
                                    "Somethig Went Wrong.",
                                    "ERROR.",
                                    JOptionPane.ERROR_MESSAGE
                            );
                        }
                    }//update sub1
                    if(!sub2.getText().equals("")){
                        try {
                            int usub2 = (int) Integer.parseInt(sub2.getText());
                            if(usub2>=0 & usub2<=100){
                                ps = connection.prepareStatement("UPDATE results SET Subject2=? WHERE StudentID=?");
                                ps.setInt(1, usub2);
                                ps.setInt(2, sid);
                                ps.executeUpdate();
                            }else{
                                isError=true;
                                JFrame frame = new JFrame();
                                JOptionPane.showMessageDialog(
                                        frame,
                                        "Invalid Marks On Subject 2.",
                                        "ERROR.",
                                        JOptionPane.ERROR_MESSAGE
                                );
                            }

                        }catch(NumberFormatException any){
                            isError=true;
                            JFrame frame = new JFrame();
                            JOptionPane.showMessageDialog(
                                    frame,
                                    "Invalid Marks On Subject 2.",
                                    "ERROR.",
                                    JOptionPane.ERROR_MESSAGE
                            );
                        }catch(Exception any){
                            isError=true;
                            JFrame frame = new JFrame();
                            JOptionPane.showMessageDialog(
                                    frame,
                                    "Somethig Went Wrong.",
                                    "ERROR.",
                                    JOptionPane.ERROR_MESSAGE
                            );
                        }
                    }//update sub2
                    if(!sub3.getText().equals("")){
                        try {
                            int usub3 = (int) Integer.parseInt(sub3.getText());
                            if(usub3>=0 & usub3<=100){
                                ps = connection.prepareStatement("UPDATE results SET Subject3=? WHERE StudentID=?");
                                ps.setInt(1, usub3);
                                ps.setInt(2, sid);
                                ps.executeUpdate();
                            }else{
                                isError=true;
                                JFrame frame = new JFrame();
                                JOptionPane.showMessageDialog(
                                        frame,
                                        "Invalid Marks On Subject 3.",
                                        "ERROR.",
                                        JOptionPane.ERROR_MESSAGE
                                );
                            }

                        }catch(NumberFormatException any){
                            isError=true;
                            JFrame frame = new JFrame();
                            JOptionPane.showMessageDialog(
                                    frame,
                                    "Invalid Marks On Subject 3.",
                                    "ERROR.",
                                    JOptionPane.ERROR_MESSAGE
                            );
                        }catch(Exception any){
                            isError=true;
                            JFrame frame = new JFrame();
                            JOptionPane.showMessageDialog(
                                    frame,
                                    "Somethig Went Wrong.",
                                    "ERROR.",
                                    JOptionPane.ERROR_MESSAGE
                            );
                        }
                    }//update sub3

                    if (!isError){
                        JFrame frame = new JFrame();
                        JOptionPane.showMessageDialog(
                                frame,
                                "Successfully Updated.",
                                "Inserted.",
                                JOptionPane.PLAIN_MESSAGE
                        );
                        ClearAll();
                    }

                } else {
                    JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(
                            frame,
                            "Student ID is Required.",
                            "WARNING",
                            JOptionPane.WARNING_MESSAGE
                    );
                }
            }catch(NumberFormatException any){
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(
                        frame,
                        "Invalid Student ID.",
                        "ERROR",
                        JOptionPane.ERROR_MESSAGE
                );
            }catch (Exception any){
                any.printStackTrace();
            }
        }
    }
}
