import Edits.Delete;
import Edits.Insert;
import Edits.Update;
import Edits.View;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

public class EDIT extends JFrame {

    public EDIT(Connection connection){
        setSize(700,500);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new GridLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Edit Table");

        JTabbedPane tabs = new JTabbedPane();

        Insert insert = new Insert(connection);
        Update update = new Update(connection);
        Delete delete = new Delete(connection);
        View view = new View(connection);

        tabs.add("Insert",insert);
        tabs.add("Update",update);
        tabs.add("Delete",delete);
        tabs.add("View",view);
        add(tabs);
    }
}
