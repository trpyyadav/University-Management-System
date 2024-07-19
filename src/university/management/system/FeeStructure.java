
package university.management.system;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.awt.*;
import java.sql.*;

public class FeeStructure extends JFrame{
    JTable table;

    FeeStructure(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("FEE STRUCTURE");
        heading.setBounds(70,15,400,40);
        heading.setFont(new Font("TAHOMA",Font.CENTER_BASELINE,25));
        add(heading);

        table = new JTable();

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from feestructure");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,65,900,550);
        add(jsp);




        setSize(900,550);
        setLocation(200,70);
        setVisible(true);
        

    }
    public static void main(String args[]){
        new FeeStructure();
    }
    
}
