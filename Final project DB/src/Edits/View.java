package Edits;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.*;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class View extends JPanel{
    private JTable table;
    private JButton refresh = new JButton("Refresh");
    private JPanel pnl = new JPanel();
    private JScrollPane sp;

    Connection connection;
    PreparedStatement ps;
    ResultSet rs;
    int index = 0;

    String[] cols = {"Student ID","Name","NIC","Subject 1","Subject 2","Subject 3"};
    Object[][] data= new Object[50][6];

    public View(Connection connection){
        this.connection = connection;
        setLayout(new FlowLayout());
        setVisible(true);
        pnl.setLocation(500,400);
        //table.setEnabled(false);


        try{
            ps = connection.prepareStatement("SELECT * FROM results");
            rs = ps.executeQuery();

            while (rs.next()) {
                data[index][0] = rs.getInt("StudentID");
                data[index][1] = rs.getString("Name");
                data[index][2] = rs.getString("NIC");
                data[index][3] = rs.getInt("Subject1");
                data[index][4] = rs.getInt("Subject2");
                data[index][5] = rs.getInt("Subject3");
                index++;
            }

        }catch (Exception any){
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(
                    frame,
                    "Something Went Wrong.\nTry Reconnecting To The Database.",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE
            );
        }

        table = new JTable(data,cols);
        table.setPreferredScrollableViewportSize(new Dimension(600,350));
        table.setFillsViewportHeight(true);

        sp = new JScrollPane(table);
        add(sp);
        pnl.add(refresh);
        add(pnl);

        event e = new event();
        refresh.addActionListener(e);
    }
    public class event implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            for(int i=0;i<50;i++) {
                data[i][0] = "";
                data[i][1] = "";
                data[i][2] = "";
                data[i][3] = "";
                data[i][4] = "";
                data[i][5] = "";
            }

            index = 0;
            try{
                //still not refreshing.

                ps = connection.prepareStatement("SELECT * FROM results");
                rs = ps.executeQuery();

                while (rs.next()) {
                    data[index][0] = rs.getInt("StudentID");
                    data[index][1] = rs.getString("Name");
                    data[index][2] = rs.getString("NIC");
                    data[index][3] = rs.getInt("Subject1");
                    data[index][4] = rs.getInt("Subject2");
                    data[index][5] = rs.getInt("Subject3");
                    index++;
                }
                //refresh

                removeAll();
                table = new JTable(data,cols);
                table.setPreferredScrollableViewportSize(new Dimension(600,350));
                table.setFillsViewportHeight(true);
                sp = new JScrollPane(table);
                add(sp);
                add(pnl);

            }catch (Exception any){
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(
                        frame,
                        "Something Went Wrong.\nTry Reconnecting To The Database.",
                        "ERROR",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }
}
