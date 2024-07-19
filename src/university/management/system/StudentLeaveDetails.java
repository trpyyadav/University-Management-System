
package university.management.system;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.awt.*;
import java.sql.ResultSet;
import java.awt.event.*;


public class StudentLeaveDetails extends JFrame implements ActionListener {
    Choice rollno;
    JTable table;
    JButton search,print,back;


    StudentLeaveDetails(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("SEARCH BY ROLL NUMBER");
        heading.setBounds(25,25,200,40);
        add(heading);

        rollno = new Choice();
        rollno.setBackground(Color.WHITE);
        rollno.setBounds(250,30,200,30);
        add(rollno);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while(rs.next()){
                rollno.add(rs.getString("ROLL_NO"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }

         table = new JTable();

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from studentleave");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,800,600);
        add(jsp);

        search = new JButton("Search");
        search.setBounds(25,70,80,20);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(125,70,80,20);
        print.addActionListener(this);
        add(print);

        back = new JButton("Back");
        back.setBounds(225,70,80,20);
        back.addActionListener(this);
        add(back);

        setSize(800,600);
        setLocation(250,70);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == search){
            String query = "select * from studentleave where ROLL_NO = '"+rollno.getSelectedItem()+"'";

            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));

            }catch(Exception e){
                e.printStackTrace();
            }

        }else if(ae.getSource() == print){
            try{
                table.print();

            }catch(Exception e){
                e.printStackTrace();
            }

        }else if(ae.getSource() == back){
            setVisible(false);
        }

    }

    public static void main(String args[]){
        new StudentLeaveDetails();
    }
    
}
