package Edits;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLIntegrityConstraintViolationException;

public class Insert extends JPanel{
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
    public  Insert(Connection connection){
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

        btn = new JButton("Add");


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
        name.setText("");
        nic.setText("");
        sub1.setText("");
        sub2.setText("");
        sub3.setText("");
    }


    public class event implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try{
                //if marks ?
                boolean isNotEmpty = !id.getText().equals("") & !name.getText().equals("") & !nic.getText().equals("") & !sub1.getText().equals("") & !sub2.getText().equals("")& !sub3.getText().equals("");
                if(isNotEmpty){
                    boolean cMarks = ((int)Integer.parseInt(sub1.getText())>=0 & (int)Integer.parseInt(sub1.getText())<=100) & ((int)Integer.parseInt(sub2.getText())>=0 & (int)Integer.parseInt(sub2.getText())<=100) & ((int)Integer.parseInt(sub3.getText())>=0 & (int)Integer.parseInt(sub3.getText())<=100);
                    //if 0<= margs <=100
                    if(cMarks & (int)Integer.parseInt(nic.getText())>0 & (int)Integer.parseInt(id.getText())>0){

                        int sid = (int)Integer.parseInt(id.getText());
                        String sname = name.getText();
                        int snic = (int)Integer.parseInt(nic.getText());
                        int ssub1 = (int)Integer.parseInt(sub1.getText());
                        int ssub2 = (int)Integer.parseInt(sub3.getText());
                        int ssub3 = (int)Integer.parseInt(sub3.getText());

                        try{
                            if(sid>=0 & sid<=100 & snic>0){
                                ps = connection.prepareStatement("INSERT INTO results VALUES(?,?,?,?,?,?)");
                                ps.setInt(1,sid);
                                ps.setString(2,sname);
                                ps.setInt(3,snic);
                                ps.setInt(4,ssub1);
                                ps.setInt(5,ssub2);
                                ps.setInt(6,ssub3);
                                ps.executeUpdate();

                                JFrame frame = new JFrame();
                                JOptionPane.showMessageDialog(
                                        frame,
                                        "Successfully Added.",
                                        "Inserted.",
                                        JOptionPane.PLAIN_MESSAGE
                                );
                                ClearAll();
                            }else{
                                JFrame frame = new JFrame();
                                JOptionPane.showMessageDialog(
                                        frame,
                                        "Invalid Student ID Or NIC.",
                                        "ERROR",
                                        JOptionPane.ERROR_MESSAGE
                                );
                            }

                        }catch(SQLIntegrityConstraintViolationException any) {
                            JFrame frame = new JFrame();
                            JOptionPane.showMessageDialog(
                                    frame,
                                    "Student ID Or NIC Already Exists.",
                                    "ERROR",
                                    JOptionPane.ERROR_MESSAGE
                            );
                        }catch (Exception any){
                            JFrame frame = new JFrame();
                            JOptionPane.showMessageDialog(
                                    frame,
                                    "Something Went Wrong.\nTry Reconnecting To The Database.",
                                    "ERROR",
                                    JOptionPane.ERROR_MESSAGE
                            );
                        }finally {
                            ps.close();
                        }

                    }else{
                        throw new Exception();
                    }

                }else{
                    JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(
                            frame,
                            "All Fields Required.",
                            "WARNING",
                            JOptionPane.WARNING_MESSAGE
                    );
                }
            }catch (NumberFormatException any){
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(
                        frame,
                        "Invalid Inputs.",
                        "ERROR",
                        JOptionPane.ERROR_MESSAGE
                );
            }catch (Exception any){
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(
                        frame,
                        "Invalid Marks.",
                        "ERROR",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }
}
