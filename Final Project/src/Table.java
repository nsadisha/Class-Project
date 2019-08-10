import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Table extends JFrame{
    JTable table;

    public static boolean isResultShowing = false;

    public Table(String id,String name,String nic,String sub1,String sub2,String sub3,String total,String average){
        this.isResultShowing=true;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(300,400);
        setTitle("Table");
        setResizable(false);
        setLayout(new FlowLayout());
        setLocation(100,200);


        String[] cols = {"Fields","Details"};
        Object[][] data={
            {"Student ID",id},
            {"Name",name},
            {"NIC",nic},
            {"Subject 1",sub1},
            {"Subject 2",sub2},
            {"Subject 3",sub3},
            {"Total Marks",total},
            {"Average",average}
        };
        table = new JTable(data,cols);
        table.setPreferredScrollableViewportSize(new Dimension(200,150));
        table.setFillsViewportHeight(true);

        JScrollPane sp = new JScrollPane(table);
        add(sp);

    }
}