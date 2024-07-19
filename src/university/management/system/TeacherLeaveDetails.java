
package university.management.system;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.awt.*;
import java.sql.ResultSet;
import java.awt.event.*;


public class TeacherLeaveDetails extends JFrame implements ActionListener {
    Choice empid;
    JTable table;
    JButton search,print,back;


    TeacherLeaveDetails(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("SEARCH BY EMPLOYEE ID");
        heading.setBounds(25,25,200,40);
        add(heading);

        empid = new Choice();
        empid.setBackground(Color.WHITE);
        empid.setBounds(250,30,200,30);
        add(empid);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            while(rs.next()){
                empid.add(rs.getString("emp_id"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }

         table = new JTable();

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacherleave");
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
            String query = "select * from teacherleave where EMPLOYEE_ID = '"+empid.getSelectedItem()+"'";

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
        new TeacherLeaveDetails();
    }
    
}
