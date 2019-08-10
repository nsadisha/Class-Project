import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame {
    private JLabel label;
    private JTextField text;
    private JButton button;



    //Constructor
    public GUI(){
        setSize(300,350);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Results");
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);

        label = new JLabel("Enter StudentID : ");
        text = new JTextField(10);
        button = new JButton("See Results");

        add(label);
        add(text);
        add(button);

        //event
        event e = new event();
        button.addActionListener(e);
    }

    public class event implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int id;
            try {
                id = Integer.parseInt(text.getText());

                    if(id>0){
                        Student stu = new Student();
                        stu.selectId(id);

                        String tsid = String.valueOf(stu.getId());
                        String tname = String.valueOf(stu.getName());
                        String tnic = String.valueOf(stu.getNic());
                        String tsub1 = String.valueOf(stu.getSub1());
                        String tsub2 = String.valueOf(stu.getSub2());
                        String tsub3 = String.valueOf(stu.getSub3());
                        String ttotal = String.valueOf(stu.getTotal());
                        String taverage = String.valueOf(stu.getAverage());

                        Table tb = new Table(tsid,tname,tnic,tsub1,tsub2,tsub3,ttotal,taverage);

                        if(Table.isResultShowing==false){
                            tb.setVisible(true);
                            Table.isResultShowing = true;
                        }else{
                            tb.dispose();
                            tb.setVisible(false);
                            tb.setVisible(true);
                            Table.isResultShowing = true;
                        }
                    }else{
                        JFrame frame = new JFrame();
                        JOptionPane.showMessageDialog(
                                frame,
                                ""+id+" Is not a valid ID.\nEnter a valid Student ID.",
                                "ERROR...!",
                                JOptionPane.ERROR_MESSAGE
                        );
                        text.setText("");
                    }

            }catch(NullPointerException nul) {
                System.out.println(nul);
            }catch(NumberFormatException n){
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(
                        frame,
                        "Invalid Student ID",
                        "ERROR...!",
                        JOptionPane.ERROR_MESSAGE
                );
                text.setText("");
            }
            catch(Exception ee){
                System.out.println(ee);
            }
        }
    }
}
