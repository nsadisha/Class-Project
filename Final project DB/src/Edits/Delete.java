package Edits;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Delete extends JPanel {

    private JLabel lbl;
    private JTextField txt;
    private JButton btn;

    Connection connection;
    PreparedStatement ps;

    public Delete(Connection connection){
        this.connection = connection;

        setLayout(new FlowLayout());
        setVisible(true);

        lbl = new JLabel("Student ID");
        txt = new JTextField(10);
        btn = new JButton("Delete");

        add(lbl);
        add(txt);
        add(btn);

        event e = new event();
        btn.addActionListener(e);
    }
    public class event implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try{
                if(!txt.getText().equals("")){
                    if((int)Integer.parseInt(txt.getText())>0){
                        int id = (int)Integer.parseInt(txt.getText());

                        try{
                            ps = connection.prepareStatement("DELETE FROM results WHERE StudentID = ?");
                            ps.setInt(1,id);
                            ps.executeUpdate();

                            JFrame frame = new JFrame();
                            JOptionPane.showMessageDialog(
                                    frame,
                                    "Student ID "+id+" Is Deleted.",
                                    "Deleted.",
                                    JOptionPane.PLAIN_MESSAGE
                            );

                        }catch(Exception any){
                            JFrame frame = new JFrame();
                            JOptionPane.showMessageDialog(
                                    frame,
                                    "Something Went Wrong.\nTry Reconnecting To The Database.",
                                    "ERROR",
                                    JOptionPane.ERROR_MESSAGE
                            );
                        }finally {
                            txt.setText("");
                        }

                    }else{
                        throw  new Exception();
                    }
                }else{
                    JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(
                            frame,
                            "Student ID Is Required.",
                            "ERROR",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }catch (Exception any){
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(
                        frame,
                        "Invalid Student ID.",
                        "ERROR",
                        JOptionPane.ERROR_MESSAGE
                );
            }finally {

            }
        }
    }
}
