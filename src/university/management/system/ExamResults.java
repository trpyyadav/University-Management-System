
package university.management.system;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.awt.*;
import java.sql.*;
import java.awt.event.*;


public class ExamResults extends JFrame implements ActionListener{
    JTable table;
    JTextField rollno;
    JButton result, back;

    ExamResults(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("CHECK RESULT");
        heading.setBounds(40,15,200,40);
        heading.setFont(new Font("TAHOMA",Font.CENTER_BASELINE,20));
        add(heading);

        table = new JTable();

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }

        table.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent me){
                int row = table.getSelectedRow();
                rollno.setText(table.getModel().getValueAt(row,2).toString());
            }

        });

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);

        rollno = new JTextField();
        rollno.setBounds(40,65,200,20);
        add(rollno);

        result = new JButton("RESULT");
        result.setBounds(280,55,100,30);
        result.setBackground(Color.DARK_GRAY);
        result.setForeground(Color.WHITE);
        result.addActionListener(this);
        add(result);

        back = new JButton("BACK");
        back.setBounds(400,55,100,30);
        back.setBackground(Color.DARK_GRAY);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);



        setSize(900,550);
        setLocation(200,70);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == result){
            setVisible(false);
            new Result(rollno.getText());

        }else if(ae.getSource() == back){
            setVisible(false);
        }

    }
    public static void main(String args[]){
        new ExamResults();
    }
    
}
